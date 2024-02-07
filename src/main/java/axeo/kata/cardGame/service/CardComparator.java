package axeo.kata.cardGame.service;

import axeo.kata.cardGame.model.Card;

import java.util.Comparator;

public class CardComparator implements Comparator<Card> {

    private static final String[] COULEURS = {"Carreaux", "Coeur", "Pique", "Trèfle"};
    private static final String[] VALEURS = {"As", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Valet", "Dame", "Roi"};

    @Override
    public int compare(Card carte1, Card carte2) {
        int couleurCompare = compareCouleurs(carte1.getSymbol(), carte2.getSymbol());
        if (couleurCompare != 0) {
            return couleurCompare;
        }
        return compareValeurs(carte1.getValeur(), carte2.getValeur());
    }

    private int compareCouleurs(String couleur1, String couleur2) {
        return Integer.compare(getCouleurIndex(couleur1), getCouleurIndex(couleur2));
    }

    private int compareValeurs(String valeur1, String valeur2) {
        return Integer.compare(getValeurIndex(valeur1), getValeurIndex(valeur2));
    }

    private int getCouleurIndex(String couleur) {
        for (int i = 0; i < COULEURS.length; i++) {
            if (COULEURS[i].equalsIgnoreCase(couleur)) {
                return i;
            }
        }
        return -1;
    }

    private int getValeurIndex(String valeur) {
        for (int i = 0; i < VALEURS.length; i++) {
            if (VALEURS[i].equalsIgnoreCase(valeur)) {
                return i;
            }
        }
        return -1;
    }
}
