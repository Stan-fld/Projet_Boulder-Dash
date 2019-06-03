package entity;


import java.awt.*;

public class Score extends Rectangle {
    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    private int score;

    public Score() {
        super(5,5,64, 32);

    }

    public void incrementScore() {
        this.score++;
    }

    public void print(Graphics g) {
        g.setColor(Color.white);
        g.fillRoundRect((int) this.getX(), (int) this.getY(), (int) this.getWidth(), (int) this.getHeight(), 5, 5);
        g.setColor(Color.BLUE);
        g.drawRoundRect((int) this.getX(), (int) this.getY(), (int) this.getWidth(), (int) this.getHeight(), 5, 5);
        g.drawString("Score : " + this.score, 6, (int) this.getCenterY());
    }

}
