package edu.wctc.poker;

import java.util.Arrays;

/**
 * Poker game class with methods to determine if the
 * given hand is two of kind, three of a kind, full
 * house or a flush.
 * @author Kathy Bauer
 * @version 1.0
 */

public class Game {

    public static boolean twoOfAKind(Card[] hand) {
        Arrays.sort(hand, (a, b) -> a.getFace().compareTo(b.getFace()));
        // check first for a higher hand which may contain two of a kind
        if (Game.fullHouse(hand)){
            return false; //this hand is a full house
        }
        for(int i=0;i < hand.length-1; i++) {
            if (hand[i].getFace().equals(hand[i + 1].getFace()) &&
                    hand[i].getFace().equals(hand[i + 2].getFace()) &&
                    hand[i].getFace().equals(hand[i + 3].getFace())) {
                return false; //this is a 4 of a kind hand
            } else if (hand[i].getFace().equals(hand[i + 1].getFace()) &&
                    hand[i].getFace().equals(hand[i + 2].getFace())) {
                return false; //this is a three of a kind hand
            } else if (  hand[i].getFace().equals(hand[i + 1].getFace()) ) {
                return true; //this is a two of a kind hand but not a full house
            }
        }
        return false; //no matching pair
    }

    public static boolean threeOfAKind(Card[] hand) {
        Arrays.sort(hand, (a, b) -> a.getFace().compareTo(b.getFace()));
        // check first for a higher hand which may contain two of a kind
        if (Game.fullHouse(hand)){
            return false; //this hand is a full house
        }
        for(int i=0;i < hand.length-1; i++) {
            if (hand[i].getFace().equals(hand[i + 1].getFace()) &&
                    hand[i].getFace().equals(hand[i + 2].getFace()) &&
                    hand[i].getFace().equals(hand[i + 3].getFace())) {
                return false; //this is a 4 of a kind hand
            } else if ( hand[i].getFace().equals(hand[i + 1].getFace()) &&
                    hand[i].getFace().equals(hand[i + 2].getFace()) ) {
                return true; //this is a three of a kind hand but not a full house
            }
        }
        return false; //no matching three cards
    }

    public static boolean fullHouse(Card[] hand) {
        Arrays.sort(hand, (a, b) -> a.getFace().compareTo(b.getFace()));
        for(int i=0;i < 1; i++) {
            // check first for a pair then three of a kind
            if (  (hand[i].getFace().equals(hand[i+1].getFace()) &&
                    hand[i+2].getFace().equals(hand[i+3].getFace()) &&
                hand[i+2].getFace().equals(hand[i+4].getFace()))  ||
                    // secondly check for three of a kind then a pair
                    (hand[i].getFace().equals(hand[i+1].getFace()) &&
                            hand[i].getFace().equals(hand[i+2].getFace()) &&
                            hand[i+3].getFace().equals(hand[i+4].getFace())) ) return true;
        }
        return false;
    }

    public static boolean flush(Card[] hand) {
        Arrays.sort(hand, (a, b) -> a.getFace().compareTo(b.getFace()));
        int black=0;
        int red=0;
        for(int i=0;i < hand.length-1; i++) {
            if ( hand[i].getSuit().equals(Suit.CLUBS) ||
                    hand[i].getSuit().equals(Suit.SPADES) ) {
                black +=1;
            } else {
                red +=1;
            }
        }
        if (black == 4 || red == 4) {
            return true;
        }
        return false;
    }
}
