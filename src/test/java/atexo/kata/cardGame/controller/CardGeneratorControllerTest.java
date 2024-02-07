package atexo.kata.cardGame.controller;

import atexo.kata.cardGame.model.Card;
import atexo.kata.cardGame.model.Player;
import atexo.kata.cardGame.service.CardGeneratorService;
import atexo.kata.cardGame.service.SortCardsService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class CardGeneratorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private CardGeneratorService cardGeneratorService;

    @Autowired
    private SortCardsService sortCardsService;
    
    @Test
    void testGenratecards() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/generate")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void uniqCards() {
        Player player = cardGeneratorService.tirerLesCartes();
        List<Card> cards = player.getCards();
        Set<String> set = cards.stream().map(a->a.getSymbol() + a.getValeur()).collect(Collectors.toSet());
        assertThat(set.size()).isEqualTo(cards.size()).isEqualTo(10);
    }

    @Test
    public void testTriDesCartes() {
        List<Card> cartesNonTrie = Arrays.asList(
                new Card("2", "Trèfle"),
                new Card("As", "Coeur"),
                new Card("Roi", "Pique"),
                new Card("5", "Coeur"),
                new Card("Dame", "Carreau")
        );
        List<Card> expected = Arrays.asList(
                new Card("Dame", "Carreau"),
                new Card("As", "Coeur"),
                new Card("5", "Coeur"),
                new Card("Roi", "Pique"),
                new Card("2", "Trèfle")
        );
        List<Card> listeTrie = sortCardsService.sortPlaterCards(cartesNonTrie);
        System.out.println(listeTrie);
        assertThat(expected).isEqualTo(listeTrie);
    }
}
