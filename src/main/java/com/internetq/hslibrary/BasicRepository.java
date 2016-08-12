package com.internetq.hslibrary;

/**
 * Created by s.bourlinou on 8/1/2016.
 */

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BasicRepository extends JpaRepository<Card, Long> {

    Page<Card> findAll(Pageable pageable);

    Card findByCardId(String cardId);

    List<Card> findByCardSet(String cardSet);

    List<Card> findByName(String name);

    List<Card> findByArtist(String artist);

    List<Card> findByType(String type);

    List<Card> findByRarity(String rarity);

    List<Card> findByPlayerClass(String playerClass);


}
