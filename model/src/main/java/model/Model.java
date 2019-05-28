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
 */
public final class Model extends Observable implements IModel {

	/** The helloWorld. */
	private HelloWorld helloWorld;
	private Rock test;

	/**
	 * Instantiates a new model.
	 */
	public Model() {
		this.helloWorld = new HelloWorld();
		this.test = new Rock(0, 0);
	}

	public void update()
	{
		this.test.updateAnimationRow();
		this.setChanged();
		this.notifyObservers();
	}
	/**
     * Gets the hello world.
     *
     * @return the hello world
     */
	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IModel#getMessage()
	 */
	public HelloWorld getHelloWorld() {
		return this.helloWorld;
	}

	/**
     * Sets the hello world.
     *
     * @param helloWorld
     *            the new hello world
     */
	private void setHelloWorld(final HelloWorld helloWorld) {
			this.helloWorld = helloWorld;
			this.setChanged();
			this.notifyObservers();
	}


	/**
     * Load hello world.
     *
     * @param code
     *            the code
     */
	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IModel#getMessage(java.lang.String)
	 */
	public void loadLevelSelect( int code) {
		try {
			final DAOLevelSelect daoLevelSelect= new DAOLevelSelect(DBConnection.getInstance().getConnection());
			this.set(daoLevelSelect.find(code));
		} catch (final SQLException e) {
			e.printStackTrace();
		}
	}

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
