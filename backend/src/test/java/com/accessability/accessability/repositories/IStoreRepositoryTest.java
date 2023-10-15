package com.accessability.accessability.repositories;

import com.accessability.accessability.dto.StoreCreateRequest;
import com.accessability.accessability.models.Store;
import com.accessability.accessability.models.Type;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class IStoreRepositoryTest
{
    @Autowired
    IStoreRepository            iStoreRepository;

    @Test
    void findByCharacteristicId_returns_all_the_stores_that_contain_the_searched_characteristic()
    {
        List<Store> storeList;

        storeList = iStoreRepository.findByCharacteristicId(1L);
        for(Store store : storeList)
        {
            System.out.println(store);
        }
    }
}