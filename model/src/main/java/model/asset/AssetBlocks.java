package model.asset;


//Singleton contenant le sprite des blocks
public class AssetBlocks extends SpriteAsset {


    private static AssetBlocks ourInstance = new AssetBlocks();

    public static AssetBlocks getInstance() {
        return ourInstance;
    }

    private AssetBlocks()
    {
        super("assets/Blocks.png");
    }


}
