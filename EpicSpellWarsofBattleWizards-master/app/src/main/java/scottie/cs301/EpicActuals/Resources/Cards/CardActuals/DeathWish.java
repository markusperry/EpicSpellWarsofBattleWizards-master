package scottie.cs301.EpicActuals.Resources.Cards.CardActuals;

import java.io.Serializable;
import java.util.Random;

import scottie.cs301.EpicActuals.Resources.Cards.Card;
import scottie.cs301.EpicActuals.Resources.Info.GameStateActual;
import scottie.cs301.Imports.GameFramework.R;

/**
 * Created by mukai18 on 4/12/2016.
 *
 * deals out damage to foe on right based on die roll
 */
public class DeathWish extends Card implements Serializable{
    //to satisfy the Serializable interface
    private static final long serialVersionUID = 3339755561382710158L;

    /**
     * constructor
     */
    public DeathWish() {
        super(22, 8, 3, R.drawable.deathwish);
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
        // randomly pick foe
        Random gen = new Random();
        int foe = gen.nextInt(4);

        // deal damage based on input from dice roll
        int roll = (gen.nextInt(6)+1)+(gen.nextInt(6)+1);

        if (roll<=4)
        {
            currentState.damage(2,foe);
            currentState.damage(1,myCasterID);
        }

        else if (roll<=9)
        {
            currentState.damage(3,foe);
            currentState.damage(1,myCasterID);
        }

        else
        {
            currentState.damage(5,foe);
            currentState.damage(1,myCasterID);
        }
    }
}
