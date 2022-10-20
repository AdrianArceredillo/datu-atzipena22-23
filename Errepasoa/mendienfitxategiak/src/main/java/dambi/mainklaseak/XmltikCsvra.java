package dambi.mainklaseak;

import dambi.atzipenekoak.Csva;
import dambi.atzipenekoak.Xmla;
import dambi.pojoak.Mendia;
import dambi.pojoak.Mendiak;

public class XmltikCsvra {
    public static void main(String[] args) {
        
        Mendiak mendiak = new Mendiak();
        Mendiak montesAlturaFiltro = new Mendiak();

        // Xmla xmla = new Xmla("data/Mendiak.xml");
        Xmla xmla = new Xmla("data/Gipuzkoakoak.xml");
        Csva csva = new Csva("", "data/MendiakXmltikCsvra.csv");

        mendiak = xmla.irakurri();
        if (mendiak != null) {
            for (Mendia m : mendiak.getMendiak()) {
                if (m.getAltuera() > 1000) {
                    montesAlturaFiltro.add(m);
                }
                // if (m.getProbintzia().equals("Gipuzkoa")) {
                //     gipuzkoakoak.add(m);
                // }
            }

            System.out.println(csva.idatzi(montesAlturaFiltro) + " mendi idatzi dira xml fitxategian.");
        }
    }
}
