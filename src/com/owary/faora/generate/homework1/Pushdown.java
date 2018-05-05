/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.owary.faora.generate.homework1;

import java.util.*;

/**
 *
 * @author OwaryLtd
 */
public class Pushdown {
    
    static Set<String> set = new HashSet<>();
    
    public static void init(int k, String[] p){
        pushdown(p[0], k-2, p);
        pushdown(p[1], k-2, p);
        pushdown(p[2], k-2, p);
    }
    
    public static void pushdown(String s, int k,String[] p){
        if(k==0){
            set.add(s.replace("S", ""));
        }
        else{
            pushdown(s.replace("S", p[0]), k-2, p);
            pushdown(s.replace("S", p[1]), k-2, p);
            pushdown(s.replace("S", p[2]), k-2, p);
        }
    }
    
    public static void main(String[] args) {
        init(6, new String[]{"aSa","bSb","cSc",""});
        for (String string : set) {
            System.out.println(string);
        }
    }
    
}
