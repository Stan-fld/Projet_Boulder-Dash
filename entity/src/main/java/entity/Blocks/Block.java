package entity.Blocks;

import entity.Direction;
import entity.GameProperties;
import entity.Level;

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
    private static final int sizeX = GameProperties.getInstance().getSizeX();
    private static final int sizeY = GameProperties.getInstance().getSizeY();
    private static final int blockScale = GameProperties.getInstance().getBlockScale();

    /**
     * <p>Constructor for Block.</p>
     */
    protected Block()
    {
        super(sizeX, sizeY);
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
        super(x * sizeX, y * sizeY, sizeX, sizeY);
        init(img);
    }

    private void init(BufferedImage img)
    {
        this.setImage(img);
    }

    public static int getBlockScale() {
        return blockScale;
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
     * @param direction a {@link entity.Direction} object.
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
        g.drawImage(this.getImage(), (int) this.getX() * getBlockScale(), (int) this.getY() * getBlockScale()
                    , (int) (this.getWidth() * getBlockScale()), (int) (this.getHeight() * getBlockScale()),null);
    }


    /**
     * <p>update.</p>
     */
    public void update(Level map, int objectiveX, int objectiveY) {
        this.setLocation(objectiveX * sizeX, objectiveY * sizeY);

    }
}
