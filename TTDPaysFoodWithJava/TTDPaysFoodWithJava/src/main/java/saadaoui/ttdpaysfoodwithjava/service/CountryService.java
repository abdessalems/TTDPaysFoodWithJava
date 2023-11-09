package saadaoui.ttdpaysfoodwithjava.service;

import saadaoui.ttdpaysfoodwithjava.entity.Country;

import java.util.List;

public interface CountryService {

    Country saveCountry(Country country);

    Country updateCountry(Country country);

    void deleteCountry(Country country);

    void deleteCountryById(Long id);

    Country getCountry(Long id);

    List<Country> getAllCountries();

}
