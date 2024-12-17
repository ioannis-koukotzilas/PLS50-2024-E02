package models.entities;

public class FastFashionToFile extends FastFashion {
  public static String fastFashionName;
  private String prefecture;

  public FastFashionToFile(int[][] weekSales, double[][] weekEarnings) {
    super(weekSales, weekEarnings);
  }

  public static String getFastFashionName() {
    return fastFashionName;
  }

  public static void setFastFashionName(String fastFashionName) {
    FastFashionToFile.fastFashionName = fastFashionName;
  }

  public String getPrefecture() {
    return prefecture;
  }

  public void setPrefecture(String prefecture) {
    this.prefecture = prefecture;
  }
}
