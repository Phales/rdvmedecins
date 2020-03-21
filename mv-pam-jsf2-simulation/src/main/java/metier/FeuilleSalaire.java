/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import java.io.Serializable;
import jpa.Cotisation;
import jpa.Employe;

public class FeuilleSalaire implements Serializable {
// champs privés
private Employe employe;
private Cotisation cotisation;
private ElementsSalaire elementsSalaire;

// constructeurs
public FeuilleSalaire() { }
public FeuilleSalaire(Employe employe, Cotisation cotisation, ElementsSalaire elementsSalaire) 
{ 
    this.employe = employe;
    this.cotisation = cotisation;
    this.elementsSalaire = elementsSalaire;
}
// toString
@Override
public String toString() {
return String.format("FeuilleSalaire[%s, %s, ,%s]", employe, cotisation, elementsSalaire); }

// accesseurs
public ElementsSalaire getElementsSalaire() {return elementsSalaire;}
public void setElementsSalaire(ElementsSalaire p) {elementsSalaire=p;}
public Employe getEmploye() {return employe;}
public void setEmploye(Employe p) {employe=p;}
public Cotisation getCotisation() {return cotisation;}
public void setCotisation(Cotisation p) {cotisation=p;}

}