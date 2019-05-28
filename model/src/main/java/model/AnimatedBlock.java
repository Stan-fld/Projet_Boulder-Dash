package model;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class AnimatedBlock extends Block {
    private int maxRow;
    private int maxCol;
    private int animationRow;
    private int animationCol;
    private static int animationSpeed;
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
        if (animationCol >= this.maxCol)
        {
            this.animationCol = 0;
        }
        else
        {
            this.animationCol = animationCol;
        }
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

    public AnimatedBlock(BufferedImage img, int maxCol, int maxRow)
    {
        super(0, 0, img);
        init(maxCol, maxRow);

    }

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

    public void updateAnimationCol()
    {
        this.animationTick++;
        if (this.animationTick >= animationSpeed)
        {
            this.animationTick = 0;
            this.animationCol = (this.animationCol + 1) % maxCol;
        }
    }

    public void updateAnimationRow()
    {
        this.animationTick++;
        if (this.animationTick >= animationSpeed)
        {
            this.animationTick = 0;
            this.animationRow = (this.animationRow + 1) % maxRow;
        }
    }

    public void print(Graphics g)
    {
        g.drawImage(this.getImage().getSubimage(getSizeX() * this.animationCol, getSizeY() * this.animationRow,
                    getSizeX(), getSizeY()), (int) this.getX(), (int) this.getY(), getSizeX() * 2, 32,null);
    }

}
