import java.util.*;
import java.io.*;

public class Packages
{
    private ArrayList<Packet> shipmentList = new ArrayList<Packet>();
    private double totalWeight = 0.0;

    public Packages() throws IOException
    {
        Scanner fileScan;
        int i;
        double w;
        String d;
        String o;

        fileScan = new Scanner (new File("packetData.txt"));
        while (fileScan.hasNext())
        {
            i = fileScan.nextInt();
            w = fileScan.nextDouble();
            d = fileScan.next();
            o = fileScan.next();

            shipmentList.add(new Packet(i, w, d, o));

            totalWeight += w;
        }

        fileScan.close();
    }

    //-------------------------------------------------------------------------
    // Returns a String 
    //-------------------------------------------------------------------------
    public String toString()
    {
        String shipmentListString = "";

        for ( Packet temp : shipmentList )
        {
            shipmentListString += temp.toString();
        }

        return shipmentListString;
    }
    
    //-------------------------------------------------------------------------
    // 
    //-------------------------------------------------------------------------
    public void displayHeavyPackages()
    {
        for ( Packet temp : shipmentList )
        {
            if ( temp.isHeavy() )
                System.out.print(temp.toString());
        }
    }

    public void displayInStatePackages()
    {
        for ( Packet temp : shipmentList )
        {
            if ( temp.isInState() )
                System.out.print(temp.toString());
        }
    }

    public Packet maxWeightPacket()
    {
        int maxWeightIndex = -1;
        double currentMaxWeight = 0.0;

        for ( int i = 0; i < shipmentList.size(); i++ )
        {
            if ( shipmentList.get(i).getWeight() > currentMaxWeight )
            {
                maxWeightIndex = i;
                currentMaxWeight = shipmentList.get(i).getWeight();
            }
        }

        return shipmentList.get(maxWeightIndex);
    }

    public void displayAverageWeight()
    {
        // display average weight to 2 decimals using full sentence.
        double averageWeight;

        averageWeight = totalWeight / shipmentList.size();

        System.out.println(String.format("%.2f", averageWeight));
    }

    public void displayLocalPackets()
    {
        System.out.println("\nLOCAL PACKETS");

        for ( Packet temp : shipmentList )
        {
            if ( temp.destinationLocation().equals("Local") )
                System.out.print(temp.toString());
        }
    }

    public void displayNonLocalPackets()
    {
        System.out.println("\nNONLOCAL PACKETS");

        for ( Packet temp : shipmentList )
        {
            if ( temp.destinationLocation().equals("NonLocal") )
                System.out.print(temp.toString());
        }
    }
}