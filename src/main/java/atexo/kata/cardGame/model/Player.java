package atexo.kata.cardGame.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class Player {
    private static final AtomicInteger counter = new AtomicInteger(0);
    private int idPlayer;
    private List<Card> cards;

    public Player(List<Card> c){
        this.cards = c;
        this.idPlayer = counter.getAndIncrement();
    }
}