/**
 * CS152 Section 01, Project #1
 * Packet class describes individual packet object
 * @author (Matthew Sullivan) 
 * @version (Feb 06, 2017)
 */

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
        
        // Populate the ArrayList of local states for later comparison
        localStates.add("CT");
        localStates.add("MA");
        localStates.add("RI");
        localStates.add("NY");
    }


    //-------------------------------------------------------------------------
    // Returns a boolean, indicating whether the Packet is "heavy" or not.
    //-------------------------------------------------------------------------
    public boolean isHeavy()
    {
        return (weight > 10);
    }


    //-------------------------------------------------------------------------
    // Returns a boolean, indicating whether the destination and origin 
    // states are the same or not.
    //-------------------------------------------------------------------------
    public boolean isInState()
    {
        return (stateDest.equals(stateOrig));
    }


    //-------------------------------------------------------------------------
    // Returns a String object that is a tab-separated combination of the 
    // four parameters of the Packet, with a line break at the end.
    //-------------------------------------------------------------------------
    public String toString()
    {
        return idNumber + "\t" + weight + "\t" + stateDest + "\t" + stateOrig + "\n";
    }


    //-------------------------------------------------------------------------
    // Returns the Packet's weight as a double
    //-------------------------------------------------------------------------
    public double getWeight()
    {
        return weight;
    }


    //-------------------------------------------------------------------------
    // Returns one of two Strings indicating whether the Packet's destination
    // is "local" or not
    //-------------------------------------------------------------------------
    public String destinationLocation()
    {
        if ( localStates.contains(stateDest) )
            return "Local";
        
        return "NonLocal";
    }
}