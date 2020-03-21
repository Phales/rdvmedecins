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
Cotisation c = new Cotisation(null,6.15,3.49,7.88,9.39,1);
return new FeuilleSalaire(e, c, new ElementsSalaire(100, 100, 100, 100,100));
}

// liste des employ.s
@Override
public List<Employe> findAllEmployes() {
if (listEmployes == null) {
// on cr.e une liste de deux employ.s
listEmployes = new ArrayList<>();
//listEmployes.add(new Employe(null, 1, "Marie", "Jouveinal", "254104940426058", "5 rue des oiseaux", "St Corentin","49203", new Indemnite(null, 2.1,2.1,15,2,3.1,0)));
Employe e1 = new Employe(null,"5 rue des oiseaux","49203","Jouveinal", "Marie","254104940426058",1,"St Corentin");
Indemnite i1= new Indemnite(null, 2.1,2.1,15,2,3.1,0);
e1.setIndemniteId(i1);
listEmployes.add(e1);
Employe e2 = new Employe(null,"La brulerie","49014","Laverti", "Justine","260124402111742",1,"St Marcel");
Indemnite i2= new Indemnite(null, 1.93,2,12,1,3,0);
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
}