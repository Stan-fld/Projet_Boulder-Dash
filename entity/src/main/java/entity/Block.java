package entity;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class Block extends Rectangle {

    private BufferedImage image;

    protected Block()
    {
        super();
        init(null);
    }


    public Block(BufferedImage img)
    {
        super(16, 16);
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

}
