package com.accessability.accessability.repositories;

import com.accessability.accessability.models.Characteristic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICharacteristicRepository extends JpaRepository<Characteristic, Long> {
}
