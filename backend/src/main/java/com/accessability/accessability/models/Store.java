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
@AllArgsConstructor
@NoArgsConstructor
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String storeName;

    @Enumerated(EnumType.STRING)
    private Type type;

    @Enumerated(EnumType.STRING)
    private Category category;

    private String address;

    private String phone;

    private String web;

    private String email;

    private String image;

    @ManyToMany(mappedBy = "store", cascade=CascadeType.ALL)
    private Set<Characteristic> characteristics = new HashSet<>();

}
