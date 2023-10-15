package com.accessability.accessability.services;

import com.accessability.accessability.dto.StoreCreateRequest;
import com.accessability.accessability.models.Characteristic;
import com.accessability.accessability.models.Store;
import com.accessability.accessability.models.Type;
import com.accessability.accessability.repositories.ICharacteristicRepository;
import com.accessability.accessability.repositories.IStoreRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.yaml.snakeyaml.util.ArrayUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
public class StoreServiceTest {

    @Autowired
    private StoreService                storeService;

    @MockBean
    IStoreRepository                    storeRepository;

    @Autowired
    private ICharacteristicRepository   characteristicRepository;

    @MockBean
    private ImageService                imageService;

    private List<Store>                 storeList;

    private StoreCreateRequest          payload;

    @BeforeEach
    public void setup()
    {
        Store               store;

        storeList = new ArrayList<>(List.of());
        for (int i = 0; i < 2; i++)
        {
            store = new Store();
            store.setStoreName("Store");
            store.setType(Type.restaurant);
            store.setAddress("address");
            store.setCity("city");
            store.setPhone("0000000");
            store.setWeb("store.com");
            store.setEmail("store@gmail.com");
            store.setDescription("description");
            store.setImage("default.png");
            storeList.add(store);
        }
        storeList.get(0).setId(1L);
        storeList.get(1).setId(2L);

        payload = new StoreCreateRequest();
        payload.setStoreName("Store");
        payload.setType(Type.restaurant);
        payload.setAddress("Address");
        payload.setPhone("0000000");
        payload.setWeb("store.com");
        payload.setEmail("store@gmail.com");
        payload.setDescription("description");
        payload.setImage(null);
        payload.setCharacteristicIds(Arrays.asList(1L, 5L, 7L, 8L));
    }

    @Test
    public void test_save_store()
    {
        //Arrange
        String  result;

        when(storeRepository.save(any(Store.class))).thenReturn(any(Store.class));
        //Act
        result = storeService.saveStore(payload, null);
        //Assert
        verify(storeRepository, times(1)).save(any());
        assertEquals("Added new Store", result);
    }

    @Nested
    public class GetStoreById
    {
        @Test
        public void getStoreById_existing_id_returns_a_store()
        {
            //Arrange
            long    storeId;
            Store   expectedStore;
            Store   result;

            storeId = 1L;
            expectedStore = storeList.get(0);
            when(storeRepository.findById(storeId)).thenReturn(Optional.of(expectedStore));
            //Act
            result = storeService.getStoreById(storeId);
            //Assert
            verify(storeRepository, times(1)).findById(storeId);
            assertEquals(expectedStore, result);
        }

        @Test
        public void getStoreById_non_existing_id_returns_null()
        {
            //Arrange
            long    storeId;
            Store   result;

            storeId = storeList.size() + 1L;
            when(storeRepository.findById(storeId)).thenReturn(Optional.empty());
            //Act
            result = storeService.getStoreById(storeId);
            //Assert
            verify(storeRepository, times(1)).findById(storeId);
            assertNull(result);
        }
    }

    @Test
    public void getAllStores_returns_List_of_Store()
    {
        //Arrange
        List<Store> result;
        when(storeRepository.findAll()).thenReturn(storeList);
        //Act
        result = storeService.getAllStores();
        //Assert
        verify(storeRepository, times(1)).findAll();
        assertNotNull(result);
    }

    @Nested
    public class DeleteStoreById
    {
        @Test
        public void deleteStoreById_existing_id_deletes_a_store() throws IOException
        {
            //Arrange
            long    storeId;
            String  expectedMessage;
            String   result;

            storeId = 1L;
            expectedMessage = "Deleted store with ID: " + storeId + ", Deleted images: test";
            doNothing().when(storeRepository).deleteById(any(Long.class));
            when(storeRepository.existsById(any(Long.class))).thenReturn(true);
            when(imageService.deleteUnusedImages()).thenReturn(new StringBuilder("test"));
            //Act
            result = storeService.deleteStoreById(storeId);
            //Assert
            verify(storeRepository, times(1)).deleteById(any(Long.class));
            verify(imageService, times(1)).deleteUnusedImages();
            assertEquals(expectedMessage, result);
        }

