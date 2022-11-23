package dambi.lehen_restapia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class LehenRestapiaApplication {

	public static void main(String[] args) {
		SpringApplication.run(LehenRestapiaApplication.class, args);
	}

	@GetMapping("/")
	public String home() {
		return "Gure lehen rest apia martxan dago.";
	}

	@GetMapping("/kaixo")
	public String hello(@RequestParam(value = "izena", defaultValue = "mundua") String izena) {
		return String.format("Kaixo %s!", izena);
	}

	@GetMapping("/zenbatu")
	public String zenbatu(@RequestParam(value = "norarte", defaultValue = "5") String norarte) {

		String strEmaitza = "";
		for (int i = 1; i <= Integer.parseInt(norarte); i++) {
			// strEmaitza += "<body style=\"background-color:grey;\">";
			// Tema_Spring\lehen\lehen_restapia\imagenes
			strEmaitza += "<body style=\"background-image:url('https://www.banderasphonline.com/wp-content/uploads/2020/03/bandera-espa%C3%B1a-con-escudo-para-exterior-interior-1200x800.png');background-repeat: no-repeat;background-attachment: fixed;background-size: cover; width:100%; height:auto\"></body>";
			
			if ((i % 2) == 0) {
				// strEmaitza += (i + " <br/><label style=\"color:yellow; font-size: 60px\">O
				// quizás no</label><br/>");
				// strEmaitza += (i + " <label style=\"color:yellow;\">O quizás no</label>"); ༼
				// つ ◕_◕ ༽つ
				strEmaitza += (i + " <label style=\"color:yellow;\">ESPAÑITA gana el Mundial!!!</label>");

			} else {
				// strEmaitza += (i + " <br/><label style=\"color:red; font-size: 100px\">ESPAÑA
				// GANA EL MUNDIAL!!!</label><br/>");
				strEmaitza += (i + " <label style=\"color:black;font-size: 40px\">༼ つ ◕_◕ ༽つ</label>");
			}

			

		}
		return strEmaitza;
	}

}


//http://localhost:8080/swagger-ui/index.html#/lehenrestapia-application/home
