import java.util.Random;
import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static Random random = new Random();
    static boolean gameFlag;

    public static void main(String[] args) {

        // 1. Написать программу, которая загадывает случайное число от 0 до 9, и пользователю дается 3 попытки
        // угадать это число. При каждой попытке компьютер должен сообщить больше ли указанное пользователем
        // число чем загаданное, или меньше. После победы или проигрыша выводится запрос – «Повторить игру еще раз?
        // 1 – да / 0 – нет»(1 – повторить, 0 – нет).

        do {
            guessNumberGame(3);
            gameFlag = getGameFlag();
        } while (gameFlag);

    }

    static void guessNumberGame (int n) {
        int number = random.nextInt(9);
        int userAnswer = 0;
        for (int i = 0; i < n; i++) {
            System.out.printf("Угадайте число от 0 до 9. Количество попыток: %d\n", n - i);
            userAnswer = sc.nextInt();
            if (userAnswer == number) {
                System.out.println("Поздравляю, вы  победили!");
                return;
            } else {
                compareNumbers(number, userAnswer);
            }
        }
        System.out.println("Вы проиграли!");
    }

    static boolean getGameFlag(){
        int userAnswer = 0;
        System.out.println("Повторить игру? 1 – да / 0 – нет");
        do {
            userAnswer = sc.nextInt();
            if (userAnswer == 0) {
                return false;
            } else if (userAnswer == 1){
                return true;
            } else {
                System.out.println("Введите корректное число. Повторить игру? 1 – да / 0 – нет");
            }
        } while (true);
    }

    static void compareNumbers (int number, int userAnswer){
        if (number > userAnswer){
            System.out.println("Введенное число меньше загаданного");
        }
        if (number < userAnswer){
            System.out.println("Введенное число больше загаданного");
        }
    }

}