package model.asset;

/**
 * The class AssetBlocks
 *
 * It is a singleton which contains blocks
 *
 * @author Kevin
 */

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
