package dambi.mainklaseak;

import dambi.atzipenekoak.*;
import dambi.pojoak.Mendia;
import dambi.pojoak.Mendiak;


public class JsonetikCsvraOtraForma {
    
    public static void main(String[] args) {
        
        Jsona jsona = new Jsona("data/MendiakXmltikJsonera.json");
        Csva csva = new Csva("", "data/Gip.csv");

        Mendiak mendiak = new Mendiak();
        Mendiak mendiGuztiak = new Mendiak();

        mendiak = jsona.irakurri();

        //Csva csva = new Csva("data/Mendiak.csv");
        //Jsona jsona = new Jsona("","data/Gipuzkoakoak.json");

        //mendiak = csva.irakurri();

        if (mendiak != null) {
            for (Mendia m : mendiak.getMendiak()) {
                mendiGuztiak.add(m);
            }
            
            // System.out.println(jsona.idatzi(gipuzkoakoak)+" mendi idatzi dira json fitxategian.");
            System.out.println(csva.idatzi(mendiGuztiak)+" mendi idatzi dira json fitxategian.");
        }

    }
}
