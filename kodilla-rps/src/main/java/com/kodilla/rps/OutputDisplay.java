package com.kodilla.rps;



public class OutputDisplay {

    static void playAgain(){
        System.out.print("Czy chcesz zagrac ponownie? (n – tak, x – nie): ");
    }
    static void thanksForPlaying(){
        System.out.println("Dziekuje za gre, " + Game.playerName + "!");
    }
    static void userName(){
        System.out.print("Podaj swoje imie: ");
    }
    static void giveRoundsNumber(){
        System.out.print("Podaj liczbe wygranych rund, po ktorych następuje zwyciestwo: ");
    }
    static void gameInstructions(){
        System.out.println("Klawisze do gry:");
        System.out.println("1 - kamien");
        System.out.println("2 - papier");
        System.out.println("3 - nozyce");
        System.out.println("x - zakonczenie gry");
        System.out.println("n - nowa gra");
    }
    static void userChoose(){
        System.out.print("Wybierz ruch (1 - kamien, 2 - papier, 3 - nozyce): ");
    }
    static void wrongMove(){
        System.out.println("Nieprawidlowy ruch, sprobuj ponownie.");
    }
    static void endGame(){
        System.out.print("Czy na pewno chcesz zakonczyc gre? (t/n): ");
    }
    static void endActualGame(){
        System.out.print("Czy na pewno chcesz zakonczyć aktualna gre? (t/n): ");
    }
    static void showMoves(String playerChoice, String computerChoice){
        System.out.println("Ty zagrales: " + playerChoice);
        System.out.println("Komputer zagral: " + computerChoice);
    }
    static void draw(){
        System.out.println("Remis!");
    }
    static void userWon(){
        System.out.println(Game.playerName + " wygrales ta runde!");
    }
    static void computerWon(){
        System.out.println("Komputer wygral ta runde!");
    }
    static void showScore(){
        System.out.println("Biezacy wynik: " + Game.playerName + " " + Game.playerScore + " - " + Game.computerScore +
                " Komputer\n");
    }
    static void userWonGame(){
        System.out.println("Gratulacje! " + Game.playerName + " Wygrales gre z wynikiem " + Game.playerScore
                + " - " + Game.computerScore);
    }
    static void computerWonGame(){
        System.out.println("Komputer wygral grę z wynikiem " + Game.computerScore + " - " + Game.playerScore);
    }
}
