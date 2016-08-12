package com.internetq.hslibrary;

/**
 * Created by s.bourlinou on 8/1/2016.
 */

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.Generated;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
        "cardId",
        "cardSet",
        "name",
        "text",
        "type",
        "locale",
        "rarity",
        "playerClass",
        "mechanics",
        "img",
        "collectible",
        "faction",
        "imgGold",
        "health",
        "race",
        "attack",
        "cost",
        "artist",
        "howToGetGold",
        "flavor",
        "howToGet",
        "durability",
        "elite"
})
@Entity
@Getter
@Setter
public class Card implements Serializable {

    @JsonProperty("cardSet")
    private String cardSet;
    @JsonProperty("cardId")
    @Id
    private String cardId;
    @JsonProperty("name")
    private String name;
    @JsonProperty("text")
    private String text;
    @JsonProperty("type")
    private String type;
    @JsonProperty("locale")
    private String locale;
    @JsonProperty("rarity")
    private String rarity;
    @JsonProperty("playerClass")
    private String playerClass;
    @JsonProperty("mechanics")
    @OneToMany(cascade = {CascadeType.ALL})
    private List<Mechanic> mechanics = new ArrayList<Mechanic>();
    @JsonProperty("img")
    private String img;
    @JsonProperty("collectible")
    private Boolean collectible;
    @JsonProperty("faction")
    private String faction;
    @JsonProperty("imgGold")
    private String imgGold;
    @JsonProperty("health")
    private Integer health;
    @JsonProperty("race")
    private String race;
    @JsonProperty("attack")
    private Integer attack;
    @JsonProperty("cost")
    private Integer cost;
    @JsonProperty("artist")
    private String artist;
    @JsonProperty("howToGetGold")
    private String howToGetGold;
    @JsonProperty("flavor")
    private String flavor;
    @JsonProperty("howToGet")
    private String howToGet;
    @JsonProperty("durability")
    private Integer durability;
    @JsonProperty("elite")
    private Boolean elite;
}
