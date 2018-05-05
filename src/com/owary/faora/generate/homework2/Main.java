/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.owary.faora.generate.homework2;

import java.util.Scanner;

/**
 *
 * @author OwaryLtd
 */
public class Main {

    public static void main(String[] args) {
        NFAAcceptorUtils.input( "0a12",
                                "0b1",
                                "1a2",
                                "1b",
                                "2a12",
                                "2b0");
        NFAAcceptorUtils.setInitial(0);
        NFAAcceptorUtils.setFinalStates(1,2);
        Scanner sc = new Scanner(System.in);
        while (true) {
            String scc = sc.next();
            NFAAcceptorUtils.checkString(scc);
        }
    }

}
