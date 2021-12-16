import java.util.ArrayList;
import java.util.Map;

public class DNutri {
    // TODO horrible code, would be better if i used a hash map
    // Déclaration nutritionnelle pour 100g ou 100ml
    public static final double kj_to_kcal = 0.239;
    private static final String[] listElements = new String[] {
            "energie",
            "gras",
            "glucides",
            "sucres",
            "proteine",
            "amidon",
            "fibres"
    };

    public double energie; // en kj

    public double gras, glucides, sucres, proteine, sel, amidon, fibres; // en g

    public static double conv_kj_to_kcal(double kj) {
        return kj * kj_to_kcal;
    }

    public static double conv_kcal_to_kj(double kcal) {
        return kcal / kj_to_kcal;
    }

    public DNutri(
            double energie,
            double gras,
            double glucides,
            double sucres,
            double proteine,
            double sel,
            double amidon,
            double fibres) {
        this.energie = energie;
        this.gras = gras;
        this.glucides = glucides;
        this.sucres = sucres;
        this.proteine = proteine;
        this.sel = sel;
        this.amidon = amidon;
        this.fibres = fibres;
    }

    public DNutri() {
        this(0, 0, 0, 0, 0, 0, 0, 0);
    }

    public String showDN() {
        // TODO
        return "";
    }

    public static DNutri fromMap(Map<String, Double> m) {
        for (String ele : listElements) {
            if (!m.containsKey(ele)) {
                // TODO raise error
                System.out.println("OULA FRÉROT C LA MERDE");
            }
        }

        return new DNutri(
                m.get("energie"),
                m.get("gras"),
                m.get("glucides"),
                m.get("sucres"),
                m.get("proteine"),
                m.get("sel"),
                m.get("amidon"),
                m.get("fibres"));
    }

    public static DNutri fromLSizedIng(ArrayList<SizedIngredient> l) {
        DNutri decNut = new DNutri();
        for (int i = 0; i < l.size(); i++) {
            // TODO horrible code, would be better if i used a hash map
            decNut.energie += l.get(i).getDNutri().energie * l.get(i).getQuantity();
            decNut.gras += l.get(i).getDNutri().gras * l.get(i).getQuantity();
            decNut.glucides += l.get(i).getDNutri().glucides * l.get(i).getQuantity();
            decNut.sucres += l.get(i).getDNutri().sucres * l.get(i).getQuantity();
            decNut.proteine += l.get(i).getDNutri().proteine * l.get(i).getQuantity();
            decNut.sel += l.get(i).getDNutri().sel * l.get(i).getQuantity();
            decNut.amidon += l.get(i).getDNutri().amidon * l.get(i).getQuantity();
            decNut.fibres += l.get(i).getDNutri().fibres * l.get(i).getQuantity();
        }

        int tot = 0;
        for (SizedIngredient ing : l) {
            tot += ing.getQuantity();
        }

        decNut.energie /= tot * 100;
        decNut.gras /= tot * 100;
        decNut.glucides /= tot * 100;
        decNut.sucres /= tot * 100;
        decNut.proteine /= tot * 100;
        decNut.sel /= tot * 100;
        decNut.amidon /= tot * 100;
        decNut.fibres /= tot * 100;
        return decNut;
    }

}
