package model;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * The Class DBProperties.
 *
 * @author Jean-Aymeric Diet
 */
class DBProperties extends Properties {

	/** The Constant serialVersionUID. */
	private static final long		serialVersionUID			= 5289057445894568927L;

	/** The Constant PROPERTIES_FILE_NAME. */
	private final static String	PROPERTIES_FILE_NAME	= "model.properties";

	/** The url. */
	private String							url										= "";

	/** The login. */
	private String							login									= "";

	/** The password. */
	private String							password							= "";

	private int block_x ;
	private int block_y;
	private int level;
	private int framerate;
	private int animationSpeed;
	/**
	 * Instantiates a new DB properties.
	 */

	private static DBProperties INSTANCE = new DBProperties();

	private DBProperties() {
		InputStream inputStream;

		inputStream = this.getClass().getClassLoader().getResourceAsStream(DBProperties.PROPERTIES_FILE_NAME);

		if (inputStream != null) {
			try {
				this.load(inputStream);
			} catch (final IOException e) {
				e.printStackTrace();
			}
			this.setUrl(this.getProperty("url"));
			this.setLogin(this.getProperty("login"));
			this.setPassword(this.getProperty("password"));
			this.setBlock_x(Integer.parseInt(this.getProperty("block_x")));
			this.setBlock_y(Integer.parseInt(this.getProperty("block_y")));
			this.setLevel(Integer.parseInt(this.getProperty("level")));
			this.setAnimationSpeed(Integer.parseInt(this.getProperty("animationSpeed")));
			this.setFramerate(Integer.parseInt(this.getProperty("framerate")));

		}
	}


	public static DBProperties getInstance()
	{
		return INSTANCE;

	}

	public int getBlock_x() {
		return block_x;
	}

	public void setBlock_x(int block_x) {
		this.block_x = block_x;
	}

	public int getBlock_y() {
		return block_y;
	}

	public void setBlock_y(int block_y) {
		this.block_y = block_y;
	}

	public int getFramerate() {
		return framerate;
	}

	public void setFramerate(int framerate) {
		this.framerate = framerate;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getAnimationSpeed() {
		return animationSpeed;
	}



	public void setAnimationSpeed(int animationSpeed) {
		this.animationSpeed = animationSpeed;
	}

	/**
	 * Gets the url.
	 *
	 * @return the url
	 */
	public String getUrl() {
		return this.url;
	}

	/**
	 * Sets the url.
	 *
	 * @param url
	 *          the new url
	 */
	private void setUrl(final String url) {
		this.url = url;
	}

	/**
	 * Gets the login.
	 *
	 * @return the login
	 */
	public String getLogin() {
		return this.login;
	}

	/**
	 * Sets the login.
	 *
	 * @param login
	 *          the new login
	 */
	private void setLogin(final String login) {
		this.login = login;
	}

	/**
	 * Gets the password.
	 *
	 * @return the password
	 */
	public String getPassword() {
		return this.password;
	}

	/**
	 * Sets the password.
	 *
	 * @param password
	 *          the new password
	 */
	private void setPassword(final String password) {
		this.password = password;
	}

}
