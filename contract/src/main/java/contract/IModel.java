package contract;

import java.awt.*;
import java.util.Observable;

import entity.Level;

/**
 * The Interface IModel.
 *
 * @author Valentin
 *
 */
public interface IModel {

	/**
	 * Gets the level.
	 *
	 * @return the getlevel
	 */
	public Level getLevel();

    /**
     * <p>print.</p>
     *
     * @param g a {@link java.awt.Graphics} object.
     */
    void print(Graphics g);
	/**
	 * Load the message.
	 *
	 * @param niv
	 *          the code
	 */
	void loadLevel(int niv);

	/**
	 * Gets the observable.
	 *
	 * @return the observable
	 */
	Observable getObservable();
}
