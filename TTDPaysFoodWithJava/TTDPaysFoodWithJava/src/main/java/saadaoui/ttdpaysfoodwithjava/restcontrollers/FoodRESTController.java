package saadaoui.ttdpaysfoodwithjava.restcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import saadaoui.ttdpaysfoodwithjava.entity.Country;
import saadaoui.ttdpaysfoodwithjava.entity.PopularFood;
import saadaoui.ttdpaysfoodwithjava.service.CountryService;
import saadaoui.ttdpaysfoodwithjava.service.PopularFoodService;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class FoodRESTController {

    @Autowired
    private CountryService countryService;

    @Autowired
    private PopularFoodService popularFoodService;

    @RequestMapping(value = "/countries", method = RequestMethod.GET)
    public List<Country> getAllCountries() {
        return countryService.getAllCountries();
    }

    @RequestMapping(value = "/countries/{id}", method = RequestMethod.GET)
    public Country getCountryById(@PathVariable("id") Long id) {
        return countryService.getCountry(id);
    }

    @RequestMapping(value = "/countries", method = RequestMethod.POST)
    public Country createCountry(@RequestBody Country country) {
        return countryService.saveCountry(country);
    }

    @RequestMapping(value = "/countries", method = RequestMethod.PUT)
    public Country updateCountry(@RequestBody Country country) {
        return countryService.updateCountry(country);
    }

    @RequestMapping(value = "/countries/{id}", method = RequestMethod.DELETE)
    public void deleteCountry(@PathVariable("id") Long id) {
        countryService.deleteCountryById(id);
    }

    @RequestMapping(value = "/popularfoods", method = RequestMethod.GET)
    public List<PopularFood> getAllPopularFoods() {
        return popularFoodService.getAllPopularFoods();
    }

    @RequestMapping(value = "/popularfoods/{id}", method = RequestMethod.GET)
    public PopularFood getPopularFoodById(@PathVariable("id") Long id) {
        return popularFoodService.getPopularFood(id);
    }

    @RequestMapping(value = "/popularfoods", method = RequestMethod.POST)
    public PopularFood createPopularFood(@RequestBody PopularFood popularFood) {
        return popularFoodService.savePopularFood(popularFood);
    }

    @RequestMapping(value = "/popularfoods", method = RequestMethod.PUT)
    public PopularFood updatePopularFood(@RequestBody PopularFood popularFood) {
        return popularFoodService.updatePopularFood(popularFood);
    }

    @RequestMapping(value = "/popularfoods/{id}", method = RequestMethod.DELETE)
    public void deletePopularFood(@PathVariable("id") Long id) {
        popularFoodService.deletePopularFoodById(id);
    }
}
