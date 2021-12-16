public class SizedIngredient extends Ingredient {
    public int quantity; // en g

    public SizedIngredient(String nom, DNutri dn, int quantity) {
        super(nom, dn);
        this.quantity = quantity;
    }

    public SizedIngredient(String nom, int quantity) {
        super(nom);
        this.quantity = quantity;
    }

    public static SizedIngredient fromIngredient(Ingredient i, int quantity) {
        return new SizedIngredient(i.getNom(), i.getDNutri(), quantity);
    }

    public int getQuantity() {
        return quantity;
    }
}
