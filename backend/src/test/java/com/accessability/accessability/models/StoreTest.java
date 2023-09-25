package com.accessability.accessability.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StoreTest {

    private Store store;

    @BeforeEach
    void setUp() {
        store = new Store();
        store.setId(1L);
        store.setStoreName("restaurante manolito");
        store.setType(Type.restaurant);
        store.setCategory(Category.prm);
        store.setAddress("C/blabla");
        store.setPhone("123456789");
        store.setWeb("manolito.com");
        store.setEmail("manolito@manolito.com");
        store.setImage("image.png");
        Set<Characteristic> characteristics = new HashSet<>();
        characteristics.add(new Characteristic("Característica 1"));
        store.setCharacteristics(characteristics);
    }

    @Test
    void getId() {
        assertEquals(1L, store.getId());
    }

    @Test
    void getStoreName() {
        assertEquals("restaurante manolito", store.getStoreName());
    }

    @Test
    void getType() {
        assertEquals("restaurant", store.getType().toString());
    }

    @Test
    void getCategory() {
        assertEquals("prm", store.getCategory().toString());
    }

    @Test
    void getAddress() {
        assertEquals("C/blabla", store.getAddress());
    }

    @Test
    void getPhone() {
        assertEquals("123456789", store.getPhone());
    }

    @Test
    void getWeb() {
        assertEquals("manolito.com", store.getWeb());
    }

    @Test
    void getEmail() {
        assertEquals("manolito@manolito.com", store.getEmail());
    }

    @Test
    void getImage() {
        assertEquals("image.png", store.getImage());
    }


    @Test
    void getCharacteristics() { assertFalse(store.getCharacteristics().isEmpty()); }


    @Test
    void setStoreName() {
        store.setStoreName("hotel manolita");

        assertEquals("hotel manolita", store.getStoreName());
    }

    @Test
    void setType() {
        store.setType(Type.hotel);

        assertEquals("hotel", store.getType().toString());
    }

    @Test
    void setCategory() {
        store.setCategory(Category.hearing);

        assertEquals("hearing", store.getCategory().toString());
    }

    @Test
    void setAddress() {
        store.setAddress("C/principal");

        assertEquals("C/principal", store.getAddress());
    }

    @Test
    void setPhone() {
        store.setPhone("987654321");

        assertEquals("987654321", store.getPhone());
    }

    @Test
    void setWeb() {
        store.setWeb("hotelmanolita.com");

        assertEquals("hotelmanolita.com", store.getWeb());
    }

    @Test
    void setEmail() {
        store.setEmail("manolita@hotel.com");

        assertEquals("manolita@hotel.com", store.getEmail());
    }

    @Test
    void setImage() {
        store.setImage("testingImage.png");

        assertEquals("testingImage.png", store.getImage());
    }


    @Test
    void setCharacteristics() {
        assertFalse(store.getCharacteristics().isEmpty());
    }
}