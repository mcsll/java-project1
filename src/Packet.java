import java.util.*;

public class Packet
{
    private int idNumber;
    private double weight;
    private String stateDest;
    private String stateOrig;

    private ArrayList<String> localStates = new ArrayList<String>();

    public Packet(int idNumber, double weight, String stateDest, String stateOrig)
    {
        this.idNumber = idNumber;
        this.weight = weight;
        this.stateDest = stateDest;
        this.stateOrig = stateOrig;
    }

    public boolean isHeavy()
    {
        return (weight > 10);
    }

    public boolean isInState()
    {
        return (stateDest.equals(stateOrig));
    }

    public String toString()
    {
        return idNumber + "\t" + weight + "\t" + stateDest + "\t" + stateOrig + "\n";
    }

    public double getWeight()
    {
        return weight;
    }

    public String destinationLocation()
    {
        localStates.add("CT");
        localStates.add("MA");
        localStates.add("RI");
        localStates.add("NY");

        if ( localStates.contains(stateDest) )
            return "Local";
        else
            return "NonLocal";
    }
}