        @Test
        public void deleteStoreById_non_existing_id_returns_error_message()
        {
            //Arrange
            long    storeId;
            String  result;
            String  expectedMessage;

            storeId = 1L;
            expectedMessage = "Not deleted, store with ID: " + storeId + " does not exist";
            when(storeRepository.existsById(any(Long.class))).thenReturn(false);
            //Act
            result = storeService.deleteStoreById(storeId);
            //Assert
            verify(storeRepository, times(1)).existsById(any(Long.class));
            assertEquals(expectedMessage, result);
        }

        @Test
        public void deleteStoreById_returns_error_message_when_failing_to_delete_Store() throws IOException
        {
            //Arrange
            long    storeId;
            String  errorMessage;

            storeId = 1L;
            errorMessage = "Simulated Error at storeRepository.deleteById(any(Long.class))";
            when(storeRepository.existsById(any(Long.class))).thenReturn(true);
            doThrow(new RuntimeException(errorMessage)).when(storeRepository).deleteById(any(Long.class));;
            when(imageService.deleteUnusedImages()).thenReturn(new StringBuilder("test"));
            //Act
            try
            {
                storeService.deleteStoreById(storeId);
            }
            // Assert
            catch (Exception error)
            {
                verify(storeRepository, times(1)).deleteById(any(Long.class));
                verify(imageService, times(0)).deleteUnusedImages();
                assertEquals("Store not deleted: " + errorMessage, error.getMessage());
            }
        }

        @Test
        public void deleteStoreById_returns_error_message_when_failing_to_delete_Images() throws IOException
        {
            //Arrange
            long    storeId;
            String  errorMessage;

            storeId = 1L;
            errorMessage = "Simulated Error at imageService.deleteUnusedImages()";
            when(storeRepository.existsById(any(Long.class))).thenReturn(true);
            doNothing().when(storeRepository).deleteById(any(Long.class));
            doThrow(new RuntimeException(errorMessage)).when(imageService).deleteUnusedImages();
            //Act
            try
            {
                storeService.deleteStoreById(storeId);
            }
            // Assert
            catch (Exception error)
            {
                verify(storeRepository, times(1)).deleteById(any(Long.class));
                verify(imageService, times(1)).deleteUnusedImages();
                assertEquals("Store not deleted: " + errorMessage, error.getMessage());
            }
        }
    }

    @Nested
    public class UpdateStoreById
    {
        @Test
        public void updateStoreById_existing_id_updates_a_store() throws IOException
        {
            //Arrange
            long    storeId;
            String  expectedMessage;
            String  result;

            storeId = 1L;
            expectedMessage = "Store updated: " + storeId + ", Deleted images: test";
            when(storeRepository.findById(storeId)).thenReturn(Optional.ofNullable(storeList.get(0)));
            when(storeRepository.save(any(Store.class))).thenReturn(null);
            when(imageService.deleteUnusedImages()).thenReturn(new StringBuilder("test"));
            //Act
            result = storeService.updateStoreById(storeId, payload, null);
            //Assert
            verify(storeRepository, times(1)).findById(any(Long.class));
            verify(storeRepository, times(1)).save(any(Store.class));
            verify(imageService, times(1)).deleteUnusedImages();
            assertEquals(expectedMessage, result);
        }

        @Test
        public void updateStoreById_non_existing_id_shows_message() throws IOException
        {
            //Arrange
            long    storeId;
            String  expectedMessage;
            String  result;

            storeId = 1L;
            expectedMessage = "Store not updated: Record with ID :" + storeId + "does not exist";
            when(storeRepository.findById(storeId)).thenReturn(Optional.empty());
            //Act
            result = storeService.updateStoreById(storeId, payload, null);
            //Assert
            verify(storeRepository, times(1)).findById(any(Long.class));
            verify(storeRepository, times(0)).save(any(Store.class));
            verify(imageService, times(0)).deleteUnusedImages();
            assertEquals(expectedMessage, result);
        }

        @Test
        public void updateStoreById_returns_error_message_when_failing_to_update_Store() throws IOException
        {
            //Arrange
            long    storeId;
            String  errorMessage;

            storeId = 1L;
            errorMessage = "Simulated Error at storeRepository.save(any(Store.class))";
            when(storeRepository.findById(storeId)).thenReturn(Optional.ofNullable(storeList.get(0)));
            doThrow(new RuntimeException(errorMessage)).when(storeRepository).save(any(Store.class));;
            //Act
            try
            {
                storeService.updateStoreById(storeId, payload, null);
            }
            // Assert
            catch (Exception error)
            {
                verify(storeRepository, times(1)).findById(any(Long.class));
                verify(storeRepository, times(1)).save(any(Store.class));
                verify(imageService, times(0)).deleteUnusedImages();
                assertEquals("Store not updated: " + errorMessage, error.getMessage());
            }
        }

