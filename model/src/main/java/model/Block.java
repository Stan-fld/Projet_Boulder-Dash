package model;

import com.sun.javafx.scene.traversal.Direction;
import contract.IBlock;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class Block extends Rectangle{ //implements IBlock

    private BufferedImage image;

    //Ecriture de la taille des blocks
    private static final int sizeX = 16;
    private static final int sizeY = 16;

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
        g.drawImage(this.getImage().getSubimage(0, 0,(int) this.getWidth(), (int) this.getHeight()), (int) this.getX(), (int) this.getY(),null);
    }
}
