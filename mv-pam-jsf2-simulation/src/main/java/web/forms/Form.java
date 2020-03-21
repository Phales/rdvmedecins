/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.forms;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.SelectItem;
import jpa.Employe;
import metier.FeuilleSalaire;
import metier.IMetierLocal;
import metier.Metier;


/**
 *
 * @author j.fasquel
 */
@ManagedBean
@RequestScoped
public class Form implements Serializable
{
   //Form fera l'interface entre les pages et la couche metier.
   private IMetierLocal metier = new Metier();
   //Utilisation du logger pour afficher les infos
   private static final Logger logger=Logger.getLogger("forms.Form");
   
   private String[] selectManyListBox=new String[]{"1","3"};
   private Employe selectOneMenuDynamic;
   
   private FeuilleSalaire feuilleSalaire;
   
   public String getSelectManyListBoxValue(){
    String value="[";
    for(String chaine : selectManyListBox){value+=" "+chaine;}
    return value+"]";
    }
    
  
  public String[] getSelectManyListBox() {
    return selectManyListBox; }
  
  public void setSelectManyListBox(String[] selectManyListBox) {
    this.selectManyListBox = selectManyListBox;  }
  
    public Employe getSelectOneMenuDynamic() {
    return selectOneMenuDynamic; }
  
  public void setSelectOneMenuDynamic(Employe selectOneMenu) {
    this.selectOneMenuDynamic = selectOneMenu; }
  
  public SelectItem[] getSelectOneMenuDynamicItems() {
      List<Employe> employes = metier.findAllEmployes();
      SelectItem[] items=new SelectItem[employes.size()];
      for(int i = 0; i<employes.size(); i++){
          items[i]=new SelectItem(""+i+1+"",employes.get(i).getPrenom()+" "+employes.get(i).getNom()+"");
      }
      return items;
  }
  
  public FeuilleSalaire getFeuilleSalaire(){
      return feuilleSalaire;
  }
}
