package scottie.cs301.EpicActuals.Resources.Cards.CardActuals;

import java.io.Serializable;
import java.util.Random;

import scottie.cs301.EpicActuals.Resources.Cards.Card;
import scottie.cs301.EpicActuals.Resources.Info.GameStateActual;
import scottie.cs301.Imports.GameFramework.R;

/**
 * Created by mukai18 on 4/12/2016.
 *
 * deals damage to strongest player based die roll
 */
public class Gorenado extends Card implements Serializable{
    //to satisfy the Serializable interface
    private static final long serialVersionUID = 3339755561382710158L;

    /**
     * constructor
     */
    public Gorenado() {
        super(28, 2, 3, R.drawable.gorenado);
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
        // find the strongest player
        int strongest = 0;
        int foeID = 0;

        for (int i = 0; i < currentState.playerHealths.length; i++)
        {
            if (currentState.playerHealths[i]>=strongest)
            {
                strongest = currentState.playerHealths[i];
                foeID = i;
            }
        }

        // deal damage based on input from dice roll
        Random gen = new Random();

        int roll = (gen.nextInt(6)+1)+(gen.nextInt(6)+1);

        if (roll<=4)
        {
            currentState.damage(2,foeID);
        }

        else if (roll<=9)
        {
            currentState.damage(3,foeID);
        }

        else
        {
            currentState.damage(6,foeID);
        }
    }
}
