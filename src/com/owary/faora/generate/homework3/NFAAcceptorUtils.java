/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.owary.faora.generate.homework3;

import com.owary.faora.generate.homework2.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author OwaryLtd
 */
public class NFAAcceptorUtils {

    private String name;
    private Map<Integer, Map<Character, List<Integer>>> stateRelations;
    private List<Integer> finalStates;
    private Integer initial;
    private NFAAcceptor nfa;
    
    public NFAAcceptorUtils(String name){
        this.name = name;
    }
    
    public Map<Integer, Map<Character, List<Integer>>> input(String... relations) {
        // input'll be of the type [state][input][states]
        stateRelations = new HashMap<>();
        for (String str : relations) {
            str = str.toLowerCase();
            Integer state = Integer.parseInt(str.charAt(0)+"");
            char input = str.charAt(1);
            Integer[] arr = new Integer[str.length()-2];
            int i = 0;
            for (char c : str.substring(2).toCharArray()){
                arr[i] = Integer.parseInt(c+"");
                i++;
            }
            Map<Character, List<Integer>> foo = new HashMap<>();
            if(stateRelations.containsKey(state)){
                foo = stateRelations.get(state);
                foo.put(input, Arrays.asList(arr));
            }else{
                foo.put(input, Arrays.asList(arr));
            }
            stateRelations.put(state, foo);
        }
        return stateRelations;
    }
    
    private List<Integer> getAllStates(){
        List<Integer> res = new ArrayList<>();
        res.addAll(stateRelations.keySet());
        return res;
    }
    
    public void setFinalStates(Integer...finalState){
        finalStates = new ArrayList<>();
        List<Integer> list = Arrays.asList(finalState);
        finalStates.addAll(list);
    }
    
    public void setInitial(Integer i){
        initial = i;
    }
    
    public boolean checkString(String strToCheck){
        Character[] cArr = new Character[strToCheck.length()];
        char[] bar = strToCheck.toCharArray();
        for(int i=0;i<bar.length;i++){
            cArr[i] = bar[i];
        }
        
        nfa = new NFAAcceptor();
        boolean b = nfa.doesAccept(initial, cArr, 0, getAllStates(), finalStates, stateRelations);
        String accOrNo = b?"accepted":"not accepted";
        System.out.printf("NFA - [%s] : the string : %s is %s\n", this.name, strToCheck, accOrNo);
        return b;
    }
}
