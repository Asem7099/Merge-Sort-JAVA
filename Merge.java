package merge;
public class Merge {
    public static void Divide(int arr[], int size) {
        if (size < 2) {
            return;
        }
        int mid = size / 2;
        int arr1[] = new int[mid];
        int arr2[] = new int[size - mid];
        for (int i = 0; i < mid; i++) {
            arr1[i] = arr[i];
        }
        for (int j = mid; j < size; j++) {
            arr2[j - mid] = arr[j];
        }
        Divide(arr1, mid);
        Divide(arr2, size - mid);
        Merge(arr, arr1, arr2, mid, size - mid);
    }
    public static void Merge(int arr[], int arr1[], int arr2[], int mid, int size) {
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < mid && j < size) {
            if (arr1[i] < arr2[j]) {
                arr[k++] = arr1[i++];
            } else {
                arr[k++] = arr2[j++];
            }
        }
        while (i < mid) {
            arr[k++] = arr1[i++];
        }
        while (j < size) {
            arr[k++] = arr2[j++];
        }
    }
    public static void main(String[] args) {
        int[] array = {25, 44, 56, 87, 10, 16, 22,90};
        Divide(array, array.length);
        for (int i = 0; i < array.length; i++) {
            System.out.print(+array[i] + "  ");
        }
    }
}
