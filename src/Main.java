import java.util.Random;
import java.util.Scanner;

public class Main {

    //2
    public static int findSymbolOccurance(String source, String target) {
        if (source == null || source.isEmpty() || target == null || target.isEmpty()) {
            return 0;
        }

        int count = 0;
        int index = 0;

        while ((index = source.indexOf(target, index)) != -1) {
            count++;
            index += target.length();
        }

        return count;
    }

    //3
    public static int findWordPosition(String source, String target) {
        if (source == null || source.isEmpty() || target == null || target.isEmpty()) {
            return -1;
        }
        return source.indexOf(target);
    }

    //4
    public static String stringReverse(String input) {
        if (input != null && !input.isEmpty()) {
            StringBuilder reversed = new StringBuilder(input);
            return reversed.reverse().toString();
        }
        return "";
    }

    //5
    public static boolean isPalindrome(String input) {
        if (input == null || input.isEmpty()) return false;
        String reversedInput = new StringBuilder(input).reverse().toString();

        return input.equals(reversedInput);
    }

    //6
    private static String hint(String mysteryWord, String userWord) {
        StringBuilder hint = new StringBuilder();
        int maxLength = 15;
        for (int i = 0; i < maxLength; i++) {
            if (i < mysteryWord.length() && i < userWord.length() && mysteryWord.charAt(i) == userWord.charAt(i)) {
                hint.append(mysteryWord.charAt(i));
            } else {
                hint.append("#");
            }
        }
        return hint.toString();
    }


    public static void main(String[] args) {

        //2
        String source = "my name is Vadym",
            target = "m";

        System.out.println(findSymbolOccurance(source, target));

        //3
        String target2 = "is";
        System.out.println(findWordPosition(source, target2));

        //4
        System.out.println(stringReverse(source));

        //5
        String palindrome = "era";
        System.out.println(isPalindrome(palindrome));

        //6
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado" , "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive",
                "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};

        Random random = new Random();
        String mysteryWord = words[random.nextInt(words.length)];

        Scanner scanner = new Scanner(System.in);
        System.out.println("Try to guess the word.");

        boolean correctly = false;
        while (!correctly) {
            System.out.print("Enter the word: ");
            String userWord = scanner.nextLine();

            if (userWord.equals(mysteryWord)) {
                System.out.println("Yes, " + mysteryWord);
                correctly = true;
            } else {
                System.out.println("No. Hint:");
                System.out.println(hint(mysteryWord, userWord));
            }
        }
        scanner.close();
    }
}