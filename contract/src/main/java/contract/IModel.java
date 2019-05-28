package contract;

import java.awt.*;
import java.util.Observable;

import entity.HelloWorld;
import entity.LevelSelect;

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
//	LevelSelect getLevelSelect();
    void print(Graphics g);
	/**
	 * Load the message.
	 *
	 * @param level
	 *          the code
	 */
	void loadLevelSelect( int level);

	/**
	 * Gets the observable.
	 *
	 * @return the observable
	 */
	Observable getObservable();
}
