package fr.norsys.stringcalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClazzTest{
    private Clazz clazz = new Clazz();
    @Test
    public void should_return_0() throws Exception {
        assertEquals(0, clazz.add(""));
    }
    @Test
    public void should_return_2()throws Exception {
        assertEquals(2, clazz.add("2"));
    }
    @Test
    public void should_return_10()throws Exception {
        assertEquals(10, clazz.add("8,2"));
    }
    @Test
    @DisplayName("return sum for number greater than 2 numbers in string")
    public void should_return_20()throws Exception {
        assertEquals(20, clazz.add("3,9,8"));
    }
    @Test
    @DisplayName("return the sum when numbers separated by , and \n")
    public void should_return_15()throws Exception {
        assertEquals(15, clazz.add("5\n5,5"));
    }
    @Test
    @DisplayName("this test must be return the sum of number when the separator is *")
    public void should_return_10_when_separator()throws Exception {
        assertEquals(10, clazz.add("//,\n7,2,1"));
    }
    @Test
    @DisplayName("this test must be return exception when numbers were negatives")
    public void should_return_exception()throws Exception {
        assertThrows(Exception.class, () -> clazz.add("//,\n-7,-2,1"));
    }
}