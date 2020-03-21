package web.utils;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ApplicationScoped;

@ManagedBean
@ApplicationScoped
public class ChangeLocale implements Serializable{
  // la locale des pages
  private String locale="fr";
  
  public ChangeLocale() {
  }
  
  public String setFrenchLocale(){
    locale="fr";
    return null;}
  
  public String setEnglishLocale(){
    locale="en";
    return null;}

  public String getLocale() {
    return locale;}

  public void setLocale(String locale) {
    this.locale = locale;
  }
  
  
}
