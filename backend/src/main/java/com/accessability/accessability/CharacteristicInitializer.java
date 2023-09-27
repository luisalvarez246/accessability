package com.accessability.accessability;

import com.accessability.accessability.models.Category;
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
    public void run(String... args) throws Exception
    {
        if (iCharacteristicRepository.findAll().isEmpty())
        {
            Characteristic characteristic1 = new Characteristic();
            characteristic1.setTitle("Support Staff for PMR");
            characteristic1.setIcon("support_staff.png");
            characteristic1.setCategory(Category.prm);
            iCharacteristicRepository.save(characteristic1);

            Characteristic characteristic2 = new Characteristic();
            characteristic2.setTitle("Access without barriers");
            characteristic2.setIcon("access_prm.png");
            characteristic2.setCategory(Category.prm);
            iCharacteristicRepository.save(characteristic2);

            Characteristic characteristic3 = new Characteristic();
            characteristic3.setTitle("Room adapted for PRM");
            characteristic3.setIcon("room_adapted.png");
            characteristic3.setCategory(Category.prm);
            iCharacteristicRepository.save(characteristic3);

            Characteristic characteristic4 = new Characteristic();
            characteristic4.setTitle("Elevator");
            characteristic4.setIcon("elevator.png");
            characteristic4.setCategory(Category.prm);
            iCharacteristicRepository.save(characteristic4);

            Characteristic characteristic5 = new Characteristic();
            characteristic5.setTitle("Reserved parking for PRM");
            characteristic5.setIcon("parking.png");
            characteristic5.setCategory(Category.prm);
            iCharacteristicRepository.save(characteristic5);

            Characteristic characteristic6 = new Characteristic();
            characteristic6.setTitle("Toilet reserved for PRM");
            characteristic6.setIcon("toilet.png");
            characteristic6.setCategory(Category.prm);
            iCharacteristicRepository.save(characteristic6);

            Characteristic characteristic7 = new Characteristic();
            characteristic7.setTitle("Visual signaling signs");
            characteristic7.setIcon("visual_signaling.png");
            characteristic7.setCategory(Category.hearing);
            iCharacteristicRepository.save(characteristic7);

            Characteristic characteristic8 = new Characteristic();
            characteristic8.setTitle("Sign Language Interpretation");
            characteristic8.setIcon("language_interpretation.png");
            characteristic8.setCategory(Category.hearing);
            iCharacteristicRepository.save(characteristic8);

            Characteristic characteristic9 = new Characteristic();
            characteristic9.setTitle("Magnetic induction loop");
            characteristic9.setIcon("magnetic_induction.png");
            characteristic9.setCategory(Category.hearing);
            iCharacteristicRepository.save(characteristic9);

            Characteristic characteristic10 = new Characteristic();
            characteristic10.setTitle("Assistance dog allowed");
            characteristic10.setIcon("assistance_dog.png");
            characteristic10.setCategory(Category.visual);
            iCharacteristicRepository.save(characteristic10);

            Characteristic characteristic11 = new Characteristic();
            characteristic11.setTitle("Information in braille");
            characteristic11.setIcon("info_braille.png");
            characteristic11.setCategory(Category.visual);
            iCharacteristicRepository.save(characteristic11);

            Characteristic characteristic12 = new Characteristic();
            characteristic12.setTitle("Information in ease reading");
            characteristic12.setIcon("ease_reading.png");
            characteristic12.setCategory(Category.visual);
            iCharacteristicRepository.save(characteristic12);
        }
    }
}
