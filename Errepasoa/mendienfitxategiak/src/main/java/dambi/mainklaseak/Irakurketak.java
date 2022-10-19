package dambi.mainklaseak;

import dambi.atzipenekoak.Csva;
import dambi.atzipenekoak.Jsona;
import dambi.atzipenekoak.Xmla;
import dambi.pojoak.Mendiak;

public class Irakurketak {
    public static void main(String[] args) {

        Mendiak mendiak = new Mendiak();
        // Csva csva = new Csva("data/Mendiakkkk.csv");
        Csva csva = new Csva("mendienfitxategiak/data/Mendiak.csv");    //copiar path desde la venta de workspace
        mendiak = csva.irakurri();
        if (mendiak != null) {
            System.out.println(csva.strFileIn + " fitxategian mendi hauek daude: ");
            System.out.println(mendiak);
        }
        // Xmla xmla = new Xmla("data/Hirumendiiii.xml");
        Xmla xmla = new Xmla("Hirumendi.xml");
        mendiak = xmla.irakurri();
        if (mendiak != null) {
            System.out.println(xmla.strFileIn + " fitxategian mendi hauek daude: ");
            System.out.println(mendiak);
        }
        Jsona jsona = new Jsona("data/Mendhhhhiak.json");
        mendiak = jsona.irakurri();
        if (mendiak != null) {
            System.out.println(jsona.strFileIn + " fitxategian mendi hauek daude: ");
            System.out.println(mendiak);
        }
    }
}
