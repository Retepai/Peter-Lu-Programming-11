package Computer;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class CPU extends Computer { //this is the cpu class, it extends the computer class
    private double price;
    private String processorname;
    private String manufacturer;
    private double cores;
    private double threads;
    private String speed;

    public int getTDP() {
        return TDP;
    }

    private int TDP;

    public String getPhotoid() {
        return photoid;
    }

    private String photoid;

    public double getRank() {
        return rank;
    }

    private double rank;

    public double getPrice() {
        return price;
    }

    public String getProcessorname() {
        return processorname;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public double getCores() {
        return cores;
    }

    public double getThreads() {
        return threads;
    }

    public String getSpeed() {
        return speed;
    }

    public String getMaxspeed() {
        return maxspeed;
    }

    public String getType() {
        return type;
    }

    private String maxspeed;
    private String type;

    public double getFps() {
        return fps;
    }

    private double fps;

//this is the cpu constructor
    public CPU(double price, String processorname, String manufacturer, double cores, double threads, String speed, String maxspeed, int TDP, String type, double fps, double rank, String photoid){
        // constructor takes all the parameters and creates a cpu object with it
        this.price=price;
        this.processorname=processorname;
        this.manufacturer=manufacturer;
        this.cores=cores;
        this.threads=threads;
        this.speed=speed;
        this.maxspeed=maxspeed;
        this.TDP=TDP;
        this.type= type;
        this.fps=fps;
        this.rank= rank;
        this.photoid = photoid;

    }
    public void writetofile(String txtfilename) throws IOException { // when loading this methode would be called, it overrides the writetofile in the computer class
        FileWriter fw = new FileWriter(txtfilename,true);
        BufferedWriter bw = new BufferedWriter(fw);//the activates the buffered writer
        bw.write("CPU+"); //this is the identifier for when the pc's components get loaded back
        bw.write(price +"<\r"); //this writes the cpu's price and a < symbol to identify it as the first parameter
        bw.write(processorname +"!\r"); //the rest all follow this pattern
        bw.write(manufacturer +"@\r");
        bw.write(cores +"#\r");
        bw.write(threads+"$\r");
        bw.write(speed +"%\r");
        bw.write(maxspeed +"^\r");
        bw.write(TDP+"&\r");
        bw.write(type +"*\r");
        bw.write(fps+">\r");
        bw.write(rank+"}\r");
        bw.write(photoid +"{\r");
        bw.write("?\r");
        bw.close();

    }

    @Override
    public String toString() {
        return manufacturer+" "+processorname+" $"+price;
    } //this tostring overrides the return methode in this class and returns the specific parameters. In this case it returns the manufacturer, cpu, and price


}
