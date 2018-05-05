/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.owary.faora.generate.homework3;

import java.util.Scanner;

/**
 *
 * @author OwaryLtd
 */
public class AutomataIntersection {
    
    public static boolean doesIntersect(NFAAcceptorUtils nfa1, NFAAcceptorUtils nfa2, String input){
        return nfa1.checkString(input) && nfa2.checkString(input);
    }
    
    public static void doesIntersectCLI(NFAAcceptorUtils nfa1, NFAAcceptorUtils nfa2){
        Scanner sc = new Scanner(System.in);
        while(true){
            String str = sc.next();
            if(str.equals("exit")){
                System.out.println("Terminated");
                break;
            }
            if(doesIntersect(nfa1, nfa2, str)){
                System.out.println("Accepted");
            }else{
                System.out.println("Not Accepted");
            }
        }
    }
}
