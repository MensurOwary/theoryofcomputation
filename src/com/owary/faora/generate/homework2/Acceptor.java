/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.owary.faora.generate.homework2;

import java.util.List;
import java.util.Map;

/**
 *
 * @author OwaryLtd
 */
public interface Acceptor { 
    boolean isMemberOf(List<Integer> finalStates, Integer i);
    List<Integer> delta(Integer state, Character input, Map<Integer, Map<Character, List<Integer>>> stateRelations);
    boolean deltaStarTransition(Integer state, Character input, Integer finalState, Map<Integer, Map<Character, List<Integer>>> stateRelations);
    boolean doesAccept(Integer initialState, Character[] cArr, int n, List<Integer> allStates, List<Integer> finalStates, Map<Integer, Map<Character, List<Integer>>> stateRelations);
}
