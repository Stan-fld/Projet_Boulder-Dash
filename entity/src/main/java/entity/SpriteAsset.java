package entity;


import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * The class SpriteAsset
 *
 * @author Valentin
 * @version $Id: $Id
 */
public class SpriteAsset {

    /** Constant <code>sizeX</code> */
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
            img = ImageIO.read(new File(path));
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

}


