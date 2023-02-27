package com.example.genghiskhan.region;

import com.example.genghiskhan.kingdom.Kingdom;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.context.annotation.Lazy;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity(name="region")
public class Region {
    @Id
    private Integer id;

    @Column(length = 45)
    private String name;


    @ManyToOne
    @JoinColumn(name = "kingdom_id")
    private Kingdom kingdom;

    private Integer money;

    private Integer food;

    private Integer population;

    @Column(name = "military_unit")
    private Integer militaryUnit;

    @Column(name = "training_degree")
    private Integer trainingDegree;


    @ManyToMany
    @JoinTable(name="region_rel",
            joinColumns={@JoinColumn(name="region2_id")},
            inverseJoinColumns={@JoinColumn(name="region1_id")})
    private Set<Region> region1 = new HashSet<>();

    @ManyToMany
    @JoinTable(name="region_rel",
            joinColumns={@JoinColumn(name="region1_id")},
            inverseJoinColumns={@JoinColumn(name="region2_id")})
    private Set<Region> region2 = new HashSet<>();


    @Override
    public String toString() {
        return "Region{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", kingdom=" + kingdom +
                ", money=" + money +
                ", food=" + food +
                ", population=" + population +
                ", militaryUnit=" + militaryUnit +
                ", trainingDegree=" + trainingDegree +
//                ", region1=" + region1 +
                ", region2=" + getRegion2Str() +
                '}';
    }


    private String getRegion2Str() {
        String str = "";
        for (Region region : region2) {
            str+= "Region{" +
                    "id=" + region.id +
                    ", name='" + region.name + '\'' +
                    ", kingdom=" + region.kingdom +
                    ", money=" + region.money +
                    ", food=" + region.food +
                    ", population=" + region.population +
                    ", militaryUnit=" + region.militaryUnit +
                    ", trainingDegree=" + region.trainingDegree +
                    '}';
        }
        return str;
    }

    // getters and setters
}


