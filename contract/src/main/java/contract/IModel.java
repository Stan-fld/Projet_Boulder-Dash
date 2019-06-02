package contract;

import entity.Blocks.Block;
import entity.Direction;

import java.awt.*;
import java.util.Observable;


/**
 * The Interface IModel.
 *
 * @author Valentin
 *
 */
public interface IModel {


    /**
     * <p>print.</p>
     *
     * @param g a {@link java.awt.Graphics} object.
     */
    void print(Graphics g);


	int getTailleMapX();

	int getTailleMapY();
	void setPlayerX(int playerX);
	void setPlayerY(int playerY);
	int getPlayerY();
	int getPlayerX();
	void setPlayerPos(int playerX, int playerY);


	void setChanged();

	/**
	 * Gets the observable.
	 *
	 * @return the observable
	 */
	Observable getObservable();


	Block getBlock(int x, int y);


	void moveBlock(Direction direction, int blockX, int blockY);


}
