package scottie.cs301.EpicActuals.Resources.Actions;

import java.io.Serializable;
import java.util.ArrayList;

import scottie.cs301.EpicActuals.Resources.Cards.Card;
import scottie.cs301.Imports.GameFramework.GamePlayer;
import scottie.cs301.Imports.GameFramework.actionMsg.GameAction;

/**
 * Created by Zimmerms18 on 3/30/2016.
 * <p/>
 * For use in Epic Spell Wars cs301 class project.
 * Team 5: Scott Zimmerman, Markus Perry, Liz Mukai, Teresa Condon
 * <p/>
 * The main player action.
 * Sending three cards as int indices that refer to the DECK element.
 */
public class SendSpell extends GameAction implements Serializable{
    public ArrayList<Card> theSpell; //the three cards being sent

    //to satisfy the Serializable interface
    private static final long serialVersionUID = 3339755561382710158L;

    /**
     * constructor
     *
     * @param player    GamePlayer object
     * @param inComingSpell   arraylist of cards in spell
     */
    public SendSpell(GamePlayer player, ArrayList<Card> inComingSpell)
    {
        super(player);
        theSpell = inComingSpell;
    }
}
