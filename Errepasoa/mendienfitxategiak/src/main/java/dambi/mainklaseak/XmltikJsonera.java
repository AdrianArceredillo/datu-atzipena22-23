package dambi.mainklaseak;

import dambi.atzipenekoak.*;
import dambi.pojoak.Mendia;
import dambi.pojoak.Mendiak;

public class XmltikJsonera {
    public static void main(String[] args) {
        

        Xmla xmla = new Xmla("data/Mendiak.xml");
        Jsona jsona = new Jsona("", "data/MendiakXmltikJsonera.json");

        Mendiak mendiak = new Mendiak();
        Mendiak mendiGuztiak = new Mendiak();

        mendiak = xmla.irakurri();

        //Csva csva = new Csva("data/Mendiak.csv");
        //Jsona jsona = new Jsona("","data/Gipuzkoakoak.json");

        //mendiak = csva.irakurri();

        if (mendiak != null) {
            for (Mendia m : mendiak.getMendiak()) {
                if (m.getClass().equals("Mendia")) {
                    System.out.println("Estamos hablando de un monte! ");
                }
                mendiGuztiak.add(m);
                // if (m.getProbintzia().equals("Gipuzkoa")) {
                //     mendiGuztiak.add(m);
                // }
            }
            
            // System.out.println(jsona.idatzi(gipuzkoakoak)+" mendi idatzi dira json fitxategian.");
            System.out.println(jsona.idatzi(mendiGuztiak)+" mendi idatzi dira json fitxategian.");
        }

    }
}

//COPILOT
//https://docs.github.com/en/copilot/overview-of-github-copilot/about-github-copilot
//https://docs.github.com/en/billing/managing-billing-for-github-copilot/about-billing-for-github-copilot

//https://docs.github.com/en/education/explore-the-benefits-of-teaching-and-learning-with-github-education/github-global-campus-for-students/apply-to-github-global-campus-as-a-student
//https://docs.github.com/es/education/explore-the-benefits-of-teaching-and-learning-with-github-education/github-global-campus-for-students/apply-to-github-global-campus-as-a-student

//https://education.github.com/discount_requests/pack_application