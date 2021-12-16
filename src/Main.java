import java.util.ArrayList;

public class Main {
        public static void main(String[] args) {
                ArrayList<Condiment> lC = new ArrayList<Condiment>();
                ArrayList<Sauce> lS = new ArrayList<Sauce>();
                ArrayList<FLVVP> lF = new ArrayList<FLVVP>();
                ArrayList<OtherIngredient> lO = new ArrayList<OtherIngredient>();

                Condiment sel = new Condiment(
                                "sel",
                                new DNutri(0, 0, 0, 0, 0, 100, 0, 0));

                Condiment gingembre = new Condiment(
                                "gingembre",
                                new DNutri(80, 1, 18, 0, 2, 20, 0, 2));

                lC.add(sel.clone());
                lC.add(gingembre.clone());

                Sauce bolo = new Sauce(
                                "bolognaise",
                                new DNutri(137, 5, 17, 3, 12, 3, 0, 0));

                Sauce blanche = new Sauce(
                                "blanche",
                                new DNutri(127, 10, 13, 1, 4, 5, 0, 1));

                lS.add(bolo.clone());
                lS.add(blanche.clone());

                FLVVP oignon = new FLVVP(
                                "oignon",
                                new DNutri(40, 0, 8, 5, 2, 0, 0, 3),
                                true);
                FLVVP patate = new FLVVP(
                                "patate",
                                new DNutri(40, 0, 8, 5, 2, 0, 0, 3),
                                false);

                lF.add(oignon.clone());
                lF.add(patate.clone());

                OtherIngredient spaghetti = new OtherIngredient(
                                "spaghetti",
                                new DNutri(37, 12, 3, 1, 48, 12, 0, 2));

                lO.add(spaghetti);
                OtherIngredient fusilli = new OtherIngredient(
                                "fusilli",
                                new DNutri(37, 12, 3, 1, 48, 12, 0, 2));

                lO.add(fusilli.clone());
                lO.add(spaghetti.clone());

                // Début du code

                if (Math.random() <= 0.5) {
                        System.out.println("Aujourd'hui ça sera des pâtes !");
                        PatePlat plat = PatePlat.getInstance(
                                        lO.get((int) Math.floor(Math.random() * lO.size())),
                                        lS.get((int) Math.floor(Math.random() * lS.size())));
                        System.out.println("Plus précisement ça sera des " + plat.toString() + " !");

                        plat.addIngredient(lC.get((int) Math.floor(Math.random() * lC.size())), 1);

                        plat.generateDecNut();
                        plat.generateRecette();

                        System.out.println("----------------------------------");

                        System.out.println("Voici la déclaration nutritionnelle :");
                        plat.showDN();

                } else {
                        System.out.println("Aujourd'hui ça sera une soupe !");
                        Soupe plat = Soupe.getInstance();

                        plat.addIngredient(lF.get((int) Math.floor(Math.random() * lF.size())), 150);
                        plat.addIngredient(lC.get((int) Math.floor(Math.random() * lC.size())), 1);

                        System.out.println("Plus précisement ça sera des " + plat.toString() + "!");

                        plat.generateDecNut();
                        plat.generateRecette();

                        System.out.println("----------------------------------");

                        System.out.println("Voici la déclaration nutritionnelle :");
                        plat.showDN();
                }
        }
}
