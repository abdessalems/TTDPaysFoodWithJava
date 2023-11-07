package saadaoui.ttdpaysfoodwithjava.service;

import saadaoui.ttdpaysfoodwithjava.entity.Country;

import java.util.List;

public interface CountryService {
    Country createCountry(String name, String continent);
    Country findCountryById(Long id);
    List<Country> listAllCountries();
    void deleteCountry(Long id);
    Country updateCountry(Long id, String name, String continent);
}
