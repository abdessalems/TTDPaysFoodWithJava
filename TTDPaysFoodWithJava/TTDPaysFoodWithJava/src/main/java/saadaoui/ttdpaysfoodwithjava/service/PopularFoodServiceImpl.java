package saadaoui.ttdpaysfoodwithjava.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import saadaoui.ttdpaysfoodwithjava.entity.Country;
import saadaoui.ttdpaysfoodwithjava.entity.PopularFood;
import saadaoui.ttdpaysfoodwithjava.repos.CountryRepository;
import saadaoui.ttdpaysfoodwithjava.repos.PopularFoodRepository;

import java.util.List;

@Service
public class PopularFoodServiceImpl implements PopularFoodService {
    private final PopularFoodRepository popularFoodRepository;
    private final CountryRepository countryRepository;

    @Autowired
    public PopularFoodServiceImpl(PopularFoodRepository popularFoodRepository, CountryRepository countryRepository) {
        this.popularFoodRepository = popularFoodRepository;
        this.countryRepository = countryRepository;
    }

    @Override
    public PopularFood createPopularFood(String name, String description, String imageUrl, Long countryId) {
        Country country = countryRepository.findById(countryId).orElse(null);
        if (country != null) {
            PopularFood popularFood = new PopularFood(name, description, imageUrl, country);
            return popularFoodRepository.save(popularFood);
        }
        return null;
    }

    @Override
    public PopularFood findPopularFoodById(Long id) {
        return popularFoodRepository.findById(id).orElse(null);
    }

    @Override
    public List<PopularFood> listPopularFoodsByCountry(Long countryId) {
        Country country = countryRepository.findById(countryId).orElse(null);
        if (country != null) {
            return popularFoodRepository.findByCountry(country);
        }
        return null;
    }

    @Override
    public void deletePopularFood(Long id) {
        popularFoodRepository.deleteById(id);
    }

    @Override
    public PopularFood updatePopularFood(Long id, String name, String description, String imageUrl) {
        PopularFood existingPopularFood = findPopularFoodById(id);
        if (existingPopularFood != null) {
            existingPopularFood.setName(name);
            existingPopularFood.setDescription(description);
            existingPopularFood.setImageUrl(imageUrl);
            return popularFoodRepository.save(existingPopularFood);
        }
        return null;
    }
}
