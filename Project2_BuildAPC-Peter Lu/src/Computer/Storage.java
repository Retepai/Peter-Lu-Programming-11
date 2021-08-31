package Computer;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Storage extends Computer{ //this is the storage class, it extends computer class
        public void setPrice(double price) {
            this.price = price;
        }

        private double price;
        private String name;
        private String manu;

        public void setCap(String cap) {
            this.cap = cap;
        }

    public String getCap() {
        return cap;
    }

    private String cap;

        public double getPrice() {
            return price;
        }

        public String getName() {
            return name;
        }

        public String getManu() {
            return manu;
        }

        private String read;
        private String write;

        public String getRead() {
            return read;
        }

        public String getWrite() {
            return write;
        }

        public String getType() {
            return type;
        }

        public String getDram() {
            return dram;
        }

        public double getRank() {
            return rank;
        }

        public String getPhotoid() {
            return photoid;
        }

        private String type;
        private String dram;
        private double rank;
        private String photoid;

        public Storage(double price, String name, String manu, String cap, String read, String write, String type, String dram, double rank, String photoid){ //this constructor for storage
            //it takes the information passed through the parameters and creates a storage object with it
            this.price=price;
            this.name=name;
            this.manu=manu;
            this.cap=cap;
            this.read=read;
            this.write=write;
            this.type=type;
            this.dram=dram;
            this.rank=rank;
            this.photoid=photoid;

        }
    public void writetofile(String txtfilename) throws IOException { //this writes the storage portion of the computer to the file
        FileWriter fw = new FileWriter(txtfilename,true);
        BufferedWriter bw = new BufferedWriter(fw);//this activates the buffered writer
        bw.write("SSD+"); //this is the identifier for when the pc gets loaded back
        bw.write(price +"<\r"); //the price gets written to the file and at end there is a < symbol to identify it as the first parameter
        bw.write(name +"!\r");
        bw.write(manu +"@\r");
        bw.write(cap +"#\r");
        bw.write(read +"$\r");
        bw.write(write +"%\r");
        bw.write(type +"^\r");
        bw.write(dram +"&\r");
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


