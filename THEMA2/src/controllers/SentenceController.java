package controllers;

import services.SentenceService;

public class SentenceController {
  public SentenceController() {
  }

  public void initSentenceProcess() {
    SentenceService sentenceService = new SentenceService();
    sentenceService.initSentenceProcess();
  }

  public void initSentenceProcessWithUserMenu() {
    SentenceService sentenceService = new SentenceService();
    sentenceService.initSentenceProcessWithUserMenu();
  }
}