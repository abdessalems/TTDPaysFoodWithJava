package saadaoui.ttdpaysfoodwithjava.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import saadaoui.ttdpaysfoodwithjava.entity.Country;

public interface CountryRepository extends JpaRepository<Country, Long> {
}
