package entity;

import java.awt.image.BufferedImage;

public abstract class AnimatedBlock extends Block {
    private int maxRow;
    private int maxCol;

    public int getAnimationRow() {
        return animationRow;
    }

    public void setAnimationRow(int animationRow) {
        if (animationRow > this.maxRow)
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

    private int animationRow;
    private int animationCol;
    private static final int ANIMATION_SPEED = 10;
    private int animationTick;

    protected AnimatedBlock()
    {
        super();
        init(0, 0);

    }

    public AnimatedBlock(int x, int y, BufferedImage img, int maxRow, int maxCol)
    {
        super();
        init(0, 0);

    }

    private void init(int maxRow, int maxCol)
    {
        this.maxRow = maxRow;
        this.maxCol = maxCol;
        this.setAnimationCol(0);
        this.setAnimationRow(0);
        animationTick = 0;
    }

    public void updateAnimationCol()
    {
        this.animationTick++;
        if (this.animationTick >= ANIMATION_SPEED)
        {
            this.animationCol = (this.animationCol + 1) % maxCol;
        }
    }

    public void updateAnimationRow()
    {
        this.animationTick++;
        if (this.animationTick >= ANIMATION_SPEED)
        {
            this.animationRow = (this.animationRow + 1) % maxRow;
        }
    }

}
