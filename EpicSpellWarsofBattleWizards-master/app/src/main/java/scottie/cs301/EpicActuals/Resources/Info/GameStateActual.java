package scottie.cs301.EpicActuals.Resources.Info;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

import scottie.cs301.EpicActuals.Resources.Cards.Card;
import scottie.cs301.EpicActuals.Resources.Cards.Deck;
import scottie.cs301.Imports.GameFramework.infoMsg.GameState;

/**
 * Created by Zimmerms18 on 3/30/2016.
 * <p/>
 * For use in Epic Spell Wars cs301 class project.
 * Team 5: Scott Zimmerman, Markus Perry, Liz Mukai, Teresa Condon
 * <p/>
 * GameState subclass that contains all of current game information.
 * Basic methods provided, although most action taken in LocalGameActual.
 */
public class GameStateActual extends GameState implements Serializable{
    //to satisfy the Serializable interface
    private static final long serialVersionUID = 3339755561382710158L;
    public int[] playerHealths; // array of players' healths
    private int whoseTurn; // ID number of current player
    public ArrayList<ArrayList<Card>> playerHands; // arraylist of all the cards in each players' hand

    public int getWhoseTurn() {
        return whoseTurn;
    }

    public void setWhoseTurn(int whoseTurn) {
        this.whoseTurn = whoseTurn;
    }

    /**
     * starting constructor
     */
    public GameStateActual() {
        // initalizes everything
        playerHealths = new int[4];
        playerHands = new ArrayList<ArrayList<Card>>();

        for(int itter = 0; itter < 4; itter++)
        {
            playerHealths[itter] = 15;
            playerHands.add(itter,deal(8));
        }
        whoseTurn=0;
    }

    /**
     * copy constructor
     * @param original GameStateActual object to copy
     */
    public GameStateActual(GameStateActual original) {
        // copy over all variables
        playerHealths = new int[4];
        playerHands = new ArrayList<ArrayList<Card>>();
        for (int i = 0; i < 4; i++) {
            playerHealths[i]=original.playerHealths[i];
           playerHands.add(i,original.playerHands.get(i));
        }
        whoseTurn = original.whoseTurn;
    }

    /**
     * choose a random card from the deck
     *
     * @return random Card chosen
     */
    public Card randomCardFrom() {
        Random RRR = new Random();
        Card randomCard = Deck.theDeck.get(RRR.nextInt(Deck.theDeck.size()));
        return randomCard;
    }

    /**
     * deals damage to one specific player
     *
     * @param damageVal amount to damage
     * @param playerToDamage    ID number of player affected
     */
    public void damage(int damageVal, int playerToDamage)
    {
        // death check
        if (playerHealths[playerToDamage] - damageVal >= 0) {
            playerHealths[playerToDamage] -= damageVal;
        }
        else {
            return;
        }
    }

    /**
     * deals damage to multiple players
     *
     * @param damageVal amount to damage
     * @param playersToDamage arraylist of ID's of players affected
     */
    public void damageMultiple(int damageVal, ArrayList<Integer>playersToDamage)
    {
        for (int a: playersToDamage)
        {
            // death check
            if (playerHealths[a] - damageVal >= 0) {
                playerHealths[a] -= damageVal;
            }
        }
    }

    /**
     * deals damage to all players, except for one
     *
     * @param damageVal amount to damage
     * @param playerNoDamage arraylist of ID's of players affected
     */
    public void damageAll(int damageVal, int playerNoDamage)
    {
        for (int i = 0; i < playerHealths.length; i++)
        {
            if (i!=playerNoDamage)
            {
                // death check
                if (playerHealths[i] - damageVal >= 0) {
                    playerHealths[i] -= damageVal;
                }
            }
        }
    }

    /**
     * fills hand to 8 cards
     *
     * @param numCards number of cards to refill
     * @return arraylist of card objects needed to refill hand to 8
     */
    public ArrayList<Card> deal(int numCards)
    {
        Deck myDeck = new Deck();
        ArrayList<Card> toDeal = new ArrayList<Card>();
        for (int i = 0; i < 8; i++) {
            toDeal.add(randomCardFrom());
        }
        return toDeal;
    }

    /**
     * deals a new hand to player who just casted spell
     *
     * @param playerNum ID of player who just played
     * @param theCastedSpell cards of the casted spell
     */
    public void dealNewHandTo(int playerNum, ArrayList<Card> theCastedSpell)
    {
        // removes cards just played from hand
        ArrayList<Card> newHand;
        for (Card a :theCastedSpell)
        {
            playerHands.get(playerNum).remove(a);
        }

        // replaces them
        newHand = this.deal(theCastedSpell.size());
        playerHands.get(playerNum).addAll(newHand);

    }

    /**
     * changes whose turn it is (numerical order)
     *
     * @param playerNum ID of player who just played
     */
    public void incrementTurn(int playerNum)
    {
        if (playerNum+1==4)
        {
            setWhoseTurn(0);
        }
        else
        {
            setWhoseTurn(playerNum+1);
        }
    }
}
