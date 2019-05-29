package entity;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * <p>Abstract AnimatedBlock class.</p>
 *
 * @author kevin
 * @version $Id: $Id
 */
public abstract class AnimatedBlock extends Block{
    private int maxRow;
    private int maxCol;
    private int animationRow;
    private int animationCol;
    private static int animationSpeed;
    private int animationTick;


    /**
     * <p>Getter for the field <code>animationRow</code>.</p>
     *
     * @return a int.
     */
    public int getAnimationRow() {
        return animationRow;
    }

    /**
     * <p>Setter for the field <code>animationRow</code>.</p>
     *
     * @param animationRow a int.
     */
    public void setAnimationRow(int animationRow) {
        if (animationRow >= this.maxRow)
        {
            this.animationRow = 0;
        }
        else
        {
            this.animationRow = animationRow;
        }
    }

    /**
     * <p>Getter for the field <code>animationCol</code>.</p>
     *
     * @return a int.
     */
    public int getAnimationCol() {
        return animationCol;
    }

    /**
     * <p>Setter for the field <code>animationCol</code>.</p>
     *
     * @param animationCol a int.
     */
    public void setAnimationCol(int animationCol) {
        if (animationCol >= this.maxCol)
        {
            this.animationCol = 0;
        }
        else
        {
            this.animationCol = animationCol;
        }
    }

    /**
     * <p>Getter for the field <code>animationTick</code>.</p>
     *
     * @return a int.
     */
    public int getAnimationTick() {
        return animationTick;
    }

    /**
     * <p>Setter for the field <code>animationTick</code>.</p>
     *
     * @param animationTick a int.
     */
    public void setAnimationTick(int animationTick) {
        this.animationTick = animationTick;
    }



    /**
     * <p>Constructor for AnimatedBlock.</p>
     */
    protected AnimatedBlock()
    {
        super();
        init(0, 0);

    }

    /**
     * <p>Constructor for AnimatedBlock.</p>
     *
     * @param img a {@link java.awt.image.BufferedImage} object.
     * @param maxCol a int.
     * @param maxRow a int.
     */
    public AnimatedBlock(BufferedImage img, int maxCol, int maxRow)
    {
        super(0, 0, img);
        init(maxCol, maxRow);

    }

    /**
     * <p>Constructor for AnimatedBlock.</p>
     *
     * @param x a int.
     * @param y a int.
     * @param img a {@link java.awt.image.BufferedImage} object.
     * @param maxCol a int.
     * @param maxRow a int.
     */
    public AnimatedBlock(int x, int y, BufferedImage img, int maxCol, int maxRow)
    {
        super(x, y, img);
        init(maxCol, maxRow);

    }

    private void init(int maxCol, int maxRow)
    {
        this.maxRow = maxRow;
        this.maxCol = maxCol;
        this.setAnimationCol(0);
        this.setAnimationRow(0);
        animationTick = 0;
        animationSpeed = GameProperties.getInstance().getAnimationSpeed();
    }

    /**
     * <p>updateAnimationCol.</p>
     */
    public void updateAnimationCol()
    {
        this.animationTick++;
        if (this.animationTick >= animationSpeed)
        {
            this.animationTick = 0;
            this.animationCol = (this.animationCol + 1) % maxCol;
        }
    }

    /**
     * <p>updateAnimationRow.</p>
     */
    public void updateAnimationRow()
    {
        this.animationTick++;
        if (this.animationTick >= animationSpeed)
        {
            this.animationTick = 0;
            this.animationRow = (this.animationRow + 1) % maxRow;
        }
    }

    /** {@inheritDoc} */
    public void print(Graphics g)
    {
        g.drawImage(this.getImage().getSubimage(getSizeX() * this.animationCol, getSizeY() * this.animationRow,
                    getSizeX(), getSizeY()), (int) this.getX() * getBlockScale(), (int) this.getY() * getBlockScale(),
                getSizeX() * getBlockScale(), getSizeY() * getBlockScale(),null);
    }

    @Override
    public void update(Level map, int objectiveX, int objectiveY) {
        super.update(map, objectiveX, objectiveY);
        this.updateAnimationRow();
    }
}
