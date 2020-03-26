/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import exception.PamException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jpa.Cotisation;
import jpa.Employe;
import jpa.Indemnite;

public class Metier implements IMetierLocal, Serializable {

// liste des employes
private final Map<String, Employe> hashEmployes = new HashMap<>();
private List<Employe> listEmployes;


// obtenir la feuille de salaire
@Override
public FeuilleSalaire calculerFeuilleSalaire(String SS, double nbHeuresTravaill, int nbJoursTravaill) {
// on r.cup.re l'employ. de nÅã SS
Employe e = hashEmployes.get(SS);
// on rend une exception si l'employ. n'existe pas
if(e==null)
{
throw new PamException(String.format("L'employ. de nÅã SS [%s] n'existe pas",SS),1);
}
// on rend une feuille de salaire fictive
Cotisation c = null;
if(e.getId().equals(Long.valueOf(1))){
    c = new Cotisation(null,6.15,5,7.88,9.39,1);
}
if(e.getId().equals(Long.valueOf(2))){
    c = new Cotisation(null,4.6,3.49,6.45,10.15,1);
}

double salaireBase=nbHeuresTravaill*e.getIndemniteId().getBaseHeure()*(1+e.getIndemniteId().getIndemnitesCp()/100);
double cotisationsSociales=salaireBase*(c.getCsgd()+c.getCsgrds()+c.getSecu()+c.getRetraite())/100;
double indemnitesEntretien=nbJoursTravaill*e.getIndemniteId().getEntretienJour();
double indemnitesRepas=nbHeuresTravaill*e.getIndemniteId().getRepasJour();
double salaireNet=salaireBase-cotisationsSociales+indemnitesEntretien+indemnitesRepas;

return new FeuilleSalaire(e, c, new ElementsSalaire(salaireBase, cotisationsSociales, indemnitesEntretien, indemnitesRepas, salaireNet));
}

// liste des employ.s
@Override
public List<Employe> findAllEmployes() {
if (listEmployes == null) {
// on cr.e une liste de deux employ.s
listEmployes = new ArrayList<>();
//listEmployes.add(new Employe(null, 1, "Marie", "Jouveinal", "254104940426058", "5 rue des oiseaux", "St Corentin","49203", new Indemnite(null, 2.1,2.1,15,2,3.1,0)));
Employe e1 = new Employe(new Long(1),"5 rue des oiseaux","49203","Jouveinal", "Marie","254104940426058",1,"St Corentin");
Indemnite i1= new Indemnite(new Long(1), 2.1,2.1,15,2,3.1,0);
e1.setIndemniteId(i1);
listEmployes.add(e1);
Employe e2 = new Employe(new Long(2),"La brulerie","49014","Laverti", "Justine","260124402111742",1,"St Marcel");
Indemnite i2= new Indemnite(new Long(2), 1.93,2,12,1,3,0);
e2.setIndemniteId(i2);
listEmployes.add(e2);
// dictionnaire des employes
for (Employe e : listEmployes) {
    hashEmployes.put(e.getSs(), e);
}
}
// on rend la liste des employ.s
return listEmployes;
}
@Override
public Employe find(String id){
    List<Employe> liste = findAllEmployes();
    for(int i = 0; i<liste.size(); i++){
        if(liste.get(i).getId().equals(Long.valueOf(id))){
            return liste.get(i);
        }
    }
    return null;
}
}