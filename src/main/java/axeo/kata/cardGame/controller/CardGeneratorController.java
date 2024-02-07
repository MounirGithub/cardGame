package axeo.kata.cardGame.controller;

import axeo.kata.cardGame.model.Card;
import axeo.kata.cardGame.model.Player;
import axeo.kata.cardGame.service.CardGeneratorService;
import axeo.kata.cardGame.service.SortCardsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class CardGeneratorController {

    private final CardGeneratorService cardGeneratorService;
    private final SortCardsService sortCardsService;

    @Autowired
    public CardGeneratorController(CardGeneratorService cardGeneratorService, SortCardsService sortCardsService) {
        this.cardGeneratorService = cardGeneratorService;
        this.sortCardsService = sortCardsService;
    }

    @GetMapping("/generate")
    public ResponseEntity<?> generateCardsForPlayer() {
        try {
            Player player = cardGeneratorService.tirerLesCartes();
            return ResponseEntity.ok(player);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("error", e.getMessage()));
        }
    }

    @PostMapping("/sort")
    public ResponseEntity<?> sortCards(@RequestBody Player player) {
        player = sortCardsService.sortPlaterCards(player);
        return ResponseEntity.ok(player);
    }
}
