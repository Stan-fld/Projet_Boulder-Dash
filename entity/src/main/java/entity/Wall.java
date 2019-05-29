package entity;

import entity.asset.AssetBlocks;

/**
 * The Wall class
 *
 *
 * @author Valentin
 */

public class Wall extends Block
{
    private static final int START_COL =0;
    private static final int START_ROW = 0;

    /**
     *
     *
     * @param x
     * @param y
     */
    public Wall(int x, int y)
    {
        super(x, y, AssetBlocks.getInstance().getSprite(START_COL, START_ROW));
    }
}
