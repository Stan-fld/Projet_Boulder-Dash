package entity.asset;

import java.awt.*;

/**
 * The class AssetBlocks
 *
 * It is a singleton which contains all blocks assets
 *
 * @author Kevin
 * @version $Id: $Id
 */
public class AssetBlocks extends SpriteAsset {

    private static AssetBlocks ourInstance = new AssetBlocks();

    /**
     * <p>getInstance.</p>
     *
     * @return a {@link entity.asset.AssetBlocks} object.
     */
    public static AssetBlocks getInstance() {
        return ourInstance;
    }

    private AssetBlocks()
    {
        super("D:\\Dev\\Java\\Projet_Boulder-Dash\\model\\src\\main\\resources\\assets\\Blocks.png");
    }


}
