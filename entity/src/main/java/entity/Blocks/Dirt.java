package entity.Blocks;

import entity.asset.AssetBlocks;

/**
 * The dirt class
 *
 * @author Valentin
 * @version $Id: $Id
 */
public class Dirt extends Block
{

    private static final int START_COL =1;
    private static final int START_ROW = 0;

    /**
     * <p>Constructor for Dirt.</p>
     *
     * @param x a int.
     * @param y a int.
     */
    public Dirt(int x, int y)
    {
        super(x, y, AssetBlocks.getInstance().getSprite(START_COL, START_ROW));
    }

}
