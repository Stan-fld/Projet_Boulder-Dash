package entity;

import entity.asset.AssetBlocks;

/**
 * The dirt class
 *
 *
 * @author Valentin
 */

public class Dirt extends Block
{

    private static final int START_COL =1;
    private static final int START_ROW = 0;

    /**
     *
     *
     * @param x
     * @param y
     */
    public Dirt(int x, int y)
    {
        super(x, y, AssetBlocks.getInstance().getSprite(START_COL, START_ROW));
    }

}
