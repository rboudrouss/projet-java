import java.util.ArrayList;

public abstract class Recette {
    public int nom;
    public DNutri decNut;
    ArrayList<Ingredient> allIngredients = new ArrayList<Ingredient>();
    ArrayList<Integer> quantities = new ArrayList<Integer>();

    public abstract String generateRecette();

    public int getMasseTot() {
        int rep = 0;
        for (int i : quantities) {
            rep += i;
        }
        return rep;
    }

    public DNutri generateDecNut() {
        return DNutri.meanDN(allIngredients, quantities);
    }

    public void addIngredient(Ingredient ingredient, int quantity) {
        allIngredients.add(ingredient);
        quantities.add(quantity);
        if (allIngredients.size() != quantities.size()) {
            // TODO raise error
            System.out.println("OULA C LA MERDE");
        }
    }

}