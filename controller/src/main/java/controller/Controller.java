package controller;

import contract.ControllerOrder;
import contract.IController;
import contract.IModel;
import contract.IView;
import entity.Blocks.*;
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


	private int points = 0;

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
		//IModel this.model = this.model;
		boolean alreadyMoved[][] = new boolean[this.model.getTailleMapX()][this.model.getTailleMapY()];

		Block blockAUpdate;


		//on update chaque block dans la matrice
		for (int y = this.model.getTailleMapY() -1; y > 0; y--)
		{
			for (int x = 0; x < this.model.getTailleMapX(); x++)
			{
				blockAUpdate = this.model.getBlock(x, y);
				if (!alreadyMoved[x][y]) {


					// FALL Section
					if (blockAUpdate instanceof Fallable && y < this.model.getTailleMapY() - 1) {
						if (this.model.getBlock(x, y + 1) instanceof BackgroundDirt) {
							this.model.moveBlock(Direction.DOWN, x, y);
							alreadyMoved[x][y + 1] = true;
						}
						else if (this.model.getBlock(x, y + 1) instanceof Ennemy) {
							this.model.moveBlock(Direction.DOWN, x, y);
							alreadyMoved[x][y + 1] = true;
						}
						else if (this.model.getBlock(x, y + 1) instanceof Fallable
								&& this.model.getBlock(x + 1, y) instanceof BackgroundDirt
								&& this.model.getBlock(x + 1, y + 1) instanceof BackgroundDirt ) {
							this.model.moveBlock(Direction.RIGHT, x, y);
							alreadyMoved[x+1][y] = true;
						}
						else if (this.model.getBlock(x, y + 1) instanceof Fallable
								&& this.model.getBlock(x - 1, y) instanceof BackgroundDirt
								&& this.model.getBlock(x - 1, y + 1) instanceof BackgroundDirt ) {
							this.model.moveBlock(Direction.LEFT, x, y);
							alreadyMoved[x-1][y] = true;
						}

					//Ennemy section
					} else if (blockAUpdate instanceof Ennemy && y < this.model.getTailleMapY() - 1) {
						if (this.model.getBlock(x + 1, y) instanceof BackgroundDirt) {
							this.model.moveBlock(Direction.RIGHT, x, y);
							alreadyMoved[x + 1][y] = true;
						} else if (this.model.getBlock(x, y - 1) instanceof BackgroundDirt) {
							this.model.moveBlock(Direction.UP, x, y);
							alreadyMoved[x][y - 1] = true;
						} else if (this.model.getBlock(x - 1, y) instanceof BackgroundDirt) {
							this.model.moveBlock(Direction.LEFT, x, y);
							alreadyMoved[x - 1][y] = true;
						} else if (this.model.getBlock(x, y + 1) instanceof BackgroundDirt) {
							this.model.moveBlock(Direction.DOWN, x, y);
							alreadyMoved[x][y + 1] = true;
						}
					}
				}

			}
			this.model.setChanged();
			this.model.getObservable().notifyObservers();

		}
		//On update chaque block a la position demandée
		for (int y = 0; y < this.model.getTailleMapY(); y++) {
			for (int x = 0; x < this.model.getTailleMapX(); x++) {
				if (this.model.getBlock(x, y) != null)
				{
					this.model.getBlock(x, y).update(x, y);
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
		int playerX = this.model.getPlayerX();
		int playerY = this.model.getPlayerY();
		Block p = this.model.getBlock(playerX, playerY);
		//All tests for player's moves
		if (p instanceof Player) {
			Player player = (Player) p;
			if (!player.isMooving()) {
				switch (controllerOrder) {
					case Up:
						Block upCase = this.model.getBlock(playerX, playerY - 1);
						if (upCase instanceof Dirt || upCase instanceof BackgroundDirt || upCase instanceof Diamond) {
							this.model.moveBlock(Direction.UP, playerX, playerY);
							this.model.setPlayerPos(playerX, playerY - 1);
							if (upCase instanceof Diamond) {
								points++;
							}
						}
						break;
					case Down:
						Block downCase = this.model.getBlock(playerX, playerY + 1);
						if (downCase instanceof Dirt || downCase instanceof BackgroundDirt || downCase instanceof Diamond) {
							this.model.moveBlock(Direction.DOWN, playerX, playerY);
							this.model.setPlayerPos(playerX, playerY + 1);
							if (downCase instanceof Diamond) {
								points++;
							}
						}
						break;
					case Left:
						Block leftCase = this.model.getBlock(playerX - 1, playerY);
						if (leftCase instanceof Dirt || leftCase instanceof BackgroundDirt || leftCase instanceof Diamond) {
							this.model.moveBlock(Direction.LEFT, playerX, playerY);
							this.model.setPlayerPos(playerX - 1, playerY);
							if (leftCase instanceof Diamond) {
								points++;
							}
						} else if (leftCase instanceof Stone) {
							Block leftStoneCase = this.model.getBlock(playerX - 2, playerY);
							if (leftStoneCase instanceof BackgroundDirt) {
								//We move the player and the stone
								this.model.moveBlock(Direction.LEFT, playerX - 1, playerY);
								this.model.moveBlock(Direction.LEFT, playerX, playerY);
								this.model.setPlayerPos(playerX - 1, playerY);
							}
						}
						break;
					case Right:
						Block rightCase = this.model.getBlock(playerX + 1, playerY);
						if (rightCase instanceof Dirt || rightCase instanceof BackgroundDirt || rightCase instanceof Diamond) {
							this.model.moveBlock(Direction.RIGHT, playerX, playerY);
							this.model.setPlayerPos(playerX + 1, playerY);
							if (rightCase instanceof Diamond) {
								points++;
							}
						} else if (rightCase instanceof Stone) {
							Block rightStoneCase = this.model.getBlock(playerX + 2, playerY);
							if (rightStoneCase instanceof BackgroundDirt) {
								//We move the player and the stone
								this.model.moveBlock(Direction.RIGHT, playerX + 1, playerY);
								this.model.moveBlock(Direction.RIGHT, playerX, playerY);
								this.model.setPlayerPos(playerX + 1, playerY);
							}
						}
						break;
					default:
						break;
				}
			}
		}

		//all others
		switch (controllerOrder) {
			default:
				break;
		}
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
