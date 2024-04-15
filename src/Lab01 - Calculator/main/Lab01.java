package cz.cvut.fel.pjv;

import java.util.Scanner;


public class Lab01 {

    public void start(String[] args) {
        homework();
    }


    private static void homework() {
        System.out.println("Vyber operaci (1-soucet, 2-rozdil, 3-soucin, 4-podil):");
        try {
            Scanner sc = new Scanner(System.in);
            byte operationNo = sc.nextByte();
            double x = 0, y = 0, result = 0;
            int decSize;
            if (operationNo == 1) {
                System.out.println("Zadej scitanec: ");
                x = sc.nextDouble();
                System.out.println("Zadej scitanec: ");
                y = sc.nextDouble();
                result = x + y;
            } else if (operationNo == 2) {
                System.out.println("Zadej mensenec: ");
                x = sc.nextDouble();
                System.out.println("Zadej mensitel: ");
                y = sc.nextDouble();
                result = x - y;
            } else if (operationNo == 3) {
                System.out.println("Zadej cinitel: ");
                x = sc.nextDouble();
                System.out.println("Zadej cinitel: ");
                y = sc.nextDouble();
                result = x * y;
            } else if (operationNo == 4) {
                System.out.println("Zadej delenec: ");
                x = sc.nextDouble();
                System.out.println("Zadej delitel: ");
                y = sc.nextDouble();
                if (y == 0) {
                    System.out.println("Pokus o deleni nulou!");
                    return;
                }
                result = x / y;
            } else {
                System.out.println("Chybna volba!");
                System.exit(1);
            }

            System.out.println("Zadej pocet desetinnych mist: ");
            decSize = sc.nextInt();
            if (decSize < 0) {
                System.out.printf("Chyba - musi byt zadane kladne cislo!\n");
                return;
            }

            String eleFormat = "%." + decSize + "f";
            String[] format = {
                    eleFormat + " + " + eleFormat + " = " + eleFormat,
                    eleFormat + " - " + eleFormat + " = " + eleFormat,
                    eleFormat + " * " + eleFormat + " = " + eleFormat,
                    eleFormat + " / " + eleFormat + " = " + eleFormat
            };
            System.out.printf(format[operationNo - 1] + "\n", x, y, result);
        } catch (Exception e) {
            System.out.println("Chybna volba!");
            System.exit(1);
        }
    }

}