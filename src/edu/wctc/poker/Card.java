package edu.wctc.poker;

/**
 * Class creating the Card objects consisting of
 * the face (in ENUM class FACE, ie TWO, THREE,etc.),
 * the suit (in ENUM class SUIT, ie CLUBS, etc.),
 * and value (integer corresponding to the face value of the card,
 * where ace is high = 14).
 * @author Kathy Bauer
 * @version 1.0
 */

public class Card {
    private Face face;
    private Suit suit;
    private int value;

    public Card(Face face, Suit suit, int value) {
        this.face = face;
        this.suit = suit;
        this.value = value;
    }

    public Face getFace() {
        return face;
    }

    public Suit getSuit() {
        return suit;
    }

    public int getValue() {
        return value;
    }
}
