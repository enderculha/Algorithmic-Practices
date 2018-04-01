package datastructures.sorting;

public class MergeSort{

    public static void main(String[] args) {
        int[] arr = new int[]{9,7,6,83,1,2,5,4, 5};
        mergeSort(arr);
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i] + " ");
        }
    }

    public static void mergeSort(int[] arr){

        // base case
        if(arr.length<2)
            return;

        int middleInd = arr.length/2;

        int[] left = new int[middleInd];
        int[] right = new int[arr.length-middleInd];

        for(int i=0;i<middleInd;i++){
            left[i] = arr[i];
        }
        for(int i=middleInd;i<arr.length;i++){
            right[i-middleInd]=arr[i];
        }

        mergeSort(left);
        mergeSort(right);
        mergeHalves(left,right,arr);
    }

    public static void mergeHalves(int[] left, int[] right, int[] target){
        int leftInd = 0;
        int rightInd = 0;
        int targetInd = 0;

        while(leftInd<left.length && rightInd<right.length){
            if(left[leftInd]<right[rightInd]){
                target[targetInd] = left[leftInd];
                leftInd++;
                targetInd++;
            }else{
                target[targetInd] = right[rightInd];
                rightInd++;
                targetInd++;
            }
        }

        while(leftInd<left.length){
            target[targetInd] = left[leftInd];
            leftInd++;
            targetInd++;
        }
        while(rightInd<right.length){
            target[targetInd] = right[rightInd];
            rightInd++;
            targetInd++;
        }

    }

}
