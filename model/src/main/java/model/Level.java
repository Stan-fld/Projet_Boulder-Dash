package model;

import contract.IModel;
import entity.Blocks.*;
import entity.Direction;
import entity.GameProperties;

import java.awt.*;
import java.util.Observable;

/**
 * The Level class
 *
 * @author Kevin
 */
public class Level extends Observable implements IModel {
    private Block[][] map;

    public int getTailleMapX() {
        return tailleMapX;
    }

    public int getTailleMapY() {
        return tailleMapY;
    }

    @Override
    public void setChanged() {
        super.setChanged();
    }

    private int tailleMapX;
    private int tailleMapY;

    private int playerX;
    private int playerY;

    /**
     * The Level default constructor
     *
     */
    public Level()
    {
        init();
    }

    /**
     *
     * The charged level constructor
     *
     * @param s the level
     */
    public Level(String s)
    {
        init();
        System.out.println(s);
        int x = 0, y = 0;
        for (int i = 0; i < s.length(); i++)
        {
            switch (s.charAt(i))
            {

                case 'W':
                    map[x][y] = new Wall(x, y);
                    break;
                case 'D':
                    map[x][y] = new Dirt(x, y);
                    break;
                case 'P':
                    //personnage
                    map[x][y] = new Player(x, y);
                    break;
                case 'S':
                    map[x][y] = new Stone(x, y);
                    //stone
                    break;
                case 'O':
                    map[x][y] = new Diamond(x, y);
                    break;
                case 'E':
                    map[x][y] = new Ennemy(x, y);
                    break;
                case '\n':
                    y++;
                    x = -1;
                    break;
                case ' ':
                    map[x][y] = new BackgroundDirt(x, y);
                    break;

                default:
                    //erreur
                    break;
            }
            x++;
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

    //va faire bouger un block sans condition
    public void moveBlock(Direction direction, int blockX, int blockY)
    {
        Block blockADeplacer = map[blockX][blockY];
        map[blockX][blockY] = new BackgroundDirt(blockX, blockY);

        switch (direction) {
            case UP:
                if (blockY > 0) {
                    map[blockX][blockY - 1] = blockADeplacer;
                }
                break;
            case LEFT:
                if (blockX > 0) {
                    map[blockX - 1][blockY] = blockADeplacer;
                }
                break;
            case DOWN:
                if (blockY < tailleMapY) {
                    map[blockX][blockY + 1] = blockADeplacer;
                }
                break;
            case RIGHT:
                if (blockX < tailleMapX) {
                    map[blockX + 1][blockY] = blockADeplacer;
                }
                break;
        }
    }


    public void update()
    {

    }

    //retourne le block a la position donnée
    public Block getBlock(int x, int y)
    {
        return map[x][y];
    }

    public void print(Graphics g)
    {
        for (int y = 0; y < tailleMapY; y++)
        {
            for (int x = 0; x < tailleMapX; x++)
            {
                if (map[x][y] != null) {
                    map[x][y].print(g);
                }
            }
        }
    }


    public Observable getObservable() {
        return this;
    }
}
