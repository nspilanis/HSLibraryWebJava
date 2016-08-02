package com.internetq.controllers;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    private HttpServletRequest request;

    @Autowired
    private ContentService dataService;

    @Autowired
    private CardRepository cardRepo;

    @RequestMapping(value = "/")
    public String index(Model model) {
        //model.addAttribute("data", dataService.getData());
        //cardRepo.save(dataService.getData());

        return "index";
    }

    @RequestMapping(value = "/carddetails")
    public String index(@RequestParam String id, Model model) {

        Card card = cardRepo.findByCardId(id);

        model.addAttribute("card", card);

        if (card.img != null) {
            try {
                log.debug(card.img);

                try (InputStream in = new URL(card.img).openStream()) {

                    String filepath = request.getServletContext().getRealPath("/photos/");

                    if (!new File(filepath).exists()) {
                        new File(filepath).mkdir();
                    }

                    log.info("filepath = {}", filepath);

                    Files.copy(in, Paths.get(filepath + String.format("%s.jpg", card.cardId)));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return "carddetails";
    }

    @ModelAttribute("allCards")
    public List<Card> populateCards() {
        return cardRepo.findAll();
    }
}
