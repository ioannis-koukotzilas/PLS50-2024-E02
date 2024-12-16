package services;

import helpers.FastFashionHelper;
import models.entities.FastFashion;
import views.FastFashionView;

public class FastFashionService {
  private FastFashionView fastFashionView;

  private static final int[][] WEEK_SALES_DATA = {
    {123, 429, 200, 190, 421, 602},
    {180, 250, 512, 300, 219, 120},
    {200, 583, 731, 186, 371, 95},
    {563, 369, 344, 450, 165, 231},
    {178, 424, 555, 213, 287, 164}
  };

  private static final double[][] WEEK_EARNINGS_DATA = {
    {33300.20, 50000.60, 1000020.00, 120000.00, 20000.00, 34000.25},
    {22500.00, 18000.27, 50520.00, 6600.00, 56300.70, 21000.14},
    {52470.34, 20000.00, 26280.45, 5225.55, 17800.00, 13020.00},
    {33210.72, 56300.70, 44520.00, 12705.00, 33300.20, 31500.90},
    {38160.00, 17800.00, 19800.42, 9020.63, 22500.00, 14910.20}
  };


  public FastFashionService() {
    this.fastFashionView = new FastFashionView();
  }

  public void initFastFashionProcess() {
    FastFashion myEntity = new FastFashion(WEEK_SALES_DATA, WEEK_EARNINGS_DATA);

    fastFashionView.displayMessage("Fast Fashion");

    calculateShopWeekSales(myEntity.getWeekSales());
    calculateShopWeekEarnings(myEntity.getWeekEarnings());

    calculateProductWeekSales(myEntity.getWeekSales());
    calculateProductWeekEarnings(myEntity.getWeekEarnings());

    calculateSales(myEntity.getWeekSales(), myEntity.getProductsCount());
    calculateEarnings(myEntity.getWeekEarnings(), myEntity.getProductsCount());
  }

  public void calculateShopWeekSales(int[][] weekSales) {
    fastFashionView.displayMessage("Weekly sales per shop");

    for (int i = 0; i < weekSales.length; i++) { 
      int totalSales = 0;

      for (int j = 0; j < weekSales[i].length; j++) {
        totalSales += weekSales[i][j];
      }

      fastFashionView.displayMessage("Shop No: " + (i + 1));
      fastFashionView.displayMessage("Total weekly sales are " + totalSales);
    }
  }

  public void calculateShopWeekEarnings(double[][] weekEarnings) {
    fastFashionView.displayMessage("Weekly earnings per shop");

    for (int i = 0; i < weekEarnings.length; i++) { 
      double totalEarnings = 0;

      for (int j = 0; j < weekEarnings[i].length; j++) {
        totalEarnings += weekEarnings[i][j];
      }

      fastFashionView.displayMessage("Shop No: " + (i + 1));
      fastFashionView.displayMessage("Total weekly earnings are " + FastFashionHelper.formatDouble2Digits(totalEarnings));
    }
  }

  public void calculateProductWeekSales(int[][] weekSales) {
    fastFashionView.displayMessage("Weekly sales per product");

    for (int j = 0; j < weekSales[0].length; j++) { 
      int totalSalesForProduct = 0;

      for (int i = 0; i < weekSales.length; i++) {
        totalSalesForProduct += weekSales[i][j];
      }

      fastFashionView.displayMessage("Product No: " + (j + 1));
      fastFashionView.displayMessage("Total weekly sales are " + totalSalesForProduct);
    }
  }

  public void calculateProductWeekEarnings(double[][] weekEarnings) {
    fastFashionView.displayMessage("Weekly earnings per product");

    for (int j = 0; j < weekEarnings[0].length; j++) { 
      double totalEarningsForProduct = 0;

      for (int i = 0; i < weekEarnings.length; i++) {
        totalEarningsForProduct += weekEarnings[i][j];
      }

      fastFashionView.displayMessage("Product No: " + (j + 1));
      fastFashionView.displayMessage("Total weekly earnings are " + FastFashionHelper.formatDouble2Digits(totalEarningsForProduct));
    }
  }

  public void calculateSales(int[][] weekSales, int productsCount) {
    fastFashionView.displayMessage("Weekly total sales");

    int totalSales = 0;

    for (int i = 0; i < weekSales.length; i++) { 
      for (int j = 0; j < weekSales[i].length; j++) {
        totalSales += weekSales[i][j];
      }
    }

    double averageSalesPerProduct = (double) totalSales / productsCount;

    fastFashionView.displayMessage("The total weekly sales in all shops are " + totalSales);
    fastFashionView.displayMessage("Average weekly sales per product are: " + FastFashionHelper.formatDouble2Digits(averageSalesPerProduct));
  }

  public void calculateEarnings(double[][] weekEarnings, int productsCount) {
    fastFashionView.displayMessage("Weekly total earnings");

    double totalEarnings = 0;

    for (int i = 0; i < weekEarnings.length; i++) { 
      for (int j = 0; j < weekEarnings[i].length; j++) {
        totalEarnings += weekEarnings[i][j];
      }
    }

    double averageEarningsPerShop = (double) totalEarnings / productsCount;

    fastFashionView.displayMessage("The total weekly earnings in all shops are " + FastFashionHelper.formatDouble2Digits(totalEarnings));
    fastFashionView.displayMessage("Average weekly earnings per shop are: " + FastFashionHelper.formatDouble2Digits(averageEarningsPerShop));
  }
}