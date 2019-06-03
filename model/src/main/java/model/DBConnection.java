package model;

import entity.GameProperties;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * The Class DBConnection.
 * Permit the connection to a database
 *
 * @author Jean-Aymeric Diet
 * @version $Id: $Id
 */
public final class DBConnection {
	/** The instance. */
	private static DBConnection	INSTANCE	= null;

	/** The connection. */
	private Connection					connection;

	/**
	 * Instantiates a new DB connection.
	 */
	private DBConnection() {
		this.open();
	}

	/**
	 * Gets the single instance of DBConnection.
	 *
	 * @return single instance of DBConnection
	 */
	public static synchronized DBConnection getInstance() {
		if (DBConnection.INSTANCE == null) {
			DBConnection.INSTANCE = new DBConnection();
		}
		return DBConnection.INSTANCE;
	}

	/**
	 * Open.
	 *
	 * @return the boolean
	 */
	private Boolean open() {
		final GameProperties gameProperties = GameProperties.getInstance();
		try {
			Class.forName("com.mysql.jdbc.Driver"); //Ca va servir à instancier une classe en question
			this.connection = DriverManager.getConnection(gameProperties.getUrl(), gameProperties.getLogin(), gameProperties.getPassword());
		} catch (final ClassNotFoundException e) {
			e.printStackTrace();
		} catch (final SQLException e) {
			e.printStackTrace();
		}
		return true;	}

	/**
	 * Gets the connection.
	 *
	 * @return the connection
	 */
	public Connection getConnection() {
		return this.connection;
	}
}
