package entity.Blocks;

import entity.asset.AssetBlocks;

/**
 * <p>BackgroundDirt class.</p>
 *
 * @author kevin
 * @version $Id: $Id
 */
public class BackgroundDirt extends Block
{
    private static final int START_COL =2;
    private static final int START_ROW = 0;

    /**
     * <p>Constructor for BackgroundDirt.</p>
     *
     * @param x a int.
     * @param y a int.
     */
    public BackgroundDirt(int x, int y)
    {
        super(x, y, AssetBlocks.getInstance().getSprite(START_COL, START_ROW));
    }
}
