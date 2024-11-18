package co2123.hw1;

import co2123.hw1.domain.Arcade;
import co2123.hw1.domain.Machine;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class Hw1Application implements CommandLineRunner {

    public static List<Arcade> arcades;

    public static void main(String[] args) {
        SpringApplication.run(Hw1Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        arcades = new ArrayList<>();
        final Arcade a = new Arcade();

        final List<Machine> machines = new ArrayList<>();
        final Machine m1 = new Machine();
        m1.setGenre("Platform");
        m1.setSupplier("Arcade Direct");
        m1.setTagline("The ultimate battle. Adventure is the name of the game.");
        m1.setScore(200);
        machines.add(m1);

        final Machine m2 = new Machine();
        m2.setGenre("Puzzle");
        m2.setSupplier("Bespoke Arcades");
        m2.setTagline("Be Pac-Tive!!");
        m2.setScore(100);
        machines.add(m2);

        a.setMachines(machines);
        a.setId(0);
        a.setName("SwagArcade");
        a.setWebsite("swagarcade.com");
        arcades.add(a);

    }

}
