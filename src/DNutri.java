import java.util.ArrayList;
import java.util.Map;

public class DNutri {
    public class InvalidDNutriException extends Exception {
        private static final long serialVersionUID = 1L;

        public InvalidDNutriException() {
            super("The data seem to be incorect");
        }
    }

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
        if (!isValid()) {
            try {
                throw new InvalidDNutriException();
            } catch (DNutri.InvalidDNutriException e) {
                e.printStackTrace();
            }
        }
    }

    public DNutri() {
        this(0, 0, 0, 0, 0, 0, 0, 0);
    }

    public void showDN() {
        System.out.println("Energie : " + String.format("%.2f", energie) + "kj | "
                + String.format("%.2f", conv_kj_to_kcal(energie)) + "kcal");
        System.out.println("Gras : " + String.format("%.2f", gras) + "g");
        System.out.println("Glucides : " + String.format("%.2f", glucides) + "g");
        System.out.println("Sucres : " + String.format("%.2f", sucres) + "g");
        System.out.println("Proteine : " + String.format("%.2f", proteine) + "g");
        System.out.println("Sel : " + String.format("%.2f", sel) + "g");
        System.out.println("Amidon : " + String.format("%.2f", amidon) + "g");
        System.out.println("Fibres : " + String.format("%.2f", fibres) + "g");
    }

    public static DNutri fromMap(Map<String, Double> m) {
        for (String ele : listElements) {
            if (!m.containsKey(ele)) {
                throw new IllegalStateException("La map n'a pas l'élément " + ele);
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

    public static DNutri meanDN(ArrayList<Ingredient> l, ArrayList<Integer> q) {
        if (l.size() != q.size()) {
            throw new IllegalStateException("Les deux liste ne sont pas de même longueur");
        }
        DNutri decNut = new DNutri();
        for (int i = 0; i < l.size(); i++) {
            // TODO horrible code, would be better if i used a hash map
            decNut.energie += l.get(i).getDNutri().energie * q.get(i);
            decNut.gras += l.get(i).getDNutri().gras * q.get(i);
            decNut.glucides += l.get(i).getDNutri().glucides * q.get(i);
            decNut.sucres += l.get(i).getDNutri().sucres * q.get(i);
            decNut.proteine += l.get(i).getDNutri().proteine * q.get(i);
            decNut.sel += l.get(i).getDNutri().sel * q.get(i);
            decNut.amidon += l.get(i).getDNutri().amidon * q.get(i);
            decNut.fibres += l.get(i).getDNutri().fibres * q.get(i);
        }

        int tot = 0;
        for (int i : q) {
            tot += i;
        }

        decNut.energie /= tot;
        decNut.gras /= tot;
        decNut.glucides /= tot;
        decNut.sucres /= tot;
        decNut.proteine /= tot;
        decNut.sel /= tot;
        decNut.amidon /= tot;
        decNut.fibres /= tot;
        return decNut;
    }

    public DNutri clone() {
        return new DNutri(
                energie,
                gras,
                glucides,
                sucres,
                proteine,
                sel,
                amidon,
                fibres);
    }

    public boolean isValid() {
        return (gras + glucides + proteine + sel + amidon + fibres) <= 100 && sucres <= glucides;
    }

}
