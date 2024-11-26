package com.kodilla.rps;

import java.util.Random;
import java.util.Scanner;

public class Game {

    static final Random random = new Random();
    static String playerName;
    static int winningRounds;
    static int playerScore = 0;
    static int computerScore = 0;

    public void play() {
            Scanner scanner = new Scanner(System.in);
            boolean end = false;

            while (!end) {
                setupGame(scanner);
                playRounds(scanner);

                OutputDisplay.playAgain();
                String choice = scanner.nextLine();
                if (choice.equalsIgnoreCase("x")) {
                    end = true;
                } else {
                    resetGame();
                }
            }

            OutputDisplay.thanksForPlaying();
            scanner.close();
        }

        private static void setupGame(Scanner scanner) {
            OutputDisplay.userName();
            playerName = scanner.nextLine();

            OutputDisplay.giveRoundsNumber();
            winningRounds = Integer.parseInt(scanner.nextLine());

            OutputDisplay.gameInstructions();
        }

        private static void playRounds(Scanner scanner) {
            while (playerScore < winningRounds && computerScore < winningRounds) {
                OutputDisplay.userChoose();
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
                    OutputDisplay.wrongMove();
                    continue;
                }

                int computerMove = random.nextInt(3) + 1;
                evaluateRound(playerMove, computerMove);
            }

            displayFinalResult();
        }

        private static boolean confirmExit(Scanner scanner) {
            OutputDisplay.endGame();
            return scanner.nextLine().equalsIgnoreCase("t");
        }

        private static boolean confirmNewGame(Scanner scanner) {
            OutputDisplay.endActualGame();
            return scanner.nextLine().equalsIgnoreCase("t");
        }

        private static void evaluateRound(String playerMove, int computerMove) {
            String playerChoice = getChoice(playerMove);
            String computerChoice = getChoice(String.valueOf(computerMove));

            OutputDisplay.showMoves(playerChoice,computerChoice);

            if (playerMove.equals(String.valueOf(computerMove))) {
                OutputDisplay.draw();
            } else if ((playerMove.equals("1") && computerMove == 3) ||
                    (playerMove.equals("2") && computerMove == 1) ||
                    (playerMove.equals("3") && computerMove == 2)) {
                OutputDisplay.userWon();
                playerScore++;
            } else {
                OutputDisplay.computerWon();
                computerScore++;
            }
           OutputDisplay.showScore();
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
                OutputDisplay.userWonGame();
            } else {
                OutputDisplay.computerWonGame();
            }
        }

        private static void resetGame() {
            playerScore = 0;
            computerScore = 0;
        }
    }

