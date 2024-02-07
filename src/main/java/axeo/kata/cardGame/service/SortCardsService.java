package axeo.kata.cardGame.service;

import axeo.kata.cardGame.model.Card;
import axeo.kata.cardGame.model.Player;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class SortCardsService {

    public Player sortPlaterCards(Player player) {
        Collections.sort(player.getCards(), new CardComparator());
        return player;
    }

    public List<Card> sortPlaterCards(List<Card> cards) {
        Collections.sort(cards, new CardComparator());
        return cards;
    }
}
