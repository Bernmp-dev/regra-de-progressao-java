package com.trybe.java.regraprogressao;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * ExamRecords Class.
 */
public class ExamManager {
  private final Scanner scanner = new Scanner(System.in);
  private int numberOfExams;
  private final Map<String, Integer> examsData = new HashMap<>();

  ExamManager() {
    examsQuantity();
    gatherExamDetails();
  }

  private void examsQuantity() {
    System.out.println("Digite a quantidade de atividades para cadastrar:");
    numberOfExams = Integer.parseInt(scanner.nextLine());
  }


  private String examNamePrompt(int i) {
    System.out.println("Digite o nome da atividade " + (i + 1) + ":");
    return scanner.nextLine();
  }

  private int examtWeightPrompt(int i) {
    System.out.println("Digite o peso da atividade " + (i + 1) + ":");
    return Integer.parseInt(scanner.nextLine());
  }

  public void gatherExamDetails() {
    for (int i = 0; i < numberOfExams; i++) {
      String testName = examNamePrompt(i);
      int testWeight = examtWeightPrompt(i);

      examsData.put(testName, testWeight);
    }
  }
}
