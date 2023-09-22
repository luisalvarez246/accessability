package com.accessability.accessability.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Characteristic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String icon;

    private String title;

    @ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinTable(
            name = "store_characteristic",
            joinColumns = @JoinColumn(name = "store_id"),
                    inverseJoinColumns = @JoinColumn(name = "characteristic_id")
            )
    private Set<Store> store= new HashSet<>();

    public Characteristic(String s) {
    }
}
