package dambi.batezbestekoak;

import java.util.Scanner;
import dambi.atzipenekoak.Csva;
import dambi.pojoak.Nota;
import dambi.pojoak.Notak;

public class IkasleBatenBatezbestekoa {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println();
        System.out.print("\tZein ikasleren batezbestekoa nahi duzu kalkulatu? ");
        String sarturikoIzena = scanner.next();
        sarturikoIzena = sarturikoIzena.toLowerCase();
        // System.out.println(izena);
        int notaBoitza = 0;
        int contarNotasDelAlumno = 0;
        double batezbestekoa;

        //irakurketa egin
        Notak notak = new Notak();
        Csva csva = new Csva("data/Notak.csv");
        notak = csva.irakurri();

        if (notak != null) {

            for (Nota n : notak.getNotak()) {
                if (n.getIkaslea().equals(sarturikoIzena)) {
                    notaBoitza = notaBoitza + n.getNota();
                    contarNotasDelAlumno++;
                } 
            }

            batezbestekoa = Double.valueOf(notaBoitza) / contarNotasDelAlumno;

            if (batezbestekoa > 0) {
                System.out.println(sarturikoIzena + " ikaslearen batezbesteko nota " + batezbestekoa + " da. \n");
            } else {
                System.out.println("Ez dugu ikasle hori aurkitu");                    
            }

        }

    }
}
