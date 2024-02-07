package atexo.kata.cardGame.service;

import atexo.kata.cardGame.model.Card;
import atexo.kata.cardGame.model.Player;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CardGeneratorService {
    public List<Card> deckGenerator(){
        Set<String> valeurs = Set.of("As", "5", "10", "8", "6", "7", "4", "2", "3", "9", "Dame", "Roi", "Valet");
        Set<String> symboles = Set.of("Carreaux", "Coeur", "Pique", "Trèfle");

        List<Card> deck = new ArrayList<>();

        for (String symbole : symboles) {
            for (String valeur : valeurs) {
                Card carte = new Card(valeur, symbole);
                deck.add(carte);
            }
        }
        return deck;
    }

    public Player tirerLesCartes() {
        List<Card> playerCards = new ArrayList<>();
        List<Card> deck = deckGenerator();
        Random random = new Random();
        List<Integer> indices = new ArrayList<>();
        while(indices.size() < 10) {
            int indiceAleatoire = random.nextInt(deckGenerator().size());
            System.out.println(playerCards.size());
            if(!indices.contains(indiceAleatoire)) {
                playerCards.add(deck.get(indiceAleatoire));
                indices.add(indiceAleatoire);
            }
        }
        return new Player(playerCards);
    }
}
