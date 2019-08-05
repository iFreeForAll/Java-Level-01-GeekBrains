import java.sql.SQLOutput;
import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {6, 5, 1, 3, 9};
        System.out.println("Initial array: " + Arrays.toString(arr));
        System.out.print("Bubble sorted array: ");
        bubbleSort(arr);

    }
    // This method does a bubble sort algorithm
    public static void bubbleSort(int arr[]) {
        for (int i = 0; i < arr.length - 1; i++) { // we go through the each element of the array
            //so basically, here we find the biggest element in the array
            //put it in the last position, and then forget about it
            //because we have j < arr.length - 1 - i, so the last element will not be checked
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}