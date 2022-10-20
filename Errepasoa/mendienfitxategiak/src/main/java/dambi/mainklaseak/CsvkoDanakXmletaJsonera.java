package dambi.mainklaseak;

import dambi.atzipenekoak.Csva;
import dambi.atzipenekoak.Xmla;
import dambi.atzipenekoak.Jsona;

import dambi.pojoak.Mendia;
import dambi.pojoak.Mendiak;

public class CsvkoDanakXmletaJsonera {
    public static void main(String[] args) {

        Mendiak mendiak = new Mendiak();
        //Csva csva = new Csva("data/Mendiak.csv");
        Csva csva2 = new Csva("data/MendiakJsontikCsvra.csv");
        //MendiakJsontikCsvra
        Xmla xmla = new Xmla("", "data/Mendiak22222.xml");
        Jsona jsona = new Jsona("", "data/Mendiak22222.json");
        mendiak = csva2.irakurri();
        xmla.idatzi(mendiak);
        jsona.idatzi(mendiak);
        
    }
}
