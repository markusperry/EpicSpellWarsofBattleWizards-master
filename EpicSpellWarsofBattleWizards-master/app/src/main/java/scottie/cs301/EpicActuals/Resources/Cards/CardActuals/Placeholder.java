package scottie.cs301.EpicActuals.Resources.Cards.CardActuals;

import java.io.Serializable;

import scottie.cs301.EpicActuals.Resources.Cards.Card;
import scottie.cs301.EpicActuals.Resources.Info.GameStateActual;
import scottie.cs301.Imports.GameFramework.R;

/**
 * Created by zimmerms18 on 3/30/2016.
 * <p/>
 * For use in Epic Spell Wars cs301 class project.
 * Team 5: Scott Zimmerman, Markus Perry, Liz Mukai, Teresa Condon
 * <p/>
 * This is an example class.
 * Each contains its initial values and its resolve method.
 */
public
class Placeholder extends Card implements Serializable
    {
        //to satisfy the Serializable interface
        private static final long serialVersionUID = 3339755561382710158L;

        /**
         * constructor
         */
        public Placeholder()
            {
                super(0, 0, 200, R.drawable.cardback);
            } //basic constructor. values hardcoded per subclass

        /**
         * overrides method from superclass
         * heals or damages caster or foes
         *
         * @param currentState current GameStateActual object
         * @param myCasterID   ID of person casting it
         */
        @Override
        public void resolve(GameStateActual currentState, int myCasterID) {
            // does nothing
        }
    }
