package model;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class AnimatedBlock extends Block {
    private int maxRow;
    private int maxCol;
    private int animationRow;
    private int animationCol;
    private static final int ANIMATION_SPEED = 10;
    private int animationTick;


    public int getAnimationRow() {
        return animationRow;
    }

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

    public int getAnimationCol() {
        return animationCol;
    }

    public void setAnimationCol(int animationCol) {
        this.animationCol = animationCol;
    }

    public int getAnimationTick() {
        return animationTick;
    }

    public void setAnimationTick(int animationTick) {
        this.animationTick = animationTick;
    }



    protected AnimatedBlock()
    {
        super();
        init(0, 0);

    }

    public AnimatedBlock(BufferedImage img, int maxRow, int maxCol)
    {
        super(0, 0, img);
        init(maxRow, maxCol);

    }

    public AnimatedBlock(int x, int y, BufferedImage img, int maxRow, int maxCol)
    {
        super(x, y, img);
        init(maxRow, maxCol);

    }

    private void init(int maxRow, int maxCol)
    {
        this.maxRow = maxRow;
        this.maxCol = maxCol;
        this.setAnimationCol(maxCol);
        this.setAnimationRow(maxRow);
        animationTick = 0;
    }

    public void updateAnimationCol()
    {
        this.animationTick++;
        if (this.animationTick >= ANIMATION_SPEED)
        {
            this.animationTick = 0;
            this.animationCol = (this.animationCol + 1) % maxCol;
        }
    }

    public void updateAnimationRow()
    {
        this.animationTick++;
        if (this.animationTick >= ANIMATION_SPEED)
        {
            this.animationTick = 0;
            this.animationRow = (this.animationRow + 1) % maxRow;
        }
    }

    public void print(Graphics g)
    {
        g.drawImage(this.getImage().getSubimage(16 * this.animationCol, 16 * this.animationRow, 16, 16), (int) this.getX(), (int) this.getY(), null);
    }

}
