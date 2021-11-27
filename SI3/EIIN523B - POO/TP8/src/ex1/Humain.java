package ex1;

import java.util.Date;
import java.util.List;

public class Humain {
    String Nom;
    String Prenom;
    List<String> autresPrenomList;
    Integer age;
    Date dateNaissance;
    Long numeroSocial;
    public Humain(String nom, String prenom, List<String> autresPrenomList,
                  Integer age, Date dateNaissance, Long numeroSocial) {
        Nom = nom;
        Prenom = prenom;
        this.autresPrenomList = autresPrenomList;
        this.age = age;
        this.dateNaissance = dateNaissance;
        this.numeroSocial = numeroSocial;
    }
    public String getNom() { return Nom; }
    public String getPrenom() { return Prenom; }
    public List<String> getAutresPrenomList() { return autresPrenomList; }
    public Integer getAge() { return age; }
    public Date getDateNaissance() { return dateNaissance; }
    public Long getNumeroSocial() { return numeroSocial; }
}