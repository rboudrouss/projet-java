import java.util.Map;

public class Sauce extends Ingredient {

    public Sauce(String nom, Map<String, Double> m) {
        super(nom, m);
    }

    public Sauce(String nom) {
        super(nom);
    }

    public Sauce(String nom, DNutri dn) {
        super(nom, dn);
    }

    @Override
    public String[] etapeRecette(int quantity) {
        return new String[] { "versez vos " + quantity + "g de sauce " + nom };
    }

}
