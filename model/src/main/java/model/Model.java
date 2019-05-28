package model;

import java.awt.*;
import java.sql.SQLException;
import java.util.Observable;

import contract.IModel;
import entity.HelloWorld;

/**
 * The Class Model.
 *
 * @author Jean-Aymeric Diet
 * @version $Id: $Id
 */
public final class Model extends Observable implements IModel {

	/** The helloWorld. */
	private HelloWorld helloWorld;
	private Level level;

	private Rock test;

	/**
	 * Instantiates a new model.
	 */
	public Model() {
		this.helloWorld = new HelloWorld();
		this.test = new Rock(0, 0);
	}

	/**
	 * <p>update.</p>
	 */
	public void update()
	{
		this.test.updateAnimationRow();
		this.setChanged();
		this.notifyObservers();
	}
	/**
	 * Gets the level.
	 *
	 * @return the hello world
	 */
	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IModel#getMessage()
	 */
	public Level getLevel() {
		return this.level;
	}

	/**
     * Sets the hello world.
     *
     * @param level
     *            the new hello world
     */
	private void setLevel(final Level level) {
		this.level = level;
		this.setChanged();
		this.notifyObservers();
	}

	/**
	 * {@inheritDoc}
	 *
	 * Load hello world.
	 */
	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IModel#getMessage(java.lang.String)
	 */
	public void loadLevel(final String code) {
		try {
			final DAOLevelSelect daoLevelSelect = new DAOLevelSelect(DBConnection.getInstance().getConnection());
			this.setLevel(daoLevelSelect.find(code));
		} catch (final SQLException e) {
			e.printStackTrace();
		}
	}

	/** {@inheritDoc} */
	public void print(Graphics g)
	{
		test.print(g);
	}

	/**
	 * Gets the observable.
	 *
	 * @return the observable
	 */
	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IModel#getObservable()
	 */
	public Observable getObservable() {
		return this;
	}
}
