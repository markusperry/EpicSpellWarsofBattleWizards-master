package scottie.cs301.EpicActuals.Resources.Cards.CardActuals;

import java.io.Serializable;
import java.util.Random;

import scottie.cs301.EpicActuals.Resources.Cards.Card;
import scottie.cs301.EpicActuals.Resources.Info.GameStateActual;
import scottie.cs301.Imports.GameFramework.R;

/**
 * Created by mukai18 on 4/12/2016.
 *
 * heals the player casting it, all the foes roll and if they roll a 6, they will heal 3
 */
public class DrRootyBark extends Card implements Serializable{
    //to satisfy the Serializable interface
    private static final long serialVersionUID = 3339755561382710158L;

    /**
     * constructor
     */
    public DrRootyBark() {
        super(54, 0, 1, R.drawable.drrootybark);
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
        // heal caster 3 points
        currentState.playerHealths[myCasterID] +=3;

        Random gen = new Random();
        int roll = 0;

        // if any foe rolls a 6, he heals 3 points
        for (int i = 0; i < currentState.playerHealths.length; i++)
        {
            roll = gen.nextInt(6)+1;
            if (roll==6)
            {
                currentState.playerHealths[i] +=3;
            }
        }

    }
}