        @Test
        public void updateStoreById_returns_error_message_when_failing_to_delete_images() throws IOException
        {
            //Arrange
            long    storeId;
            String  errorMessage;

            storeId = 1L;
            errorMessage = "Simulated Error at imageService.deleteUnusedImages()";
            when(storeRepository.findById(storeId)).thenReturn(Optional.ofNullable(storeList.get(0)));
            when(storeRepository.save(any(Store.class))).thenReturn(null);
            doThrow(new RuntimeException(errorMessage)).when(imageService).deleteUnusedImages();
            //Act
            try
            {
                storeService.updateStoreById(storeId, payload, null);
            }
            // Assert
            catch (Exception error)
            {
                verify(storeRepository, times(1)).findById(any(Long.class));
                verify(storeRepository, times(1)).save(any(Store.class));
                verify(imageService, times(1)).deleteUnusedImages();
                assertEquals("Store not updated: " + errorMessage, error.getMessage());
            }
        }
    }

    @Test
    void mapRequest_set_values_from_request_to_store()
    {
        //arrange
        Store store;

        store = new Store();
        //act
        storeService.mapRequest(store, payload, null);
        //assert
        assertEquals(store.getStoreName(), payload.getStoreName());
        assertEquals(store.getAddress(), payload.getAddress());
        assertEquals(store.getCity(), payload.getCity());
        assertEquals(store.getType(), payload.getType());
        assertEquals(store.getEmail(), payload.getEmail());
        assertEquals(store.getWeb(), payload.getWeb());
        assertEquals(store.getPhone(), payload.getPhone());
        assertEquals(store.getDescription(), payload.getDescription());
    }

    @Nested
    class CategoryAssign
    {
        @Test
        void Stores_are_assigned_distinct_comma_separated_categories_from_its_characteristics()
        {
            //arrange
            List<Characteristic>    selectedCharacteristics;
            String                  categories;
            //act
            selectedCharacteristics = characteristicRepository.findAll();
            categories = storeService.categoryLoad(selectedCharacteristics);
            //assert
            assertEquals("prm,hearing,visual", categories);
        }

        @Test
        void adding_characteristics_from_prm_categories_1_to_6_adds_prm_to_Store()
        {
            //arrange
            List<Characteristic>    selectedCharacteristics;
            String                  categories;
            Long[]                  characteristicIds = {1L, 2L, 3L, 4L, 5L, 6L};
            //act
            selectedCharacteristics = characteristicRepository.findAllById(new ArrayList<>(Arrays.asList(characteristicIds)));
            categories = storeService.categoryLoad(selectedCharacteristics);
            //assert
            assertEquals("prm", categories);
        }

        @Test
        void adding_characteristics_from_hearing_categories_7_to_9_adds_hearing_to_Store()
        {
            //arrange
            List<Characteristic>    selectedCharacteristics;
            String                  categories;
            Long[]                  characteristicIds = {7L, 8L, 9L};
            //act
            selectedCharacteristics = characteristicRepository.findAllById(new ArrayList<>(Arrays.asList(characteristicIds)));
            categories = storeService.categoryLoad(selectedCharacteristics);
            //assert
            assertEquals("hearing", categories);
        }

        @Test
        void adding_characteristics_from_visual_categories_10_to_12_adds_visual_to_Store()
        {
            //arrange
            List<Characteristic>    selectedCharacteristics;
            String                  categories;
            Long[]                  characteristicIds = {10L, 11L, 12L};
            //act
            selectedCharacteristics = characteristicRepository.findAllById(new ArrayList<>(Arrays.asList(characteristicIds)));
            categories = storeService.categoryLoad(selectedCharacteristics);
            //assert
            assertEquals("visual", categories);
        }

        @Test
        void adding_characteristics_from_prm_and_hearing_categories_adds_prmhearing_to_Store()
        {
            //arrange
            List<Characteristic>    selectedCharacteristics;
            String                  categories;
            Long[]                  characteristicIds = {1L, 4L, 8L};
            //act
            selectedCharacteristics = characteristicRepository.findAllById(new ArrayList<>(Arrays.asList(characteristicIds)));
            categories = storeService.categoryLoad(selectedCharacteristics);
            //assert
            assertEquals("prm,hearing", categories);
        }

