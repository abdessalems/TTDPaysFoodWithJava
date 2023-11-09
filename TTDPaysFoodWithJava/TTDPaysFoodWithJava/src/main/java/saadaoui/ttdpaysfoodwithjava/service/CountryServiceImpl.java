package saadaoui.ttdpaysfoodwithjava.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import saadaoui.ttdpaysfoodwithjava.entity.Country;
import saadaoui.ttdpaysfoodwithjava.repos.CountryRepository;

import java.util.List;

@Service
public class CountryServiceImpl implements CountryService
{

    @Autowired
    private CountryRepository countryRepository;

    @Override
    public Country saveCountry(Country country) {
        return countryRepository.save(country);
    }

    @Override
    public Country updateCountry(Country country) {
        return countryRepository.save(country);
    }

    @Override
    public void deleteCountry(Country country) {
        countryRepository.delete(country);
    }

    @Override
    public void deleteCountryById(Long id) {
        countryRepository.deleteById(id);
    }

    @Override
    public Country getCountry(Long id) {
        return countryRepository.findById(id).orElse(null);
    }

    @Override
    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }

}
