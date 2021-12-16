import java.util.Map;

public class OtherIngredient extends Ingredient {

    public OtherIngredient(String nom, Map<String, Double> m) {
        super(nom, m);
    }

    public OtherIngredient(String nom) {
        super(nom);
    }

    public OtherIngredient(String nom, DNutri dn) {
        super(nom, dn);
    }

    @Override
    public String[] etapeRecette(int quantity) {
        return new String[] { "ajouter vos " + quantity + "g de " + nom };
    }

}
