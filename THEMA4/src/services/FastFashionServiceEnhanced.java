package services;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import helpers.FastFashionHelper;
import models.entities.FastFashionToFile;

public class FastFashionServiceEnhanced extends FastFashionService {

  private static final int[][] ATTIKI_SHOP_WEEK_SALES_DATA = {
      { 421, 321, 445, 500, 675 },
      { 219, 180, 921, 120, 250 },
      { 371, 200, 667, 95, 583 },
      { 112, 563, 200, 231, 369 }
  };

  private static final double[][] ATTIKI_SHOP_WEEK_EARNINGS_DATA = {
      { 5225.55, 20500.00, 50000.60, 54000.50, 73100.20 },
      { 22500.00, 50520.00, 18000.27, 21000.14, 6600.00 },
      { 52470.34, 26280.45, 20000.00, 13020.00, 5225.55 },
      { 33210.72, 44520.00, 56300.70, 31500.90, 12705.00 }
  };

  private static final int[][] ACHAIA_SHOP_WEEK_SALES_DATA = {
      { 320, 689, 150, 532, 234 },
      { 219, 200, 886, 95, 583 },
      { 165, 178, 318, 164, 424 }
  };

  private static final double[][] ACHAIA_SHOP_WEEK_EARNINGS_DATA = {
      { 20500.00, 52470.34, 26280.45, 20000.00, 13020.00 },
      { 50520.00, 26280.45, 5225.55, 13020.00, 52470.34 },
      { 26280.45, 19800.42, 9020.63, 14910.20, 38160.00 }
  };

  public FastFashionServiceEnhanced() {
    super();
  }

  public void initFastFashionProcess() {
    StringBuilder reportBuilder = new StringBuilder();
    FastFashionToFile.setFastFashionName("Zara");

    FastFashionToFile attikiFastFashionToFile = new FastFashionToFile(ATTIKI_SHOP_WEEK_SALES_DATA, ATTIKI_SHOP_WEEK_EARNINGS_DATA);
    attikiFastFashionToFile.setPrefecture("Attiki");
    reportBuilder.append(FastFashionToFile.getFastFashionName() + "\n\n");
    reportBuilder.append("Prefecture: " + attikiFastFashionToFile.getPrefecture() + "\n\n");
    calculateShopWeekSales(attikiFastFashionToFile.getWeekSales(), reportBuilder);
    reportBuilder.append("\n");
    calculateShopWeekEarnings(attikiFastFashionToFile.getWeekEarnings(), reportBuilder);
    writeToFile(reportBuilder.toString(), attikiFastFashionToFile.getPrefecture() + ".txt");

    reportBuilder = new StringBuilder();
    FastFashionToFile achaiaFastFashionToFile = new FastFashionToFile(ACHAIA_SHOP_WEEK_SALES_DATA, ACHAIA_SHOP_WEEK_EARNINGS_DATA);
    achaiaFastFashionToFile.setPrefecture("Achaia");
    reportBuilder.append(FastFashionToFile.getFastFashionName() + "\n\n");
    reportBuilder.append("Prefecture: " + achaiaFastFashionToFile.getPrefecture() + "\n\n");
    calculateShopWeekSales(achaiaFastFashionToFile.getWeekSales(), reportBuilder);
    reportBuilder.append("\n");
    calculateShopWeekEarnings(achaiaFastFashionToFile.getWeekEarnings(), reportBuilder);
    writeToFile(reportBuilder.toString(), achaiaFastFashionToFile.getPrefecture() + ".txt");
  }

  public void calculateShopWeekSales(int[][] weekSales, StringBuilder reportBuilder) {
    reportBuilder.append("Weekly sales per shop\n");

    for (int i = 0; i < weekSales.length; i++) {
      int totalSales = 0;

      for (int j = 0; j < weekSales[i].length; j++) {
        totalSales += weekSales[i][j];
      }

      reportBuilder.append(String.format("Shop No: %d%n", i + 1));
      reportBuilder.append(String.format("Total weekly sales are %d%n", totalSales));
    }
  }

  public void calculateShopWeekEarnings(double[][] weekEarnings, StringBuilder reportBuilder) {
    reportBuilder.append("Weekly earnings per shop\n");

    for (int i = 0; i < weekEarnings.length; i++) {
      double totalEarnings = 0;

      for (int j = 0; j < weekEarnings[i].length; j++) {
        totalEarnings += weekEarnings[i][j];
      }

      reportBuilder.append(String.format("Shop No: %d%n", i + 1));
      reportBuilder.append(String.format("Total weekly earnings are %s%n", FastFashionHelper.formatDouble2Digits(totalEarnings)));
    }
  }

  private void writeToFile(String content, String filename) {
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
      writer.write(content);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
