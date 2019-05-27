package model;

import entity.Entity;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class SpriteAssets {

        public static final int largeur=16,hauteur=16;
        private BufferedImage img;
        {
            try {
                img = ImageIO.read(new File("C:\\Users\\vzonz\\OneDrive\\Documents\\Cours\\A1\\Projet\\Projet UML Java 2\\Sprites\\74359.png"));
            } catch (IOException e) {
                System.out.println("le fichier n'existe pas");
            }
        }

        public void init() {

        }

    public BufferedImage Decoupage(int x, int y, int nRow, int nCol)
    {
        return img.getSubimage(x,y,nRow * 16,nCol * 16);
    }

}
/* public class DecoupageSprite
{
    private BufferedImage image;
    public DecoupageSprite (BufferedImage image)
    {
        this.image=image;
    }

}


 */

