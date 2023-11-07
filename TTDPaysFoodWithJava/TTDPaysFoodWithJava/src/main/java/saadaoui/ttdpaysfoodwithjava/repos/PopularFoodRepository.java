package saadaoui.ttdpaysfoodwithjava.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import saadaoui.ttdpaysfoodwithjava.entity.PopularFood;

public interface PopularFoodRepository extends JpaRepository<PopularFood, Long> {
}
