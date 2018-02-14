package org.amazon.src;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class AutomataLabel {
    public static void main(String[] args) {
        List<String> tagList = new ArrayList<>(Arrays.asList("in", "the", "spain"));
        List<String> availableTagList = new ArrayList<>(Arrays.asList("in","the", "spain"));
        List<Integer> output = new AutomataLabel().labelProductEfficient(tagList, availableTagList);

        for(Integer i :output){
            System.out.print(i + " ");
        }
    }

    public List<Integer> labelProductEfficient(List<String> tagList, List<String>  availableTagList){
        int[] store = new int[tagList.size()];
        int startInd = 0;
        int endInd = Integer.MAX_VALUE;
        int minDistance = Integer.MAX_VALUE;
        for(int i=0;i<availableTagList.size();i++){
            String aTag = availableTagList.get(i);
            for(int j=0; j<tagList.size();j++){
                String tag = tagList.get(j);
                if(aTag.equalsIgnoreCase(tag)){
                    store[j] = store[j] + 1;
                }
            }
            if(checkStoreArray(store)) {
                if (i - startInd < minDistance) {
                    minDistance = i - startInd;
                    endInd=i;
                    //remove from store if exist
                    String extract = availableTagList.get(startInd);
                    for (int j = 0; j < tagList.size(); j++) {
                        String tag = tagList.get(j);
                        if (extract.equalsIgnoreCase(tag)) {
                            store[j] =store[j]-1;
                        }
                    }
                    // increment startInd
                    startInd++;
                }else {
                    break;
                }

            }
        }

        return new ArrayList<>(Arrays.asList(--startInd, endInd));
    }

    private boolean checkStoreArray(int[] store) {
        for(int i=0;i<store.length;i++){
            if(store[i]<1){
                return false;
            }
        }
        return true;
    }


    public List<Integer> labelProductBruteForce(List<String> tagList, List<String>  availableTagList){
        int startInd = 0;
        int endInd = 0;
        int distance = Integer.MAX_VALUE;
        List<Integer> store = null;
        for(int i=0;i<availableTagList.size();i++){
            for(int j=0;j<tagList.size();j++){
                String tag = tagList.get(j);
                String aTag = availableTagList.get(i);
                if(tag.equalsIgnoreCase(aTag)){
                    startInd = i;
                    endInd = findEndIndex(tagList, availableTagList, startInd+1, j);
                    if(endInd-startInd<distance && endInd!=Integer.MAX_VALUE){
                        distance = endInd-startInd;
                        store = new ArrayList<>(Arrays.asList(startInd,endInd));
                    }
                }
            }
        }
        return store!=null?store:new ArrayList<Integer>(Arrays.asList(0));
    }

    private static int findEndIndex(List<String> tagList, List<String> availableTagList, int startInd, int removeInd) {
        List<String> newTagList = new ArrayList<>();
        for(int i=0;i<tagList.size();i++){
            if(i!=removeInd){
                newTagList.add(tagList.get(i));
            }
        }
        int tagSize = newTagList.size();
        Set<String> uniqueMap = new HashSet<>();
        for(int i=startInd;i<availableTagList.size();i++){
            for(int j=0;j<newTagList.size();j++){
                String atag = availableTagList.get(i);
                String tag = (newTagList.get(j));
                if(atag.equalsIgnoreCase(tag)){
                    if(!uniqueMap.contains(tag)){
                        tagSize--;
                        uniqueMap.add(tag);
                    }
                }
            }
            if(tagSize==0){
                return i;
            }

        }
        return Integer.MAX_VALUE;
    }
}
