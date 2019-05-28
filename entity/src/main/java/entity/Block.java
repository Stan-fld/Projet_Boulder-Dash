package entity;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * <p>Abstract Block class.</p>
 *
 * @author kevin
 * @version $Id: $Id
 */
public abstract class Block extends Rectangle{

    private BufferedImage image;

    /**
     * <p>Getter for the field <code>sizeX</code>.</p>
     *
     * @return a int.
     */
    public static int getSizeX() {
        return sizeX;
    }

    /**
     * <p>Getter for the field <code>sizeY</code>.</p>
     *
     * @return a int.
     */
    public static int getSizeY() {
        return sizeY;
    }


    //propriétés modifiables dans le fichier model.properties


    //Ecriture de la taille des blocks
    private static int sizeX = 0;
    private static int sizeY = 0;
    private static int blockScale = 0;

    /**
     * <p>Constructor for Block.</p>
     */
    protected Block()
    {

        super();
        init(null);
    }


    /**
     * <p>Constructor for Block.</p>
     *
     * @param img a {@link java.awt.image.BufferedImage} object.
     */
    public Block(BufferedImage img)
    {
        super(sizeX, sizeY);
        init(img);
    }

    /**
     * <p>Constructor for Block.</p>
     *
     * @param x a int.
     * @param y a int.
     * @param img a {@link java.awt.image.BufferedImage} object.
     */
    public Block(int x, int y, BufferedImage img)
    {
        super(x, y, sizeX, sizeY);
        init(img);
    }

    private void init(BufferedImage img)
    {
        this.setImage(img);
        if (sizeX == 0 || sizeY == 0 || blockScale == 0)
        {
            GameProperties properties = GameProperties.getInstance();
            sizeX = properties.getSizeX();
            sizeY = properties.getSizeY();
            blockScale = properties.getBlockScale();
        }
    }


    /**
     * <p>Getter for the field <code>image</code>.</p>
     *
     * @return a {@link java.awt.image.BufferedImage} object.
     */
    public BufferedImage getImage() {
        return this.image;
    }

    /**
     * <p>Setter for the field <code>image</code>.</p>
     *
     * @param image a {@link java.awt.image.BufferedImage} object.
     */
    public void setImage(BufferedImage image) {
        this.image = image;
    }

    /**
     * <p>move.</p>
     *
     * @param direction a {@link model.Direction} object.
     */
    public void move(Direction direction)
    {
        if (direction == Direction.UP)
        {
            this.setLocation((int) (this.getX() + this.getWidth()), (int) (this.getY() + this.getHeight()));
        }
    }

    /**
     * <p>print.</p>
     *
     * @param g a {@link java.awt.Graphics} object.
     */
    public void print(Graphics g)
    {
        g.drawImage(this.getImage(), (int) this.getX(), (int) this.getY(),null);
    }


    /**
     * <p>update.</p>
     */
    public void update() {

    }
}
