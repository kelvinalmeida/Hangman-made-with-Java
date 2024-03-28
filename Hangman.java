import java.lang.Math;
import java.util.Scanner;

public class Hangman {

        public static String[] words = { "ant", "baboon", "badger", "bat", "bear", "beaver", "camel",
                        "cat", "clam", "cobra", "cougar", "coyote", "crow", "deer",
                        "dog", "donkey", "duck", "eagle", "ferret", "fox", "frog", "goat",
                        "goose", "hawk", "lion", "lizard", "llama", "mole", "monkey", "moose",
                        "mouse", "mule", "newt", "otter", "owl", "panda", "parrot", "pigeon",
                        "python", "rabbit", "ram", "rat", "raven", "rhino", "salmon", "seal",
                        "shark", "sheep", "skunk", "sloth", "snake", "spider", "stork", "swan",
                        "tiger", "toad", "trout", "turkey", "turtle", "weasel", "whale", "wolf",
                        "wombat", "zebra" };

        public static String[] gallows = { "+---+\n" +
                        "|   |\n" +
                        "    |\n" +
                        "    |\n" +
                        "    |\n" +
                        "    |\n" +
                        "=========\n",

                        "+---+\n" +
                                        "|   |\n" +
                                        "O   |\n" +
                                        "    |\n" +
                                        "    |\n" +
                                        "    |\n" +
                                        "=========\n",

                        "+---+\n" +
                                        "|   |\n" +
                                        "O   |\n" +
                                        "|   |\n" +
                                        "    |\n" +
                                        "    |\n" +
                                        "=========\n",

                        " +---+\n" +
                                        " |   |\n" +
                                        " O   |\n" +
                                        "/|   |\n" +
                                        "     |\n" +
                                        "     |\n" +
                                        " =========\n",

                        " +---+\n" +
                                        " |   |\n" +
                                        " O   |\n" +
                                        "/|\\  |\n" + // if you were wondering, the only way to print '\' is with a
                                                      // trailing escape
                                                      // character, which also happens to be '\'
                                        "     |\n" +
                                        "     |\n" +
                                        " =========\n",

                        " +---+\n" +
                                        " |   |\n" +
                                        " O   |\n" +
                                        "/|\\  |\n" +
                                        "/    |\n" +
                                        "     |\n" +
                                        " =========\n",

                        " +---+\n" +
                                        " |   |\n" +
                                        " O   |\n" +
                                        "/|\\  |\n" +
                                        "/ \\  |\n" +
                                        "     |\n" +
                                        " =========\n" };

        public static boolean verifyArrayWithString(String[] array, int arrayLength, String world) {

                for (int i = 0; i <= arrayLength; i++) {
                        if (array[i].equals(world))
                                return true;
                        else
                                return false;
                }

                return false;
        }

        public static String randomWord() {
                double randomNumber = Math.random() * words.length;
                return words[(int) randomNumber];

        }

        public static boolean checkGuess(String word, String guess) {
                boolean userGuess = word.contains(guess);
                return userGuess;
        }

        public static void main(String[] args) {

                boolean inGame = true;

                int turns = 0;

                String[] rightWords = new String[100];
                int indexRightWords = 0;
                String[] missedWords = new String[100];
                int IndexMissedWords = 0;

                String randWorld = randomWord();
                System.out.println(randWorld);

                while (inGame) {

                        // Show the gallows
                        System.out.println(gallows[turns]);

                        System.out.println(randWorld);

                        System.out.print("\nWord: ");
                        for (int i = 0; i <= indexRightWords; i++) {
                                if (rightWords[i] != null)
                                        System.out.print(rightWords[i] + " ");
                        }
                        System.out.println();

                        System.out.print("\nMissed: ");
                        for (int i = 0; i <= IndexMissedWords; i++) {
                                if (missedWords[i] != null)
                                        System.out.print(missedWords[i] + " ");
                        }
                        System.out.println();

                        Scanner scan = new Scanner(System.in);
                        String caracterGuessed = scan.nextLine();

                        if (checkGuess(randWorld, caracterGuessed)) {

                                if (verifyArrayWithString(rightWords, indexRightWords, caracterGuessed)) {
                                        rightWords[indexRightWords] = caracterGuessed;
                                        indexRightWords++;
                                }

                                System.out.println("Contem na string!");

                                int worldLength = randWorld.length();
                                if (indexRightWords == worldLength) {
                                        System.out.println("Win! : )");
                                        break;
                                }

                        } else {
                                if (verifyArrayWithString(missedWords, IndexMissedWords, caracterGuessed)) {
                                        missedWords[IndexMissedWords] = caracterGuessed;
                                        IndexMissedWords++;
                                }

                                System.out.println("Não contem na string!");
                        }
                }

        }

}
