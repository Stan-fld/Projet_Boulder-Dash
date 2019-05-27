package model;

import entity.Entity;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class SpriteAssets {

        public static final int largeur=16,hauteur=16;
        BufferedImage wall, dirt, stone, diamond, teleport;
        BufferedImage img;
        {
            try {
                img = ImageIO.read(new File("C:\\Users\\vzonz\\OneDrive\\Documents\\Cours\\A1\\Projet\\Projet UML Java 2\\Sprites\\74359.png"));
                System.out.println("je suis la");
            } catch (IOException e) {
                System.out.println("le fichier n'existe pas");
            }
        }
        DecoupageSprite sprite = new DecoupageSprite(img);
        public void init()
        {
            this.wall = sprite.Decoupage(0,0, largeur,hauteur);
            this.dirt = sprite.Decoupage(largeur,0,largeur,hauteur);
            this.stone = sprite.Decoupage(3*largeur,0,largeur,hauteur);
            this.diamond = sprite.Decoupage(4*largeur, 0 , largeur, hauteur);
            this.teleport = sprite.Decoupage(6*largeur, 0 , largeur, hauteur);
        }

        public BufferedImage getDiamond() {
            return this.diamond;
        }

    }
/* public class DecoupageSprite
{
    private BufferedImage image;
    public DecoupageSprite (BufferedImage image)
    {
        this.image=image;
    }
    public BufferedImage Decoupage(int x, int y, int largeur, int hauteur)
    {
        return image.getSubimage(x,y,largeur,hauteur);
    }
}


 */


}
