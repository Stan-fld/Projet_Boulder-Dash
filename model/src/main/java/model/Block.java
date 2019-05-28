package model;

import contract.IBlock;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class Block extends Rectangle implements IBlock {

    private BufferedImage image;

    public static int getSizeX() {
        return sizeX;
    }

    public static int getSizeY() {
        return sizeY;
    }

    //Ecriture de la taille des blocks
    private static int sizeX;
    private static int sizeY;

    protected Block()
    {

        super();
        init(null);
    }


    public Block(BufferedImage img)
    {
        super(sizeX, sizeY);
        init(img);
    }

    public Block(int x, int y, BufferedImage img)
    {
        super(x, y, sizeX, sizeY);
        init(img);
    }

    private void init(BufferedImage img)
    {
        this.setImage(img);
        GameProperties properties = GameProperties.getInstance();
        sizeX = properties.getSizeX();
        sizeY = properties.getSizeY();
    }


    public BufferedImage getImage() {
        return this.image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }

    public void move(Direction direction)
    {
        if (direction == Direction.UP)
        {
            this.setLocation((int) (this.getX() + this.getWidth()), (int) (this.getY() + this.getHeight()));
        }
    }

    public void print(Graphics g)
    {
        g.drawImage(this.getImage(), (int) this.getX(), (int) this.getY(),null);
    }

    @Override
    public void update() {

    }
}