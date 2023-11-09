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

        // Insert real or sample popular foods into the database
        PopularFood food1 = new PopularFood("Burger");
        PopularFood food2 = new PopularFood("Poutine");
        PopularFood food3 = new PopularFood("Bratwurst");

        // Save entities to the database
        popularFoodRepository.saveAll(List.of(food1, food2, food3));
    }

    @Test
    @Transactional
    void testCreateAndDeleteCountry() {
        // Given
        Country newCountry = new Country("Brazil", "South America");

        // When
        countryRepository.save(newCountry);
        countryRepository.deleteById(newCountry.getId());

        // Then
        Optional<Country> deletedCountry = countryRepository.findById(newCountry.getId());
        assertFalse(deletedCountry.isPresent(), "Failed to delete the country with ID: " + newCountry.getId());
    }

    @Test
    @Transactional
    void testCreateAndListPopularFoodsInCountry() {
        // Given
        Country country = new Country("Australia", "Oceania");
        countryRepository.save(country);

        PopularFood food1 = new PopularFood("Vegemite Sandwich", "Iconic Australian Dish", "vegemite.jpg");
        PopularFood food2 = new PopularFood("Tim Tam", "Australian Chocolate Biscuit", "timtam.jpg");
        food1.setCountry(country);
        food2.setCountry(country);

        // When
        popularFoodRepository.saveAll(List.of(food1, food2));
        List<PopularFood> foodsInCountry = popularFoodRepository.findByCountry(country);

        // Then
        assertFalse(foodsInCountry.isEmpty(), "No popular foods found for country: " + country.getName());
        assertEquals(2, foodsInCountry.size(), "Unexpected number of popular foods for country.");
    }

    @Test
    @Transactional
    void testUpdateNonExistentPopularFood() {
        // Given
        Long nonExistentFoodId = 999L;

        // When
        Optional<PopularFood> nonExistentFood = popularFoodRepository.findById(nonExistentFoodId);
        assertFalse(nonExistentFood.isPresent(), "Non-existent popular food found unexpectedly.");

        // Then
        // Update should not throw an exception or cause issues for a non-existent entity.
    }



    @Test
    @Transactional
    void testDeleteNonExistentCountry() {
        // Given
        Long nonExistentCountryId = 999L;

        // When
        Optional<Country> nonExistentCountryBeforeDeletion = countryRepository.findById(nonExistentCountryId);

        // Then
        assertFalse(nonExistentCountryBeforeDeletion.isPresent(), "Non-existent country found unexpectedly before deletion.");

        // When (attempting to delete)
        // The delete operation on a non-existent entity should not throw an exception.

        // Then
        // No exceptions should be thrown, and the system should handle the non-existent entity deletion gracefully.

        // When
        Optional<Country> nonExistentCountryAfterDeletion = countryRepository.findById(nonExistentCountryId);

        // Then
        assertFalse(nonExistentCountryAfterDeletion.isPresent(), "Non-existent country found unexpectedly after deletion.");
    }


    @Test
    @Transactional
    void testListAllPopularFoodsWithData() {
        // Given
        // Popular foods have been inserted into the database during test setup.

        // When
        List<PopularFood> popularFoods = popularFoodRepository.findAll();

        // Then
        assertFalse(popularFoods.isEmpty(), "List of popular foods is empty. Actual values: " + popularFoods);
        // You can add more assertions based on the expected data in the list.
    }






}
