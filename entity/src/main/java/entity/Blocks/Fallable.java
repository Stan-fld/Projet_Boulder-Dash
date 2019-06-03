package entity.Blocks;

import java.awt.image.BufferedImage;

/**
 * <p>Fallable class.</p>
 *
 * @author kevin
 * @version $Id: $Id
 */
public class Fallable extends AnimatedBlock {
    /**
     * <p>Constructor for Fallable.</p>
     *
     * @param x a int.
     * @param y a int.
     * @param img a {@link java.awt.image.BufferedImage} object.
     * @param maxCol a int.
     * @param maxRow a int.
     */
    public Fallable(int x, int y, BufferedImage img, int maxCol, int maxRow)
    {
        super(x,y,img,maxCol,maxRow);
    }
}
