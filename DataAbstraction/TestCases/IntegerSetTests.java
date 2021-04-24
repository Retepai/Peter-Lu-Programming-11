import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class IntegerSetTests {
    IntegerSet testSet;

    @Before
    public void setup(){
        testSet = new IntegerSet();
    }

    @Test
    public void testInsertNotThere(){
        //check number is not already in set
        assertEquals(0,testSet.size());
        assertFalse(testSet.contains(3));
        //insert a number
        testSet.insert(3);
        //check the number is in the set
        assertEquals(1,testSet.size());
        assertTrue(testSet.contains(3));
    }
    @Test
    public void testInsertAlreadyThere(){
        //insert a number
        testSet.insert(3);
        //check the number is in the set
        assertEquals(1,testSet.size());
        assertTrue(testSet.contains(3));
        //insert another number that is the same as the first one
        testSet.insert(3);
        //check that there is only one of that number in the integer set
        assertEquals(1,testSet.size());
    }
}