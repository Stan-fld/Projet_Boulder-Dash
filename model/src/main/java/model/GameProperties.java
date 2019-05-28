package model;


import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * The Class GameProperties.
 *
 * @author Jean-Aymeric Diet
 */
public class GameProperties extends Properties {

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
    /** The block length*/
	private int sizeX;
	/** The block heigth*/
	private int sizeY;
	/** The level*/
	private int level;
	private int framerate;
	private int animationSpeed;

	public int getBlockScale() {
		return blockScale;
	}

	private void setBlockScale(int blockScale) {
		this.blockScale = blockScale;
	}

	private int blockScale;
	/**
	 * Instantiates a new DB properties.
	 */

	private static GameProperties INSTANCE = new GameProperties();

	private GameProperties() {
		InputStream inputStream;

		inputStream = this.getClass().getClassLoader().getResourceAsStream(GameProperties.PROPERTIES_FILE_NAME);

		if (inputStream != null) {
			try {
				this.load(inputStream);
			} catch (final IOException e) {
				e.printStackTrace();
			}
			this.setUrl(this.getProperty("url"));
			this.setLogin(this.getProperty("login"));
			this.setPassword(this.getProperty("password"));
			this.setSizeX(Integer.parseInt(this.getProperty("sizeX")));
			this.setSizeY(Integer.parseInt(this.getProperty("sizeY")));
			this.setLevel(Integer.parseInt(this.getProperty("level")));
			this.setAnimationSpeed(Integer.parseInt(this.getProperty("animationSpeed")));
			this.setFramerate(Integer.parseInt(this.getProperty("framerate")));
			this.setBlockScale(Integer.parseInt(this.getProperty("blockScale")));

		}
	}


	public static GameProperties getInstance() {
        return INSTANCE;

    }


    /**
     * Gets the block length
     *
     *
     * @return The block length
     */

	public int getSizeX() {
        return sizeX;
    }

	private void setSizeX(int sizeX) {
		this.sizeX = sizeX;
	}

	public int getSizeY() {
		return sizeY;
	}

	private void setSizeY(int sizeY) {
		this.sizeY = sizeY;
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

	private void setLevel(int level) {
		this.level = level;
	}

    /**
     * Gets the animation speed
     *
     * @return the animation speed
     */
	public int getAnimationSpeed() {
        return animationSpeed;
    }


	/**
	 * Sets the animation speed.
	 *
	 * @param animationSpeed
	 * 					the new animation speed
	 */

	private void setAnimationSpeed(int animationSpeed) {
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
