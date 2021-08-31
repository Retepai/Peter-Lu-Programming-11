package Computer;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class Controller {
//Fields
    //Home
    public Tab homtab;
    public Button btnhomeNext;
    public TabPane tbdpMain;
    //CPU Fields
    public Tab Cputab;
    public Button btnCpunext;
    public Button btnCpuback;
    public Label lblcpuname;
    public Label lblmanu;
    public Label lblcpucores;
    public Label lblcputhreads;
    public Label lblcpuspeed;
    public Label lblcpuboost;
    public Label lblcpusocket;
    public Label lblprice;
    public ImageView cpuimage;
    public Label lblcpurank;
    public Button btncpuadd;
    public Label lblcputdp;
    //the price,name,cores,threads,speed,maxspeed,thermal design power,fps,rank, and photo id of theses cpu will be stored in arrays and loaded onto the listview
    public ListView <CPU> AMDCpuView = new ListView<>(); //this is the list View that will display all the AMD CPUs
    private final double[] Aprice = new double[]{1149.99,779.99,569.99,439.99,1099.00,749.99,564.45,339.99};
    private final String[] Aprocessor = new String[]{"Ryzen 9 5950X", "Ryzen 9 5900X", "Ryzen 7 5800X", "Ryzen 5 5600X", "Ryzen 9 3950X", "Ryzen 9 3900X", "Ryzen 7 3800X", "Ryzen 5 3600X"};
    private final double[] Acores = new double[]{16,12,8,6,16,12,8,6};
    private final double[] Athreads = new double[]{32,24,16,12,32,24,16,12};
    private final String[] Aspeed = new String[]{"3.4GHz", "3.7GHz", "3.8GHz", "3.7GHz", "3.5GHz", "3.8GHz", "3.9GHz", "3.8GHz"};
    private final String[] AmaxSpeed = new String[]{"4.9GHz", "4.8GHz", "4.7GHz", "4.6GHz", "4.7GHz", "4.6GHz", "4.5GHz", "4.4GHz"};
    private final int[] Atdp= new int[]{105,105,105,65,105,105,105,95};
    private final double[] Acpufps={94,65,50,40,80,60,46,32};
    private final double[] Arank = new double[]{5,4,3,2,4,3,2,1};
    private final String[] Aphotoid = new String[]{"cpupics/Ryzen 9.png","cpupics/Ryzen 9.png","cpupics/Ryzen 7.png","cpupics/Ryzen 5.jpg","cpupics/Ryzenold 9.png","cpupics/Ryzenold 9.png","cpupics/Ryzenold 7.jpg","cpupics/Ryzenold 5.jpg"};
    public ListView <CPU>IntelCpuView = new ListView<>(); // this is the list view that will display all the Intel Cpus
    private final double[] iprice = new double[]{708.99,599.99,399.99,299.99,564.99,519.99,296.99,170.99,144.99};
    private final String[] iprocessor = new String[]{"Core i9 11900K", "Core i7 11700K", "Core i5 11600K", "Core i5 11400f", "Core i9 10900K", "Core i7 10700K", "Core i5 10600K", "Core i5 10400f","Core i3 10100"};
    private final double[] icores = new double[]{8,8,6,6,10,8,6,6,4};
    private final double[] ithreads = new double[]{12,16,12,12,20,16,12,12,8};
    private final String[] ispeed = new String[]{"3.5GHz", "3.6GHz", "3.9GHz", "2.6GHz", "3.7GHz", "3.8GHz", "4.1GHz", "2.9GHz","3.6GHz"};
    private final String[] imaxSpeed = new String[]{"5.3GHz", "5.0GHz", "4.9GHz", "4.4GHz", "5.3GHz", "5.1GHz", "4.8GHz", "4.3GHz","4.3GHz"};
    private final int [] itdp= {125,125,125,65,125,125,125,65,65};
    private final double[] icpufps={87,68,53,42,74,62,57,41,0};
    private final double[] irank = new double[]{5,4,3,3,4,3,2,2,1};
    private final String[] iphotoid = new String[]{"cpupics/11 i9.jpg","cpupics/11 i7.jpg","cpupics/11 i5.jpg","cpupics/11 i5.jpg","cpupics/10 i9.jpg","cpupics/10 i7.jpg","cpupics/10 i5.jpg","cpupics/10 i5.jpg","cpupics/10 i3.jpg"};
    //Mobo Fields
    public Tab mobotab;
    public Button btnmobonext;
    public Button btnmoboback;
    public ImageView moboimage;
    public Label lblmobosocket;
    public Label lblmoborank;
    public Label lblmoboname;
    public Label lblmobomanu;
    public Label lblmoboprice;
    public Label lblcompatcpu;
    public Button btnaddmobo;
    public ListView<Mobo> MoboView= new ListView<>(); //this is the list view that will display the motherboards
    //these are the AMD compatible motherboard's parameters
    private final double[] Amoboprice = new double[]{999.00,400.00,500.00,210.00,254.99,91.47};
    private final String[] Amoboname = new String[]{"AsRock X570 Aqua","Asus ROG X570 Crosshair Dark Hero","MSI prestige x570 creation","Asus ROG Strix B550-f Gaming Wifi","MSI MAG B550 Tomahawk","Gigabyte B450M DS3H"};
    private final String[] Amobomanu = new String[]{"AsRock","Asus","MSI","Asus","MSI","Gigabyte"};
    private final double[] Amoborank = new double[]{5,4,4,3,2,1};
    private final String[] Amobophotoid= new String[]{"mobopics/Aqua.png","mobopics/Hero.png","mobopics/Creation.png","mobopics/Wifi.png","mobopics/tmhwk.png","mobopics/DS3H.png"};
    //these are the Intel compatible motherboard's parameters
    private final double[] imoboprice = new double[]{1120.00,649.00,429.00,324.00,449.00,174.00};
    private final String[] imoboname = new String[]{"Asus ROG Maximus XII Extreme Glacial","AsRock Z590 Taichi","EVGA Z590 FTW Wifi","MSI MPG Z590 Gaming Carbon Wifi","BioStar Z590 Valkyrie","AsRock Z590 Phatom Gaming 4/ac"};
    private final String[] imobomanu = new String[]{"Asus","AsRock","EVGA","MSI","BioStar","Asus"};
    private final double[] imoborank = new double[]{5,4,3,3,2,1};
    private final String[] imobophotoid= new String[]{"mobopics/glacial.png","mobopics/taichi.png","mobopics/ftw.png","mobopics/carbon.png","mobopics/valkyrie.png","mobopics/phatom.png"};
    //Ram Fields
    public Tab ramtab;
    public Button btnramnext;
    public Button btnramback;
    public ImageView ramimage;
    public Label lblramname;
    public Label lblrammanu;
    public Button btn8gbram;
    public Button btn16gbram;
    public Button btnram32gb;
    public Button btnramx2;
    public Button btnramx4;
    public Label lblramspeed;
    public Label lblramlat;
    public Label lblramrank;
    public Label lblramprice;
    public Button btnaddram;
    public Label lblramtype;
    public ListView <Ram>RamView = new ListView<>(); //this will display the ram
    //the fields below are the parameter for ram
    private final double[] ramprice ={207.99,205.89,159.95,157.76,120.89,110.00,80.69,59.99};
    private final String[] ramname ={"Crucial Ballistix MAX","G.Skill Trident Z RGB","G.Skill Trident Z Neo","Crucial Ballistix RGB","Corsair Vengeance RGB Pro","HyperX Fury","Corsair Vengeance LPX","Crucial RAM"};
    private final String[] rammanu = {"Crucial","G.Skill","G.Skill","Crucial","Corsair","HyperX","Corsair","Crucial"};
    private final String[] ramspeed = {"5100Mhz","3600Mhz","3800Mhz","3200Mhz","3200Mhz","2133Mhz","2400Mhz","2666Mhz"};
    private final String[] ramlatency={"Cl 19","Cl 18","Cl 14","Cl 16","Cl16","Cl 14","Cl 16","Cl 19"};
    private final double[]ramrank={5,4,5,3,3,2,2,1};
    private final String[] ramphotoid = {"rampics/Max.png","rampics/Rgb.png","rampics/Neo.png","rampics/White.png","rampics/Pro.png","rampics/Fury.png","rampics/Lpx.png","rampics/Ram.png"};
    //GPU Fields
    public Tab gputab;
    public Button btnGpunext;
    public Button btnGpuback;
    public ImageView gpuimage;
    public Label lblgpuname;
    public Label lblgpumanu;
    public Label lblgpumaxspeed;
    public Label lblgpufans;
    public Label lblgpuvram;
    public Label lblgpurank;
    public Label lblgpuprice;
    public Button btnaddgpu;
    public Label lblgpucores;
    public Label lblgputdp;
    public ListView <Gpu>Nvidiagpuview= new ListView<>(); //this displays the Nvidia gpus
    //these are the Nvidia gpu parameters
    private final double[] ngpuprice={2049.99,1599.00,1029.99,799.99,679.99,549.99,539.99};
    private final String[] ngpuname={"GeForce RTX 3090","GeForce RTX 3080Ti","GeForce RTX 3080","GeForce RTX 3070Ti","GeForce RTX 3070","GeForce RTX 3060Ti","GeForce RTX 3060"};
    private final String[] ngpucores={"10,496 Cuda Cores","10,240 Cuda Cores","8,704 Cuda Cores","6,144 Cuda Cores","5,888 Cuda Cores","4,864 Cuda Cores","3,584 Cuda Cores",};
    private final String[] ngpumaxspeed={"1.70GHz","1.67GHz","1.67GHz","1.77GHz","1.73GHz","1.67GHz","1.77GHz",};
    private final int[] ngputdp={450,350,320,290,220,200,170};
    private final String[] nfans={"1 fan both sides","1 fan both sides","1 fan both sides","1 fan both sides","2 fans 1 side","2 fans 1 side","2 fans 1 side"};
    private final String[] nvram={"GDDR6X 24GB","GDDR6X 12GB","GDDR6X 12GB","GDDR6X 8GB","GDDR6 8GB","GDDR6 8GB","GDDR6 12GB"};
    private final int[] ngpufps={307,303,263,216,205,172,125};
    private final double[] nrank={5,4,4,3,3,2,1};
    private final String[] nphotoid={"gpupics/3090.png","gpupics/3080ti.jpg","gpupics/3080.png","gpupics/3070ti.png","gpupics/3070.png","gpupics/3060ti.png","gpupics/3060.png",};
    public ListView <Gpu>AMDgpuview = new ListView<>(); //this displays the AMD gpus
    //these are the AMD gpu parameters
    private final double[] agpuprice={2174.99,1481.99,1171.99,999.99};
    private final String[] agpuname={"Radeon RX6900XT","Radeon RX6800XT","Radeon RX6800","Radeon RX6700XT"};
    private final String[] agpuscores={"5,120 Stream Processors","4,608 Stream Processors","3,840 Stream Processors","2,560 Stream Processors"};
    private final String[] agpumaxspeed={"2.25GHz","2.25GHz","2.11GHz","2.58GHz"};
    private final int[] agputdp={300,300,250,230};
    private final String[] afans={"3 fans 1 side","3 fans 1 side","3 fans 1 side","2 fans 1 side",};
    private final String[] avram={"GDDR6 16 16GB","GDDR6 16 16GB","GDDR6 16 16GB","GDDR6 12 16GB",};
    private final int[] agpufps={338,293,236,190};
    private final double[] arank={5,4,3,2};
    private final String[] aphotoid={"gpupics/6900xt.png","gpupics/6800xt.png","gpupics/6800.png","gpupics/6700xt.png"};
    //Storage Fields
    public Tab ssdtab;
    public Button btnssdnext;
    public Button btnssdback;
    public Label lblstoragename;
    public Label lblstoragemanu;
    public Button btn500gbstrge;
    public Button btn1tbstrge;
    public Button btn2tbstrge;
    public Label lblstorageread;
    public Label lblstoragewrite;
    public Label lblstoragedram;
    public Label lblstoragerank;
    public Label lblstorageprice;
    public Button btnaddstrge;
    public ImageView storageimage;
    public ListView<Storage> StorageView = new ListView<>();//displays all the storage
    //these are the storage parameters
    private final double[] storageprice={149.79,119.99,126.89,94.99,74.99,84.99,79.99,75.99,32.99};
    private final String[] storagename={"Samsung 980 Pro","Sabrent Rocket 4 Plus","WD Black SN 850","Samsung 970 Evo Plus","SK Hynix Gold P31","Samsung 870 Evo","WD Blue SN 550","Crucial MX 500","Seagate Barracuda HDD"};
    private final String[] storagemanu={"Samsung","Sabrent","Western Digital","Samsung","SK Hynix","Samsung","Western Digital","Crucial","Seagate"};
    private final String[] storageread={"7,000MBps","7,200MBps","7,000MBps","3,500MBps","3,500MBps","560MBps","2,400MBps","560MBps","540MBps"};
    private final String[] storagewrite={"5,000MBps","6,900MBps","5,300MBps","3,200MBps","3,200MBps","530MBps","1,750MBps","510MBps","520MBps"};
    private final String[] storagetype={"NVMe 1.3c SSD","MVMe 1.4 SSD","NVMe 1.4 SSD","NVMe 1.3 SSD","NVMe 1.3 SSD","SATA SSD","NVMe 1.3 SSD","SATA SSD","SATA HDD"};
    private final String[] storagedram={"Yes","Yes","Yes","Yes","Yes","Yes","No","No","Yes"};
    private final double[] storagerank={5,5,4,3,3,3,2,2,1};
    private final String[] storagephotoid={"storagepics/980.png","storagepics/Rocket.png","storagepics/850.png","storagepics/970.png","storagepics/31.png","storagepics/870.png","storagepics/550.png","storagepics/500.png","storagepics/cuda.jpg"};
    public Label lblstoragetype;
    //PSU Fields
    public Tab psutab;
    public Button btnpsunext;
    public Button btnPsuback;
    public ImageView psuimage;
    public Label lblpsuname;
    public Label lblpsumanu;
    public Label lblpsuwat;
    public Label lblpsurank;
    public Label lblpsuprice;
    public Button btnaddpsu;
    public Label lblpsurequiredwat;
    public ImageView psuratingimage;
    public Label lblpsuratingtxt;
    public ListView <Psu> PsuView = new ListView<>();// displays all the Psu
    //the code below is the parameters that will be loaded in to the listview
    private final double[] psuprice={587.36,399.99,521.99,205.79,179.99,169.99,153.99,104.99,103.67,49.99};
    private final String[] psuname={"BE Quiet Dark Power Pro 12","Seasonic Prime TX-1000","Asus Rog Thor 1200","NZXT e850","Seasonic Focus GX-850","Corsair RM 750X","EVGA Supernova 650 G3","Corsair CX 550m","EVGA 550B5","Thermaltake Smart BX1 430"};
    private final String[] psumanu={"BE Quiet","Seasonic","Asus","NZXT","Seasonic","Corsair","EVGA","Corsair","EVGA","Thermaltake"};
    private final int[] psuwattage={1500,1000,1200,850,850,750,650,550,550,430};
    private final String[] psurating={"ratingpics/titanium.png","ratingpics/titanium.png","ratingpics/plat.png","ratingpics/gold.png","ratingpics/gold.png","ratingpics/gold.png","ratingpics/gold.png","ratingpics/bronze.png","ratingpics/bronze.png","ratingpics/white.png"};
    private final String[] psuratingtxt={"80 plus titanium","80 plus titanium","80 plus platinum","80 plus gold","80 plus gold","80 plus gold","80 plus gold","80 plus bronze","80 plus bronze","80 plus white"};
    private final double[] psurank= {5,4,4,3,3,3,2,2,2,1};
    private final String[] psuphotoid={"psupics/pro.png","psupics/prime.jpg","psupics/thor.png","psupics/e850.png","psupics/focus.png","psupics/rm.png","psupics/nova.png","psupics/cx.png","psupics/b5.png","psupics/smart.jpg"};
    //Case Fields
    public Tab casetab;
    public Button btncasenext;
    public Button btncaseback;
    public Label lblcasename;
    public Label lblcasemanu;
    public Label lblcaseprice;
    public Button btnaddcase;
    public ImageView caseimage;
    public ListView<Case>CaseView;//diplays all the Cases
    //Case parameters
    private final double[] caseprice = {209.99,199.99,209.99,109.99,99.99,149.99,129.99,159.99,79.99};
    private final String[] casename={"Lian Li O11 Dynamic","Phanteks Eclipse P500A Digital","Corsair Obsidian 500D Airflow","Phanteks P400A Digital","Phantek P300A Digital","Lian Li Lancool 2 Mesh","NZXT H510","Fractal Design Meshify C","Corsair 275R"};
    private final String[] casemanu={"Lian Li","Phanteks","Corsair","Phanteks","Phanteks","Lian Li","NZXT","Fractal","Cosair"};
    private final String[] casephotoid={"casepics/1.jpg","casepics/2.jpg","casepics/3.jpg","casepics/4.jpg","casepics/5.jpg","casepics/6.jpg","casepics/7.jpg","casepics/8.jpg","casepics/9.jpg"};
    //End Fields
    public Tab endtab;
    public Label lbltotal;
    public Button btnremove;
    public Button btnsave;
    public Button btnload;
    public TextField txtbuildfilename;
    public ListView<Computer> ComputerView = new ListView<>(); //this will display all the components the user added
    public Label lbloverallscore;
    public Label lblfps$;
    public Label lblgamerating;
    public Label lbldesktoprating;
    public Label lblworkrating;
    public ImageView pubgimage;
    public ImageView valimage;
    public ImageView fortimage;
    public ImageView gtaimage;
    public ImageView csimage;
    public Label lblpubgfps;
    public Label lblvalfps;
    public Label lblfortfps;
    public Label lblgtafps;
    public Label lblcsfps;
    public int finaltabvistcounter=0; //this will record the number of times the user has visited the end tab
    public ImageView homeimage;
    public int requiredwattage;

    public  Computer computer = new Computer(null,null,null,null,null,null,null);

//Home
    public void onhome(Event event) {//when the program detects that the home tab has been selected then home image will be loaded up

    homeimage.setImage(new Image(getClass().getResource("view/wireframe.jpg").toExternalForm())); //this sets the imageview to the home image

}

//Next
    //the methods below will take care of the next buttons on the tabs
    //Home
    public void homeNext(ActionEvent actionEvent) { // when the next button on the home tab is pressed the following code will execute
        tbdpMain.getSelectionModel().select(Cputab); //the tab pane will switch to the cpu tab
        Cputab.setDisable(false);//the cpu tab will be enabled
        homtab.setDisable(true);//the home tab will be disabled
        for(int i=0; i< Aprocessor.length;i++){//this loop will loop through indexes of the amd cpu arrays
            //the code below creates a new cpu by getting the parameters from each index of the amd cpu arrays
            CPU cpu= new CPU(Aprice[i],Aprocessor[i],"AMD",Acores[i],Athreads[i],Aspeed[i],AmaxSpeed[i],Atdp[i],"AM4",Acpufps[i],Arank[i],Aphotoid[i]);
            AMDCpuView.getItems().add(cpu); // this adds the new cpu to the amd listview for display
        }
        for(int i=0; i< iprocessor.length;i++){//this loop through the indexes of the intel cpu arrays
            //the code below creates a new cpu by getting the parameters from each index of the intel cpu arrays
            CPU cpu= new CPU(iprice[i],iprocessor[i],"Intel",icores[i],ithreads[i],ispeed[i],imaxSpeed[i],itdp[i], "LGA 1200",icpufps[i], irank[i],iphotoid[i]);
            IntelCpuView.getItems().add(cpu);// this adds the cpu to the intel listview for display
        }
    }
    //CPU
    public void Cpunext(ActionEvent actionEvent) {//when the next button on the CPU tab is pressed then following code will execute
        tbdpMain.getSelectionModel().select(mobotab); //this switches the tab pane to the the mobo tab
        Cputab.setDisable(true); //the cpu tab will be disabled
        mobotab.setDisable(false);// the mobo tab will be enabled
        if(computer.getCpu().getManufacturer().contains("AMD")){ // this if statement detects whether the user chose an amd cpu or a intel cpu and loads the proper motherboard for the cpu

            // if an amd cpu is chosen then the following code will run
            for(int i=0; i<Amoboname.length;i++){  // this for loop will loop through the indexes of the amd motherboards arrays
                // the code below creates a new mobo by getting the information on the amd mobo arrays at the current index and setting them as the parameter of the mobo object
                Mobo mobo = new Mobo(Amoboprice[i],Amoboname[i],Amobomanu[i],"AM4",Amoborank[i],Amobophotoid[i]);
                MoboView.getItems().add(mobo);// this adds the motherboard to the listview to show
                lblcompatcpu.setText("AMD processor");// this sets the compatible cpu label to amd

            }
        }else{ // if an intel cpu is chosen then the following code will run

            for(int i=0; i<Amoboname.length;i++){// this for loop will loop through the indexes of the intel motherboards arrays
                // the code below creates a new mobo by getting the information on the intel mobo arrays at the current index and setting them as the parameter of the mobo object
                Mobo mobo = new Mobo(imoboprice[i],imoboname[i],imobomanu[i],"LGA 1200",imoborank[i],imobophotoid[i]);
                MoboView.getItems().add(mobo);// this adds the motherboard to the listview show
                lblcompatcpu.setText("Intel processor"); // this sets the compatible cpu to intel
            }
        }
    }
    //Mobo
    public void mobonext(ActionEvent actionEvent) { //when the next button on the motherboard is pressed the following code will execute
        tbdpMain.getSelectionModel().select(ramtab);// the tab pane will switch to the ramtab
        mobotab.setDisable(true); // the motherboard tab will be disabled
        ramtab.setDisable(false); // the ram tab will be enabled
        for(int i= 0; i< ramprice.length;i++){ // this for loop will load all the ram to the the ram listview
            Ram ram = new Ram(ramprice[i],ramname[i],rammanu[i],"0",1,ramspeed[i],ramlatency[i],"DDR4",ramrank[i],ramphotoid[i]);
            RamView.getItems().add(ram);
        }

    }
    //Ram
    public void ramnext(ActionEvent actionEvent) { // when the next button on the ram tab is pressed then the following code will run
        tbdpMain.getSelectionModel().select(gputab); // the tab would be switched to the gpu tab
        ramtab.setDisable(true);// ram tab disabled
        gputab.setDisable(false);// gpu tab enabled
        for(int i=0; i< ngpuname.length;i++){ // this for loop loads the nvidia gpus to the Nvidiagpulistview
            Gpu gpu= new Gpu(ngpuprice[i],ngpuname[i],"Nvidia",ngpucores[i],ngpumaxspeed[i],ngputdp[i],nfans[i],nvram[i],ngpufps[i],nrank[i],nphotoid[i]);
            Nvidiagpuview.getItems().add(gpu);
        }
        for(int i=0; i< agpuname.length;i++){// this for loop loads the amd gpu to the amdgpulistview
            Gpu gpu= new Gpu(agpuprice[i],agpuname[i],"AMD",agpuscores[i],agpumaxspeed[i],agputdp[i],afans[i],avram[i],agpufps[i],arank[i],aphotoid[i]);
            AMDgpuview.getItems().add(gpu);
        }
    }
    //Gpu
    public void gpunext(ActionEvent actionEvent) {// when the next button on the gpu tab is pressed the following will execute
        tbdpMain.getSelectionModel().select(ssdtab);// the tab would be switched to the storage tab (ssdtab for short)
        gputab.setDisable(true);// the gpu tab would be disabled
        ssdtab.setDisable(false);// the ssd tab would be enabled
        for(int i=0; i<storagename.length;i++){// this loads all the storage to the storage listview
            Storage storage = new Storage(storageprice[i],storagename[i],storagemanu[i],"0",storageread[i],storagewrite[i],storagetype[i],storagedram[i],storagerank[i],storagephotoid[i]);
            StorageView.getItems().add(storage);
        }
    }
    //Storage
    public void ssdnext(ActionEvent actionEvent) { //when the next button on the storage tab is pressed then following will execute
        tbdpMain.getSelectionModel().select(psutab); // the tab would be set to the psutab
        ssdtab.setDisable(true); // the storage tab would be disabled
        psutab.setDisable(false);// the psu tab would be enabled
        for(int i=0;i< psuname.length;i++){// this loads all the psu to the psu listview
            Psu psu= new Psu(psuprice[i],psuname[i],psumanu[i],psuwattage[i],psurating[i],psuratingtxt[i], psurank[i],psuphotoid[i]);
            PsuView.getItems().add(psu);
        }
        /* the code below calculates the required wattage of the system by adding the tdp of the cpu and the gpu and on top of that another 150
         */
        requiredwattage=computer.getCpu().getTDP()+computer.getGpu().getTDP()+150;

       lblpsurequiredwat.setText(requiredwattage+"W");// this sets the required wattage of label on the psu tab as the requiredwattage
    }
    //Psu
    public void psunext(ActionEvent actionEvent) {// when the next button on the psu is pressed the following code will execute
        tbdpMain.getSelectionModel().select(casetab); // the tab would be switched to case tab
        psutab.setDisable(true);// the psu tab would be disabled
        casetab.setDisable(false);// the case tab is enabled
        for(int i=0; i< casename.length;i++){ // this loads up all the cases and displays them in listview
            Case Case= new Case(caseprice[i],casename[i],casemanu[i],casephotoid[i]);
            CaseView.getItems().add(Case);
        }
    }
    //Case
    public void casenext(ActionEvent actionEvent) { // when the next button on the case tab is pressed then the following code will execute
        tbdpMain.getSelectionModel().select(endtab); // the tab would be set to the end tab
        casetab.setDisable(true);// the case tab will be disabled
        endtab.setDisable(false);// the end tab would be enabled

        // the code below sets the total that the whole build costs by adding all the prices of the components together
        lbltotal.setText("$"+ doubleformatter(computer.getCpu().getPrice()+computer.getMobo().getPrice()+computer.getRam().getPrice()+computer.getGpu().getPrice()+computer.getStorage().getPrice()+computer.getPsu().getPrice()+computer.getCase().getPrice()));
        performanceinfo(); // this updates the performance info of the system that the user just built
    }


 //Specs
    //CPU
    public void AMDcpuspecs(MouseEvent mouseEvent) throws IOException { // when the items on the amd cpu view are selected the following code will execute
         CPU cpu; //this calls for the cpu object
         cpu=AMDCpuView.getSelectionModel().getSelectedItem(); // the cpu is then set to the the selected cpu in listview
         btncpuadd.setDisable(false); // the add button would be enabled so the user could buy the item
        /*the code below creates a new image object using the photo that the cpu photoid points to and set the imageview as that photo */
        cpuimage.setImage(new Image(getClass().getResource(cpu.getPhotoid()).toExternalForm()));
        lblprice.setText("$"+cpu.getPrice()); //this gets the price of the cpu and sets it to the cpu price label
         lblcpuname.setText(cpu.getProcessorname());// this sets the cpu name
         lblmanu.setText(cpu.getManufacturer());//this sets the cpu manufacturer
         lblcpucores.setText(Double.toString(cpu.getCores()));//this sets the number cores of the cpu
         lblcputhreads.setText(Double.toString(cpu.getThreads()));//this sets the number of threads of the cpu
         lblcpuspeed.setText(cpu.getSpeed());//this sets the speed
         lblcpuboost.setText(cpu.getMaxspeed());//sets the max speed
         lblcputdp.setText(cpu.getTDP()+"W");//sets the thermal design power
         lblcpusocket.setText(cpu.getType());//sets the socket type
         lblcpurank.setText(ranker(cpu.getRank()));//this set the rank by getting the rank of the cpu and putting it through the ranker to get a rank in text and then setting it
     }
     public void IntelCpuSpecs(MouseEvent mouseEvent) { //when the items on the intel cpu view are selected the following code will execute
        //the code is the same as the amdcpuspecs except this is for the intel cpus
            CPU cpu;
            cpu= IntelCpuView.getSelectionModel().getSelectedItem();
            btncpuadd.setDisable(false);
            cpuimage.setImage(new Image(getClass().getResource(cpu.getPhotoid()).toExternalForm()));
            lblprice.setText("$"+cpu.getPrice());
            lblcpuname.setText(cpu.getProcessorname());
            lblmanu.setText(cpu.getManufacturer());
            lblcpucores.setText(Double.toString(cpu.getCores()));
            lblcputhreads.setText(Double.toString(cpu.getThreads()));
            lblcpuspeed.setText(cpu.getSpeed());
            lblcpuboost.setText(cpu.getMaxspeed());
            lblcputdp.setText(cpu.getTDP()+"W");
            lblcpusocket.setText(cpu.getType());
            lblcpurank.setText(ranker(cpu.getRank()));
        }
    //Mobo
    public void MoboSpecs(MouseEvent mouseEvent) { //when the items on the motherboard specs are selected the following code will run
        Mobo mobo;
        mobo = MoboView.getSelectionModel().getSelectedItem(); //this sets the mobo as the mobo selected from listview
        btnaddmobo.setDisable(false);//the add mobo button would be disabled so the user could add the mobo
        moboimage.setImage(new Image(getClass().getResource(mobo.getPhotoid()).toExternalForm())); //the mobo image is set here
        lblmoboprice.setText("$"+mobo.getPrice());//the motherboard price is displayed
        lblmoboname.setText(mobo.getName());//the name of the mobo is set here
        lblmobomanu.setText(mobo.getManu());//this sets the manufacturer of the motherboard
        lblmobosocket.setText(mobo.getType());//this sets the socket of the motherboard
        lblmoborank.setText(ranker(mobo.getRank()));//this gets the rank, puts it through ranker and sets it to the label motherboard rank
    }
    //Ram
    public void RamSpecs(MouseEvent mouseEvent) {
        Ram ram;
        ram=RamView.getSelectionModel().getSelectedItem(); // the sets the ram as the ram selected from listview
        //the ram capacity button would be enabled for the user to choose
        btn8gbram.setDisable(false);
        btn16gbram.setDisable(false);
        btnram32gb.setDisable(false);
        ramimage.setImage(new Image(getClass().getResource(ram.getPhotoid()).toExternalForm()));//this sets the mobo image
        lblramprice.setText("$"+ram.getPrice());//this sets the price of the cpu
        lblramname.setText(ram.getName());// sets the name
        lblrammanu.setText(ram.getManu());//sets the manufacturer
        lblramspeed.setText(ram.getSpeed());//sets the speed
        lblramlat.setText(ram.getLatency());//sets the latency
        lblramtype.setText(ram.getType());//sets the type
        lblramrank.setText(ranker(ram.getRank()));// sets the rank
    }
    public void ram8gboptn(ActionEvent actionEvent) {//when the user presses the 8 gb option for ram the following code will run
        // all the ram capacity options would be disabled
        btn8gbram.setDisable(true);
        btn16gbram.setDisable(true);
        btnram32gb.setDisable(true);
        // the amount of ram stick button would be enabled
        btnramx2.setDisable(false);
        btnramx4.setDisable(false);
        Ram ram;
        ram=RamView.getSelectionModel().getSelectedItem(); // this sets the ram as the ram selected in listview
        ram.setCapacity("8GB");//the capacity of the ram would be set to 8gb
    }
    public void ram16gboptn(ActionEvent actionEvent) {// when the user presses the 16 gb option for ram the following code will execute

        double tempramprice;//this double will be temporarily used to store the updated price of the ram
        //all the ram capacity options would be disabled
        btn8gbram.setDisable(true);
        btn16gbram.setDisable(true);
        btnram32gb.setDisable(true);
        // the amount of ram sticks button would be enabled
        btnramx2.setDisable(false);
        btnramx4.setDisable(false);
        Ram ram;
        ram=RamView.getSelectionModel().getSelectedItem();//this sets the ram as the ram selected in listview
        tempramprice=ram.getPrice()+100; //the tempramprice as the ram price plus 100
        lblramprice.setText(Double.toString(tempramprice));//this updates the price of the label
        ram.setPrice(tempramprice);//updates the price of the object ram
        ram.setCapacity("16GB"); //this set the ram's capacity as 16gb
    }
    public void ram32gb(ActionEvent actionEvent) {//when the user presses the 32 gb option for ram the following code will run
        //the code is the same as the 16gb option except the price and capacity difference
        double tempramprice;
        btn8gbram.setDisable(true);
        btn16gbram.setDisable(true);
        btnram32gb.setDisable(true);
        btnramx2.setDisable(false);
        btnramx4.setDisable(false);
        Ram ram;
        ram=RamView.getSelectionModel().getSelectedItem();
        tempramprice=ram.getPrice()+200;//the tempramprice is the ram price plus 200
        lblramprice.setText(Double.toString(tempramprice));//updates the ram price
        ram.setPrice(tempramprice);
        ram.setCapacity("32GB");//this sets the ram capacity as 32 gb
    }
    public void ram2sets(ActionEvent actionEvent) { //when the user chooses 2 sticks of ram the code below will run
        //the stick of ram buttons would be disabled
        btnramx2.setDisable(true);
        btnramx4.setDisable(true);
        //the add ram to the cart button would be enabled
        btnaddram.setDisable(false);
        Ram ram;
        ram=RamView.getSelectionModel().getSelectedItem();
        ram.setSticks(2);//the ram sticks would be set to 2
    }
    public void ram4sets(ActionEvent actionEvent) {//when the user chooses 4 sticks of ram the code below will run
        double tempramprice;
        btnramx2.setDisable(true);
        btnramx4.setDisable(true);
        btnaddram.setDisable(false);
        Ram ram;
        ram=RamView.getSelectionModel().getSelectedItem();
        tempramprice=Double.parseDouble(lblramprice.getText())*2;//the new price would be two times the original since there is 2 sets
        lblramprice.setText(Double.toString(tempramprice));//the prices would be updated
        ram.setPrice(Double.parseDouble(lblramprice.getText()));
        ram.setSticks(4);//the sticks of ram would be set as 2
    }
    //GPu
    public void Nvidiagpuspecs(MouseEvent mouseEvent) { //when the items on the nvidia gpu listview are selected the code below will run
        Gpu gpu;
        gpu= Nvidiagpuview.getSelectionModel().getSelectedItem(); //this set the gpu as the gpu selected
        btnaddgpu.setDisable(false); //the add button would be disabled
        gpuimage.setImage(new Image(getClass().getResource(gpu.getPhotoid()).toExternalForm()));//this sets the image
        lblgpuprice.setText("$"+gpu.getPrice());//sets the price
        lblgpuname.setText(gpu.getName());//sets the name
        lblgpumanu.setText(gpu.getManu());//sets the manufacturer
        lblgpucores.setText(gpu.getCores());//sets the cores
        lblgpumaxspeed.setText(gpu.getMaxspeed());//sets the maxspeed
        lblgputdp.setText(gpu.getTDP()+"W");//sets the tdp
        lblgpufans.setText(gpu.getFans());//sets the fan config
        lblgpuvram.setText(gpu.getVram());//sets the vram
        lblgpurank.setText(ranker(gpu.getRank()));//sets the rank

    }
    public void AMDgpuspecs(MouseEvent mouseEvent) {// when items on the amd gpu listview are selected then the code below will run
        //this the same as the nvidiaspecs except this displays the amd gpus
        Gpu gpu;
        gpu= AMDgpuview.getSelectionModel().getSelectedItem();
        btnaddgpu.setDisable(false);
        gpuimage.setImage(new Image(getClass().getResource(gpu.getPhotoid()).toExternalForm()));
        lblgpuprice.setText("$"+gpu.getPrice());
        lblgpuname.setText(gpu.getName());
        lblgpumanu.setText(gpu.getManu());
        lblgpucores.setText(gpu.getCores());
        lblgpumaxspeed.setText(gpu.getMaxspeed());
        lblgputdp.setText(gpu.getTDP()+"W");
        lblgpufans.setText(gpu.getFans());
        lblgpuvram.setText(gpu.getVram());
        lblgpurank.setText(ranker(gpu.getRank()));
    }
    //Storage
    public void StorageSpecs(MouseEvent mouseEvent) { // this displays the specs for the item selected in the storage listview
        Storage storage;
        storage= StorageView.getSelectionModel().getSelectedItem();// sets the storage as the storage selected
        // enables the storage size buttons
        btn500gbstrge.setDisable(false);
        btn1tbstrge.setDisable(false);
        btn2tbstrge.setDisable(false);

        storageimage.setImage(new Image(getClass().getResource(storage.getPhotoid()).toExternalForm())); // sets the image
        lblstorageprice.setText("$"+storage.getPrice()); // sets the price
        lblstoragename.setText(storage.getName());// sets the name
        lblstoragemanu.setText(storage.getManu());//sets the manufacturer
        lblstorageread.setText(storage.getRead());//sets the read speed
        lblstoragewrite.setText(storage.getWrite());//sets the write speed
        lblstoragetype.setText(storage.getType());//sets the type of storage
        lblstoragedram.setText(storage.getDram());//sets if dram is present or not
        lblstoragerank.setText(ranker(storage.getRank()));//sets the rank by putting the number into the ranker
    }
    public void storage500gb(ActionEvent actionEvent) { // if the 500gb option is selected the code below will run
        //disables all storage size selection buttons
        btn500gbstrge.setDisable(true);
        btn1tbstrge.setDisable(true);
        btn2tbstrge.setDisable(true);
        //enables add storage
        btnaddstrge.setDisable(false);
        Storage storage;
        storage= StorageView.getSelectionModel().getSelectedItem();
        storage.setCap("500GB");//set the storage capacity to 500GB
    }
    public void storage1tb(ActionEvent actionEvent) { // if the 1TB option is selected the code below will execute

        double tempstrgeprice; // creates the a double that stores price temporarily to make changes
        //disables all storage size buttons
        btn500gbstrge.setDisable(true);
        btn1tbstrge.setDisable(true);
        btn2tbstrge.setDisable(true);
        // enables the add storage button
        btnaddstrge.setDisable(false);
        Storage storage;
        storage= StorageView.getSelectionModel().getSelectedItem();
        tempstrgeprice= storage.getPrice()*2; // this gets the price of the storage selected and doubles it
        lblstorageprice.setText(Double.toString(tempstrgeprice)); // this updates the price for the storage
        storage.setPrice(tempstrgeprice); // sets the price for the storage to the new price
        storage.setCap("1TB");// sets the capacity to 1tb
    }
    public void storage2tb(ActionEvent actionEvent) { // this is the same as 1tb storage option except for the price and the size
        double tempstrgeprice;
        btn500gbstrge.setDisable(true);
        btn1tbstrge.setDisable(true);
        btn2tbstrge.setDisable(true);
        btnaddstrge.setDisable(false);
        Storage storage;
        storage= StorageView.getSelectionModel().getSelectedItem();
        tempstrgeprice= storage.getPrice()*4;// this quadruples the original price
        lblstorageprice.setText(Double.toString(tempstrgeprice));
        storage.setPrice(tempstrgeprice);
        storage.setCap("2TB");// sets the capacity to 2 tb
    }
    //Psu
    public void PsuSpecs(MouseEvent mouseEvent) { // this gets the psu specs for each psu
        Psu psu;
        psu= PsuView.getSelectionModel().getSelectedItem();
        int tempwat= psu.getWattage(); // this sets the wattage of the selected psu as tempwat
        if(requiredwattage>=tempwat){ // this if statement compares the required wattage by the system and the psu wattage
            lblpsuwat.setStyle("-fx-text-fill: red"); // if the required wattage is larger or equal to the psu wattage then the psu wattage number will turn red
            btnaddpsu.setDisable(true); // the program will not allow you to add the psu
        }else{ // if the required wattage is smaller thant the psu wattage then its safe
            lblpsuwat.setStyle("-fx-text-fill: black"); // the text for the wattage is black
            btnaddpsu.setDisable(false);// the button to add the psu is enabled
        }
        psuimage.setImage(new Image(getClass().getResource(psu.getPhotoid()).toExternalForm())); // this sets the photo for the psu
        lblpsuprice.setText("$"+psu.getPrice());//sets price
        lblpsuname.setText(psu.getName());//sets name
        lblpsumanu.setText(psu.getManu());//sets manufacturer
        lblpsuwat.setText(psu.getWattage()+"W");//sets wattage
        psuratingimage.setImage(new Image(getClass().getResource(psu.getRating()).toExternalForm()));// sets the rating image
        lblpsuratingtxt.setText(psu.getRatingtxt());// sets the rating text
        lblpsurank.setText(ranker(psu.getRank()));// sets the rank

    }
    //Case
    public void CaseSpecs(MouseEvent mouseEvent) { // this display the case's specs
        Case Case;
        Case= CaseView.getSelectionModel().getSelectedItem();
        btnaddcase.setDisable(false); // disables the add case button
        caseimage.setImage(new Image(getClass().getResource(Case.getPhotoid()).toExternalForm())); // displays the image of the case selected
        lblcaseprice.setText("$"+Case.getPrice());// displays the price of the case
        lblcasename.setText(Case.getName());//sets the name
        lblcasemanu.setText(Case.getManu());// sets the manufacturer
    }

//Add
    //CPU
    public void cpuaddtocart(ActionEvent actionEvent) { // the code below will run if the add cpu button is pressed

    if(lblmanu.getText().equals("AMD")) { // if the manufacturer is amd ...
        // the program will get the selected cpu from the amd listview and set the computer's cpu as that one
        computer.setCpu( AMDCpuView.getSelectionModel().getSelectedItem());
        // this adds the cpu to the overview computer view at the first index position
        ComputerView.getItems().add(0,computer.getCpu());
    }else{ // if the manufacturer of the cpu is intel
        // the program will get the selected cpu from the intel cpu listview and set the computer's cpu as that one
        computer.setCpu(IntelCpuView.getSelectionModel().getSelectedItem());
        // then it would add the cpu to computer listview at the first index position
        ComputerView.getItems().add(0,computer.getCpu());
    }
    // enables the next button
    btnCpunext.setDisable(false);
    // disables the listviews and the add button
    btncpuadd.setDisable(true);
    AMDCpuView.setDisable(true);
    IntelCpuView.setDisable(true);
   /*the code below will decide which tab to switch to based on the user's choice
    */
    if(finaltabvistcounter>0){ // if the finaltabvistcounter is greater than 0 ( meaning that you have already visted the final tab) then the code below will run
        if(computer.getMobo().getType().contains(computer.getCpu().getType())) { // if the cpu is still compatible with the motherboard
            tbdpMain.getSelectionModel().select(endtab); // then the code will direct back to the end tab

        }else{ // if it is not compatible
            MoboView.getItems().clear();
            tbdpMain.getSelectionModel().select(mobotab); // the mobo tab would be selected
            mobotab.setDisable(false);
            MoboView.setDisable(false);
            btnmobonext.setVisible(false);
            btnmoboback.setVisible(false);
            // the motherboard would be loaded in with the new brand of cpu choose and you would need to pick a new motherboard compatible with your cpu
            if(computer.getCpu().getManufacturer().contains("AMD")){
                for(int i = 0; i<Amoboname.length; i++){
                    Mobo mobo = new Mobo(Amoboprice[i],Amoboname[i],Amobomanu[i],"AM4",Amoborank[i],Amobophotoid[i]);
                    MoboView.getItems().add(mobo);
                    lblcompatcpu.setText("AMD processor");
                }
            }else{
                for(int i = 0; i<Amoboname.length; i++){
                    Mobo mobo = new Mobo(imoboprice[i],imoboname[i],imobomanu[i],"LGA 1200",imoborank[i],imobophotoid[i]);
                    MoboView.getItems().add(mobo);
                    lblcompatcpu.setText("Intel processor");
                }
            }
            ComputerView.getItems().remove(1); // this would remove the previous mobo
            Cputab.setDisable(true);
        }
    }

}
    //Mobo
    public void addmobo(ActionEvent actionEvent) { // this adds the mobo
        computer.setMobo( MoboView.getSelectionModel().getSelectedItem()); // sets the mobo of the computer to the mobo selected
        ComputerView.getItems().add(1,computer.getMobo()); // gets the mobo in the computer class and adds it to the computer listview
        btnaddmobo.setDisable(true); //add mobo button disabled
        btnmobonext.setDisable(false); // the next button is enabled on the mobo tab
        MoboView.setDisable(true); // disables the listview
        if(finaltabvistcounter>=1){ // if the final tab has already been visited then the program would immediately direct you there
            tbdpMain.getSelectionModel().select(endtab);
        }
    }
    //Ram
    public void addram(ActionEvent actionEvent) { // this methode adds the ram
        computer.setRam(RamView.getSelectionModel().getSelectedItem()); // set the computer ram as the ram selected
        ComputerView.getItems().add(2,computer.getRam()); // gets the computer's ram ( the ram you selected) and adds it to computer view
        btnaddram.setDisable(true); // disables the add ram button
        btnramnext.setDisable(false);// enables the next button
        RamView.setDisable(true); // disables the listview button
        if(finaltabvistcounter>=1){ // if the final tab has already been visited the user is back to change their selection. So after they are done they would be taken immediately back to the overview page
            tbdpMain.getSelectionModel().select(endtab); // selects the end tab
        }
    }
    //Gpu
    public void addgpu(ActionEvent actionEvent) { // adds the gpu
        if(lblgpumanu.getText().equals("AMD")) { // if the gpu manufacturer is amd then the program will take the amd listview and add it to the overview
            computer.setGpu(AMDgpuview.getSelectionModel().getSelectedItem());
            ComputerView.getItems().add(3,computer.getGpu());
        }else{ // if nvidia then it will take the nvidia gpu from the nvidia listview and add it to overview
            computer.setGpu(Nvidiagpuview.getSelectionModel().getSelectedItem());
            ComputerView.getItems().add(3,computer.getGpu());
        }
        //disables the listview
        AMDgpuview.setDisable(true);
        Nvidiagpuview.setDisable(true);
        //disables the add button
        btnaddgpu.setDisable(true);
        //enables next button
        btnGpunext.setDisable(false);
        if(finaltabvistcounter>=1){
            tbdpMain.getSelectionModel().select(endtab);
        }
    }
    //Storage
    public void addstorage(ActionEvent actionEvent) { // similar to mobo
        computer.setStorage(StorageView.getSelectionModel().getSelectedItem());
        ComputerView.getItems().add(4,computer.getStorage());
        StorageView.setDisable(true);
        btnaddstrge.setDisable(true);
        btnssdnext.setDisable(false);
        if(finaltabvistcounter>=1){
            tbdpMain.getSelectionModel().select(endtab);
        }
    }
    //Psu
    public void addpsu(ActionEvent actionEvent) { // similar to mobo
        computer.setPsu(PsuView.getSelectionModel().getSelectedItem());
        ComputerView.getItems().add(5,computer.getPsu());
        PsuView.setDisable(true);
        btnaddpsu.setDisable(true);
        btnpsunext.setDisable(false);
        if(finaltabvistcounter>=1){
            tbdpMain.getSelectionModel().select(endtab);
        }
    }
    //Case
    public void addcase(ActionEvent actionEvent) { // similar to mobo
        computer.setCase(CaseView.getSelectionModel().getSelectedItem());
        ComputerView.getItems().add(6,computer.getCase());
        CaseView.setDisable(true);
        btnaddcase.setDisable(true);
        btncasenext.setDisable(false);
        if(finaltabvistcounter>=1){
            tbdpMain.getSelectionModel().select(endtab);
        }
    }


 //Back
    //Cpu
    public void Cpuback(ActionEvent actionEvent) { // if the back button on the cpu tab is pressed the following code will commence
        tbdpMain.getSelectionModel().select(homtab); // takes you to the previous tab (home tab)
        AMDCpuView.getItems().clear(); // clears listviews
        IntelCpuView.getItems().clear();
        Cputab.setDisable(true); // disables the tab that the user is on
        homtab.setDisable(false); // enables the previous tab

    }
    //Mobo
    public void moboback(ActionEvent actionEvent) { // similar to cpu back
        tbdpMain.getSelectionModel().select(Cputab);
        mobotab.setDisable(true);
        Cputab.setDisable(false);
        MoboView.getItems().clear();
    }
    //Ram
    public void ramback(ActionEvent actionEvent) {// similar to cpu back
        tbdpMain.getSelectionModel().select(mobotab);
        ramtab.setDisable(true);
        mobotab.setDisable(false);
        RamView.getItems().clear();
    }
    //Gpu
    public void gpuback(ActionEvent actionEvent) {// similar to cpu back
        tbdpMain.getSelectionModel().select(ramtab);
        gputab.setDisable(true);
        ramtab.setDisable(false);
        AMDgpuview.getItems().clear();
        Nvidiagpuview.getItems().clear();
    }
    //Storage
    public void ssdback(ActionEvent actionEvent) {// similar to cpu back
        tbdpMain.getSelectionModel().select(gputab);
        ssdtab.setDisable(true);
        gputab.setDisable(false);
        StorageView.getItems().clear();
    }
    //Psu
    public void psuback(ActionEvent actionEvent) {// similar to cpu back
        tbdpMain.getSelectionModel().select(ssdtab);
        psutab.setDisable(true);
        ssdtab.setDisable(false);
        PsuView.getItems().clear();

    }
    //Case
    public void caseback(ActionEvent actionEvent) {// similar to cpu back
        tbdpMain.getSelectionModel().select(psutab);
        casetab.setDisable(true);
        psutab.setDisable(false);
        CaseView.getItems().clear();
    }

//Ranker
    static public String ranker(double rank){ //this is the ranker for the individual components
        // the ranker ranks the component by taking in a number from 1-5 (1 being the worst, 5 being the best) and then return the descriptor associated with it.
        if(rank==5){
            return "Top of the line"; // if it's a 5 it's the best
        }else if(rank==4){
            return "Xtreme";
        }else if(rank==3){
            return "High";
        }else if(rank==2){
            return "Mid Range";
        }else{
            return "Entry"; //if it's 1 it's entry level component
        }
    }
    static public String overranker(double rank){ // this ranker is for the ranking a whole pc, this one's is more specific on the rankings
        if(rank>=4.9){
            return "Top of the line";
        }else if(rank<4.9&&rank>=4.1){
            return "Xtreme";
        }else if(rank<4.1&&rank>=3.3){
            return "High";
        }else if(rank<3.3&&rank>2.2){
            return "Mid Range";
        }else{
            return "Entry";
        }
    }


//End tab
    public void viewallparts(MouseEvent mouseEvent) { }
    public void componentremove(ActionEvent actionEvent) { // when the user removed a component the following code will run
        int i;
        if (ComputerView.getSelectionModel().getSelectedIndex() == 0){ // if index of the item that was deleted was 0 then it must be cpu, so the code below will run
            IntelCpuView.getItems().clear(); // clears all the listviews
            AMDCpuView.getItems().clear();
            tbdpMain.getSelectionModel().select(Cputab);// selects cpu tab
            Cputab.setDisable(false); // enables the cpu tab
            AMDCpuView.setDisable(false); // enables the listviews
            IntelCpuView.setDisable(false);
            btnCpunext.setVisible(false); // enables the next button
            btnCpuback.setVisible(false);// enables the back button
            // the code below loads up all the cpus
            for(i = 0; i< Aprocessor.length; i++){
                CPU cpu= new CPU(Aprice[i],Aprocessor[i],"AMD",Acores[i],Athreads[i],Aspeed[i],AmaxSpeed[i],Atdp[i],"AM4",Acpufps[i], Arank[i],Aphotoid[i]);
                AMDCpuView.getItems().add(cpu);
            }
            for(i = 0; i< iprocessor.length; i++){
                CPU cpu= new CPU(iprice[i],iprocessor[i],"Intel",icores[i],ithreads[i],ispeed[i],imaxSpeed[i],itdp[i], "LGA 1200",icpufps[i], irank[i],iphotoid[i]);
                IntelCpuView.getItems().add(cpu);
            }
        }else if(ComputerView.getSelectionModel().getSelectedIndex()==1){ // user item at index 1 then it must be a mobo, the following code will run

            // this is similar to cpu view
            MoboView.getItems().clear();
            tbdpMain.getSelectionModel().select(mobotab);
            mobotab.setDisable(false);
            MoboView.setDisable(false);
            btnmobonext.setVisible(false);
            btnmoboback.setVisible(false);
            if(computer.getCpu().getManufacturer().contains("AMD")){
                for(i = 0; i<Amoboname.length; i++){
                    Mobo mobo = new Mobo(Amoboprice[i],Amoboname[i],Amobomanu[i],"AM4",Amoborank[i],Amobophotoid[i]);
                    MoboView.getItems().add(mobo);
                    lblcompatcpu.setText("AMD processor");
                }
            }else{
                for(i = 0; i<Amoboname.length; i++){
                    Mobo mobo = new Mobo(imoboprice[i],imoboname[i],imobomanu[i],"LGA 1200",imoborank[i],imobophotoid[i]);
                    MoboView.getItems().add(mobo);
                    lblcompatcpu.setText("Intel processor");
                }
            }
        }else if(ComputerView.getSelectionModel().getSelectedIndex()==2){ //this is similar to mobo except it's for ram
            RamView.getItems().clear();
            tbdpMain.getSelectionModel().select(ramtab);
            ramtab.setDisable(false);
            RamView.setDisable(false);
            btnramnext.setVisible(false);
            btnramback.setVisible(false);
            for(i = 0; i< ramprice.length; i++){
                Ram ram = new Ram(ramprice[i],ramname[i],rammanu[i],"0",1,ramspeed[i],ramlatency[i],"DDR4",ramrank[i],ramphotoid[i]);
                RamView.getItems().add(ram);
            }
        }else if(ComputerView.getSelectionModel().getSelectedIndex()==3){ //this is for gpu
            AMDgpuview.getItems().clear();
            Nvidiagpuview.getItems().clear();
            tbdpMain.getSelectionModel().select(gputab);
            gputab.setDisable(false);
            AMDgpuview.setDisable(false);
            Nvidiagpuview.setDisable(false);
            btnGpunext.setVisible(false);
            btnGpuback.setVisible(false);
            for(i = 0; i< ngpuname.length; i++){
                Gpu gpu= new Gpu(ngpuprice[i],ngpuname[i],"Nvidia",ngpucores[i],ngpumaxspeed[i],ngputdp[i],nfans[i],nvram[i],ngpufps[i],nrank[i],nphotoid[i]);
                Nvidiagpuview.getItems().add(gpu);
            }
            for(i = 0; i< agpuname.length; i++){
                Gpu gpu= new Gpu(agpuprice[i],agpuname[i],"AMD",agpuscores[i],agpumaxspeed[i],agputdp[i],afans[i],avram[i],agpufps[i],arank[i],aphotoid[i]);
                AMDgpuview.getItems().add(gpu);
            }
        }else if(ComputerView.getSelectionModel().getSelectedIndex()==4){ //this is for storage
            StorageView.getItems().clear();
            tbdpMain.getSelectionModel().select(ssdtab);
            ssdtab.setDisable(false);
            StorageView.setDisable(false);
            btnssdnext.setVisible(false);
            btnssdback.setVisible(false);

            for(i = 0; i<storagename.length; i++){
                Storage storage = new Storage(storageprice[i],storagename[i],storagemanu[i],"0",storageread[i],storagewrite[i],storagetype[i],storagedram[i],storagerank[i],storagephotoid[i]);
                StorageView.getItems().add(storage);
            }

        }else if(ComputerView.getSelectionModel().getSelectedIndex()==5){ //this is for psu
            PsuView.getItems().clear();
            tbdpMain.getSelectionModel().select(psutab);
            psutab.setDisable(false);
            PsuView.setDisable(false);
            btnpsunext.setVisible(false);
            btnPsuback.setVisible(false);
            lblpsurequiredwat.setText( computer.getCpu().getTDP()+computer.getGpu().getTDP()+150+"W");
            for(i = 0; i< psuname.length; i++){
                Psu psu= new Psu(psuprice[i],psuname[i],psumanu[i],psuwattage[i],psurating[i],psuratingtxt[i], psurank[i],psuphotoid[i]);
                PsuView.getItems().add(psu);
            }
        }else{ // this is for when case is deleted
            CaseView.getItems().clear();
            tbdpMain.getSelectionModel().select(casetab);
            casetab.setDisable(false);
            CaseView.setDisable(false);
            btncasenext.setVisible(false);
            btncaseback.setDisable(false);
            for(i = 0; i< casename.length; i++){
                Case Case= new Case(caseprice[i],casename[i],casemanu[i],casephotoid[i]);
                CaseView.getItems().add(Case);
            }
        }
        ComputerView.getItems().remove(ComputerView.getSelectionModel().getSelectedIndex());
    }
    public void savebuild(ActionEvent actionEvent) throws IOException { // when the save button is pressed this methode would run, and it would save the build
        btnsave.setDisable(true); //this button disables the save button to show that the computer has already saved the build
        btnload.setDisable(false); //it enables the load
        String filename = txtbuildfilename.getText();
        FileWriter fw = new FileWriter(filename,false); //this calls a file writer
        BufferedWriter bw = new BufferedWriter(fw); //this activates the buffered filewriter
        bw.write(""); //first, the program will clear the file so the new and updated version can be added on
        ObservableList<Computer> mybuild = ComputerView.getItems(); //this gets the items from the overview
        for(Computer c: mybuild){ //this loops through the computer overview
            c.writetofile(filename); //this uses the write to file methode in the computer class to write components along with the specs onto the designated file
        }
        ComputerView.getItems().clear(); //this clears the computerview notifying the user that the file has been saved
    }
    public void loadbuild(ActionEvent actionEvent) throws IOException { //this methode loads the components back onto the computer overview
        btnload.setDisable(true);
        btnsave.setDisable(false);

        double totalprice;


       ArrayList<Computer> computers=Load.loadBuild(txtbuildfilename.getText()); //this calls the load methode in the load class and assigns it to the arraylist computer

       ComputerView.getItems().clear(); //this clears the clear the computer overview to make sure nothing is on it
        int i=0;
        for (Computer c : computers) { //this loops through computer and gets all the loaded components and reassigns them to their classes
            ComputerView.getItems().add(c); //this adds the components from Computer class to the computer overview
            if(i==0) { //if the loop is going through the first time then it must be component cpu since it first. This if statement catches that and runs the code below
                computer.setCpu((CPU) c); //this code casts the computer component to a cpu and set the cpu as it.
            }else if(i==1){//if it is going through the second time it must be mobo, and the following code will run
                computer.setMobo((Mobo)c); //this casts the component as mobo and sets the mobo as it.
            }else if(i==2){ //this is the same as the previous
                computer.setRam((Ram)c);
            }else if(i==3){
                computer.setGpu((Gpu)c);
            }else if(i==4){
                computer.setStorage((Storage) c);
            }else if(i==5){
                computer.setPsu((Psu)c);
            }else{
                computer.setCase((Case)c);
            }
            i++;
        }
        performanceinfo(); //this then calls the for the performance info for that build
        computers.clear(); //this clears the arraylist computers so the next time it load it won't load the previous computer components
    }
    static public String doubleformatter(Double price){ //this methode formats the price so that the double won't go on forever

        DecimalFormat df = new DecimalFormat("#.##");

        return df.format(price);
    }
    public void onoverview(Event event) { //when the overview tab is visited...
        finaltabvistcounter++; //this adds the final tab counter
        boolean psudisable =true;

        if(finaltabvistcounter>1){ //if the final tab is visited twice, the second time that the user visits the components needs to be updated
            performanceinfo();
            requiredwattage=computer.getCpu().getTDP()+computer.getGpu().getTDP()+150;
            if(requiredwattage>=computer.getPsu().getWattage()){
                ComputerView.getItems().remove(6);
                psutab.setDisable(false);
                PsuView.setDisable(false);
                btnaddpsu.setDisable(false);
                tbdpMain.getSelectionModel().select(psutab);
                PsuView.getItems().clear();

                for(int i=0;i< psuname.length;i++){// this loads all the psu to the psu listview
                    Psu psu= new Psu(psuprice[i],psuname[i],psumanu[i],psuwattage[i],psurating[i],psuratingtxt[i], psurank[i],psuphotoid[i]);
                    PsuView.getItems().add(psu);
                }
                if(requiredwattage>=computer.getPsu().getWattage()){ // this if statement compares the required wattage by the system and the psu wattage
                    lblpsuwat.setStyle("-fx-text-fill: red"); // if the required wattage is larger or equal to the psu wattage then the psu wattage number will turn red
                    btnaddpsu.setDisable(true); // the program will not allow you to add the psu
                }else{ // if the required wattage is smaller thant the psu wattage then its safe
                    lblpsuwat.setStyle("-fx-text-fill: black"); // the text for the wattage is black
                    btnaddpsu.setDisable(false);// the button to add the psu is enabled
                }
                psudisable =false;
            }
        }

        pubgimage.setImage(new Image(getClass().getResource("games/pub.png").toExternalForm())); //this sets the images of the games
        valimage.setImage(new Image(getClass().getResource("games/val.png").toExternalForm()));
        fortimage.setImage(new Image(getClass().getResource("games/fort.png").toExternalForm()));
        gtaimage.setImage(new Image(getClass().getResource("games/gta.png").toExternalForm()));
        csimage.setImage(new Image(getClass().getResource("games/cs.png").toExternalForm()));
        //disables all the tabs

        Cputab.setDisable(true);
        mobotab.setDisable(true);
        ramtab.setDisable(true);
        gputab.setDisable(true);
        ssdtab.setDisable(true);
        if(psudisable==true ) {
            psutab.setDisable(true);
        }
        casetab.setDisable(true);


    }
    public void performanceinfo(){ //this calculates the computer's performance and price
        //the code below takes all the prices of the computer components, adds then together, put it through double formatter and assign that to price
        String price= doubleformatter(computer.getCpu().getPrice()+computer.getMobo().getPrice()+computer.getRam().getPrice()+computer.getGpu().getPrice()+computer.getStorage().getPrice()+computer.getPsu().getPrice()+computer.getCase().getPrice());
        //this code below takes all the rank numbers, adds then together, and assignment then to the overscore
        double overscore=computer.getCpu().getRank()+computer.getMobo().getRank()+computer.getRam().getRank()+computer.getGpu().getRank()+computer.getStorage().getRank()+computer.getPsu().getRank();
        double fps=computer.getCpu().getFps()+computer.getGpu().getFps(); //this gets the fps from cpu and gpu, adds them together, and assigns then to the double fps
        lbltotal.setText("$"+price); //this sets the total price as the string price

        lbloverallscore.setText(overranker((overscore)/6)+" "+ doubleformatter(overscore/30 * 100)+"%"); /*this sets the overall score. Overscore will be put through the overranker for a 'word'
        ranking beside it the overscore will be divded by 30 ( 30 being max) then times 100 to get the percentage */
        lblfps$.setText(doubleformatter((fps)/Double.parseDouble(price))+"fps/$"); //this gets the sets the fps/dollar of the machine by getting the total fps (cpu fps+gpu fps) and divides it by the total price.

        //the code below calculates the pc's performance in respective areas

        //for gaming the pc's cpu and gpu will be looked at and so their ranks would be gathered divided by 2 and put through the ranker for ranking. Also the cpu+gpu ranking out of 10 ( since the max ranking for the individual is 5) would be multiplied by 100 to get the percentage perforamce
        lblgamerating.setText(overranker((computer.getCpu().getRank()+computer.getGpu().getRank())/2)+" "+ doubleformatter((computer.getCpu().getRank()+computer.getGpu().getRank())/10*100)+"%");
        //for normal use the pc's cpu, ram and storage would be looked at, so the program would calculate the ranking of those components combined
        lbldesktoprating.setText(overranker((computer.getCpu().getRank()+computer.getRam().getRank()+computer.getStorage().getRank())/3)+" "+ doubleformatter(((computer.getCpu().getRank()+computer.getRam().getRank()+computer.getStorage().getRank())/15*100))+"%");
        // for workstation user the pc's cpu, motherboard, gpu, and ram would be looked at, so the program would calculate the ranking of those components combined
        lblworkrating.setText(overranker((computer.getCpu().getRank()+computer.getMobo().getRank()+computer.getGpu().getRank()+computer.getRam().getRank())/4)+" "+ doubleformatter((computer.getCpu().getRank()+computer.getMobo().getRank()+computer.getGpu().getRank()+computer.getRam().getRank())/20*100)+"%");
        String resolution; //this is for the resolution that is going to be recommended for the computer/ the resolution the games are going to run at
        if(computer.getGpu().getRank()<3){ //if the gpu's rank is below 3 then it is a mid-range to entry therefore it should run at a lower resolution
            resolution="max @1080p"; //the string resolution would be set to 1080p
            fps+=20; //since 1080p is a bit easier to run there would be about a 20 fps gain
        }else{ //if the gpu's ranking is greater than 2 then it should run at 1440p
            resolution="max @1440p";
        }
        //the code below sets the fps for each game. Some games are easier to run and other are not so the fps would be added on differently for each game
        lblpubgfps.setText(doubleformatter(fps+100)+" "+resolution);
        lblvalfps.setText(doubleformatter(fps+200)+" "+resolution);
        lblfortfps.setText(doubleformatter(fps+150)+" "+resolution);
        lblgtafps.setText(doubleformatter(fps+40)+" "+resolution);
        lblcsfps.setText(doubleformatter(fps+120)+" "+resolution);
    }
}
