package saadaoui.ttdpaysfoodwithjava.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import saadaoui.ttdpaysfoodwithjava.entity.Country;
import saadaoui.ttdpaysfoodwithjava.entity.PopularFood;

import java.util.List;

public interface PopularFoodRepository extends JpaRepository<PopularFood, Long> {

}
