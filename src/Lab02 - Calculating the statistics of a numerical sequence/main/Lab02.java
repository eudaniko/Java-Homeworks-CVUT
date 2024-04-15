/*
 * File name: Lab02.java
 * Date:      2024/02/26 18:18
 * Author:    @nikondan
 */

package cz.cvut.fel.pjv;
import java.util.Scanner;

public class Lab02 {

   public  void start(String[] args) {
      MakeStatistic();
   }
   private static void MakeStatistic() {
      try {
         Scanner s = new Scanner(System.in);
         double sum = 0, avg = 0, sumOfSquares = 0;
         int numbersAmount = 0, line = 0;

         while (s.hasNextLine()) {
            line++;
            String str = s.nextLine();
            if (isNumeric(str)) {
               double number = Double.parseDouble(str);
               numbersAmount++;
               sum += number;
               sumOfSquares += Math.pow(number, 2);

               if (numbersAmount == 10) {
                  avg = sum / numbersAmount;
                  double variance = (sumOfSquares - Math.pow(sum, 2) / numbersAmount) / numbersAmount;
                  double stdDeviation = Math.sqrt(variance);

                  System.out.printf("%2d %.3f %.3f\n", numbersAmount, avg, stdDeviation);
                  sum = 0;
                  sumOfSquares = 0;
                  numbersAmount = 0;
               }
            } else {
               System.err.println("A number has not been parsed from line " + line);
            }
         }
         System.err.println("End of input detected!");
         if (numbersAmount > 1) {
            avg = sum / numbersAmount;
            double variance = (sumOfSquares - Math.pow(sum, 2) / numbersAmount) / numbersAmount;
            double stdDeviation = Math.sqrt(variance);
            System.out.printf("%2d %.3f %.3f\n", numbersAmount, avg, stdDeviation);
         }
      } catch (Exception ignored) {
      }
   }

   private static boolean isNumeric(String str){
      try {
         Double.parseDouble(str);
         return true;
      } catch (NumberFormatException e) {
         return false;
      }
   }





}


