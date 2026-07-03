package qn4_naro;

import java.util.Random;

public class RainfallAnalyzer {
    public static void main(String[] args) {
        double[] dailyRainfall = new double[30];
        Random randomGenerator = new Random();

        double totalRainfallSum = 0.0;
        int wetDaysCounter = 0;

        System.out.println("=== NARO IoT Sensor Array Data Logs ===");
        
        for (int i = 0; i < dailyRainfall.length; i++) {
            dailyRainfall[i] = 0.0 + (60.0 * randomGenerator.nextDouble());
            
            System.out.printf("Day %d Sensor Reading: %.2f mm\n", (i + 1), dailyRainfall[i]);

            totalRainfallSum += dailyRainfall[i];

            
            if (dailyRainfall[i] > 30.0) {
                wetDaysCounter++;
            }
        }

        double averageDailyRainfall = totalRainfallSum / dailyRainfall.length;

        String climateClassification;
        if (totalRainfallSum <= 300.0) {
            climateClassification = "Dry Category";
        } else if (totalRainfallSum < 600.0) {
            climateClassification = "Normal Category";
        } else {
            climateClassification = "Flood Risk Warning Level";
        }

        System.out.println("\n=== Monthly Analytical Summary Report ===");
        System.out.printf("Total Accumulated Rainfall: %.2f mm\n", totalRainfallSum);
        System.out.printf("Calculated Daily Average  : %.2f mm\n", averageDailyRainfall);
        System.out.println("Total Number of Wet Days  : " + wetDaysCounter);
        System.out.println("Seasonal Climate Status   : " + climateClassification);
    }
}