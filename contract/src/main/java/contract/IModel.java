package contract;

import entity.Blocks.Block;
import entity.Direction;

import java.awt.*;
import java.util.Observable;


/**
 * The Interface IModel.
 *
 * @author Valentin
 * @version $Id: $Id
 */
public interface IModel {


    /**
     * <p>prints the model on the {@link java.awt.Graphics} parameter</p>
     *
     * @param g a {@link java.awt.Graphics} object.
     */
    void print(Graphics g);


	/**
	 * <p>getTailleMapX.</p>
	 *
	 * @return the map X size.
	 */
	int getTailleMapX();

	/**
	 * <p>getTailleMapY.</p>
	 *
	 * @return the map Y size.
	 */
	int getTailleMapY();
	/**
	 * <p>setPlayerX.</p>
	 *
	 * @param playerX a int.
	 */
	void setPlayerX(int playerX);
	/**
	 * <p>setPlayerY.</p>
	 *
	 * @param playerY a int.
	 */
	void setPlayerY(int playerY);
	/**
	 * <p>getPlayerY.</p>
	 *
	 * @return a int.
	 */
	int getPlayerY();
	/**
	 * <p>getPlayerX.</p>
	 *
	 * @return a int.
	 */
	int getPlayerX();
	/**
	 * <p>setPlayerPos.</p>
	 *
	 * @param playerX a int.
	 * @param playerY a int.
	 */
	void setPlayerPos(int playerX, int playerY);


	/**
	 * <p>setChanged.</p>
	 */
	void setChanged();

	/**
	 * Gets the observable.
	 *
	 * @return the observable
	 */
	Observable getObservable();


	/**
	 * <p>getBlock.</p>
	 *
	 * @param x a int.
	 * @param y a int.
	 * @return a {@link entity.Blocks.Block} object.
	 */
	Block getBlock(int x, int y);


	/**
	 * <p>moveBlock.</p>
	 *
	 * @param direction a {@link entity.Direction} object.
	 * @param blockX a int.
	 * @param blockY a int.
	 */
	void moveBlock(Direction direction, int blockX, int blockY);


}
