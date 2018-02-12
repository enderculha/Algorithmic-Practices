package org.amazon.src;

import java.util.*;

/**
 * Created by lenovo on 11.02.2018.
 */
public class AutomataLabel {
    public static void main(String[] args) {
        List<String> tagList = new ArrayList<>(Arrays.asList("made", "in", "spain"));
        List<String> availableTagList = new ArrayList<>(Arrays.asList("en", "made", "in", "spain"));
        List<Integer> output = new AutomataLabel().labelProduct(tagList, availableTagList);

        for(Integer i :output){
            System.out.print(i + " ");
        }
    }

    public List<Integer> labelProduct(List<String> tagList, List<String>  availableTagList){
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
