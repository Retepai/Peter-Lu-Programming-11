package Computer;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Gpu extends Computer { //this is the gpu class and it extends the computer class
    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public String getManu() {
        return manu;
    }

    public String getCores() {
        return cores;
    }

    public String getMaxspeed() {
        return maxspeed;
    }

    public String getFans() {
        return fans;
    }

    public String getVram() {
        return vram;
    }

    public double getRank() {
        return rank;
    }

    public String getPhotoid() {
        return photoid;
    }


    private double price;
    private String name;
    private String manu;
    private String cores;
    private String maxspeed;

    public int getTDP() {
        return TDP;
    }

    private int TDP;
    private String fans;
    private String vram;
    private double rank;
    private String photoid;

    public int getFps() {
        return fps;
    }

    private int fps;

    public Gpu(double price, String name, String manu, String cores, String maxspeed, int TDP, String fans, String vram, int fps, double rank, String photoid){ //this the constructor for the gpu
        //it all the parameters that is put in upon the creation and makes an gpu with those parameters
        this.price=price;
        this.name=name;
        this.manu=manu;
        this.cores=cores;
        this.maxspeed=maxspeed;
        this.TDP=TDP;
        this.fans=fans;
        this.vram=vram;
        this.fps=fps;
        this.rank=rank;
        this.photoid=photoid;
    }
    public void writetofile(String txtfilename) throws IOException { //this writes the gpu portion of the computer to the file
        FileWriter fw = new FileWriter(txtfilename,true);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write("GPU+");
        bw.write(price +"<\r");
        bw.write(name +"!\r");
        bw.write(manu +"@\r");
        bw.write(cores +"#\r");
        bw.write(maxspeed +"$\r");
        bw.write(TDP +"%\r");
        bw.write(fans +"^\r");
        bw.write(vram +"&\r");
        bw.write(fps+"*\r");
        bw.write(rank +">\r");
        bw.write(photoid +"{\r");
        bw.write("?\r");
        bw.close();
    }

    @Override
    public String toString() {
        return manu+" "+name+" $"+price;
    }
}
