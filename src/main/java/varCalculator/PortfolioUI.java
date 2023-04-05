package varCalculator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PortfolioUI {
    public void run(Scanner sc) {
        List<List<Double>> trades = new ArrayList<>();

        System.out.println("Enter the Profit and Loss values separated with spaces and then press enter at the end of each trade.\nConfirm the datasets by entering 'y': ");
        sc.nextLine();
        String input = sc.nextLine();

        if (!input.isEmpty()) {
            do {
                List<Double> pAndL = new ArrayList<>();
                for (String value : input.split("\\s+")) {
                    pAndL.add(Double.parseDouble(value));
                }
                if (!pAndL.isEmpty()) {
                    trades.add(pAndL);
                    System.out.println(pAndL);
                }
                input = sc.nextLine();
            } while (!input.isEmpty() && !input.equalsIgnoreCase("y"));

            System.out.print("Enter the confidence level as a percentage: ");
            int confidenceLevel = sc.nextInt();
            sc.nextLine();

            List<Double> portfolioPAndL = new ArrayList<>();
            for (List<Double> trade : trades) {
                double totalPAndL = 0.0;
                for (double pAndL : trade) {
                    totalPAndL += pAndL;
                }
                portfolioPAndL.add(totalPAndL);
            }
            double portfolioVaR = Calculator.calculateVaR(portfolioPAndL, confidenceLevel);
            System.out.println(portfolioVaR);
        } else {
            System.out.println("Please enter values for each trade.");
        }
    }
}