package datastructures.sorting;

public class SelectionSort{

    public static void main(String[] args) {
        int[] arr = new int[]{9,3,6,2,7,4,8,5,1};
        selectSort(arr);
        for(int i=0;i<arr.length;i++)
            System.out.print(arr[i] + " ");
    }

    public static void selectSort(int[] arr){
        int unsortedInd =0;

        while(unsortedInd<arr.length){
            int smallInd = unsortedInd;
            smallInd = findSmallestValueIndex(arr, unsortedInd);
            swap(arr,smallInd,unsortedInd);
            unsortedInd++;
        }

    }

    public static int findSmallestValueIndex(int[] arr, int start){
        int smallestVal = Integer.MAX_VALUE;
        int smallestInd = 0;
        for(int i=start;i<arr.length;i++){
            if (arr[i] < smallestVal) {
                smallestVal = arr[i];
                smallestInd = i;
            }
        }
        return smallestInd;
    }

    public static void swap(int[] arr, int smallInd, int targetInd){
        int temp = arr[smallInd];
        arr[smallInd] = arr[targetInd];
        arr[targetInd] = temp;
    }
}
