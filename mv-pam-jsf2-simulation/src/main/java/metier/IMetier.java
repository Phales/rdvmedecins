/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import java.util.List;
import jpa.Employe;

public interface IMetier {
// obtenir la feuille de salaire
FeuilleSalaire calculerFeuilleSalaire(String SS, double nbHeuresTravaillées, int nbJoursTravaillés );
// liste des employés
List<Employe> findAllEmployes();

Employe find(String id);
}