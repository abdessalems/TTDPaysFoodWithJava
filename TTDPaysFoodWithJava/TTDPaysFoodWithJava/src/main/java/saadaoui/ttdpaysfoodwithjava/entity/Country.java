package saadaoui.ttdpaysfoodwithjava.entity;


import jakarta.persistence.*;

import java.util.List;

@Entity
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String continent;
    @OneToMany(mappedBy = "country", cascade = CascadeType.ALL)
    private List<PopularFood> popularFoods;
    public Country() {
    }

    public Country(String name, String continent, List<PopularFood> popularFoods) {
        this.name = name;
        this.continent = continent;
        this.popularFoods = popularFoods;
    }

    public Country(String name, String continent) {
        this.name = name;
        this.continent = continent;
    }
// Getters and setters

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

    public List<PopularFood> getPopularFoods() {
        return popularFoods;
    }

    public void setPopularFoods(List<PopularFood> popularFoods) {
        this.popularFoods = popularFoods;
    }
}
