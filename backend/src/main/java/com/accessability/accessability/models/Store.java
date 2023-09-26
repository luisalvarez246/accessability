package com.accessability.accessability.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
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

    private String categories;

    private String address;

    private String phone;

    private String web;

    private String email;

    private String image;

    @ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinTable(
            name = "store_characteristic",
            joinColumns = @JoinColumn(name = "store_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "characteristic_id", referencedColumnName = "id")
    )
    private Set<Characteristic> characteristic = new HashSet<>();

    @Override
    public String toString()
    {
        return ("Store " +
                "[storeName=" + storeName + ", " +
                "type=" + type + ", " +
                "categories=" + categories + ", " +
                "address=" + address + ", " +
                "phone=" + phone + ", " +
                "web=" + web + ", " +
                "email=" + email + ", " +
                "image=" + image + ", " +
                "]"
        );
    }

}
