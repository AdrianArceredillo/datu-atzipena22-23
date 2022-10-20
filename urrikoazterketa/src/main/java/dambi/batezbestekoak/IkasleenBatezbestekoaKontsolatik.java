package dambi.batezbestekoak;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import dambi.atzipenekoak.Csva;
import dambi.pojoak.Nota;
import dambi.pojoak.Notak;

public class IkasleenBatezbestekoaKontsolatik {
    public static void main(String[] args) {

        int notaBoitza = 0;
        int contarNotasDelAlumno = 0;
        double batezbestekoa = 0;

        // irakurketa egin
        Notak notak = new Notak();
        Notak ikasleBakoitza = new Notak();
        List<String> denaIkusi = new ArrayList<>();
        denaIkusi.add("cero");

        Csva csva = new Csva("data/Notak.csv");
        notak = csva.irakurri();
        ikasleBakoitza = csva.irakurri();

        if (notak != null) {

            String izena = "";
            for (int i = 0; i < notak.getNotak().size(); ++i) {
                izena = notak.getNotak().get(i).getIkaslea();
                System.out.println(izena + "\n");

                if (!denaIkusi.contains(izena)) {
                    denaIkusi.add(izena);
                }
            }


            System.out.println("\tIKASLEA\t\t\tBATEZBESTEKOA");
            System.out.println("===================================================");

            for (int i = 1; i < denaIkusi.size(); ++i) {
                //System.out.println(i + " - " + denaIkusi.get(i));
                for (int a = 0; a < notak.getNotak().size(); ++a) {
                    if (notak.getNotak().get(a).getIkaslea().equals(denaIkusi.get(i))) {
                        notaBoitza = notaBoitza + notak.getNotak().get(a).getNota();
                        contarNotasDelAlumno++;
                    }
                }

                batezbestekoa = Double.valueOf(notaBoitza) / contarNotasDelAlumno;

                if (batezbestekoa > 0) {
                    System.out.println(denaIkusi.get(i) + " \t\t " + batezbestekoa);
                } else {
                    System.out.println("Ez dugu ikasle hori aurkitu");
                }

                notaBoitza = 0;
                contarNotasDelAlumno = 0;
            }
            System.out.println();
            
        }
    }
}
