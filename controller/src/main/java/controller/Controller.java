package controller;

import contract.ControllerOrder;
import contract.IController;
import contract.IModel;
import contract.IView;

/**
 * The Class Controller.
 *
 * @author kevin
 * @version $Id: $Id
 */
public final class Controller implements IController {

	/** The view. */
	private IView		view;

	/** The model. */
	private IModel	model;

	/**
	 * Instantiates a new controller.
	 *
	 * @param view
	 *          the view
	 * @param model
	 *          the model
	 */
	public Controller(final IView view, final IModel model) {
		this.setView(view);
		this.setModel(model);
	}

	/**
	 * Control.
	 */
	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IController#control()
	 */
	public void control() {
		this.view.printMessage("Appuyer sur les touches 'E', 'F', 'D' ou 'I', pour afficher Hello world dans la langue d votre choix.");
	}

	/**
     * Sets the view.
     *
     * @param pview
     *            the new view
     */
	private void setView(final IView pview) {
		this.view = pview;
	}

	/**
	 * Sets the model.
	 *
	 * @param model
	 *          the new model
	 */
	private void setModel(final IModel model) {
		this.model = model;
	}

	/**
	 * {@inheritDoc}
	 *
	 * Order perform.
	 */
	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IController#orderPerform(contract.ControllerOrder)
	 */
	public void orderPerform(final ControllerOrder controllerOrder) {
		switch (controllerOrder) {
			case Up:
				this.model.loadHelloWorld("GB");
				break;
			case Down:
				this.model.loadHelloWorld("FR");
				break;
			case Left:
				this.model.loadHelloWorld("DE");
				break;
			case Right:
				this.model.loadHelloWorld("ID");
				break;
			default:
				break;
		}
		/*
			public void orderPerform(final ControllerOrder controllerOrder) {
		switch (controllerOrder) {
			case Up:
				this.model.moveChar("UP");
				break;
			case Down:
				this.model.moveChar("DOWN");
				break;
			case Left:
				this.model.moveChar("LEFT");
				break;
			case Right:
				this.model.moveChar("RIGHT");
				break;
			default:
				break;
		}
		 */
	}

}
