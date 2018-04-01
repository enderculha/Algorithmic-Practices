package datastructures.sorting;

public class InsertSort{

    public static void main(String[] args) {
        int[] arr = new int[]{9,3,6,2,7,4,8,5,1};
        insertSort(arr);
        for(int i=0;i<arr.length;i++)
            System.out.print(arr[i] + " ");
    }


    public static void insertSort(int[] arr){

        for(int i=1;i<arr.length;i++){
            int j = 0;
            while(i-j-1>=0 && arr[i-j]<arr[i-j-1]) {
                swap(arr, i-j , i-j-1);
                j++;
            }
        }
    }

    public static void swap(int[] arr, int sourceInd, int targetInd){
        int temp = arr[sourceInd];
        arr[sourceInd] = arr[targetInd];
        arr[targetInd] = temp;

    }
}

