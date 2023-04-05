package varCalculator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter '1' to calculate VaR for a single trade");
        System.out.println("Enter '2' to calculate VaR for a portfolio");

        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                SingleTradeUI ui1 = new SingleTradeUI();
                ui1.run(sc);
                break;
            case 2:
                PortfolioUI ui2 = new PortfolioUI();
                ui2.run(sc);
                break;
            default:
                System.out.println("Please enter either 1 or 2.");
        }
    }
}

