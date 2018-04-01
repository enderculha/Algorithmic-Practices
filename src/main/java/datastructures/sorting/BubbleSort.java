package datastructures.sorting;

public class BubbleSort{

    public static void main(String[] args) {
        int[] arr = new int[]{3,2,8,7,10,1,4};

        int[] output = new BubbleSort().bubbleSort2(arr);
        System.out.println(output);

    }

    public int[] bubbleSort2(int[] arr){

        for(int j=0;j<arr.length;j++){
            for(int i=0;i<arr.length-j-1;i++){
                if(arr[i]>arr[i+1]){
                    arr = swap(arr, i, i+1);
                }
            }
        }
        return arr;

    }

    public int[] bubbleSort1(int[] arr){

        boolean isSorted = false;
        int lastSorted = arr.length-1;
        while(!isSorted){
            isSorted = true;
            for(int i=0;i<lastSorted;i++){
                if(arr[i]>arr[i+1]){
                    arr = swap(arr, i, i+1);
                    isSorted = false;
                }
            }
            lastSorted = lastSorted-1;
        }

        return arr;


    }

    private int[] swap(int[] arr, int index1, int index2){
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
        return arr;
    }

}