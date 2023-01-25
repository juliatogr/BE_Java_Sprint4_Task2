package cat.itacademy.barcelonactiva.tortosagrau.julia.s04.t02.n01.model.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import cat.itacademy.barcelonactiva.tortosagrau.julia.s04.t02.n01.model.domain.Fruita;

@Configuration
class LoadDatabase {

  private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

  @Bean
  CommandLineRunner initDatabase(FruitaRepository repository) {

    return args -> {
      log.info("Preloading " + repository.save(new Fruita("Poma", 30)));
      log.info("Preloading " + repository.save(new Fruita("Plàtan", 20)));
      log.info("Preloading " + repository.save(new Fruita("Pera", 50)));
      log.info("Preloading " + repository.save(new Fruita("Fresa", 10)));
    };
  }
}