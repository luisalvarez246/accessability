package com.accessability.accessability.repositories;

import com.accessability.accessability.models.Category;
import com.accessability.accessability.models.Store;
import com.accessability.accessability.models.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface IStoreRepository extends JpaRepository<Store, Long>
{
    List<Store> findByCharacteristicId(Long characteristicId);

    @Query("SELECT s FROM Store s WHERE (:city IS NULL OR s.city = :city) AND (:type IS NULL OR s.type = :type) AND (:categories IS NULL OR s.categories LIKE CONCAT('%', :categories, '%'))")
    List<Store> searchStores(
            @Param("city") String city,
            @Param("type") Type type,
            @Param("categories") String categories
    );
}
