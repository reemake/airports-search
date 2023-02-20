import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Application {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.print("Введите строку: ");
            String userInput = in.nextLine();
            if (userInput.equals("!quit"))
                break;
            try {
                Searcher.search(userInput, Integer.parseInt(args[0]));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
