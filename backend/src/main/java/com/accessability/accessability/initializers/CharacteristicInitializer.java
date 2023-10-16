package com.accessability.accessability.initializers;

import com.accessability.accessability.models.Category;
import com.accessability.accessability.models.Characteristic;
import com.accessability.accessability.repositories.ICharacteristicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
public class CharacteristicInitializer {

    @Autowired
    private ICharacteristicRepository   iCharacteristicRepository;

    @Autowired
    private StoreInitializer            storeInitializer;

    public void characteristicInitialize()
    {
        if (iCharacteristicRepository.findAll().isEmpty())
        {
            Characteristic characteristic1 = new Characteristic();
            characteristic1.setTitle("Support Staff for PMR");
            characteristic1.setIcon("support_staff.svg");
            characteristic1.setCategory(Category.prm);
            iCharacteristicRepository.save(characteristic1);

            Characteristic characteristic2 = new Characteristic();
            characteristic2.setTitle("Access without barriers");
            characteristic2.setIcon("access_prm.svg");
            characteristic2.setCategory(Category.prm);
            iCharacteristicRepository.save(characteristic2);

            Characteristic characteristic3 = new Characteristic();
            characteristic3.setTitle("Room adapted for PRM");
            characteristic3.setIcon("room_adapted.svg");
            characteristic3.setCategory(Category.prm);
            iCharacteristicRepository.save(characteristic3);

            Characteristic characteristic4 = new Characteristic();
            characteristic4.setTitle("Elevator");
            characteristic4.setIcon("elevator.svg");
            characteristic4.setCategory(Category.prm);
            iCharacteristicRepository.save(characteristic4);

            Characteristic characteristic5 = new Characteristic();
            characteristic5.setTitle("Reserved parking for PRM");
            characteristic5.setIcon("parking.svg");
            characteristic5.setCategory(Category.prm);
            iCharacteristicRepository.save(characteristic5);

            Characteristic characteristic6 = new Characteristic();
            characteristic6.setTitle("Toilet reserved for PRM");
            characteristic6.setIcon("toilet.svg");
            characteristic6.setCategory(Category.prm);
            iCharacteristicRepository.save(characteristic6);

            Characteristic characteristic7 = new Characteristic();
            characteristic7.setTitle("Visual signaling signs");
            characteristic7.setIcon("visual_signaling.svg");
            characteristic7.setCategory(Category.hearing);
            iCharacteristicRepository.save(characteristic7);

            Characteristic characteristic8 = new Characteristic();
            characteristic8.setTitle("Sign Language Interpretation");
            characteristic8.setIcon("language_interpretation.svg");
            characteristic8.setCategory(Category.hearing);
            iCharacteristicRepository.save(characteristic8);

            Characteristic characteristic9 = new Characteristic();
            characteristic9.setTitle("Magnetic induction loop");
            characteristic9.setIcon("magnetic_induction.svg");
            characteristic9.setCategory(Category.hearing);
            iCharacteristicRepository.save(characteristic9);

            Characteristic characteristic10 = new Characteristic();
            characteristic10.setTitle("Assistance dog allowed");
            characteristic10.setIcon("assistance_dog.svg");
            characteristic10.setCategory(Category.visual);
            iCharacteristicRepository.save(characteristic10);

            Characteristic characteristic11 = new Characteristic();
            characteristic11.setTitle("Information in braille");
            characteristic11.setIcon("info_braille.svg");
            characteristic11.setCategory(Category.visual);
            iCharacteristicRepository.save(characteristic11);

            Characteristic characteristic12 = new Characteristic();
            characteristic12.setTitle("Information in ease reading");
            characteristic12.setIcon("ease_reading.svg");
            characteristic12.setCategory(Category.visual);
            iCharacteristicRepository.save(characteristic12);
        }
    }
}
