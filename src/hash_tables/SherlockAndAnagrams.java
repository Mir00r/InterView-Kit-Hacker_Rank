
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class SherlockAndAnagrams {
    // Complete the sherlockAndAnagrams function below.
    static int sherlockAndAnagrams(String s) {
        int length = s.length();
        int pairCount = 0, index = 1;
        HashMap<String, Integer> hashMap = new HashMap<>();

        while (index < length) {
            for (int i = 0; i < length - (index - 1); i++) {
                String subStr = s.substring(i, i + index);
                char[] arrStr = subStr.toCharArray();
                Arrays.sort(arrStr);
                subStr = String.valueOf(arrStr);

                if (hashMap.containsKey(subStr)) {
                    hashMap.put(subStr, hashMap.get(subStr) + 1);
                } else {
                    hashMap.put(subStr, 1);
                }
            }
            index++;
        }

        for (Integer integer : hashMap.values()) {
            if (integer >= 2) {
                pairCount += (integer * integer - integer) / 2;
            }
        }
        return pairCount;
        
        /*int[][] frequencyTables = new int[length][];
        for (int i = 0; i < length; i++) {
            frequencyTables[i] = new int[26];
        }
        // go over the string once from the beginning
        for (int start = 0; start < length; start++) {
            char current = s.charAt(start);
            int charIndex = current - 'a';

            for (int index = start; index < length; index++) {
                frequencyTables[index][charIndex]++;
            }
        }
        return frequencyTables.length;*/
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            int result = sherlockAndAnagrams(s);
            System.out.println(result);
            /*bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();*/
        }

        //bufferedWriter.close();
        scanner.close();
    }
}
