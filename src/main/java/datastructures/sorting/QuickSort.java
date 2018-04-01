package datastructures.sorting;

public class QuickSort{

    public static void main(String[] args) {
        int[] arr = new int[]{2,1,3,4,8,5,7,6};
        quickSort(arr);
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i] + " ");
        }
    }

    public static void quickSort(int[] arr){
        quickSortRecursive(arr, 0, arr.length-1);
    }

    public static void quickSortRecursive(int[] arr, int start, int end){

        if(start>=end)
            return;
        int indexPartition = partition(arr, start, end);

        quickSortRecursive(arr, 0, indexPartition-1);
        quickSortRecursive(arr, indexPartition+1, end);

    }

    public static int partition(int []arr, int start, int end){
        int pivot = arr[end];
        int partInd = start;

        for(int i=start;i<end;i++){
            if(arr[i]<=pivot){
                swap(arr, i , partInd);
                partInd++;
            }
        }
        swap(arr, partInd, end);
        return partInd;
    }

    public static void swap(int[] arr, int index1, int index2){
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

}
