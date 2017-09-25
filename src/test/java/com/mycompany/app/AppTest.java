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

    public void SearchWordFound() {
      ArrayList<String> array = new ArrayList<>(Arrays.asList("Araba", "kalem", "bilgisayar", "silgi"));
      ArrayList<String> array2 = new ArrayList<>(Arrays.asList("bilgisayar"));
      assertTrue(new App().SearchWord(array, array2));
    }

    public void Array1Null() {
      ArrayList<String> array = new ArrayList<>(Arrays.asList());
      ArrayList<String> array2 = new ArrayList<>(Arrays.asList("bilgisayar"));
      assertFalse(new App().SearchWord(array, array2));
    }

    public void Array2Null() {
      ArrayList<String> array = new ArrayList<>(Arrays.asList("Araba", "kalem", "bilgisayar", "silgi"));
      ArrayList<String> array2 = new ArrayList<>(Arrays.asList());
      assertFalse(new App().SearchWord(array, array2));
    }

    public void Array1Empty() {
      ArrayList<String> array = new ArrayList<>(Arrays.asList(""));
      ArrayList<String> array2 = new ArrayList<>(Arrays.asList("bilgisayar"));
      assertFalse(new App().SearchWord(array, array2));
    }

    public void Array2Empty() {
      ArrayList<String> array = new ArrayList<>(Arrays.asList("Araba", "kalem", "bilgisayar", "silgi"));
      ArrayList<String> array2 = new ArrayList<>(Arrays.asList(""));
      assertFalse(new App().SearchWord(array, array2));
    }

    public void Array2SizeMoreThan1() {
      ArrayList<String> array = new ArrayList<>(Arrays.asList("Araba", "kalem", "bilgisayar", "silgi"));
      ArrayList<String> array2 = new ArrayList<>(Arrays.asList("bilgisayar", "kalem"));
      assertFalse(new App().SearchWord(array, array2));
    }

    public void SearchWordNotFound() {
      ArrayList<String> array = new ArrayList<>(Arrays.asList("Araba", "kalem", "bilgisayar", "silgi"));
      ArrayList<String> array2 = new ArrayList<>(Arrays.asList("cetvel"));
      assertFalse(new App().SearchWord(array, array2));
    }
}
