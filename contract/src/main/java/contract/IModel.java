package contract;

import java.awt.*;
import java.util.Observable;

import entity.HelloWorld;

/**
 * The Interface IModel.
 *
 * @author Jean-Aymeric Diet
 */
public interface IModel {

	/**
	 * Gets the hello world.
	 *
	 * @return the helloworld entity
	 */
	HelloWorld getHelloWorld();
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
