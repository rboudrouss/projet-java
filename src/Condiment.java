import java.util.Map;

public class Condiment extends Ingredient {

    public Condiment(String nom, Map<String, Double> m) {
        super(nom, m);
    }

    public Condiment(String nom) {
        super(nom);
    }

    public Condiment(String nom, DNutri dn) {
        super(nom, dn);
    }

    @Override
    public String[] etapeRecette(int quantity) {
        return new String[] { "Ajouter une pincée de " + quantity + "g de " + super.nom };
    }

    public Condiment clone() {
        return new Condiment(nom, decNut.clone());
    }

}
