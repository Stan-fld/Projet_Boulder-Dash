package contract;

/**
 * The Interface IController.
 *
 * @author Jean-Aymeric Diet
 * @version $Id: $Id
 */
public interface IController {

	/**
	 * Control.
	 */
	public void control();

	/**
	 * Order perform.
	 *
	 * @param controllerOrder
	 *          the controller order
	 */
	public void orderPerform(ControllerOrder controllerOrder);
}
