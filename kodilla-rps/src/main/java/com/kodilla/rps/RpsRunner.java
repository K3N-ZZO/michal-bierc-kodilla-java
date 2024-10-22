package com.kodilla.rps;

import java.util.Random;
import java.util.Scanner;

 public class RpsRunner {
    private static final Random random = new Random();
    private static String playerName;
    private static int winningRounds;
    private static int playerScore = 0;
    private static int computerScore = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean end = false;

        while (!end) {
            setupGame(scanner);
            playRounds(scanner);

            System.out.print("Czy chcesz zagrac ponownie? (n – tak, x – nie): ");
            String choice = scanner.nextLine();
            if (choice.equalsIgnoreCase("x")) {
                end = true;
            } else {
                resetGame();
            }
        }

        System.out.println("Dziekuje za gre, " + playerName + "!");
        scanner.close();
    }

    private static void setupGame(Scanner scanner) {
        System.out.print("Podaj swoje imie: ");
        playerName = scanner.nextLine();

        System.out.print("Podaj liczbe wygranych rund, po ktorych następuje zwyciestwo: ");
        winningRounds = Integer.parseInt(scanner.nextLine());

        System.out.println("Klawisze do gry:");
        System.out.println("1 - kamien");
        System.out.println("2 - papier");
        System.out.println("3 - nozyce");
        System.out.println("x - zakonczenie gry");
        System.out.println("n - nowa gra");
    }

    private static void playRounds(Scanner scanner) {
        while (playerScore < winningRounds && computerScore < winningRounds) {
            System.out.print("Wybierz ruch (1 - kamien, 2 - papier, 3 - nozyce): ");
            String playerMove = scanner.nextLine();

            if (playerMove.equalsIgnoreCase("x")) {
                if (confirmExit(scanner)) {
                    break;
                }
            } else if (playerMove.equalsIgnoreCase("n")) {
                if (confirmNewGame(scanner)) {
                    resetGame();
                    return;
                }
            } else if (!playerMove.equals("1") && !playerMove.equals("2") && !playerMove.equals("3")) {
                System.out.println("Nieprawidlowy ruch, sprobuj ponownie.");
                continue;
            }

            int computerMove = random.nextInt(3) + 1;
            evaluateRound(playerMove, computerMove);
        }

        displayFinalResult();
    }

    private static boolean confirmExit(Scanner scanner) {
        System.out.print("Czy na pewno chcesz zakonczyc gre? (t/n): ");
        return scanner.nextLine().equalsIgnoreCase("t");
    }

    private static boolean confirmNewGame(Scanner scanner) {
        System.out.print("Czy na pewno chcesz zakonczyć aktualna gre? (t/n): ");
        return scanner.nextLine().equalsIgnoreCase("t");
    }

    private static void evaluateRound(String playerMove, int computerMove) {
        String playerChoice = getChoice(playerMove);
        String computerChoice = getChoice(String.valueOf(computerMove));

        System.out.println("Ty zagrales: " + playerChoice);
        System.out.println("Komputer zagral: " + computerChoice);

        if (playerMove.equals(String.valueOf(computerMove))) {
            System.out.println("Remis!");
        } else if ((playerMove.equals("1") && computerMove == 3) ||
                (playerMove.equals("2") && computerMove == 1) ||
                (playerMove.equals("3") && computerMove == 2)) {
            System.out.println(playerName + " wygrales ta runde!");
            playerScore++;
        } else {
            System.out.println("Komputer wygral ta runde!");
            computerScore++;
        }

        System.out.println("Biezacy wynik: " + playerName + " " + playerScore + " - " + computerScore + " Komputer\n");
    }

    private static String getChoice(String move) {
        switch (move) {
            case "1": return "kamien";
            case "2": return "papier";
            case "3": return "nozyce";
            default: return "";
        }
    }

    private static void displayFinalResult() {
        if (playerScore == winningRounds) {
            System.out.println("Gratulacje! " + playerName + " Wygrales gre z wynikiem " + playerScore + " - " + computerScore);
        } else {
            System.out.println("Komputer wygral grę z wynikiem " + computerScore + " - " + playerScore);
        }
    }

    private static void resetGame() {
        playerScore = 0;
        computerScore = 0;
    }
}