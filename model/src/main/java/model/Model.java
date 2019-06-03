package model;

import java.awt.*;
import java.sql.SQLException;
import java.util.Observable;
import java.io.*;

import contract.IModel;
import entity.GameProperties;


/**
 * The Class Model.
 * ######OBSOLETE
 *
 * @deprecated
 * @author Valentin
 * @version $Id: $Id
 */
public final class Model extends Observable /*implements IModel*/ {

	/** The level */
	private Level level;

	/**
	 * Instantiates a new model.
	 */
	public Model() {
		loadLevel(GameProperties.getInstance().getLevel());
	}

	/**
	 * Gets the level.
	 *
	 * @return the level
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
     * Sets the level
     *
     * @param level
     *            the new level
     */
	private void setLevel(final Level level) {
		this.level = level;
		this.setChanged();
		this.notifyObservers();
	}

	/**
	 * {@inheritDoc}
	 *
	 * Load the level
	 *
	 * @param niv a int.
	 */
	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IModel#getMessage(java.lang.String)
	 */
	public void loadLevel(final int niv) {
		try {
			final DAOLevel daoLevel = new DAOLevel(DBConnection.getInstance().getConnection());
			this.setLevel(daoLevel.find(niv));
		} catch (final SQLException e) {
			e.printStackTrace();
		}


	}

	/**
	 * {@inheritDoc}
	 *
	 * @param g a {@link java.awt.Graphics} object.
	 */
	public void print(Graphics g)
	{
		level.print(g);
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
