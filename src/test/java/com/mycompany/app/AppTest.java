package com.mycompany.app;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import java.util.*;

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

    public void testNullMergeSort(){
      ArrayList<Integer> array = new ArrayList<>(Arrays.asList(1, 2, 3, null));
      assertFalse(new App().MergeSort(array, 0,3));
    }
    
    public void testEmptyArrayMergeSort(){
      ArrayList<Integer> array = new ArrayList<>();
      assertFalse(new App().MergeSort(array, 0,1));
    }

    public void testCompute(){
      ArrayList<Integer> array = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
      assertTrue(new App().MergeSort(array, 0,3));
    }

    public void testComputeNegativeNumbersMix(){
      ArrayList<Integer> array = new ArrayList<>(Arrays.asList(1, 2, -1, 4));
      assertTrue(new App().MergeSort(array, 0,3));
    }
}
