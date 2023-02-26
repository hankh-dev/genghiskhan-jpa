package com.example.genghiskhan.kingdom;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="kingdom")
public class Kingdom {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Byte id;

    @Column(length = 45)
    private String name;

    @Column(length = 1000)
    private String description;

    // getters and setters
}
