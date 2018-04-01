package datastructures.sorting;

public class BinarySearch{

    public boolean binarySearch(int searchValue, int[] arr){
        return binarySearchRecursively(arr, searchValue, 0, arr.length-1);
    }

    public boolean binarySearchRecursively(int[] arr, int searchValue, int start, int end){
        //base value
        if(start>end)
            return false;

        int middleInd = start + (end-start)/2;

        if(arr[middleInd]==searchValue){
            return true;
        } else if(arr[middleInd] < searchValue){
            return binarySearchRecursively(arr, searchValue, start, middleInd-1);
        } else{
            return binarySearchRecursively(arr,searchValue, middleInd+1, end);
        }
    }

    public boolean binarySearchIteratively(int[] arr, int searchValue){

        int start = 0;
        int end = arr.length-1;

        while(start<end){
            int middleInd = (start+end)/2;

            if(arr[middleInd] == searchValue){
                return true;
            } else if(arr[middleInd]<searchValue){
                start = middleInd +1;
            } else{
                end = middleInd-1;
            }
        }
        return false;


    }

}