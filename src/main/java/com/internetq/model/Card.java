
package com.internetq.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
        "cardSet",
        "cardId",
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
        "durability"
})

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Card extends DefaultEntity implements Serializable {

    @JsonProperty("cardSet")
    public String cardSet;
    @JsonProperty("cardId")
    public String cardId;
    @JsonProperty("name")
    public String name;
    @JsonProperty("text")
    public String text;
    @JsonProperty("type")
    public String type;
    @JsonProperty("locale")
    public String locale;
    @JsonProperty("rarity")
    public String rarity;
    @JsonProperty("playerClass")
    public String playerClass;

    @JsonProperty("mechanics")
    @OneToMany(cascade= CascadeType.ALL)
    public List<Mechanic> mechanics = new ArrayList<Mechanic>();
    @JsonProperty("img")
    public String img;
    @JsonProperty("collectible")
    public boolean collectible;
    @JsonProperty("faction")
    public String faction;
    @JsonProperty("imgGold")
    public String imgGold;
    @JsonProperty("health")
    public long health;
    @JsonProperty("race")
    public String race;
    @JsonProperty("attack")
    public long attack;
    @JsonProperty("cost")
    public long cost;
    @JsonProperty("artist")
    public String artist;
    @JsonProperty("howToGetGold")
    public String howToGetGold;
    @JsonProperty("flavor")
    public String flavor;
    @JsonProperty("howToGet")
    public String howToGet;
    @JsonProperty("durability")
    public long durability;
}
