package scottie.cs301.EpicActuals.Players;

import java.io.Serializable;

import scottie.cs301.Imports.GameFramework.GameHumanPlayer;

/**
 * Created by zimmerms18 on 4/11/2016.
 *
 * Abstract Human super class
 */
public abstract
class HumanAbstract extends GameHumanPlayer implements Serializable
    {
        //to satisfy the Serializable interface
        private static final long serialVersionUID = 3339755561382710158L;

        /**
         * constructor
         *
         * @param name  name of human player
         */
        public
        HumanAbstract(String name)
            {
                super(name);
            }

        /**
         * returns playerID
         *
         * @return playerID
         */
        public
        int id()
            {
                return playerNum;
            }
    }
