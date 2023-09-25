package com.accessability.accessability.models;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class CharacteristicTest {

    private Characteristic characteristic;

    @BeforeEach
    void setUp() {
        characteristic = new Characteristic();
        characteristic.setId(1L);
        characteristic.setTitle("test characteristic");
        characteristic.setIcon("image.png");
        /*
        Set<Store> store = new HashSet<>();
        store.add(new Store(1L, "hotel pepita", Type.hotel, Category.visual, "C/calle", "123123123", "hotel.com", "hotel@pepita.com", "image.png", ""));
        */
    }


    @Test
    void getId() {
        assertEquals(1L, characteristic.getId());
    }

    @Test
    void getIcon() {
        assertEquals("image.png", characteristic.getIcon());
    }

    @Test
    void getTitle() {
        assertEquals("test characteristic", characteristic.getTitle());
    }


    @Test
    void setIcon() {
        characteristic.setIcon("testingImage.png");

        assertEquals("testingImage.png", characteristic.getIcon());
    }

    @Test
    void setTitle() {
        characteristic.setTitle("testing setter");

        assertEquals("testing setter", characteristic.getTitle());
    }


    /*
    @Test
    void setStore() {
    }
    */

}