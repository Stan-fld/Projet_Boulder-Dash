package entity.Blocks;

import entity.asset.AssetBlocks;

/**
 * The Wall class
 *
 * @author Valentin
 * @version $Id: $Id
 */
public class Wall extends Block
{
    private static final int START_COL =0;
    private static final int START_ROW = 0;

    /**
     * <p>Constructor for Wall.</p>
     *
     * @param x a int.
     * @param y a int.
     */
    public Wall(int x, int y)
    {
        super(x, y, AssetBlocks.getInstance().getSprite(START_COL, START_ROW));
    }
}
