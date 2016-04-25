package scottie.cs301.EpicActuals.Resources.Cards.CardActuals;

import java.io.Serializable;

import scottie.cs301.EpicActuals.Resources.Cards.Card;
import scottie.cs301.EpicActuals.Resources.Info.GameStateActual;
import scottie.cs301.Imports.GameFramework.R;

/**
 * Created by mukai18 on 4/12/2016.
 *
 * heals caster by 2. if caster is the weakest player, he heals additional 1 health point
 */
public class MightyGro extends Card implements Serializable{
    //to satisfy the Serializable interface
    private static final long serialVersionUID = 3339755561382710158L;

    /**
     * constructor
     */
    public MightyGro() {
        super(57, 0, 2, R.drawable.mightygro);
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
        // find the weakest foe
        int weakest = 0;
        int foeID = 0;
        for (int i = 0; i < currentState.playerHealths.length; i++)
        {
            if (currentState.playerHealths[i]<=weakest)
            {
                weakest = currentState.playerHealths[i];
                foeID = i;
            }
        }

        // heal caster 2 points unless he is the weakest player, then heal 1
        currentState.playerHealths[myCasterID] +=2;
        if (foeID==myCasterID)
        {
            currentState.playerHealths[myCasterID]+=1;
        }
    }
}
