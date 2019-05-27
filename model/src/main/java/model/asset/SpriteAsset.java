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


    public SpriteAsset(String path) {
        try {
            img = ImageIO.read(new File(path));
        } catch (IOException e) {
            System.out.println("le fichier n'existe pas");
        }
        maxRow = img.getHeight() / hauteur;
        maxCol = img.getWidth() / largeur;
    }

    public BufferedImage getSprite(int x, int y, int nRow, int nCol) {
        return img.getSubimage(x, y, nCol * 16, nRow * 16);
    }
    public BufferedImage getSprite(int x, int y) {
        return getSprite(x, y, 1, 1);
    }

}


