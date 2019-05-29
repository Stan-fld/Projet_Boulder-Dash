package entity.Blocks;

import entity.asset.AssetBlocks;

public class BackgroundDirt extends Block
{
    private static final int START_COL =2;
    private static final int START_ROW = 0;

    /**
     *
     *
     * @param x
     * @param y
     */
    public BackgroundDirt(int x, int y)
    {
        super(x, y, AssetBlocks.getInstance().getSprite(START_COL, START_ROW));
    }
}
