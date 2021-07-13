package contract;

import java.text.SimpleDateFormat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LoadDatabase {

  private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);
  SimpleDateFormat format = new SimpleDateFormat("dd-MMM-yyyy");
  @Bean
  CommandLineRunner initDatabase(ContractRepository repository) {

    return args -> {
      log.info("Preloading " + repository.save(new Contract("First", 1, format.parse("01-03-2020"))));
      log.info("Preloading " + repository.save(new Contract("Second", 2, format.parse("01-02-2020"))));
    };
  }
}