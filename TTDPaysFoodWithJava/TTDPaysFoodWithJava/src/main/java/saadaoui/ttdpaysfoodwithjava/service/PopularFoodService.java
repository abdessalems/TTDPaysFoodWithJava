package saadaoui.ttdpaysfoodwithjava.service;

import saadaoui.ttdpaysfoodwithjava.entity.PopularFood;

import java.util.List;

public interface PopularFoodService {
    PopularFood createPopularFood(String name, String description, String imageUrl, Long countryId);
    PopularFood findPopularFoodById(Long id);
    List<PopularFood> listPopularFoodsByCountry(Long countryId);
    void deletePopularFood(Long id);
    PopularFood updatePopularFood(Long id, String name, String description, String imageUrl);
}
