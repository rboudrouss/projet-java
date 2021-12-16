import java.util.Map;

public abstract class Ingredient {
    public String nom;
    public DNutri decNut;

    public String getNom() {
        return nom;
    }

    public DNutri getDNutri() {
        return decNut;
    }

    public Ingredient(String nom, Map<String, Double> m) {
        this.nom = nom;
        this.decNut = DNutri.fromMap(m);
    }

    public Ingredient(String nom) {
        this.nom = nom;
        this.decNut = new DNutri();
    }

    public Ingredient(String nom, DNutri dn) {
        this.nom = nom;
        this.decNut = dn;
    }

    public abstract String[] etapeRecette(int quantity);

}
