package edu.wctc.poker;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static edu.wctc.poker.Face.*;
import static edu.wctc.poker.Suit.*;


/**
 * Poker game class with static methods to determine if the
 * given hand is two of kind, three of a kind, full
 * house or a flush.
 * @author Kathy Bauer
 * @version 1.0
 */

public class Game {

    /**
     * A static method looking for two of a kind
     * @param hand
     * @return True if the hand has only two of a kind, otherwise false
     */
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

    /**
     * A static method looking for three of a kind
     * @param hand
     * @return True if the hand has only three of a kind, otherwise false
     */
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

    /**
     * A static method looking for a full house
     * @param hand
     * @return True if the hand is a full house, otherwise false
     */
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

    /**
     * A static method looking for a flush
     * @param hand
     * @return True if the hand is a flush, otherwise false
     */
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

    /**
     * A static method using streams to check for a straight
     * @param hand
     * @return True if the hand is a straight, otherwise false
     */
    public static boolean straight(Card[] hand) {
        List<Card> handSortedByValue = Arrays.stream(hand)
                .sorted(Comparator.comparingInt(Card::getValue))
                .collect(Collectors.toList());
        int difference = 0;
        int numberOfComparisons = 0;
        for (int i = 0; i < hand.length-1; i++) {
            difference = handSortedByValue.get(i + 1).getValue() - handSortedByValue.get(i).getValue();
            if (difference != 1) {
                return false;
            } else {
                numberOfComparisons +=1;
                difference = 0;
            }
        }
        if (numberOfComparisons == 4){
            return true;
        }
        return false;
    }
}
