package scottie.cs301.EpicActuals.Resources.Cards.CardActuals;

import java.io.Serializable;
import java.util.Random;

import scottie.cs301.EpicActuals.Resources.Cards.Card;
import scottie.cs301.EpicActuals.Resources.Info.GameStateActual;
import scottie.cs301.Imports.GameFramework.R;

/**
 * Created by mukai18 on 4/12/2016.
 *
 * rolls die and either heals or damages caster accordinly
 */
public class OldScratch extends Card implements Serializable{
    //to satisfy the Serializable interface
    private static final long serialVersionUID = 3339755561382710158L;

    /**
     * constructor
     */
    public OldScratch() {
        super(13, 0, 1, R.drawable.oldscratch);
    }

    /**
     * overrides method from superclass
     * heals or damages caster or foes
     *
     * @param currentState current GameStateActual object
     * @param myCasterID   ID of person casting it
     */
    @Override
    public void resolve(GameStateActual currentState, int myCasterID) {
        // damage or heal caster based on dice roll
        Random gen = new Random();
        int roll = gen.nextInt(6)+1;

        if (roll<=3)
        {
            currentState.damage(roll,myCasterID);
        }
        else
        {
            currentState.playerHealths[myCasterID]+=roll;
        }
    }
}
