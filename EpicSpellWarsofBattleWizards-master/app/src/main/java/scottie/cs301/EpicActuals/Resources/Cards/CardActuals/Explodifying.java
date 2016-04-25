package scottie.cs301.EpicActuals.Resources.Cards.CardActuals;

import java.io.Serializable;
import java.util.Random;

import scottie.cs301.EpicActuals.Resources.Cards.Card;
import scottie.cs301.EpicActuals.Resources.Info.GameStateActual;
import scottie.cs301.Imports.GameFramework.R;

/**
 * Created by mukai18 on 4/12/2016.
 *
 * chooses a foe and deals damage based on die roll
 */
public class Explodifying extends Card implements Serializable{
    //to satisfy the Serializable interface
    private static final long serialVersionUID = 3339755561382710158L;

    /**
     * constructor
     */
    public Explodifying() {
        super(26, 0, 2, R.drawable.explodifying);
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
        //randomly pick foe
        Random gen = new Random();
        int foe = gen.nextInt(currentState.playerHealths.length);

        // deal damage based on dice roll
        int roll = (gen.nextInt(6)+1)+(gen.nextInt(6)+1);

        if (roll<=4)
        {
            currentState.damage(4,foe);
        }

        else if (roll<=9)
        {
            currentState.damage(3,foe);
            currentState.damage(1,myCasterID);
        }

        else
        {
            currentState.damage(4,foe);
        }
    }
}
