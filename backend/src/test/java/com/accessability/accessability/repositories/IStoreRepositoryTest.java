package com.accessability.accessability.repositories;

import com.accessability.accessability.models.Store;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class IStoreRepositoryTest
{
    @Autowired
    IStoreRepository    iStoreRepository;

    @Test
    void findByCharacteristicId_returns_all_the_stores_that_contain_the_searched_characteristic()
    {
        ArrayList<Store> storeList;

        storeList = iStoreRepository.findByCharacteristicId(1L);
        for(Store store : storeList)
        {
            System.out.println(store);
        }
    }
}