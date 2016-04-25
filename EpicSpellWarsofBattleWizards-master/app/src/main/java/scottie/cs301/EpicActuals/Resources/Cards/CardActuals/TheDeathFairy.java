package scottie.cs301.EpicActuals.Resources.Cards.CardActuals;

import java.io.Serializable;
import java.util.Random;

import scottie.cs301.EpicActuals.Resources.Cards.Card;
import scottie.cs301.EpicActuals.Resources.Info.GameStateActual;
import scottie.cs301.Imports.GameFramework.R;

/**
 * Created by mukai18 on 4/12/2016.
 *
 * deals 2 damage to a foe. If that foe dies, deal 2 damage to another foe, and so on
 */
public class TheDeathFairy extends Card implements Serializable{
    //to satisfy the Serializable interface
    private static final long serialVersionUID = 3339755561382710158L;

    /**
     * constructor
     */
    public TheDeathFairy() {
        super(11, 0, 1, R.drawable.thedeathfairy);
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
        // pick random foe and deal 3 damage
        Random gen = new Random();
        int foe = gen.nextInt(currentState.playerHealths.length);

        currentState.damage(2,foe);
    }
}
