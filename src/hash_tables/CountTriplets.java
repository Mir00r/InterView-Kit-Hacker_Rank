import java.io.*;
import java.util.*;

public class CountTriplets {
    // Complete the countTriplets function below.
    static long countTriplets(List<Long> arr, long r) {
        int length = arr.size();
        long result = 0;
        HashMap<Long, Long> map1 = new HashMap<>();
        HashMap<Long, Long> map2 = new HashMap<>();

        for (Long aLong : arr) {
            result += map2.getOrDefault(aLong, 0L);
            if (map1.containsKey(aLong)) {
                map2.put(aLong * r, map2.getOrDefault(aLong * r, 0L) + map1.get(aLong));
            }
            map1.put(aLong * r, map1.getOrDefault(aLong * r, 0L) + 1);
        }

        /*for (int i = 0; i < length; i++) {
            if (i + 1 < length
                    && arr.get(i) * r == arr.get(i + 1)
                    && arr.get(i + 1) / r == arr.get(i)) {
                if (i + 2 < length) {
                    for (int j = i + 2; j < length; j++) {
                        if (arr.get(i) * r == arr.get(j)) result++;
                    }
                }
            }
        }*/
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nr = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(nr[0]);

        long r = Long.parseLong(nr[1]);

        String[] arrItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Long> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            long arrItem = Long.parseLong(arrItems[i]);
            arr.add(arrItem);
        }

        long ans = countTriplets(arr, r);
        System.out.println(ans);
        bufferedWriter.write(String.valueOf(ans));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
