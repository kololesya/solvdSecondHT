package firstHomeTask;

import java.util.Arrays;
import java.util.Scanner;

public class InsertionSort {
    public static void insertionSort() {
        int[] existArray = createAnArray();
        System.out.println("Exist array: " + Arrays.toString(existArray));

        int n = existArray.length;
        for (int i = 1; i < n; ++i) {
            int key = existArray[i];
            int j = i - 1;

            while (j >= 0 && existArray[j] > key) {
                existArray[j + 1] = existArray[j];
                j = j - 1;
            }
            existArray[j + 1] = key;
        }
        System.out.println(Arrays.toString(existArray));
    }

    public static int[] createAnArray(){
        int [] array = new int[4];
        Scanner sc = new Scanner(System.in);
        System.out.println("Please, input the first string: ");
        array[0] = sc.nextInt();
        System.out.println("Please, input the second string: ");
        array[1] = sc.nextInt();
        System.out.println("Please, input the third string: ");
        array[2] = sc.nextInt();
        System.out.println("Please, input the forth string: ");
        array[3] = sc.nextInt();

        return array;
    }
}
