package entity.Blocks;

import entity.asset.AssetBlocks;

/**
 * The Diamond class
 *
 * @author Valentin
 * @version $Id: $Id
 */
public class Diamond extends Fallable {
    private static final int ANIMATION_COL = 1;
    private static final int ANIMATION_ROWS = 4;
    private static final int START_COL = 4;
    private static final int START_ROW = 0;

    /**
     * <p>Constructor for Diamond.</p>
     *
     * @param x a int.
     * @param y a int.
     */
    public Diamond(int x, int y) {
        super(x, y, AssetBlocks.getInstance().getSprite(START_COL, START_ROW, ANIMATION_COL, ANIMATION_ROWS)
                , ANIMATION_COL, ANIMATION_ROWS);
    }
}