        @Test
        void adding_characteristics_from_prm_and_visual_categories_adds_prmvisual_to_Store()
        {
            //arrange
            List<Characteristic>    selectedCharacteristics;
            String                  categories;
            Long[]                  characteristicIds = {1L, 4L, 10L, 12L};
            //act
            selectedCharacteristics = characteristicRepository.findAllById(new ArrayList<>(Arrays.asList(characteristicIds)));
            categories = storeService.categoryLoad(selectedCharacteristics);
            //assert
            assertEquals("prm,visual", categories);
        }

        @Test
        void adding_characteristics_from_hearing_and_prm_categories_adds_hearingprm_to_Store()
        {
            //arrange
            List<Characteristic>    selectedCharacteristics;
            String                  categories;
            Long[]                  characteristicIds = {8L, 1L};
            //act
            selectedCharacteristics = characteristicRepository.findAllById(new ArrayList<>(Arrays.asList(characteristicIds)));
            categories = storeService.categoryLoad(selectedCharacteristics);
            //assert
            assertEquals("prm,hearing ", categories);
        }

        @Test
        void adding_characteristics_from_hearing_and_visual_categories_adds_hearingvisual_to_Store()
        {
            //arrange
            List<Characteristic>    selectedCharacteristics;
            String                  categories;
            Long[]                  characteristicIds = {12L, 8L};
            //act
            selectedCharacteristics = characteristicRepository.findAllById(new ArrayList<>(Arrays.asList(characteristicIds)));
            categories = storeService.categoryLoad(selectedCharacteristics);
            //assert
            assertEquals("hearing,visual", categories);
        }
    }

    @Test
    void findByCharacteristicId_calls_custom_method_from_repository_that_returns_a_store_List()
    {
        //arrange
        long        storeId;
        List<Store> returnedStores;

        storeId = 1L;
        when(storeRepository.findByCharacteristicId(any(Long.class))).thenReturn(storeList);
        //act
        returnedStores = storeService.findByCharacteristicId(storeId);
        //assert
        verify(storeRepository, times(1)).findByCharacteristicId(any(Long.class));
        assertNotNull(returnedStores);
    }

    @Nested
    class getFieldValuesInStore
    {
        @Test
        void getCitiesInStore_returns_all_the_cities_present_in_Store_entity()
        {
            //arrange
            List<String>    citiesInStore;

            when(storeRepository.findAll()).thenReturn(storeList);
            //act
            citiesInStore = storeService.getCitiesInStore();
            //assert
            verify(storeRepository, times(1)).findAll();
            assertEquals("city", citiesInStore.get(0));
            assertEquals(1, citiesInStore.size());
        }

        @Test
        void getTypesInStore_returns_all_the_types_present_in_Store_entity()
        {
            //arrange
            List<Type>    typesInStore;

            when(storeRepository.findAll()).thenReturn(storeList);
            //act
            typesInStore = storeService.getTypesInStore();
            //assert
            verify(storeRepository, times(1)).findAll();
            assertEquals(Type.restaurant, typesInStore.get(0));
            assertEquals(1, typesInStore.size());
        }

        @Test
        void Other_fields_can_be_requested_to_getFieldValuesInStore()
        {
            //arrange
            List<Long>      idInStore;
            List<String>    storeNameInStore;

            when(storeRepository.findAll()).thenReturn(storeList);
            //act
            idInStore = storeService.getFieldValuesInStore(Store::getId);
            storeNameInStore = storeService.getFieldValuesInStore(Store::getStoreName);
            //assert
            assertEquals(2, idInStore.size());
            assertEquals(1, storeNameInStore.size());
        }
    }

    @Nested
    class StoreQueries
    {
        @Test
        void searchStores_queries_stores_based_off_city_type_categories()
        {
            //arrange
            List<Store> returnedStores;

            when(storeRepository.searchStores(any(String.class), any(Type.class), any(String.class))).thenReturn(storeList);
            //act
            returnedStores = storeService.searchStores("city", Type.restaurant, "");
            //assert
            verify(storeRepository, times(1)).searchStores(any(String.class), any(Type.class), any(String.class));
            assertNotNull(returnedStores);
        }
    }
}
