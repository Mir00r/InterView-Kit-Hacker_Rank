import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    // Complete the twoStrings function below.
    static String twoStrings(String s1, String s2) {
        boolean isSubString = false;
        String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

        for (int i = 0; i < alphabet.length(); i++) {
            int s1Index = s1.indexOf(alphabet.charAt(i));
            int s2Index = s2.indexOf(alphabet.charAt(i));
            //System.out.println("Char -> "+alphabet.charAt(i));
            if (s1.indexOf(alphabet.charAt(i)) >= 0
                    && s2.indexOf(alphabet.charAt(i)) >= 0) {
                isSubString = true;
                break;
            }
        }
        if (isSubString) return "YES";
        else return "NO";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s1 = scanner.nextLine();

            String s2 = scanner.nextLine();

            String result = twoStrings(s1, s2);
            System.out.println(result);

            //bufferedWriter.write(result);
            //bufferedWriter.newLine();
        }

        //bufferedWriter.close();

        scanner.close();
    }
}
