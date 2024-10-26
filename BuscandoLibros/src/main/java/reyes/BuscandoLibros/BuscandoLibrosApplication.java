package reyes.BuscandoLibros;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import reyes.BuscandoLibros.PrincipalMenu.Principal;

@SpringBootApplication
public class BuscandoLibrosApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(BuscandoLibrosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Principal ejecutarMenu = new Principal();
		ejecutarMenu.mostrarMenu();
	}
}
