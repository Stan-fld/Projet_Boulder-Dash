package entity.asset;

/**
 * The class AssetBlocks
 *
 * It is a singleton which contains blocks
 *
 * @author Kevin
 */
public class AssetBlocks extends SpriteAsset {

    private static AssetBlocks ourInstance = new AssetBlocks();

    /**
     * <p>getInstance.</p>
     *
     * @return a {@link AssetBlocks} object.
     */
    public static AssetBlocks getInstance() {
        return ourInstance;
    }

    private AssetBlocks()
    {
        super("C:\\Users\\vzonz\\OneDrive\\Documents\\Cours\\A1\\Projet\\Projet UML Java 2\\Projet_Boulder-Dash\\model\\src\\main\\resources\\assets\\Blocks.png");
    }


}
