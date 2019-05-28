package model.asset;

import model.*;

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

    public static int sizeX, sizeY;
    private BufferedImage img;
    private int maxRow;
    private int maxCol;


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
     * @param col
     * @param row
     * X and Y are the coordinates to take the sprite on the sheet
     * @param nCol
     * nRow and nCol are the coordinates to know until how many pixels we cut the sprite
     * @param nRow
     * @return the sprite asked
     */

    public BufferedImage getSprite(int col, int row, int nCol, int nRow) {
        return img.getSubimage(col * sizeX, row * sizeY, nCol * sizeX, nRow * sizeY);
    }
    public BufferedImage getSprite(int x, int y) {
        return getSprite(x, y, 1, 1);
    }

}


