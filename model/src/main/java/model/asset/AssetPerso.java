package model.asset;


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
