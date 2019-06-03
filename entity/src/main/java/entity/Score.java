package entity;


import java.awt.*;

/**
 * <p>Score class.</p>
 * permit to print the score on the screen
 *
 * @author kevin
 * @version $Id: $Id
 */
public class Score extends Rectangle {
    /**
     * <p>Getter for the field <code>score</code>.</p>
     *
     * @return a int.
     */
    public int getScore() {
        return score;
    }

    /**
     * <p>Setter for the field <code>score</code>.</p>
     *
     * @param score a int.
     */
    public void setScore(int score) {
        this.score = score;
    }

    private int score;

    /**
     * <p>Constructor for Score.</p>
     */
    public Score() {
        super(5,5,64, 32);

    }

    /**
     * <p>incrementScore.</p>
     */
    public void incrementScore() {
        this.score++;
    }

    /**
     * <p>print.</p>
     *
     * @param g a {@link java.awt.Graphics} object.
     */
    public void print(Graphics g) {
        g.setColor(Color.white);
        g.fillRoundRect((int) this.getX(), (int) this.getY(), (int) this.getWidth(), (int) this.getHeight(), 5, 5);
        g.setColor(Color.BLUE);
        g.drawRoundRect((int) this.getX(), (int) this.getY(), (int) this.getWidth(), (int) this.getHeight(), 5, 5);
        g.drawString("Score : " + this.score, 6, (int) this.getCenterY());
    }

}
