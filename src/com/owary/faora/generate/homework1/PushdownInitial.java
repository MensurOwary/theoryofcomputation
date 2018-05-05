/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.owary.faora.generate.homework1;


/**
 *
 * @author OwaryLtd
 */
public class PushdownInitial {
    
    public static boolean isOdd(int a){return a%2==1;}

    public static void pushdown(String s, int k){
        if(isOdd(k)){throw new RuntimeException("Length cannot be an odd number!");}
        if(k==0) {System.out.println("\""+s+"\"");}
        else{
            System.out.println("\""+s+"\"");
            pushdown('a'+s+'a', k-2);
            pushdown('b'+s+'b', k-2);
        }
    }
    public static void main(String[] args){
        pushdown("", 6);
    }
    
}
