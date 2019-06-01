package entity.asset;

import java.awt.*;

/**
 * The AssetPerso class
 *
 * @author Kevin
 * @version $Id: $Id
 */
//Singleton contenant le sprite des blocks
public class AssetPerso extends SpriteAsset {


    private static AssetPerso ourInstance = new AssetPerso();

    /**
     * <p>getInstance.</p>
     *
     * @return a {@link AssetPerso} object.
     */
    public static AssetPerso getInstance() {
        return ourInstance;
    }

    /**
     *The AssetPerso method
     *
     */
    private AssetPerso()
    {
        super("D:\\Dev\\Java\\Projet_Boulder-Dash\\model\\src\\main\\resources\\assets\\Perso.png");

        //On rend le fond transparent par rapport a une couleur
        makeTransparent(new Color(107, 109, 0));

    }




}
