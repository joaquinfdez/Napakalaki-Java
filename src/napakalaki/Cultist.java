package napakalaki;

/**
 *
 * @author JFL
 */
public class Cultist{
    private String name;
    private int gainedLevels;

    public Cultist(String n, int gL)
    {
      this.name = n;
      this.gainedLevels = gL;
    }
    
    public int getGainedLevels()
    {
      return gainedLevels;
    }

    public String getName()
    {
      return name;
    }
}
