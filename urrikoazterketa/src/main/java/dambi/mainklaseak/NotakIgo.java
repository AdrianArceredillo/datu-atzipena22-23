package dambi.mainklaseak;

import dambi.atzipenekoak.Csva;
import dambi.atzipenekoak.Xmla;
import dambi.pojoak.Nota;
import dambi.pojoak.Notak;

public class NotakIgo {
    public static void main(String[] args) {
        
        Notak notak = new Notak();
        Notak notaBerriak = new Notak();

        Csva csva = new Csva("data/Notak.csv");
        Xmla xmla = new Xmla("", "data/NotaHobetuak.xml");

        notak = csva.irakurri();

        if (notak != null) {
            for (Nota n : notak.getNotak()) {
                int nuevaNota = n.getNota() + 1;
                if (nuevaNota <= 10) {
                    n.setNota(nuevaNota);
                } else {
                    nuevaNota = 10;
                    n.setNota(nuevaNota);
                }
                notaBerriak.add(n);
            }

            System.out.println(xmla.idatzi(notaBerriak) + " mendi idatzi dira xml fitxategian.");
        }

    }
}
