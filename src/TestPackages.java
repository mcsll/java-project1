import java.io.*;

public class TestPackages
{
    public static void main(String[] args) throws IOException
    {
        Packages thePackages = new Packages();

        // Print all packets
        System.out.print("\nALL PACKETS\n");
        System.out.print(thePackages.toString());

        // Print all heavy packets
        System.out.print("\nALL HEAVY PACKETS\n");
        thePackages.displayHeavyPackages();

        // Print all in-state packets
        System.out.print("\nALL IN-STATE PACKETS\n");
        thePackages.displayInStatePackages();
        
        // Print packet with max weight
        System.out.print("\nThe packet object with max weight is: " + thePackages.maxWeightPacket().toString());

        // Print average packet weight
        System.out.print("\nThe average weight of all packets is: ");
        thePackages.displayAverageWeight();

        // Print all local packets
        thePackages.displayLocalPackets();

        // Print all non-local packets
        thePackages.displayNonLocalPackets();
    }
}