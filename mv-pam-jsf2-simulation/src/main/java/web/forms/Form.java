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
   
   //private Employe[] selectManyListBox;
   private Employe selectOneMenuDynamic = metier.findAllEmployes().get(0);
   
   private double heuresT;
   private int joursT;
   
   private boolean viewInfosIsRendered = false;
   
   private boolean viewSalaryIsRendered = false;

    public boolean isViewSalaryIsRendered() {
        return viewSalaryIsRendered;
    }

    public void setViewSalaryIsRendered(boolean viewSalaryIsRendered) {
        this.viewSalaryIsRendered = viewSalaryIsRendered;
    }

    public boolean isViewInfosIsRendered() {
        return viewInfosIsRendered;
    }

    public void setViewInfosIsRendered(boolean viewInfosIsRendered) {
        this.viewInfosIsRendered = viewInfosIsRendered;
    }

    public double getHeuresT() {
        return heuresT;
    }

    public void setHeuresT(double heuresT) {
        this.heuresT = heuresT;
    }

    public int getJoursT() {
        return joursT;
    }

    public void setJoursT(int joursT) {
        this.joursT = joursT;
    }
   
   /*public Employe getSelectManyListBoxValue(){
    String value="[";
    for(String chaine : selectManyListBox){value+=" "+chaine;}
    return value+"]";
    }*/
  
//  public Employe[] getSelectManyListBox() {
//    return selectManyListBox; }
//  
//  public void setSelectManyListBox(Employe[] selectManyListBox) {
//    this.selectManyListBox = selectManyListBox;  }
  
   public IMetierLocal getMetier(){
      return metier;
  }
  
  public void setMetier(IMetierLocal m){
      metier = m;
  }
   
    public Employe getSelectOneMenuDynamic() {
    return selectOneMenuDynamic; }
  
  public void setSelectOneMenuDynamic(Employe selectOneMenu) {
    this.selectOneMenuDynamic = selectOneMenu; }
  
  public SelectItem[] getSelectOneMenuDynamicItems() {
      List<Employe> employes = metier.findAllEmployes();
      SelectItem[] items=new SelectItem[employes.size()];
      for(int i = 0; i<employes.size(); i++){
          items[i]=new SelectItem(employes.get(i),employes.get(i).getPrenom()+" "+employes.get(i).getNom()+"");
      }
      return items;
  }

  public String envoyer(){
      this.viewInfosIsRendered = true;
      this.viewSalaryIsRendered = true;
      return null;
  }
  
  public String raz(){
      this.viewInfosIsRendered = true;
      return null;
  }
}
