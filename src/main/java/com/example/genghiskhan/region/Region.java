package com.example.genghiskhan.region;

import com.example.genghiskhan.kingdom.Kingdom;
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
@ToString
@Entity(name="region")
public class Region {
    @Id
    private Byte id;

    @Column(length = 45)
    private String name;


    @ManyToOne
    @JoinColumn(name = "kingdom_id", foreignKey=@ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private Kingdom kingdom;

    private Integer money;

    private Integer food;

    private Integer population;

    @Column(name = "military_unit")
    private Byte militaryUnit;

    @Column(name = "training_degree")
    private Byte trainingDegree;


    @ManyToMany(mappedBy = "regions2")
    private Set<Region> regions1 = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "RegionList",
            joinColumns = @JoinColumn(name = "region1_id", foreignKey = @ForeignKey(name = "none", value = ConstraintMode.NO_CONSTRAINT)),
            inverseJoinColumns = @JoinColumn(name = "region2_id", foreignKey = @ForeignKey(name = "none", value = ConstraintMode.NO_CONSTRAINT)))
    private Set<Region> regions2 = new HashSet<>();


    // getters and setters
}


