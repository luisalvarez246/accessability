package com.accessability.accessability;

import com.accessability.accessability.models.Characteristic;
import com.accessability.accessability.repositories.ICharacteristicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CharacteristicInitializer implements CommandLineRunner {

    @Autowired
    private ICharacteristicRepository iCharacteristicRepository;

    @Override
    public void run(String... args) throws Exception {
        Characteristic characteristic1 = new Characteristic();
        characteristic1.setTitle("Support Staff for PMR");
        characteristic1.setIcon("personal_apoyo.png");
        iCharacteristicRepository.save(characteristic1);

        Characteristic characteristic2 = new Characteristic();
        characteristic1.setTitle("Support Staff for PMR");
        characteristic1.setIcon("personal_apoyo.png");
        iCharacteristicRepository.save(characteristic2);

        //add more
    }
}
