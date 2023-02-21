import exception.ArgumentsValidationException;
import searcher.Searcher;

import java.io.IOException;
import java.util.Scanner;

public class Application {

    private static void validateArgs(String[] args) throws ArgumentsValidationException {
        if (args.length == 0) {
            throw new ArgumentsValidationException("Параметр не задан!");
        }
        else if (args.length == 1) {
            if (Integer.parseInt(args[0]) < 1 || Integer.parseInt(args[0]) > 13)
                throw new ArgumentsValidationException("Некорректный номер колонки!");
        }
        else {
            throw new ArgumentsValidationException("Задано некорректное число параметров!");
        }
    }
    public static void main(String[] args) {
        try {
            validateArgs(args);
            Scanner in = new Scanner(System.in);
            while (true) {
                System.out.print("Введите строку: ");
                String userInput = in.nextLine();
                if (userInput.equals("!quit"))
                    break;
                Searcher.search(userInput, Integer.parseInt(args[0]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ArgumentsValidationException e) {
            e.printStackTrace();
        }
    }
}
