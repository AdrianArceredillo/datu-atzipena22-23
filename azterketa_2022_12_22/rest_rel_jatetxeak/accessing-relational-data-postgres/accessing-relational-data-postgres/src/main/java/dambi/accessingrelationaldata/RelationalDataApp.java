package dambi.accessingrelationaldata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
/*
 * nombre antiguo -> "AccessingRelationalDataApplication"
 * 		-> da error al subirlo a Github porque es un nombre demasiado largo
 * 
 * nuevo nombre:
 * 		-> RelationalDataApp
 */
public class RelationalDataApp {

	public static void main(String[] args) {
		SpringApplication.run(RelationalDataApp.class, args);

		// System.out.println("\033[H\033[2J");
        // System.out.flush();
		
	}

}
