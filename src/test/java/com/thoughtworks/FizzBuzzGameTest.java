package com.thoughtworks;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class FizzBuzzGameTest {
    private FizzBuzzGame fbg = new FizzBuzzGame();
    private List<String> results = new ArrayList<>();

    @Before
    public void setup(){
        int[] arr = {3,5,7};
        fbg.setThreeSpecialNumber(arr);
        fbg.start(100);
        results = fbg.getResults();
    }
    @Test
    public void should_return_Fizz_when_have_3() {
        assertEquals(results.get(2),"Fizz");
    }
    @Test
    public void should_return_Buzz_when_have_5() {
        assertEquals(results.get(4),"Buzz");
    }
    @Test
    public void should_return_Whizz_when_have_7() {
        assertEquals(results.get(6),"Whizz");
    }
    @Test
    public void should_return_FizzBuzz_when_have_15() {
        assertEquals(results.get(14),"FizzBuzz");
    }
    @Test
    public void should_return_FizzWhizz_when_have_21() {
        assertEquals(results.get(20),"FizzWhizz");
    }
    //BuzzWhizz
    @Test
    public void should_return_BuzzWhizz_when_have_70() {
        assertEquals(results.get(69),"BuzzWhizz");
    }
}
