package controllers;

import services.CarLeasingService;

public class CarLeasingController {
  public CarLeasingController() {
  }

  public void initCarLeasingProcess() {
    CarLeasingService carLeasingService = new CarLeasingService();
    carLeasingService.initCarLeasingProcess();
  }
}