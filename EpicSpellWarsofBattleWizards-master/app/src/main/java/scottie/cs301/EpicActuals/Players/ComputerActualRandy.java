package scottie.cs301.EpicActuals.Players;

import android.util.Log;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

import scottie.cs301.EpicActuals.Resources.Actions.SendSpell;
import scottie.cs301.EpicActuals.Resources.Cards.Card;
import scottie.cs301.EpicActuals.Resources.Info.GameStateActual;
import scottie.cs301.Imports.GameFramework.GameComputerPlayer;
import scottie.cs301.Imports.GameFramework.infoMsg.GameInfo;
import scottie.cs301.Imports.GameFramework.infoMsg.IllegalMoveInfo;
import scottie.cs301.Imports.GameFramework.infoMsg.NotYourTurnInfo;

/**
 * Created by Zimmerms18 on 3/30/2016.
 * <p>
 * For use in Epic Spell Wars cs301 class project.
 * Team 5: Scott Zimmerman, Markus Perry, Liz Mukai, Teresa Condon
 * <p>
 * This is the basic AI player.
 * It receives info, stores, and responds when asked.
 * This AI will be random. "Smarter" AI(s) will be subclasses of this.
 */
public class ComputerActualRandy extends GameComputerPlayer implements Serializable
{

    protected GameStateActual myRecentState;//full copy of most recently received Game State for easier access

    //to satisfy the Serializable interface
    private static final long serialVersionUID = 3339755561382710158L;
    /*
     * External Citation:
     *  Date: 4/20/16
     *  Problem: could not remember how to use Serializable
     *  Resource: Notes from CS 301-A
     *  Solution: used code from notes
     */


    /**
     * default constructor
     *
     * @param name name of random computer player
     */
    public ComputerActualRandy(String name)
    {
        super(name);
    } //default constructor


    /**
     * overrides the recieveInfo method from the super class
     * assigns value to Recent State and dispatches helper methods
     *
     * @param info GameInfo object passed in
     */
    @Override
    protected void receiveInfo(GameInfo info)
    {
        // do nothing if not your turn
        if (info instanceof NotYourTurnInfo)
        {
            return;
        }

        // if GameStateActual action is taken, send the spell
        if (info instanceof GameStateActual)
        {
            myRecentState = (GameStateActual) info;
            this.sleep(1000); // slow computer to show turns
            game.sendAction(new SendSpell(this, selectNextSpell()));
            Log.i("Computer Player: ", "" + this);//cast it and store
        }

        if (info instanceof IllegalMoveInfo)
        {
                ArrayList<Card> newSpell = this.selectNextSpell();
                game.sendAction(new SendSpell(this, newSpell));
        }
    }

    /**
     * chooses the spell components
     *
     * @return ArrayList containing the cards in the spell
     */
    public ArrayList<Card> selectNextSpell()
    {

        //select a random number of 1, 2, or 3 of cards to pick
        Random rand = new Random();
        int numCardsInSpell = 1 + rand.nextInt(3);

        /**
         * External Citation:
         *  Date: 4/10/16
         *  Problem: didn't remember if nextInt(int n) in Random class was exclusive or inclusive
         *  Resource: https://docs.oracle.com/javase/8/docs/api/java/util/Random.html
         *  Solution: question was answered after reading the description of the above method
         */

        //selects random number of cards from hand and returns it
        ArrayList<Card> spellToSend = new ArrayList<Card>();
        int cardSelector; // iterator

        for (int i = 0; i < numCardsInSpell; i++)
        {
            cardSelector = rand.nextInt(8);
            spellToSend.add(myRecentState.playerHands.get(playerNum).get(cardSelector));
        }
        return spellToSend;
    }

}
