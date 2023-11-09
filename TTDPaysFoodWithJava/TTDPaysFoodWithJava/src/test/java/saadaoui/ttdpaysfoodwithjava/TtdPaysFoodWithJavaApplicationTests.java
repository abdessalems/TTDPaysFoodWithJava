package saadaoui.ttdpaysfoodwithjava;

import jakarta.transaction.Transactional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import saadaoui.ttdpaysfoodwithjava.entity.Country;
import saadaoui.ttdpaysfoodwithjava.entity.PopularFood;
import saadaoui.ttdpaysfoodwithjava.repos.CountryRepository;
import saadaoui.ttdpaysfoodwithjava.repos.PopularFoodRepository;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TtdPaysFoodWithJavaApplicationTests {

    @Autowired
    private CountryRepository countryRepository;

    @Autowired
    private PopularFoodRepository popularFoodRepository;

    @BeforeEach
    void setUp() {
        // Insert real or sample countries into the database
        Country country1 = new Country("United States");
        Country country2 = new Country("Canada");
        Country country3 = new Country("Germany");

        // Save entities to the database
        countryRepository.saveAll(List.of(country1, country2, country3));

        PopularFood food1 = new PopularFood("Burger");
        PopularFood food2 = new PopularFood("Poutine");
        PopularFood food3 = new PopularFood("Bratwurst");

        // Save entities to the database
        popularFoodRepository.saveAll(List.of(food1, food2, food3));

    }



    @Test
    @Transactional
    void testCreateCountry() {
        Country country = new Country("France", "Europe");
        countryRepository.save(country);

        assertNotNull(country.getId());
    }

    @Test
    @Transactional
    void testFindCountry() {
        Country country = new Country("Germany", "Europe");
        countryRepository.save(country);

        Country retrievedCountry = countryRepository.findById(country.getId()).orElse(null);
        assertNotNull(retrievedCountry);
        assertEquals("Germany", retrievedCountry.getName());
    }

    @Test
    @Transactional
    void testUpdateCountry() {
        Country country = new Country("Spain", "Europe");
        countryRepository.save(country);

        country.setName("UpdatedSpain");
        countryRepository.save(country);

        Optional<Country> updatedCountry = countryRepository.findById(country.getId());
        assertTrue(updatedCountry.isPresent());
        assertEquals("UpdatedSpain", updatedCountry.get().getName());
    }

    @Test
    @Transactional
    void testDeleteCountry() {
        Country country = new Country("Italy", "Europe");
        countryRepository.save(country);

        countryRepository.deleteById(country.getId());

        Optional<Country> deletedCountry = countryRepository.findById(country.getId());
        assertFalse(deletedCountry.isPresent());
    }



    @Test
    @Transactional
    void testCreatePopularFood() {
        Country country = new Country("Japan", "Asia");
        countryRepository.save(country);

        PopularFood popularFood = new PopularFood("Sushi", "Traditional Japanese Dish", "sushi.jpg");
        popularFood.setCountry(country);
        popularFoodRepository.save(popularFood);

        assertNotNull(popularFood.getId());
    }

    @Test
    @Transactional
    void testFindPopularFood() {
        Country country = new Country("China", "Asia");
        countryRepository.save(country);

        PopularFood popularFood = new PopularFood("Dim Sum", "Chinese Dumplings", "dimsum.jpg");
        popularFood.setCountry(country);
        popularFoodRepository.save(popularFood);

        Optional<PopularFood> retrievedPopularFood = popularFoodRepository.findById(popularFood.getId());
        assertTrue(retrievedPopularFood.isPresent());
        assertEquals("Dim Sum", retrievedPopularFood.get().getName());
    }

    @Test
    @Transactional
    void testUpdatePopularFood() {
        Country country = new Country("India", "Asia");
        countryRepository.save(country);

        PopularFood popularFood = new PopularFood("Curry", "Spicy Indian Dish", "curry.jpg");
        popularFood.setCountry(country);
        popularFoodRepository.save(popularFood);

        popularFood.setName("UpdatedCurry");
        popularFoodRepository.save(popularFood);

        Optional<PopularFood> updatedPopularFood = popularFoodRepository.findById(popularFood.getId());
        assertTrue(updatedPopularFood.isPresent());
        assertEquals("UpdatedCurry", updatedPopularFood.get().getName());
    }

    @Test
    @Transactional
    void testDeletePopularFood() {
        Country country = new Country("Thailand", "Asia");
        countryRepository.save(country);

        PopularFood popularFood = new PopularFood("Pad Thai", "Thai Noodles", "padthai.jpg");
        popularFood.setCountry(country);
        popularFoodRepository.save(popularFood);

        popularFoodRepository.deleteById(popularFood.getId());

        Optional<PopularFood> deletedPopularFood = popularFoodRepository.findById(popularFood.getId());
        assertFalse(deletedPopularFood.isPresent());
    }

    @Test
    @Transactional
    void testListAllCountries() {
        List<Country> countries = countryRepository.findAll();
        assertFalse(countries.isEmpty(), "List of countries is empty. Actual values: " + countries);
    }

    @Test
    @Transactional
    void testListAllPopularFoods() {
        List<PopularFood> popularFoods = popularFoodRepository.findAll();
        assertFalse(popularFoods.isEmpty(), "List of popular foods is empty. Actual values: " + popularFoods);
    }




}
