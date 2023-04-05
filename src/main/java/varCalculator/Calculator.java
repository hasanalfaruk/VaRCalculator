package varCalculator;

import java.util.Collections;
import java.util.List;

public class Calculator {

    public static double calculateVaR(List<Double> pAndL, double confidenceLevel) {
        Collections.sort(pAndL);
        int index = (int) Math.ceil(confidenceLevel / 100.0 * pAndL.size()) - 1;

        return pAndL.get(index);
    }

    public static double calculateTotalPAndL(List<List<Double>> trades) {
        double totalPAndL = 0.0;
        for (List<Double> trade : trades) {
            for (double pAndL : trade) {
                totalPAndL += pAndL;
            }
        }
        return totalPAndL;
    }

    public static double calculatePortfolioVaR(List<List<Double>> trades, double confidenceLevel) {
        List<Double> portfolioPAndL = getPortfolioPAndL(trades);
        return calculateVaR(portfolioPAndL, confidenceLevel);
    }

    private static List<Double> getPortfolioPAndL(List<List<Double>> trades) {
        List<Double> portfolioPAndL = new java.util.ArrayList<Double>();
        for (List<Double> trade : trades) {
            double totalPAndL = 0.0;
            for (double pAndL : trade) {
                totalPAndL += pAndL;
            }
            portfolioPAndL.add(totalPAndL);
        }
        return portfolioPAndL;
    }
}