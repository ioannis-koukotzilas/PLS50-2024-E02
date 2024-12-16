package controllers;

import services.FastFashionService;

public class FastFashionController {
  public FastFashionController() {
  }

  public void initFastFashionProcess() {
    FastFashionService fastFashionService = new FastFashionService();
    fastFashionService.initFastFashionProcess();
  }
}