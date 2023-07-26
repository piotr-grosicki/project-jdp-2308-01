package com.kodilla.ecommercee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GenericEntityRepository extends JpaRepository<GenericEntity, Long> {
    @Override
    List<GenericEntity> findAll();

    @Override
    GenericEntity save (GenericEntity genericEntity);

    @Override
    Optional<GenericEntity> findById(Long id);

}
