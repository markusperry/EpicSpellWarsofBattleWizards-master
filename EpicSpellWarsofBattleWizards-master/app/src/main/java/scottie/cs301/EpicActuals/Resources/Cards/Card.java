package scottie.cs301.EpicActuals.Resources.Cards;

import java.io.Serializable;

import scottie.cs301.EpicActuals.Resources.Info.GameStateActual;

/**
 * Created by zimmerms18 on 3/30/2016.
 * <p/>
 * For use in Epic Spell Wars cs301 class project.
 * Team 5: Scott Zimmerman, Markus Perry, Liz Mukai, Teresa Condon
 * <p/>
 * This is the highest level super for each CardActual.
 * It contains public variables for easy dot access elsewhere.
 */
public abstract
class Card implements Serializable
    {
        public final int idNum; //number reference and DECK index
        public final int initiative; //gameplay attribute
        public final int placement; //gameplay attribute
        public final int imageRef; //gameplay attribute

        //to satisfy the Serializable interface
        private static final long serialVersionUID = 3339755561382710158L;

        /**
         * constructor
         *
         * @param myID  ID number of card
         * @param myInit    initiative of card
         * @param myPlace   position in spell
         * @param myImage   image resource
         */
        protected
        Card(int myID,
             int myInit,
             int myPlace,
             int myImage) //basic constructor
        {
            idNum = myID;
            initiative = myInit;
            placement = myPlace;
            imageRef = myImage;

        }

        /**
         * abstract method created in each card class
         *
         * @param currentState  current gamestate
         * @param myCasterID    ID of caster
         */
        public abstract void resolve(GameStateActual currentState, int myCasterID);
    }
