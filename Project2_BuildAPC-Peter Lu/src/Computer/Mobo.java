package Computer;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Mobo extends Computer { //this is the motherboard class and it extends the computer class
    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public String getManu() {
        return manu;
    }

    public String getType() {
        return type;
    }

    public double getRank() {
        return rank;
    }


    private double price;
    private String name;
    private String manu;
    private String type;
    private double rank;

    public String getPhotoid() {
        return photoid;
    }

    private String photoid;


    public Mobo(double price, String name, String manu, String type, double rank, String photoid){ //this uses the parameter and constructs the mobo object with it
        this.price=price;
        this.name=name;
        this.manu=manu;
        this.type=type;
        this.rank= rank;
        this.photoid= photoid;

    }
    public void writetofile(String txtfilename) throws IOException { //this overrides the return methode in the computer class and writes the mobo portion of computer to the file
        FileWriter fw = new FileWriter(txtfilename,true);
        BufferedWriter bw = new BufferedWriter(fw); //this activates the buffered writer
        bw.write("MOBO+"); //this is the identifier, in this case it tells the loader that it's mobo that is being loaded.
        bw.write(price +"<\r"); //this writes the price with the < symbol to identify it as the first parameter
        bw.write(name +"!\r");
        bw.write(manu +"@\r");
        bw.write(type +"#\r");
        bw.write(rank +"$\r");
        bw.write(photoid +"%\r");
        bw.write("?\r");
        bw.close();
    }


    @Override
    public String toString() {
        return name+" $"+price;
    }
}
