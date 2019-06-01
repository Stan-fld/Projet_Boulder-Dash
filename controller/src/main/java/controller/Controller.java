package controller;

import contract.ControllerOrder;
import contract.IController;
import contract.IModel;
import contract.IView;
import entity.Blocks.BackgroundDirt;
import entity.Blocks.Block;
import entity.Blocks.Ennemy;
import entity.Blocks.Fallable;
import entity.Direction;
import model.DAOLevel;
import model.DBConnection;
import model.Level;

import java.sql.SQLException;

/**
 * The Class Controller.
 *
 * @author kevin
 * @version $Id: $Id
 */
public final class Controller implements IController  {

	/** The view. */
	private IView view;

	/** The model. */
	private IModel	model;

	private Level level;

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
		IModel level = this.model;
		boolean alreadyMoved[][] = new boolean[level.getTailleMapX()][level.getTailleMapY()];

		Block blockAUpdate;


		//on update chaque block dans la matrice
		for (int y = level.getTailleMapY() -1; y > 0; y--)
		{
			for (int x = 0; x < level.getTailleMapX(); x++)
			{
				blockAUpdate = level.getBlock(x, y);
				if (!alreadyMoved[x][y]) {


					// FALL Section
					if (blockAUpdate instanceof Fallable && y < level.getTailleMapY() - 1) {
						if (level.getBlock(x, y + 1) instanceof BackgroundDirt) {
							level.moveBlock(Direction.DOWN, x, y);
							alreadyMoved[x][y + 1] = true;
						}
						else if (level.getBlock(x, y + 1) instanceof Ennemy) {
							level.moveBlock(Direction.DOWN, x, y);
							alreadyMoved[x][y + 1] = true;
						}
						else if (level.getBlock(x, y + 1) instanceof Fallable && level.getBlock(x + 1, y) instanceof BackgroundDirt && level.getBlock(x + 1, y + 1) instanceof BackgroundDirt ) {
							level.moveBlock(Direction.RIGHT, x, y);
							alreadyMoved[x+1][y] = true;
						}
						else if (level.getBlock(x, y + 1) instanceof Fallable && level.getBlock(x - 1, y) instanceof BackgroundDirt && level.getBlock(x - 1, y + 1) instanceof BackgroundDirt ) {
							level.moveBlock(Direction.LEFT, x, y);
							alreadyMoved[x-1][y] = true;
						}

					//Ennemy section
					} else if (blockAUpdate instanceof Ennemy && y < level.getTailleMapY() - 1) {
						if (level.getBlock(x + 1, y) instanceof BackgroundDirt) {
							level.moveBlock(Direction.RIGHT, x, y);
							alreadyMoved[x + 1][y] = true;
						} else if (level.getBlock(x, y - 1) instanceof BackgroundDirt) {
							level.moveBlock(Direction.UP, x, y);
							alreadyMoved[x][y - 1] = true;
						} else if (level.getBlock(x - 1, y) instanceof BackgroundDirt) {
							level.moveBlock(Direction.LEFT, x, y);
							alreadyMoved[x - 1][y] = true;
						} else if (level.getBlock(x, y + 1) instanceof BackgroundDirt) {
							level.moveBlock(Direction.DOWN, x, y);
							alreadyMoved[x][y + 1] = true;
						}
					}
				}

			}
			this.model.setChanged();
			this.model.getObservable().notifyObservers();

		}
		//On update chaque block a la position demandée
		for (int y = 0; y < level.getTailleMapY(); y++) {
			for (int x = 0; x < level.getTailleMapX(); x++) {
				if (level.getBlock(x, y) != null)
				{
					level.getBlock(x, y).update(x, y);
				}
			}
		}
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
	/*	switch (controllerOrder) {
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

	 */

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

	public static Level loadLevel(final int niv) {
		Level level = null;
		try {
			final DAOLevel daoLevel = new DAOLevel(DBConnection.getInstance().getConnection());
			level = daoLevel.find(niv);
		} catch (final SQLException e) {
			e.printStackTrace();
		}
		return level;
	}

}
