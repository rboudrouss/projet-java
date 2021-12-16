import java.util.ArrayList;

public abstract class Recette {
    public int nom;
    public DNutri decNut;
    ArrayList<SizedIngredient> allIngredients = new ArrayList<SizedIngredient>();

    public abstract String generateRecette();

    public int getMasseTot() {
        int rep = 0;
        for (SizedIngredient ing : allIngredients) {
            rep += ing.getQuantity();
        }
        return rep;
    }

    public DNutri generateDecNut() {
        return DNutri.fromLSizedIng(allIngredients);
    }

    public void addIngredient(SizedIngredient ingredient) {
        allIngredients.add(ingredient);
    }

}