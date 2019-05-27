package model;

import entity.Entity;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class SpriteAssets {

        public static final int largeur=16,hauteur=16;
        private BufferedImage img;

        public void init() {
            try {
                img = ImageIO.read(new File("assets/74359.png"));
            } catch (IOException e) {
                System.out.println("le fichier n'existe pas");
            }
        }

    public BufferedImage Decoupage(int x, int y, int nRow, int nCol)
    {
        return img.getSubimage(x,y,nRow * 16,nCol * 16);
    }

}


