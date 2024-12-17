package services;

import models.entities.CarLeasing;
import models.entities.FullTimeLeasing;
import models.entities.PartTimeLeasing;
import views.CarLeasingView;

public class CarLeasingService {
  private CarLeasingView carLeasingView;
  private CarLeasing[] carLeasingArray;

  public CarLeasingService() {
    this.carLeasingView = new CarLeasingView();
    carLeasingArray = new CarLeasing[5];
  }

  public void initCarLeasingProcess() {
    carLeasingArray[0] = new FullTimeLeasing("ΥΖΕ6418", 1200.0);
    carLeasingArray[1] = new FullTimeLeasing("ΑΙΧ2334", 1000.0);
    carLeasingArray[2] = new PartTimeLeasing("ΧΑΡ5689", 15, 50);
    carLeasingArray[3] = new FullTimeLeasing("ΖΑΒ1262", 1500.0);
    carLeasingArray[4] = new PartTimeLeasing("ΙΝΒ9080", 20, 40);

    for (int index = 0; index < carLeasingArray.length; index++) {
      CarLeasing carLeasing = carLeasingArray[index];
      carLeasingView.displayMessage(carLeasing.toString());
    }
  }
}