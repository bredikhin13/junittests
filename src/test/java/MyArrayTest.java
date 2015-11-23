import MyApp.MyArray;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by User on 10.11.2015.
 */
public class MyArrayTest {
    MyArray instance, expected;
    int[] testArr;
    @Before
    public void setup(){
        testArr = new int[]{0,1,-2,3,43,55,61,-7,-999,19,-10,11,12,113,14};
    }
    @Test
    public void testAdd()
    {
        instance = new MyArray(10);
        for(int i = 0; i<testArr.length;i++){
            instance.add(testArr[i]);
        }
        for(int i = 0; i<testArr.length;i++){
            expected = new MyArray(testArr);
            assertEquals("Failed",expected,instance);

        }


    }
    @Test
    public void testGet(){
        instance = new MyArray(testArr);
        assertEquals(instance.get(0),0);
        assertEquals(instance.get(1),1);
        assertEquals(instance.get(2),-2);
        assertEquals(instance.get(3),3);

    }

    @Test
    public void testDelete(){
        instance = new MyArray(new int []{0,1,2,3,4,5});
        instance.delete(0);
        expected = new MyArray(new int[]{1,2,3,4,5});
        assertEquals("Fail 0",expected,instance);
        instance.delete(4);
        expected = new MyArray(new int[]{1,2,3,4});
        assertEquals("Fail 4",expected,instance);
        instance.delete(2);
        expected = new MyArray(new int[]{1,2,4});
        assertEquals("Fail 0",expected,instance);
    }

    @Test
    public void testSort(){
        instance = new MyArray(testArr);
        instance.sort();
        Arrays.sort(testArr);
        expected = new MyArray(testArr);
        assertEquals("Fail sort",expected,instance);
    }

    @Test
    public void testSet(){
        instance = new MyArray(new int[]{0,1,2,3,4,5});
        instance.set(0,99);
        expected = new MyArray(new int[]{99,1,2,3,4,5});
        assertEquals("Fail 0",expected,instance);
        instance.set(5,99);
        expected = new MyArray(new int[]{99,1,2,3,4,99});
        assertEquals("Fail 5",expected,instance);
        instance.set(2,99);
        expected = new MyArray(new int[]{99,1,99,3,4,99});
        assertEquals("Fail 2",expected,instance);
    }

    @Test
    public void testFindMin(){
        instance = new MyArray(testArr);
        assertEquals("Fail",-999,instance.findMin());
    }
}
