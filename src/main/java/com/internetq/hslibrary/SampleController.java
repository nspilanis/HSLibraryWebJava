package com.internetq.hslibrary;

/**
 * Created by s.bourlinou on 7/29/2016.
 */

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.ServletContextAware;

import javax.imageio.ImageIO;
import javax.servlet.ServletContext;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.util.List;

@Controller
public class SampleController implements ServletContextAware {

    private static final Logger log = LoggerFactory.getLogger(SampleController.class);

    private ServletContext servletContext;

    @Autowired
    private BasicRepository basicRepository;

    @RequestMapping("/")
    public String index(Model model) {
        //model.addAttribute("tsaki", getData());
        model.addAttribute("tsakiData", basicRepository.findAll());
        return "hello";
    }

    @RequestMapping(value = "/CardDetails", method= RequestMethod.GET)
    public void search(@RequestParam("id") String singleCardId, Model model) {
        model.addAttribute("singleCardData", getCard(singleCardId));
        model.addAttribute("savedImgPath", saveImage((getCard(singleCardId).getImg()), (getCard(singleCardId).getCardId())));
    }

    @RequestMapping("/search")
    public String search() {
        return "search";
    }

    @RequestMapping(value = "/searchBy", method= RequestMethod.GET, produces="application/json")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody String searchByJSON(@RequestParam(value="critiria") String name,@RequestParam(value="searchTxt") String searchTxt) {
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = null;
        try {
            if (name.equals("CardSet")) {
                jsonString = mapper.writeValueAsString(getCardSet(searchTxt));
            }else if (name.equals("Name")) {
                jsonString = mapper.writeValueAsString(getName(searchTxt));
            }else if(name.equals("Artist")) {
                jsonString = mapper.writeValueAsString(getArtist(searchTxt));
            }else if(name.equals("Type")) {
                jsonString = mapper.writeValueAsString(getType(searchTxt));
            }else if(name.equals("Rarity")) {
                jsonString = mapper.writeValueAsString(getRarity(searchTxt));
            }else if(name.equals("PlayerClass")) {
                jsonString = mapper.writeValueAsString(getPlayerClass(searchTxt));
            }
        } catch (JsonProcessingException e) {
        }

        return jsonString;
    }

    @RequestMapping(value = "/searchBy", method= RequestMethod.GET)
    public String searchByHTML(@RequestParam(value="critiria") String name,@RequestParam(value="searchTxt") String searchTxt, Model model) {

        if (name.equals("CardSet")) {
            model.addAttribute("cardSetData", getCardSet(searchTxt));
        }else if (name.equals("Name")) {
            model.addAttribute("cardSetData", getName(searchTxt));
        }else if(name.equals("Artist")) {
            model.addAttribute("cardSetData", getArtist(searchTxt));
        }else if(name.equals("Type")) {
            model.addAttribute("cardSetData", getType(searchTxt));
        }else if(name.equals("Rarity")) {
            model.addAttribute("cardSetData", getRarity(searchTxt));
        }else if(name.equals("PlayerClass")) {
            model.addAttribute("cardSetData", getPlayerClass(searchTxt));
        }
        return "/searchBy";
    }

    @Override
    public void setServletContext(ServletContext servletContext) {
        this.servletContext = servletContext;

    }

    public String saveImage(String stringUrl, String stringCardId)
    {
        String savedPath = null;
        BufferedImage image = null;
        try {

            URL url = new URL(stringUrl);
            image = ImageIO.read(url);

            String fileName = stringCardId + ".png";

            String filePath = servletContext.getRealPath("/") + "/images/";

            File path = new File(filePath);

            if (!path.exists()) path.mkdirs();

            File fileLocation = new File(filePath + fileName);

            ImageIO.write(image, "png",new File(fileLocation.toString()));

            savedPath = "images/" + fileName ;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return savedPath;
    }

    //TODO() : Phase 2 - do that pretty thing asynchronous
    public String getData(){

        // Only one time
        Unirest.setObjectMapper(new com.mashape.unirest.http.ObjectMapper() {
            private ObjectMapper jacksonObjectMapper
                    = new ObjectMapper();

            public <T> T readValue(String value, Class<T> valueType) {
                try {
                    return jacksonObjectMapper.readValue(value, valueType);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

            public String writeValue(Object value) {
                try {
                    return jacksonObjectMapper.writeValueAsString(value);
                } catch (JsonProcessingException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        HttpResponse<BasicCards> jsonResponse = null;
        try {
            jsonResponse = Unirest.get("https://omgvamp-hearthstone-v1.p.mashape.com/cards")
                    .header("X-Mashape-Key","lPZgrvLPStmshXyIxqaY2ZFeiEXpp1zJ7xwjsnkaZ9chBzRNB3")
                    .asObject(BasicCards.class);
        } catch (UnirestException e) {
            e.printStackTrace();
        }

        BasicCards basic1 = jsonResponse.getBody();
        basicRepository.save(basic1.getBasic());
        basicRepository.save(basic1.getBasicBlackrock());
        basicRepository.save(basic1.getBasicClassic());
        basicRepository.save(basic1.getBasicCredits());
        basicRepository.save(basic1.getBasicDebug());
        basicRepository.save(basic1.getBasicGoblins());
        basicRepository.save(basic1.getBasicGrand());
        basicRepository.save(basic1.getBasicHero());
        basicRepository.save(basic1.getBasicLeague());
        basicRepository.save(basic1.getBasicMissions());
        basicRepository.save(basic1.getBasicNaxxramas());
        basicRepository.save(basic1.getBasicPromo());
        basicRepository.save(basic1.getBasicReward());
        basicRepository.save(basic1.getBasicSystem());
        basicRepository.save(basic1.getBasicTavern());
        basicRepository.save(basic1.getBasicWhispers());

        return basic1 == null ? "" : jsonResponse.getBody().toString();
    }

    public Card getCard(String cardId){
        return basicRepository.findByCardId(cardId);
    }

    public List<Card> getCardSet(String cardSet){
        return basicRepository.findByCardSet(cardSet);
    }

    public List<Card> getName(String name){
        return basicRepository.findByName(name);
    }

    public List<Card> getArtist(String artist){
        return basicRepository.findByArtist(artist);
    }

    public List<Card> getType(String type){
        return basicRepository.findByType(type);
    }

    public List<Card> getRarity(String rarity){
        return basicRepository.findByRarity(rarity);
    }

    public List<Card> getPlayerClass(String playerClass){
        return basicRepository.findByPlayerClass(playerClass);
    }

}
