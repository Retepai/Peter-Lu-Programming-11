package Computer;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Computer { //this is the main computer class, it has sub-classes ( cpu, mobo, ram , gpu, storage, psu, case)


    public Computer() {
    }

    public CPU getCpu() {
        return cpu;
    }

    private CPU cpu;
    private Mobo mobo;

    public Mobo getMobo() {
        return mobo;
    }

    public Ram getRam() {
        return ram;
    }

    public Gpu getGpu() {
        return gpu;
    }

    public Storage getStorage() {
        return storage;
    }

    public Psu getPsu() {
        return psu;
    }

    public Case getCase() {
        return Case;
    }

    private Ram ram;
    private Gpu gpu;
    private Storage storage;
    private Psu psu;

    public void setCase(Case Case) {
        this.Case = Case;
    }

    private Case Case;

    public void setCpu(CPU cpu) {
        this.cpu = cpu;
    }

    public void setMobo(Mobo mobo) {
        this.mobo = mobo;
    }

    public void setRam(Ram ram) {
        this.ram = ram;
    }

    public void setGpu(Gpu gpu) {
        this.gpu = gpu;
    }

    public void setStorage(Storage storage) {
        this.storage = storage;
    }

    public void setPsu(Psu psu) {
        this.psu = psu;
    }



    Computer(CPU cpu, Mobo mobo, Ram ram, Gpu gpu, Storage storage, Psu psu,Case Case){ //this is the constructor for the computer, it takes all the components, combines them, and makes a computer object with it
        this.cpu=cpu;
        this.mobo=mobo;
        this.ram= ram;
        this.gpu=gpu;
        this.storage=storage;
        this.psu=psu;
        this.Case=Case;

    }
    public void writetofile(String txtfilename) throws IOException {} /*this is the write to file methode that is getting overridden by
     the writetofile methode in the sub-classes. When this methode is called all the methode in the subclasses will execute*/



}
