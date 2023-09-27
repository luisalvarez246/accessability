package com.accessability.accessability.repositories;

import com.accessability.accessability.models.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface IStoreRepository extends JpaRepository<Store, Long>
{
    ArrayList<Store> findByCharacteristicId(Long characteristicId);
}
