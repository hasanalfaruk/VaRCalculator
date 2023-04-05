package varCalculator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SingleTradeUI {
    public void run(Scanner sc) {
        System.out.println("Enter the Profit and Loss values separated with spaces and then press enter.\nConfirm the dataset by entering 'y': ");

        List<Double> pAndL = new ArrayList<>();

        while (sc.hasNext()) {
            if (sc.hasNextDouble()) {
                pAndL.add(sc.nextDouble());
                System.out.println(pAndL);
            } else {
                String input = sc.next();
                if (input.equalsIgnoreCase("y")) {
                    break;
                }
            }
        }

        System.out.println("Enter the confidence level as a percentage: ");
        double confidenceLevel = sc.nextDouble();
        double var = Calculator.calculateVaR(pAndL, confidenceLevel);

        System.out.println("The VaR for the this trade is: " + var);
    }
}