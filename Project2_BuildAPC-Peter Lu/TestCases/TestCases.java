import Computer.*;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class TestCases { //these are the test cases, it tests if teach of the return methode in the classes are working
    @Test
    public void testCpuToString(){ //this test the cpu to string
        //it creates the new cpu
        CPU cpu= new CPU(1234.34,"CPU1","Intel",9,21,"5GHz","100GHz",1000,"AM4",2000,5,"cpu photo");
        assertEquals("Intel CPU1 $1234.34",cpu.toString()); // and see if the to string return is what is expected
    }
    @Test
    public void testMoboToString(){ //this test the mobo to string
        // it creates a new mobo
        Mobo mobo= new Mobo(18319.28,"Mobotester","NZXT","AM4",4,"Mobo Photo");
        assertEquals("Mobotester $18319.28",mobo.toString());// and see if the to string return for mobo is what it supposed to be
    }
    @Test
    public void testRamToString(){ //this is the same for ram
        Ram ram = new Ram(1231.02,"RamTest","Crucial","8GB",2,"3600Mhz","CL19","DDR4",2,"Ramphoto");
        assertEquals("RamTest $1231.02",ram.toString());
    }
    @Test
    public void testGpuToString(){ // similar to mobo
        Gpu gpu= new Gpu(2090.98,"GTX 1660ti","Nvidia","12343 CUDA Cores","1.8GHz",4000,"2 on one side","4gb GDDR4",1000,4,"GPUphoto");
    assertEquals("Nvidia GTX 1660ti $2090.98",gpu.toString());
    }
    @Test
    public void testStorageToString(){ // similar to mobo
        Storage storage= new Storage(14132.01,"SSD2","Seagate","120GB","1234mbps","1431mbps","SSD","yes",1,"SSD photo");
        assertEquals("SSD2 $14132.01",storage.toString());
    }
    @Test
    public void testPsuToString(){ // similar to mobo
        Psu psu= new Psu(431.03,"Psu2","SeaSonic",1000,"rating pic","80 plus plat",4,"Psu photo");
        assertEquals("Psu2 2000W $431.03",psu.toString());
    }
    @Test
    public void testCaseToString(){ //similar to mobo
        Case Case = new Case(100.79,"CaseTest","NZXT","Casephoto");
        assertEquals("CaseTest $100.79",Case.toString());
    }
    @Test
    public void RankerTester(){ // this test the ranker
        assertEquals("Entry",Controller.ranker(1)); // it enters numbers 1-5 and see if the return string is what expected
        assertEquals("Mid Range",Controller.ranker(2));
        assertEquals("High",Controller.ranker(3));
        assertEquals("Xtreme",Controller.ranker(4));
        assertEquals("Top of the line",Controller.ranker(5));
    }
    @Test
    public void overRankerTester(){ // this is test for overall ranker
        assertEquals("Entry",Controller.overranker(1.9)); // it enters numbers with decimals from 1-5 and see the ranker return what's expected
        assertEquals("Mid Range",Controller.overranker(2.4));
        assertEquals("High",Controller.overranker(3.8));
        assertEquals("Xtreme",Controller.overranker(4.3));
        assertEquals("Top of the line",Controller.overranker(4.9));
    }
    @Test
    public void formatertester(){ // this test the formatter and see it formats the double correctly
        assertEquals("1923.12",Controller.doubleformatter(1923.12341324100102304001000030401002030040103));
    }
}
