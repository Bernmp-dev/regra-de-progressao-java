package com.trybe.java.regraprogressao;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * ExamManager Class.
 */
public class ExamManager {
  private final Scanner scanner = new Scanner(System.in);
  private int numberOfExams;
  private final Map<String, Exam> examsMap = new HashMap<>();

  ExamManager() {
    numberOfExamsPrompt();
    gatherExamDetails();
    displayFinalResult();
  }

  private void numberOfExamsPrompt() {
    System.out.println("Digite a quantidade de atividades para cadastrar:");
    numberOfExams = Integer.parseInt(scanner.nextLine());
  }

  private String examNamePrompt(int i) {
    System.out.println("Digite o nome da atividade " + (i + 1) + ":");
    return scanner.nextLine();
  }

  private int examWeightPrompt(int i) {
    System.out.println("Digite o peso da atividade " + (i + 1) + ":");
    return Integer.parseInt(scanner.nextLine());
  }

  private int examScorePrompt(String examName) {
    System.out.println("Digite a nota obtida para " + examName + ":");
    return Integer.parseInt(scanner.nextLine());
  }

  /** gatherExamDetails method. */
  public void gatherExamDetails() {
    for (int i = 0; i < numberOfExams; i++) {
      String examName = examNamePrompt(i);
      int examWeight = examWeightPrompt(i);
      int examScore = examScorePrompt(examName);

      Exam exam = new Exam(examName, examWeight, examScore);
      examsMap.put(examName, exam);
    }
  }

  private float calculateTotalPercentage() {
    int totalScore = 0;
    int totalWeight = 0;

    for (Exam exam : examsMap.values()) {
      totalScore += exam.score * exam.weight;
      totalWeight += exam.weight;
    }

    return (float) totalScore / totalWeight;
  }

  /** displayFinalResult method. */
  public void displayFinalResult() {
    float totalPercentage = calculateTotalPercentage();
    if (totalPercentage < 85) {
      System.out.println(
          "Lamentamos informar que, com base na sua pontuação alcançada neste período, "
              + totalPercentage
              + "%, você não atingiu a pontuação mínima necessária para sua aprovação."
      );
    } else {
      System.out.println(
          "Parabéns! Você alcançou "
              + totalPercentage
              + "%! E Temos o prazer de informar que você obteve aprovação!"
      );
    }
  }
}