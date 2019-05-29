package entity.Blocks;


import entity.asset.AssetBlocks;

/**
 * The TP class
 *
 *
 * @author Valentin
 */

public class TP extends AnimatedBlock {

    private static final int ANIMATION_COL = 1;
    private static final int ANIMATION_ROWS = 4;
    private static final int START_COL = 6;
    private static final int START_ROW = 0;

    /**
     *
     *
     * @param x
     * @param y
     */
    public TP(int x, int y) {
        super(x, y, AssetBlocks.getInstance().getSprite(START_COL, START_ROW, ANIMATION_COL, ANIMATION_ROWS)
                , ANIMATION_COL, ANIMATION_ROWS);
    }

}