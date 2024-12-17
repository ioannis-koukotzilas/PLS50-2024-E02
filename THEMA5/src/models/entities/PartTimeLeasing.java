package models.entities;

public class PartTimeLeasing extends CarLeasing {
  private int leasingHours;
  private double costPerHour;

  public PartTimeLeasing(String carId, int leasingHours, double costPerHour) {
    super(carId);
    this.leasingHours = leasingHours;
    this.costPerHour = costPerHour;
  }

  @Override
  public double getLeasingCost() {
    return leasingHours * costPerHour;
  }
}
