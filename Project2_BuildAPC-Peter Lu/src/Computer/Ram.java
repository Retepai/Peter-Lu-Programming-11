package Computer;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Ram extends Computer{ //this is the ram class and it extends the main computer class


    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public String getManu() {
        return manu;
    }



    public String getSpeed() {
        return speed;
    }

    public String getLatency() {
        return latency;
    }

    public String getType() {
        return type;
    }

    public double getRank() {
        return rank;
    }

    public String getPhotoid() {
        return photoid;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    private double price;
    private String name;
    private String manu;

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public String getCapacity() {
        return capacity;
    }

    public int getSticks() {
        return sticks;
    }

    private String capacity;
    private String speed;
    private String latency;
    private String type;
    private double rank;
    private String photoid;

    public void setSticks(int sticks) {
        this.sticks = sticks;
    }

    private int sticks;

    public Ram(double price, String name, String manu, String capacity, int sticks, String speed, String latency, String type, double rank, String photoid){ //this is the constructor for the ram
        //it takes all the ram parameters and creates an ram object with those parameters
        this.price= price;
        this.name=name;
        this.manu=manu;
        this.capacity=capacity;
        this.sticks=sticks;
        this.speed= speed;
        this.latency=latency;
        this.type=type;
        this.rank=rank;
        this.photoid=photoid;
    }
    public void writetofile(String txtfilename) throws IOException { //this overrides the writetofile methode in the computer class and writes the ram portion of the computer
        FileWriter fw = new FileWriter(txtfilename,true);
        BufferedWriter bw = new BufferedWriter(fw); //this activates the buffered writer
        bw.write("RAM+"); //this is the identifier
        bw.write(price +"<\r"); //the price gets written in
        bw.write(name +"!\r");
        bw.write(manu +"@\r");
        bw.write(capacity +"#\r");
        bw.write(sticks+"$\r");
        bw.write(speed +"%\r");
        bw.write(latency +"^\r");
        bw.write(type +"&\r");
        bw.write(rank +"*\r");
        bw.write(photoid +">\r");
        bw.write("?\r");
        bw.close();
    }

    @Override
    public String toString() {
        return name+" $"+price;
    }
}
