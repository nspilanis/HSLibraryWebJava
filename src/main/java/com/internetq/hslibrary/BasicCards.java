package com.internetq.hslibrary;

/**
 * Created by s.bourlinou on 8/1/2016.
 */

import javax.annotation.Generated;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
        "Basic",
        "Classic",
        "Promo",
        "Reward",
        "Naxxramas",
        "Goblins vs Gnomes",
        "Blackrock Mountain",
        "The Grand Tournament",
        "The League of Explorers",
        "Whispers of the Old Gods",
        "Tavern Brawl",
        "Hero Skins",
        "Missions",
        "Credits",
        "System",
        "Debug"
})

@Getter
@Setter
public class BasicCards {

    @JsonProperty("Basic")
    private List<Card> basic = new ArrayList<Card>();
    @JsonProperty("Classic")
    private List<Card> basicClassic = new ArrayList<Card>();
    @JsonProperty("Promo")
    private List<Card> basicPromo = new ArrayList<Card>();
    @JsonProperty("Reward")
    private List<Card> basicReward = new ArrayList<Card>();
    @JsonProperty("Naxxramas")
    private List<Card> basicNaxxramas = new ArrayList<Card>();
    @JsonProperty("Goblins vs Gnomes")
    private List<Card> basicGoblins = new ArrayList<Card>();
    @JsonProperty("Blackrock Mountain")
    private List<Card> basicBlackrock = new ArrayList<Card>();
    @JsonProperty("The Grand Tournament")
    private List<Card> basicGrand = new ArrayList<Card>();
    @JsonProperty("The League of Explorers")
    private List<Card> basicLeague = new ArrayList<Card>();
    @JsonProperty("Whispers of the Old Gods")
    private List<Card> basicWhispers = new ArrayList<Card>();
    @JsonProperty("Tavern Brawl")
    private List<Card> basicTavern = new ArrayList<Card>();
    @JsonProperty("Hero Skins")
    private List<Card> basicHero = new ArrayList<Card>();
    @JsonProperty("Missions")
    private List<Card> basicMissions = new ArrayList<Card>();
    @JsonProperty("Credits")
    private List<Card> basicCredits = new ArrayList<Card>();
    @JsonProperty("System")
    private List<Card> basicSystem = new ArrayList<Card>();
    @JsonProperty("Debug")
    private List<Card> basicDebug = new ArrayList<Card>();
}