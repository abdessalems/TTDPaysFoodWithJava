package saadaoui.ttdpaysfoodwithjava.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import saadaoui.ttdpaysfoodwithjava.entity.Country;
import saadaoui.ttdpaysfoodwithjava.repos.CountryRepository;

import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {
    private final CountryRepository countryRepository;

    @Autowired
    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public Country createCountry(String name, String continent) {
        Country country = new Country(name, continent);
        return countryRepository.save(country);
    }

    @Override
    public Country findCountryById(Long id) {
        return countryRepository.findById(id).orElse(null);
    }

    @Override
    public List<Country> listAllCountries() {
        return countryRepository.findAll();
    }

    @Override
    public void deleteCountry(Long id) {
        countryRepository.deleteById(id);
    }

    @Override
    public Country updateCountry(Long id, String name, String continent) {
        Country existingCountry = findCountryById(id);
        if (existingCountry != null) {
            existingCountry.setName(name);
            existingCountry.setContinent(continent);
            return countryRepository.save(existingCountry);
        }
        return null;
    }
}
