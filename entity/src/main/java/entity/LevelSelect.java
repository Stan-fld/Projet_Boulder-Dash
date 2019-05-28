package entity;

public class LevelSelect
{
    final int id;
    private String level;




    public LevelSelect (final int id, final String level)
    {
        this.id=id;
        this.level=level;
    }

    public int getId() {
        return id;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

}
