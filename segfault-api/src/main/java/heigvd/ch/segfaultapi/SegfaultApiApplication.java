package heigvd.ch.segfaultapi;

import heigvd.ch.segfaultapi.model.Utilisateur;
import heigvd.ch.segfaultapi.repositories.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SegfaultApiApplication implements CommandLineRunner {

    @Autowired
    private UtilisateurRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(SegfaultApiApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Utilisateur user = new Utilisateur();
        user.setUsername("ADMIN");
        user.setPassword("ADMIN");
    }
}
