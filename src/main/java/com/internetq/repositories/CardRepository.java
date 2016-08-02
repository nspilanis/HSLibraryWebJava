package com.internetq.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.internetq.model.Card;

/**
 * @author n.spilanis
 * @version 1.0
 * @since 1/8/2016
 */

@Repository
public interface CardRepository extends JpaRepository<Card, Long> {

    Page<Card> findAll(Pageable pageable);

    Card findByName(String name);
}