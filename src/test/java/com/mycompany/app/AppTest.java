package com.mycompany.app;

import java.util.ArrayList;
import java.util.Arrays;
import junit.framework.TestCase;
import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }


    public void testFound() {
        ArrayList<Integer> array = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        assertTrue(new App().search(array, 4));
    }

    public void testNotFound() {
        ArrayList<Integer> array = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        assertFalse(new App().search(array, 5));
    }

    public void testEmptyArray() {
        ArrayList<Integer> array = new ArrayList<>();
        assertFalse(new App().search(array, 1));
    }

    public void testNull() {
        assertFalse(new App().search(null, 1));
    }

    //New test methods for summation
    public void testSum(){
        ArrayList<Integer> array = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        ArrayList<Integer> array2 = new ArrayList<>(Arrays.asList(1, 2, 3, 4));

        ArrayList<Integer> sum = new ArrayList<>(Arrays.asList(2, 4, 6, 8));
        ArrayList<Integer> empty = new ArrayList<>();
        int a= 8;
        int b=0;

        new App().SumArrayLists(array,5, array2 ,3, empty,b);

        for(int i=0; i<array.size(); i++){

            assertEquals(sum.get(i), empty.get(i));
        }

        assertEquals(a,b);
    }

    public void testEmptyArrayForSummation(){
        ArrayList<Integer> array = new ArrayList<>();
        ArrayList<Integer> array2 = new ArrayList<>(Arrays.asList(1, 2, 3, 4));

        ArrayList<Integer> sum = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        ArrayList<Integer> empty = new ArrayList<>();

        int a= 8;
        int b=0;

        new App().SumArrayLists(array,5, array2 ,3, empty, b);

        for(int i=0; i<array.size(); i++){

            assertEquals(sum.get(i), empty.get(i));
        }

        assertEquals(a,b);
    }

    public void testNullForSummation()
    {
        
        assertFalse(new App().search(null, 1));

    }
    }

