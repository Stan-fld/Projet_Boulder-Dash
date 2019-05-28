package entity;

import entity.Block;
import entity.GameProperties;

/**
 * The Level class
 *
 * @author Kevin
 */
public class Level {
    private Block[][] map;
    private int tailleMapX;
    private int tailleMapY;

    /**
     * The Level default constructor
     *
     */
    public Level()
    {
        init();
    }

    /**
     * The charged level constructor
     *
     * @param s the level
     */
    public Level(String s)
    {
        System.out.println(
                s
        );
        int x = 0, y = 0;
        for (int i = 0; i < s.length(); i++)
        {
            switch (s.charAt(i))
            {

                case 'W':
                    //wall
                    break;
                case 'D':
                    //dirt
                    break;
                case 'P':
                    //personnage
                    break;
                case 'S':
                    //stone
                    break;
                case 'O':
                    //diamond
                    break;
                case 'E':
                    //ennemy
                    break;
                case '\n':
                    y++;
                    break;

                default:
                    //erreur
                    break;


            }
        }

    }


    /**
     * The init method
     *
     * It initializes the map
     */

    private void init()
    {
        GameProperties properties = GameProperties.getInstance();
        tailleMapX = properties.getTailleMapX();
        tailleMapY = properties.getTailleMapY();

        map = new Block[tailleMapX][tailleMapY];

    }
}
