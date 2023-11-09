package saadaoui.ttdpaysfoodwithjava;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import saadaoui.ttdpaysfoodwithjava.entity.Country;
import saadaoui.ttdpaysfoodwithjava.entity.PopularFood;
import saadaoui.ttdpaysfoodwithjava.repos.CountryRepository;
import saadaoui.ttdpaysfoodwithjava.repos.PopularFoodRepository;

import java.util.Arrays;

@SpringBootApplication
public class TtdPaysFoodWithJavaApplication {

    public static void main(String[] args) {
        SpringApplication.run(TtdPaysFoodWithJavaApplication.class, args);
    }

    @Bean
    public CommandLineRunner loadData(CountryRepository countryRepository, PopularFoodRepository popularFoodRepository) {
        return args -> {
            // Save sample countries
            Country tunisia = new Country("Tunisia", "TN");
            Country france = new Country("France", "FR");
            countryRepository.saveAll(Arrays.asList(tunisia, france));

            // Save sample popular foods
            PopularFood couscous = new PopularFood("Couscous", "Traditional dish", tunisia);
            PopularFood baguette = new PopularFood("Baguette", "French bread", france);
            popularFoodRepository.saveAll(Arrays.asList(couscous, baguette));
        };
    }

}
