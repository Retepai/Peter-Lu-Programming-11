package Computer;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Psu extends Computer { //this is the psu class and it extends the computer class
    private double price;
    private String name;
    private String manu;
    private int wattage;

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public String getManu() {
        return manu;
    }

    public int getWattage() {
        return wattage;
    }

    public String getRating() {
        return rating;
    }

    public double getRank() {
        return rank;
    }

    public String getPhotoid() {
        return photoid;
    }

    private String rating;
    private double rank;
    private String photoid;

    public String getRatingtxt() {
        return ratingtxt;
    }

    private String ratingtxt;

    public Psu(double price, String name, String manu, int wattage, String rating, String ratingtxt, double rank, String photoid){ //this is the constructor for the psu
        //it takes in all the parameter and creates a psu object with it
        this.price=price;
        this.name=name;
        this.manu=manu;
        this.wattage=wattage;
        this.rating=rating;
        this.ratingtxt=ratingtxt;
        this.rank=rank;
        this.photoid=photoid;
    }
    public void writetofile(String txtfilename) throws IOException { //this overrides the write to file methode in computer, and it writes the psu portion of the pc build
        FileWriter fw = new FileWriter(txtfilename,true);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write("PSU+");
        bw.write(price +"<\r");
        bw.write(name +"!\r");
        bw.write(manu +"@\r");
        bw.write(wattage +"#\r");
        bw.write(rating +"$\r");
        bw.write(ratingtxt +"%\r");
        bw.write(rank +"^\r");
        bw.write(photoid +"&\r");
        bw.write("?\r");
        bw.close();
    }

    @Override
    public String toString() {
        return name+" "+wattage+" $"+price;
    }
}
