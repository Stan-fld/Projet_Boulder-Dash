package model;

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

    }

    private void init()
    {
        GameProperties properties = GameProperties.getInstance();
        tailleMapX = properties.getTailleMapX();
        tailleMapY = properties.getTailleMapY();

        map = new Block[tailleMapX][tailleMapY];

    }
}