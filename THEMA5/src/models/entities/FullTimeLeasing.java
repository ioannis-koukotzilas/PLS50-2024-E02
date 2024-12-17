package models.entities;

public class FullTimeLeasing extends CarLeasing {
  private double leasingCost;

  public FullTimeLeasing(String carId, double leasingCost) {
    super(carId);
    this.leasingCost = leasingCost;
  }

  @Override
  public double getLeasingCost() {
    return leasingCost;
  }
}
