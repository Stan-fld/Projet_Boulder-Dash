package contract;

import java.awt.*;
import java.util.Observable;

import entity.HelloWorld;

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
	HelloWorld getHelloWorld();
    /**
     * <p>print.</p>
     *
     * @param g a {@link java.awt.Graphics} object.
     */
    void print(Graphics g);
	/**
	 * Load the message.
	 *
	 * @param code
	 *          the code
	 */
	void loadHelloWorld(String code);

	/**
	 * Gets the observable.
	 *
	 * @return the observable
	 */
	Observable getObservable();
}
