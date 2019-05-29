package entity;

import entity.Blocks.*;

import javax.xml.stream.events.EndElement;
import java.awt.*;

/**
 * The Level class
 *
 * @author Kevin
 */
public class Level {
    private Block[][] map;
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
        boolean alreadyMoved[][] = new boolean[tailleMapX][tailleMapY];

        Block blockAUpdate;


        //on update chaque block dans la matrice
        for (int y = tailleMapY -1; y > 0; y--)
        {
            for (int x = 0; x < tailleMapX; x++)
            {
                blockAUpdate = map[x][y];
                if (!alreadyMoved[x][y]) {
                    if (blockAUpdate instanceof Fallable && y < tailleMapY - 1) {
                        if (map[x][y + 1] instanceof BackgroundDirt) {
                            moveBlock(Direction.DOWN, x, y);
                            alreadyMoved[x][y + 1] = true;
                        }
                        else if (map[x][y + 1] instanceof Ennemy) {
                            moveBlock(Direction.DOWN, x, y);
                            alreadyMoved[x][y + 1] = true;
                        }
                        else if (map[x][y + 1] instanceof Fallable && map[x+1][y] instanceof BackgroundDirt && map[x+1][y+1] instanceof BackgroundDirt ) {
                            moveBlock(Direction.RIGHT, x, y);
                            alreadyMoved[x+1][y] = true;
                        }
                        else if (map[x][y + 1] instanceof Fallable && map[x-1][y] instanceof BackgroundDirt && map[x-1][y+1] instanceof BackgroundDirt ) {
                            moveBlock(Direction.LEFT, x, y);
                            alreadyMoved[x-1][y] = true;
                        }
                    } else if (blockAUpdate instanceof Ennemy && y < tailleMapY - 1) {
                        if (map[x + 1][y] instanceof BackgroundDirt) {
                            moveBlock(Direction.RIGHT, x, y);
                            alreadyMoved[x + 1][y] = true;
                        } else if (map[x][y - 1] instanceof BackgroundDirt) {
                            moveBlock(Direction.UP, x, y);
                            alreadyMoved[x][y - 1] = true;
                        } else if (map[x - 1][y] instanceof BackgroundDirt) {
                            moveBlock(Direction.LEFT, x, y);
                            alreadyMoved[x - 1][y] = true;
                        } else if (map[x][y + 1] instanceof BackgroundDirt) {
                            moveBlock(Direction.DOWN, x, y);
                            alreadyMoved[x][y + 1] = true;
                        }
                    }
                }

            }
        }
        //On update chaque block a la position demandée
        for (int y = 0; y < tailleMapY; y++) {
            for (int x = 0; x < tailleMapX; x++) {
                if (map[x][y] != null)
                {
                    map[x][y].update(this, x, y);
                }
            }
        }
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
}
