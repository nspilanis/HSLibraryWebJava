package com.internetq.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.internetq.model.Card;
import com.internetq.repositories.CardRepository;
import com.internetq.services.ContentService;

/**
 * @author n.spilanis
 * @version 1.0
 * @since 29/7/2016
 */

@Controller
public class MainController {

    private static final Logger log = LoggerFactory.getLogger(MainController.class);

    @Autowired
    private ContentService dataService;

    @Autowired
    private CardRepository cardRepo;

    @RequestMapping("/")
    public String index(Model model) {
        //model.addAttribute("data", dataService.getData());
        //cardRepo.save(dataService.getData());

        return "index";
    }

    @ModelAttribute("allCards")
    public List<Card> populateCards() {
        return cardRepo.findAll();
    }
}
