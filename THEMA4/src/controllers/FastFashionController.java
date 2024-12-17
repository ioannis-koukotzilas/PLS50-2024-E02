package controllers;

import services.FastFashionServiceEnhanced;

public class FastFashionController {
  public FastFashionController() {
  }

  public void initFastFashionProcess() {
    FastFashionServiceEnhanced fastFashionServiceEnhanced = new FastFashionServiceEnhanced();
    fastFashionServiceEnhanced.initFastFashionProcess();
  }
}