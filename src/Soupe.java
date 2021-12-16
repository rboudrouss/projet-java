public class Soupe extends Recette {

    @Override
    public String toString() {
        String name = "Soupe au ";
        for (Ingredient ing : allIngredients) {
            name += ing.nom + " ";
        }
        return name;
    }

    @Override
    public void generateRecette() {
        if (allIngredients.size() != quantities.size()) {
            // TODO raise excpetion
            System.out.print("ché la merde");
        }
        System.out.println("1- Dans une casserole, mettez 200ml d'eau à bouillir");
        int nb = 2;
        for (int i = 0; i < allIngredients.size(); i++) {
            for (String etape : allIngredients.get(i).etapeRecette(quantities.get(i))) {
                System.out.println((nb++) + "- " + etape);
            }
        }

        System.out.println((nb++) + "- Laissez bouillir pendant 15 minutes\n Et voilà !");

        return;

    }

}
