package contract;

import java.awt.*;
import java.util.Observable;

import entity.HelloWorld;
import entity.Level;

/**
 * The Interface IModel.
 *
 * @author Jean-Aymeric Diet
 * @version $Id: $Id
 */
public interface IModel {

	/**
	 * Gets the hello world.
	 *
	 * @return the helloworld entity
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
