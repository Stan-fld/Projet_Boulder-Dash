package model.asset;

import entity.Entity;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * The class SpriteAsset
 *
 * @author Valentin
 */
public class SpriteAsset {

    public static final int largeur = 16, hauteur = 16;
    private BufferedImage img;
    private int maxRow;
    private int maxCol;

    /**
     * The SpriteAsset method
     * It loads the sprite sheet and calculates the max row and col.
     *
     * @param path
     *          The sprite sheet path
     */

    public SpriteAsset(String path) {
        try {
            img = ImageIO.read(new File(path));
        } catch (IOException e) {
            System.out.println("le fichier n'existe pas");
        }
        maxRow = img.getHeight() / hauteur;
        maxCol = img.getWidth() / largeur;
    }

    /**
     * Gets the sprite
     * @param x
     * @param y
     * X and Y are the coordinates to take the sprite on the sheet
     * @param nRow
     * @param nCol
     * nRow and nCol are the coordinates to know until how many pixels we cut the sprite
     * @return the sprite asked
     */
    public BufferedImage getSprite(int x, int y, int nRow, int nCol) {
        return img.getSubimage(x, y, nRow * largeur, nCol * hauteur);
    }

    /**
     *
     * @param x
     * @param y
     * X and Y are the coordinates to take the sprite on the sheet
     * @return The sprite asked
     */
    public BufferedImage getSprite(int x, int y) {
        return getSprite(x, y, 1, 1);
    }

}


