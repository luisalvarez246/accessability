package com.accessability.accessability.initializers;

import com.accessability.accessability.dto.StoreCreateRequest;
import com.accessability.accessability.models.Category;
import com.accessability.accessability.models.Characteristic;
import com.accessability.accessability.models.Store;
import com.accessability.accessability.models.Type;
import com.accessability.accessability.repositories.ICharacteristicRepository;
import com.accessability.accessability.repositories.IStoreRepository;
import com.accessability.accessability.services.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.DependsOn;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

@Component
@Transactional
public class StoreInitializer
{
    @Autowired
    private IStoreRepository    iStoreRepository;

    @Autowired
    private ICharacteristicRepository   iCharacteristicRepository;

    @Autowired
    private StoreService        storeService;

    private Type[]              typeArray = {Type.restaurant, Type.hotel, Type.cafeteria, Type.museum, Type.hairdresser, Type.shops};

    private String[]            cityArray = {"Aviles", "Gijon", "Oviedo"};

    private StoreCreateRequest  store;

    public void storeInitialize()
    {
        Store                   store;
        List<Characteristic> characteristicList;

        if (iStoreRepository.findAll().isEmpty())
        {
            System.out.println("gets here");
            for (int i = 0; i < typeArray.length; i++)
            {
                store = new Store();
                store.setStoreName("Accessability");
                store.setAddress("address");
                store.setPhone("0000000");
                store.setWeb("store.com");
                store.setEmail("store@gmail.com");
                store.setDescription("description");
                store.setType(typeArray[i]);
                store.setCity(cityArray[i % cityArray.length]);
                characteristicList = iCharacteristicRepository.findAllById(Arrays.asList((long) (i + 1), (long) (i + 5)));
                store.setCategories(storeService.categoryLoad(characteristicList));
                store.setImage(typeArray[i] + ".png");
                try
                {
                    iStoreRepository.save(store);
                }
                catch (Exception error)
                {
                    System.out.println(error.getMessage());
                }
            }
        }
    }
}
