package saadaoui.ttdpaysfoodwithjava;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import saadaoui.ttdpaysfoodwithjava.entity.Country;
import saadaoui.ttdpaysfoodwithjava.entity.PopularFood;
import saadaoui.ttdpaysfoodwithjava.repos.CountryRepository;
import saadaoui.ttdpaysfoodwithjava.repos.PopularFoodRepository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class TtdPaysFoodWithJavaApplicationTests {

	@Autowired
	private CountryRepository countryRepository;

	@Autowired
	private PopularFoodRepository popularFoodRepository;



	@Test
	public void testCreatePopularFoodWithCountryy() {
		// Create a new Country
		Country france = new Country("France", "Europe");
		countryRepository.save(france);

		// Create a new PopularFood associated with France
		PopularFood croissant = new PopularFood("Croissant", "A delicious French pastry", "croissant.jpg");
		croissant.setCountry(france);
		popularFoodRepository.save(croissant);

		// Assertions for the first PopularFood
		assertNotNull(croissant.getId());
		assertEquals("France", croissant.getCountry().getName());

		// Create another Country
		Country italy = new Country("Italy", "Europe");
		countryRepository.save(italy);

		// Create a new PopularFood associated with Italy
		PopularFood pizza = new PopularFood("Pizza", "Classic Italian dish", "pizza.jpg");
		pizza.setCountry(italy);
		popularFoodRepository.save(pizza);

		// Assertions for the second PopularFood
		assertNotNull(pizza.getId());
		assertEquals("Italy", pizza.getCountry().getName());

		// Create more countries and popular foods as needed
	}


	@Test
	public void testCreatePopularFoodWithCountry() {
		// Create a new Country and save it
		Country country = new Country("France", "Europe");
		countryRepository.save(country);

		// Create a new PopularFood associated with the Country
		PopularFood popularFood = new PopularFood("Baguette", "A French staple", "baguette.jpg");
		popularFood.setCountry(country);

		// Save the PopularFood entity
		popularFoodRepository.save(popularFood);

		// Make assertions or print statements to verify the data was saved correctly
		assertNotNull(popularFood.getId());
		assertEquals("France", popularFood.getCountry().getName());
	}


	@Test
	public void testCreatePopularFoodWithAsianCountry() {
		// Create a new Country for an Asian country
		Country japan = new Country("Japan", "Asia");
		countryRepository.save(japan);

		// Create a new PopularFood associated with Japan
		PopularFood sushi = new PopularFood("Sushi", "Traditional Japanese cuisine", "sushi.jpg");
		sushi.setCountry(japan);
		popularFoodRepository.save(sushi);

		// Assertions for the PopularFood associated with Japan
		assertNotNull(sushi.getId());
		assertEquals("Japan", sushi.getCountry().getName());

	}


	@Test
	public void testCreatePopularFood() {
		PopularFood newFood = new PopularFood("Hamburger", "American dish", "hamburger.jpg");
		PopularFood savedFood = popularFoodRepository.save(newFood);
		System.out.println("Created PopularFood: " + savedFood);
	}

	@Test
	public void testFindPopularFood() {
		PopularFood food = popularFoodRepository.findById(1L).get();
		System.out.println("Found PopularFood: " + food);
	}

	@Test
	public void testUpdatePopularFood() {
		PopularFood food = popularFoodRepository.findById(1L).get();
		food.setDescription("Updated description");
		PopularFood updatedFood = popularFoodRepository.save(food);
		System.out.println("Updated PopularFood: " + updatedFood);
	}

	@Test
	public void testDeletePopularFood() {
		popularFoodRepository.deleteById(1L);
		System.out.println("Deleted PopularFood with ID 1");
	}

	@Test
	public void testListAllPopularFoods() {
		Iterable<PopularFood> foods = popularFoodRepository.findAll();
		for (PopularFood food : foods) {
			System.out.println("PopularFood: " + food);
		}
	}

}
