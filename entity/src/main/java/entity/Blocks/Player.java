package entity.Blocks;

import entity.PlayerState;
import entity.asset.AssetPerso;
import entity.asset.SpriteAsset;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * <p>Player class.</p>
 *
 * @author kevin
 * @version $Id: $Id
 */
public class Player extends AnimatedBlock {
    BufferedImage[] imgTab;
    private static final int[] START_COL = {0, 0, 0, 0, 0};
    private static final int[] START_ROW = {0, 1, 2, 3, 4};
    private static final int[] ANIMATION_COLS = {2, 3, 4, 3, 4};
    private static final int[] ANIMATION_ROWS = {1, 1, 1, 1, 1};
    boolean mooving = false;

    PlayerState state = PlayerState.STATIC;

    Block backgroudBlock;


    /**
     * <p>Constructor for Player.</p>
     *
     * @param x a int.
     * @param y a int.
     */
    public Player(int x, int y)
    {
        super(x, y, AssetPerso.getInstance().getSprite(START_COL[0], START_ROW[0], ANIMATION_COLS[0], ANIMATION_ROWS[0])
                , ANIMATION_COLS[0], ANIMATION_ROWS[0]);
        SpriteAsset asset = AssetPerso.getInstance();

        imgTab = new BufferedImage[5];

        imgTab[PlayerState.STATIC.ordinal()] = this.getImage();

        imgTab[PlayerState.UP.ordinal()] = asset.getSprite(START_COL[PlayerState.UP.ordinal()],
                START_ROW[PlayerState.UP.ordinal()], ANIMATION_COLS[PlayerState.UP.ordinal()],
                ANIMATION_ROWS[PlayerState.UP.ordinal()]);


        imgTab[PlayerState.LEFT.ordinal()] = asset.getSprite(START_COL[PlayerState.LEFT.ordinal()],
                START_ROW[PlayerState.LEFT.ordinal()], ANIMATION_COLS[PlayerState.LEFT.ordinal()],
                ANIMATION_ROWS[PlayerState.LEFT.ordinal()]);

        imgTab[PlayerState.RIGHT.ordinal()] = asset.getSprite(START_COL[PlayerState.RIGHT.ordinal()],
                START_ROW[PlayerState.RIGHT.ordinal()], ANIMATION_COLS[PlayerState.RIGHT.ordinal()],
                ANIMATION_ROWS[PlayerState.RIGHT.ordinal()]);

        imgTab[PlayerState.DOWN.ordinal()] = asset.getSprite(START_COL[PlayerState.DOWN.ordinal()],
                START_ROW[PlayerState.DOWN.ordinal()], ANIMATION_COLS[PlayerState.DOWN.ordinal()],
                ANIMATION_ROWS[PlayerState.DOWN.ordinal()]);

        backgroudBlock = new BackgroundDirt(x, y);
    }

    /**
     *  The player's update makes the player move pixel by pixel to have the same impression than the original boulder dash game
     * @see AnimatedBlock#update(int, int)
     *
     */
    @Override
    public void update(int objectiveX, int objectiveY) {
        PlayerState oldState = this.state;
        this.backgroudBlock.update(objectiveX, objectiveY);

        if (objectiveX * 16 == this.getX() && objectiveY * 16 == this.getY())
        {
            this.state = PlayerState.STATIC;
            this.mooving = false;
        }
        else if (objectiveX * 16 > this.getX() && objectiveY * 16 == this.getY())
        {
            this.state = PlayerState.RIGHT;
            this.setLocation((int) this.getX() + 1, (int) this.getY());
            this.mooving = true;
        }
        else if (objectiveX * 16 < this.getX() && objectiveY * 16 == this.getY())
        {
            this.state = PlayerState.LEFT;
            this.setLocation((int) this.getX() - 1, (int) this.getY());
            this.mooving = true;

        }
        else if (objectiveY * 16 > this.getY() && objectiveX * 16 == this.getX())
        {
            this.state = PlayerState.DOWN;
            this.setLocation((int) this.getX(), (int) this.getY() + 1);
            this.mooving = true;
        }
        else if (objectiveY * 16 < this.getY() && objectiveX * 16 == this.getX())
        {
            this.state = PlayerState.UP;
            this.setLocation((int) this.getX(), (int) this.getY() - 1);
            this.mooving = true;
        }

        if (oldState != this.state) {
            this.setImage(this.imgTab[state.ordinal()]);
            this.setMaxCol(ANIMATION_COLS[state.ordinal()]);
            this.setMaxRow(ANIMATION_ROWS[state.ordinal()]);
        }


        this.updateAnimationCol();
    }

    /**
     * <p>isMooving.</p>
     *
     * @return a boolean.
     */
    public boolean isMooving()
    {
        return this.mooving;
    }

    /**
     * <p>Setter for the field <code>mooving</code>.</p>
     *
     * @param mooving a boolean.
     */
    public void setMooving(boolean mooving)
    {
        this.mooving = mooving;
    }

    /** {@inheritDoc} */
    @Override
    public void print(Graphics g) {
        this.backgroudBlock.print(g);
        super.print(g);
    }
}
