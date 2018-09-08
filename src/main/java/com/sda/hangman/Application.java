package com.sda.hangman;

import com.sda.hangman.domain.HangmanGameService;
import com.sda.hangman.domain.model.GameStatus;
import com.sda.hangman.domain.port.PhraseRepository;
import com.sda.hangman.infrastructure.memory.InMemoryPhraseRepository;

import java.util.Scanner;

public class Application {

    private static Scanner scanner;
    private static PhraseRepository phraseRepository;
    private static HangmanGameService handmanGameService;

    public static void main(String[] args) {
        handmanGameService = new HangmanGameService();
        phraseRepository = new InMemoryPhraseRepository();
        scanner = new Scanner(System.in);
        System.out.println("1. Start");
        System.out.println("2. Wyniki");
        System.out.println("3. Koniec");
        int decision = scanner.nextInt();
        boolean menuFlag = true;
        switch (decision) {
            case 1:
                System.out.println("Tutaj będzie logika do start");
                break;
            case 2:
                System.out.println("Tutaj będzie logika do wyników");
                break;
            case 3:
                System.out.println("Tutaj będzie koniec");
                break;
            default:
                menuFlag = false;
        }
        while (menuFlag);
    }

    public static void startGame(){
        System.out.println("Podaj imię");
        String name = scanner.nextLine();
        System.out.println("Kliknij enter żeby zacząć gre");
        String phrase = phraseRepository.getPhrase();
        GameStatus gameStatus = handmanGameService.createGameStatus(name, phrase);

        while () {
            System.out.println("Tutaj będzie fraza, (pozostało 5 prób)");
            System.out.println("Podaj kolejną literę: ");
            char letter = scanner.nextLine().charAt(0);
            handmanGameService.processNextLetter();
        }
    }
}
