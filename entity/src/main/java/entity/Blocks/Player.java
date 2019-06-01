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
 */
public class Player extends AnimatedBlock {
    BufferedImage[] imgTab;
    private static final int[] START_COL = {0, 0, 0, 0, 0};
    private static final int[] START_ROW = {0, 1, 2, 3, 4};
    private static final int[] ANIMATION_COLS = {2, 3, 4, 3, 4};
    private static final int[] ANIMATION_ROWS = {1, 1, 1, 1, 1};

    PlayerState state = PlayerState.STATIC;

    Block backgroudBlock;


    /**
     * <p>Constructor for Player.</p>
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

    @Override
    public void update(int objectiveX, int objectiveY) {
        PlayerState oldState = this.state;

        this.backgroudBlock.update(objectiveX, objectiveY);

        if (objectiveX == this.getX() && objectiveY == this.getY())
        {
            this.state = PlayerState.STATIC;

        }
        else if (objectiveX > this.getX() && objectiveY == this.getY())
        {
            this.state = PlayerState.RIGHT;
            objectiveX = (int) this.getX() + 1;
        }
        else if (objectiveX < this.getX() && objectiveY == this.getY())
        {
            this.state = PlayerState.LEFT;
            objectiveX = (int) this.getX() - 1;
        }
        else if (objectiveY > this.getY() && objectiveX == this.getX())
        {
            this.state = PlayerState.DOWN;
            objectiveY = (int) this.getY() + 1;
        }
        else if (objectiveY < this.getY() && objectiveX == this.getX())
        {
            this.state = PlayerState.UP;
            objectiveY = (int) this.getY() - 1;
        }

        if (oldState != this.state) {
            this.setImage(this.imgTab[state.ordinal()]);
            this.setMaxCol(ANIMATION_COLS[state.ordinal()]);
            this.setMaxRow(ANIMATION_ROWS[state.ordinal()]);
        }


        this.updateAnimationCol();
        super.update(objectiveX, objectiveY);
    }

    @Override
    public void print(Graphics g) {
        this.backgroudBlock.print(g);
        super.print(g);
    }
}
