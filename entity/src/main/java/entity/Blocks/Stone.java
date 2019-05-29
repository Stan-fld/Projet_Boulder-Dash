package entity.Blocks;

import entity.asset.AssetBlocks;

/**
 * <p>Stone class.</p>
 *
 * @author kevin
 */
public class Stone extends AnimatedBlock {
    private static final int ANIMATION_COL = 1;
    private static final int ANIMATION_ROWS = 4;
    private static final int START_COL = 3;
    private static final int START_ROW = 0;




    /**
     * <p>Constructor for Stone.</p>
     *
     * @param x a int.
     * @param y a int.
     */
    public Stone(int x, int y)
    {
        super(x, y, AssetBlocks.getInstance().getSprite(START_COL, START_ROW, ANIMATION_COL, ANIMATION_ROWS)
                , ANIMATION_COL, ANIMATION_ROWS);
    }


}
