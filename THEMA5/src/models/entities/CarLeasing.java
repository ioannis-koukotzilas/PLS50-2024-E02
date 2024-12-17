package models.entities;

public abstract class CarLeasing {
  private String carId;

  public CarLeasing(String carId) {
    this.carId = carId;
  }

  public abstract double getLeasingCost();

  public String toString() {
    return "ARITHMOS KYKLOFORIAS: " + carId + " -> " + "XREWSH MISTHWSIS: " + getLeasingCost();
  }
}