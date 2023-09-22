package com.accessability.accessability.repositories;

import com.accessability.accessability.models.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IStoreRepository extends JpaRepository<Store, Long> {
}
