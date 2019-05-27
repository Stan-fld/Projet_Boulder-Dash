package model.asset;

/**
 * The AssetPerso class
 *
 * @author Kevin
 */
//Singleton contenant le sprite des blocks
public class AssetPerso extends SpriteAsset {


    private static AssetPerso ourInstance = new AssetPerso();

    public static AssetPerso getInstance() {
        return ourInstance;
    }

    private AssetPerso()
    {
        super("assets/Perso.png");
    }


}
