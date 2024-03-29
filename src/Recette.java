import java.util.ArrayList;

public abstract class Recette {
    public int nom;
    public DNutri decNut;
    ArrayList<Ingredient> allIngredients = new ArrayList<Ingredient>();
    ArrayList<Integer> quantities = new ArrayList<Integer>();

    public abstract void generateRecette();

    public int getMasseTot() {
        int rep = 0;
        for (int i : quantities) {
            rep += i;
        }
        return rep;
    }

    public DNutri generateDecNut() {
        decNut = DNutri.meanDN(allIngredients, quantities);
        return decNut;
    }

    public void showDN() {
        this.decNut.showDN();
    }

    public void addIngredient(Ingredient ingredient, int quantity) {
        allIngredients.add(ingredient);
        quantities.add(quantity);
        if (allIngredients.size() != quantities.size()) {
            throw new IllegalStateException("Les deux liste ne sont pas de même longueur");
        }
    }

}