import java.io.*;
import java.util.*;

public class MarkAndToys {

    static void mergeSort(int[] prices, int firstIndex, int middleIndex, int lastIndex) {
        int fIndex = firstIndex;
        int mIndex = middleIndex + 1;
        int[] tempArray = new int[prices.length];
        int index = 0;

        while (fIndex <= middleIndex && mIndex <= lastIndex) {
            if (prices[fIndex] < prices[mIndex]) {
                tempArray[index] = prices[fIndex];
                fIndex++;
            } else {
                tempArray[index] = prices[mIndex];
                mIndex++;
            }
            index++;
        }

        while (fIndex <= middleIndex) {
            tempArray[index] = prices[fIndex];
            index++;
            fIndex++;
        }
        while (mIndex <= lastIndex) {
            tempArray[index] = prices[mIndex];
            index++;
            mIndex++;
        }

        //System.out.println("Index -> " + index);
        for (int i = firstIndex, k = 0; i <= lastIndex; i++) {
            prices[i] = tempArray[k];
            k++;
        }
    }

    static int quickSort(int[] prices, int firstIndex, int lastIndex) {
        int fIndex = firstIndex;
        int lIndex = lastIndex;
        boolean isCheck = true;
        int pivot = prices[firstIndex]; // store first element as a pivot

        while (fIndex < lIndex) {
            if (isCheck) {
                if (pivot > prices[lIndex]) {
                    prices[fIndex] = prices[lIndex];
                    fIndex++;
                    isCheck = false;
                } else lIndex--;
            } else {
                if (pivot < prices[fIndex]) {
                    prices[lIndex] = prices[fIndex];
                    lIndex--;
                    isCheck = true;
                } else fIndex++;
            }
        }

        prices[lIndex] = pivot;
        return lIndex;
    }

    static void divideArray(int[] prices, int firstIndex, int lastIndex) {
        int middleIndex; // for merge sort
        int pivot; // for quick sort

        // divide array for merge sorting
        /*if (firstIndex < lastIndex) {
            middleIndex = (firstIndex + lastIndex) / 2;
            divideArray(prices, firstIndex, middleIndex);
            divideArray(prices, middleIndex + 1, lastIndex);
            mergeSort(prices, firstIndex, middleIndex, lastIndex);
        }*/

        // divide array for quick sorting
        if (firstIndex < lastIndex) {
            pivot = quickSort(prices, firstIndex, lastIndex);
            divideArray(prices, firstIndex, pivot - 1);
            divideArray(prices, pivot + 1, lastIndex);
        }
    }

    // Complete the maximumToys function below.
    static int maximumToys(int[] prices, int k) {
        int maximumToysBuy = 0;
        divideArray(prices, 0, prices.length - 1);
        //Arrays.sort(prices);
        for (int i = 0; i < prices.length; i++) {
            //System.out.print(prices[i] + " ");
            if (prices[i] <= k) {
                k -= prices[i];
                maximumToysBuy++;
            }
        }
        System.out.println();
        return maximumToysBuy;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[] prices = new int[n];

        String[] pricesItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int pricesItem = Integer.parseInt(pricesItems[i]);
            prices[i] = pricesItem;
        }

        int result = maximumToys(prices, k);
        System.out.println(result);

        /*bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();
        bufferedWriter.close();*/

        scanner.close();
    }
}
