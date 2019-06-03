package entity.asset;


import entity.GameProperties;
import org.w3c.dom.css.RGBColor;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.*;
import java.io.File;
import java.io.IOException;

/**
 * The class SpriteAsset
 *
 * @author Valentin
 * @version $Id: $Id
 */
public class SpriteAsset {

    /** Constant <code>sizeY</code> */
    /** Constant <code>sizeY</code> */
    public static int sizeX, sizeY;
    private BufferedImage img;
    private int maxRow;
    private int maxCol;


    /**
     * <p>Constructor for SpriteAsset.</p>
     *
     * @param path a {@link java.lang.String} object.
     */
    public SpriteAsset(String path) {
        try {
            BufferedImage tmp = ImageIO.read(new File(path));
            //On converti en RGBA :
            img = new BufferedImage(tmp.getWidth(), tmp.getHeight(), BufferedImage.TYPE_INT_ARGB);
            img.getGraphics().drawImage(tmp, 0, 0, null);
        } catch (IOException e) {
            System.out.println("le fichier n'existe pas");
        }
        GameProperties properties = GameProperties.getInstance();
        sizeX = properties.getSizeX();
        sizeY = properties.getSizeY();

    }

    /**
     * Gets the sprite
     *
     * @param col a int.
     * @param row
     * X and Y are the coordinates to take the sprite on the sheet
     * @param nCol
     * nRow and nCol are the coordinates to know until how many pixels we cut the sprite
     * @param nRow a int.
     * @return the sprite asked
     */
    public BufferedImage getSprite(int col, int row, int nCol, int nRow) {
        return img.getSubimage(col * sizeX, row * sizeY, nCol * sizeX, nRow * sizeY);
    }
    /**
     * <p>getSprite.</p>
     *
     * @param x a int.
     * @param y a int.
     * @return a {@link java.awt.image.BufferedImage} object.
     */
    public BufferedImage getSprite(int x, int y) {
        return getSprite(x, y, 1, 1);
    }

    /**
     * <p>makeTransparent.</p>
     * makes the color key transparent on the {@link SpriteAsset}
     * @param colorMask a {@link java.awt.Color} object.
     */
    public void makeTransparent(Color colorMask)
    {
        int width = this.img.getWidth();
        int height = this.img.getHeight();
        Color transp = new Color(0,0,0, 0);

        int[] imagePixels = this.img.getRGB(0, 0, width, height, null, 0, width);

        for (int i = 0; i < imagePixels.length; i++)
        {
            if (imagePixels[i] == colorMask.getRGB()) {

                imagePixels[i] = transp.getRGB();
            }
        }

        this.img.setRGB(0, 0, width, height, imagePixels, 0, width);
    }

}


