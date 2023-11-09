package saadaoui.ttdpaysfoodwithjava.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import saadaoui.ttdpaysfoodwithjava.entity.Country;
import saadaoui.ttdpaysfoodwithjava.entity.PopularFood;
import saadaoui.ttdpaysfoodwithjava.repos.CountryRepository;
import saadaoui.ttdpaysfoodwithjava.repos.PopularFoodRepository;

import java.util.List;

@Service
public class PopularFoodServiceImpl implements PopularFoodService
{
    @Autowired
    private PopularFoodRepository popularFoodRepository;

    @Override
    public PopularFood savePopularFood(PopularFood popularFood) {
        return popularFoodRepository.save(popularFood);
    }

    @Override
    public PopularFood updatePopularFood(PopularFood popularFood) {
        return popularFoodRepository.save(popularFood);
    }

    @Override
    public void deletePopularFood(PopularFood popularFood) {
        popularFoodRepository.delete(popularFood);
    }

    @Override
    public void deletePopularFoodById(Long id) {
        popularFoodRepository.deleteById(id);
    }

    @Override
    public PopularFood getPopularFood(Long id) {
        return popularFoodRepository.findById(id).orElse(null);
    }

    @Override
    public List<PopularFood> getAllPopularFoods() {
        return popularFoodRepository.findAll();
    }

}
