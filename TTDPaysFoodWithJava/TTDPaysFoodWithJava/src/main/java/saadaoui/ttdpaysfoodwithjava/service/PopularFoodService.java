package saadaoui.ttdpaysfoodwithjava.service;

import saadaoui.ttdpaysfoodwithjava.entity.PopularFood;

import java.util.List;

public interface PopularFoodService {
    PopularFood savePopularFood(PopularFood popularFood);

    PopularFood updatePopularFood(PopularFood popularFood);

    void deletePopularFood(PopularFood popularFood);

    void deletePopularFoodById(Long id);

    PopularFood getPopularFood(Long id);

    List<PopularFood> getAllPopularFoods();

}
