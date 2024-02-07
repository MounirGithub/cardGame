package axeo.kata.cardGame.model;

import lombok.Data;

@Data
public class Card {
    private String valeur;
    private String symbol;

    public Card(String val, String sym) {
        this.valeur = val;
        this.symbol = sym;
    }
}