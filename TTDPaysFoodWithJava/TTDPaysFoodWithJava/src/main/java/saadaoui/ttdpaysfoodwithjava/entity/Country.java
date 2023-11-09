package saadaoui.ttdpaysfoodwithjava.entity;

import jakarta.persistence.*;
import saadaoui.ttdpaysfoodwithjava.entity.PopularFood;

import java.util.List;
import java.util.stream.Collectors;

@Entity
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String continent;

    @OneToMany(mappedBy = "country", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    private List<PopularFood> popularFoods;

    public Country() {
    }

    public Country(Long id, String name, String continent, List<PopularFood> popularFoods) {
        this.id = id;
        this.name = name;
        this.continent = continent;
        this.popularFoods = popularFoods;
    }

    public Country(String name, String continent) {
        this.name = name;
        this.continent = continent;
    }


    public Country(String name) {
        this.name = name;
    }

    public List<PopularFood> getPopularFoods() {
        return popularFoods;
    }

    public void setPopularFoods(List<PopularFood> popularFoods) {
        this.popularFoods = popularFoods;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    // Other methods and overrides

    @Override
    public String toString() {
        return "Country{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", continent='" + continent + '\'' +
                ", popularFoods=" + popularFoods +
                '}';
    }
}

