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


    public Level()
    {
        init();
    }

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
                //TODO add blocks
                case 'W':
                    break;
                case 'D':
                    break;
                case 'P':
                    break;
                case 'S':
                    break;
                case 'O':
                    //diamond
                    break;
                case 'E':
                    //monster
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




    private void init()
    {
        GameProperties properties = GameProperties.getInstance();
        tailleMapX = properties.getTailleMapX();
        tailleMapY = properties.getTailleMapY();

        map = new Block[tailleMapX][tailleMapY];

    }
}
