package varCalculator;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class CalculatorTest {
    
    @Test
    public void testCalculateVar() {
        List<Double> pAndL = Arrays.asList(10.0, 20.0, 30.0, 40.0, 50.0);
        double confidenceLevel = 95.0;
        double expectedVar = 50.0;
        double tolerance = 1;
        
        double actualVar = Calculator.calculateVaR(pAndL, confidenceLevel);
        
        assertEquals(expectedVar, actualVar, tolerance);
    }
    
    @Test
    public void testCalculateTotalPAndL() {
        List<List<Double>> trades = new ArrayList<>();
        trades.add(Arrays.asList(10.0, 20.0, 30.0));
        trades.add(Arrays.asList(-5.0, 15.0, 25.0));
        trades.add(Arrays.asList(-10.0, -20.0, 40.0));
        double expectedTotalPAndL = 105.0;
        double tolerance = 1;
        
        double actualTotalPAndL = Calculator.calculateTotalPAndL(trades);
        
        assertEquals(expectedTotalPAndL, actualTotalPAndL, tolerance);
    }
    
    @Test
    public void testCalculatePortfolioVaR() {
        List<List<Double>> trades = new ArrayList<>();
        trades.add(Arrays.asList(10.0, 20.0, 30.0));
        trades.add(Arrays.asList(-5.0, 15.0, 25.0));
        trades.add(Arrays.asList(-10.0, -20.0, 40.0));
        double confidenceLevel = 95.0;
        double expectedPortfolioVaR = 60.0;
        double tolerance = 1;
        
        double actualPortfolioVaR = Calculator.calculatePortfolioVaR(trades, confidenceLevel);
        
        assertEquals(expectedPortfolioVaR, actualPortfolioVaR, tolerance);
    }
}