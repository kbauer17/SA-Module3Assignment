package edu.wctc.poker.test;

import edu.wctc.poker.Card;
import edu.wctc.poker.Game;
import org.junit.Before;
import org.junit.Test;

import static edu.wctc.poker.Face.*;
import static edu.wctc.poker.Suit.*;
import static org.junit.Assert.assertTrue;


public class GameTest {
    private Card[] hand;

    @Before
    public void setUp() {
        hand = new Card[]{  new Card(THREE,DIAMONDS, 3),
                            new Card(FOUR,DIAMONDS, 4),
                            new Card(TWO,HEARTS, 2),
                            new Card(FIVE,DIAMONDS,5),
                            new Card(SIX,HEARTS,6)};
    }

    @Test
    public void twoOfAKindTest(){
        assertTrue("Hand is not two of a kind",Game.twoOfAKind(hand));
    }

    @Test
    public void threeOfAKindTest(){
        assertTrue("Hand is not three of a kind",Game.threeOfAKind(hand));
    }

    @Test
    public void fullHouseTest(){
        assertTrue("Hand is not a full house",Game.fullHouse(hand));
    }

    @Test
    public void flushTest(){
        assertTrue("Hand is not a flush",Game.flush(hand));
    }

    @Test
    public void straightTest(){
        assertTrue("Hand is not a straight",Game.straight(hand));
    }
}
