package entity;


import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * The Class GameProperties.
 *
 * @author Kevin
 *
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

	/**
	 * <p>Getter for the field <code>blockScale</code>.</p>
	 *
	 * @return a int.
	 */
	public int getBlockScale() {
		return blockScale;
	}

	/**
	 * The blockSale Setter
	 *
	 * @param blockScale
	 */
	private void setBlockScale(int blockScale) {
		this.blockScale = blockScale;
	}

	private int blockScale;



	private int tailleMapX;
	private int tailleMapY;
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
			this.setTailleMapX(Integer.parseInt(this.getProperty("tailleMapX")));
			this.setTailleMapY(Integer.parseInt(this.getProperty("tailleMapY")));

		}
	}


	/**
	 * <p>getInstance.</p>
	 *
	 * @return a {@link GameProperties} object.
	 */
	public static GameProperties getInstance() {
        return INSTANCE;

    }


	/**
	 * Gets the block length
	 *
	 * @return The block length
	 */
	public int getSizeX() {
        return sizeX;
    }

	private void setSizeX(int sizeX) {
		this.sizeX = sizeX;
	}

	/**
	 * <p>Getter for the field <code>sizeY</code>.</p>
	 *
	 * @return a int.
	 */
	public int getSizeY() {
		return sizeY;
	}

	private void setSizeY(int sizeY) {
		this.sizeY = sizeY;
	}

	/**
	 * <p>Getter for the field <code>framerate</code>.</p>
	 *
	 * @return a int.
	 */
	public int getFramerate() {
		return framerate;
	}

	/**
	 * <p>Setter for the field <code>framerate</code>.</p>
	 *
	 * @param framerate a int.
	 */
	public void setFramerate(int framerate) {
		this.framerate = framerate;
	}

	/**
	 * <p>Getter for the field <code>level</code>.</p>
	 *
	 * @return a int.
	 */
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

	/**
	 * Gets the tailleMapx
	 *
	 * @return tailleMapx
	 */
	public int getTailleMapX() {
		return tailleMapX;
	}

	/**
	 * Sets the TailleMax
	 *
	 * @param tailleMapX the new TailleMapX
	 */
	private void setTailleMapX(int tailleMapX) {
		this.tailleMapX = tailleMapX;
	}

	/**
	 * Gets the TailleMapY
	 *
	 * @return TailleMapY
	 */
	public int getTailleMapY() {
		return tailleMapY;
	}

	/**
	 * Sets the TailleMapY
	 *
	 * @param tailleMapY the new TailleMapY
	 */
	private void setTailleMapY(int tailleMapY) {
		this.tailleMapY = tailleMapY;
	}
}
