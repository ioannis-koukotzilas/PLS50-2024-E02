package models.entities;

public class FastFashion {
  public int[][] weekSales;
  public double[][] weekEarnings;
  public int shopsCount;
  public int productsCount;

  public FastFashion(int[][] weekSales, double[][] weekEarnings) {
    validateMatrixData(weekSales);
    validateMatrixData(weekEarnings);

    this.weekSales = weekSales;
    this.weekEarnings = weekEarnings;
    this.shopsCount = weekSales.length;
    this.productsCount = weekSales[0].length;
  }

  public int[][] getWeekSales() {
    return weekSales;
  }

  public double[][] getWeekEarnings() {
    return weekEarnings;
  }

  public int getShopsCount() {
    return shopsCount;
  }

  public int getProductsCount() {
    return productsCount;
  }

  private void validateMatrixData(int[][] matrixData) {
    for (int i = 0; i < matrixData.length; i++) {
      for (int j = 0; j < matrixData[i].length; j++) {
        if (matrixData[i][j] < 0) {
          System.out.println("Error: Invalid matrix data (values must be ≥0).");
          System.exit(1);
        }
      }
    }
  }

  private void validateMatrixData(double[][] matrixData) {
    for (int i = 0; i < matrixData.length; i++) {
      for (int j = 0; j < matrixData[i].length; j++) {
        if (matrixData[i][j] < 0) {
          System.out.println("Error: Invalid matrix data (values must be ≥0).");
          System.exit(1);
        }
      }
    }
  }
}