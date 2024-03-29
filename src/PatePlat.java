public class PatePlat extends Recette {
    Ingredient pate;
    Sauce sauce;
    private static PatePlat instance;

    private PatePlat(Ingredient pate, Sauce sauce) {
        this.pate = pate;
        this.sauce = sauce;
    }

    public static PatePlat getInstance(Ingredient pate, Sauce sauce) {
        if (instance == null) {
            instance = new PatePlat(pate, sauce);
        }
        return instance;

    }

    @Override
    public void generateRecette() {
        if (allIngredients.size() != quantities.size()) {
            throw new IllegalStateException("Les deux liste ne sont pas de même longueur");
        }
        System.out.println("1- mettre les pâtes " + pate.nom + " à cuire dans une casserôle");
        System.out.println("2- ajouter la sauce " + sauce.nom + " à vos pâtes");

        int i;
        for (i = 0; i < allIngredients.size(); i++) {
            for (String etape : allIngredients.get(i).etapeRecette(quantities.get(i))) {
                System.out.println((i + 3) + "- " + etape);
            }
        }

        System.out.println((i + 3) + "- Cervez vos pâtes bien chaude\n Et voilà !");

        return;

    }

    @Override
    public String toString() {
        return pate.nom + " au " + sauce.nom;
    }

}
