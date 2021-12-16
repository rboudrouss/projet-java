import java.util.Map;

public class FLVVP extends Ingredient {
    // Fruit Legume Viande Poulet Volaille
    private boolean couper;

    public FLVVP(String nom, Map<String, Double> m, boolean couper) {
        super(nom, m);
        this.couper = couper;
    }

    public FLVVP(String nom, boolean couper) {
        super(nom);
        this.couper = couper;
    }

    public FLVVP(String nom, DNutri dn, boolean couper) {
        super(nom, dn);
        this.couper = couper;
    }

    @Override
    public String[] etapeRecette(int quantity) {
        if (couper) {
            return new String[] {
                    "Couper votre " + super.nom,
                    "ajouter vos " + quantity + "g de " + super.nom
            };
        }
        return new String[] { "ajouter vos " + quantity + "g de " + super.nom };
    }

    public FLVVP clone() {
        return new FLVVP(nom, decNut.clone(), couper);
    }

}
