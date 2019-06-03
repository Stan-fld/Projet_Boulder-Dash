package entity;


import java.awt.*;

/**
 * Score class
 * permit to print the score on the screen
 *
 * @author Valentin
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


    public void setScore(int score) {
        this.score = score;
    }

    /**
     * Score
     */
    private int score;

    /**
     * Score constructor
     */
    public Score() {
        super(5,5,64, 32);

    }

    /**
     * incrementScore method
     *
     */
    public void incrementScore() {
        this.score++;
    }

    /**
     * print method
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
