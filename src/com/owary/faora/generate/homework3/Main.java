/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.owary.faora.generate.homework3;

/**
 *
 * @author OwaryLtd
 */
public class Main {

    public static void main(String[] args) {
        NFAAcceptorUtils nfa1 = new NFAAcceptorUtils("Exactly 2 a's");
        nfa1.input( "0a1",
                    "0b0",
                    "1a2",
                    "1b1",
                    "2a3",
                    "2b2",
                    "3a3",
                    "3b3");
        nfa1.setInitial(0);
        nfa1.setFinalStates(2);
        
        NFAAcceptorUtils nfa2 = new NFAAcceptorUtils("At least 2 b's");
        nfa2.input( "0a0",
                    "0b1",
                    "1a1",
                    "1b2",
                    "2a2",
                    "2b2");
        nfa2.setInitial(0);
        nfa2.setFinalStates(2);
        
        AutomataIntersection.doesIntersectCLI(nfa1, nfa2);
    }
}
