package entity;

import entity.asset.AssetBlocks;

/**
 * The ennemy class
 *
 * @author Valentin
 */
    public class Ennemy extends AnimatedBlock
    {
        private static final int ANIMATION_COL = 1;
        private static final int ANIMATION_ROWS = 4;
        private static final int START_COL = 9;
        private static final int START_ROW = 0;

        public Ennemy(int x, int y) {
            super(x, y, AssetBlocks.getInstance().getSprite(START_COL, START_ROW, ANIMATION_COL, ANIMATION_ROWS)
                    , ANIMATION_COL, ANIMATION_ROWS);
        }
}
