package com.accessability.accessability.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @Enumerated(EnumType.STRING)
    private Category category;

    @ManyToMany(mappedBy = "characteristic", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JsonIgnore
    private Set<Store> store= new HashSet<>();

    @Override
    public String toString()
    {
        return ("Request " +
                "[id=" + id + ", " +
                "icon=" + icon + ", " +
                "title=" + title +"]"
        );
    }

}
