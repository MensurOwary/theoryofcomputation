package com.owary.faora.generate.homework2;

import java.util.*;

/**
 *
 * @author OwaryLtd
 */
public class NFAAcceptor implements Acceptor {

    @Override
    public boolean isMemberOf(List<Integer> finalStates, Integer i) {
        return finalStates.indexOf(i) != -1;
    }

    @Override
    public List<Integer> delta(Integer state, 
                               Character input, 
                               Map<Integer, Map<Character, List<Integer>>> stateRelations) {
        Map<Character, List<Integer>> list = stateRelations.get(state);
        for (Map.Entry<Character, List<Integer>> entry : list.entrySet()) {
            Character key = entry.getKey();
            List<Integer> value = entry.getValue();
            if (key.equals(input)) {
                return value;
            }
        }
        return new ArrayList<>();
    }

    @Override
    public boolean deltaStarTransition(Integer state, 
                                       Character input, 
                                       Integer finalState, 
                                       Map<Integer, Map<Character, List<Integer>>> stateRelations) {
        
        List<Integer> list = delta(state, input, stateRelations);
        return list.contains(finalState);
    }

    @Override
    public boolean doesAccept(
            Integer initialState,
            Character[] cArr,
            int n,
            List<Integer> allStates,
            List<Integer> finalStates,
            Map<Integer, Map<Character, List<Integer>>> stateRelations) {
        
        if (n == cArr.length) {
            return isMemberOf(finalStates, initialState);
        }
        allStates = delta(initialState,cArr[n],stateRelations);
        for (Integer i : allStates) {
            int m = n;m++;
            if (deltaStarTransition(initialState, cArr[n], i, stateRelations) && 
                doesAccept(i, cArr, m, allStates, finalStates, stateRelations)) {
                return true;
            }
        }
        return false;
    }

}
