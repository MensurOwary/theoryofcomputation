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
public class GeneralizedPushdown {

    static Set<String> set = new HashSet<>();
    
    /* Returns the length of the string without Non-Terminals */
    public static int len(String s) {
        int i = 0;
        for (Character c : s.toCharArray()) {
            if (!(c >= 65 && c <= 90)) {
                i++;
            }
        }
        return i;
    }
    /* Remove the capital letter */    
    public static String replaceWithLambda(String s) {
        String res = "";
        for (Character c : s.toCharArray()) {
            if (!(c >= 65 && c <= 90)) {
                res += c;
            }
        }
        return res;
    }
    
    /* Code */    
    public static void pushdown(String s, int k, Map<Character, String[]> prodRules) {
        // base case; if the desired length is zero print the string
        if (k == 0) {
            System.out.println(replaceWithLambda(s));
        } else {
            // traverse the production rules prodRules map
            for (Map.Entry<Character, String[]> entry : prodRules.entrySet()) {
                Character key = entry.getKey();
                String[] value = entry.getValue();
                // traverse through the prodRules of the specific vertex
                for (int i = 0; i < value.length; i++) {
                    // compute how much the added characters will add to the general string
                    int kk = len(value[i]);
                    // replace the Vertex with the derivated string
                    String rep = s.replace(key + "", value[i]);
                    // for evading the error
                    if (!rep.equals(s)) {
                        // repeat
                        pushdown(s.replace(key + "", value[i]), k - kk, prodRules);
                    }
                }
            }
        }
    }
    
    // initialization
    public static void init(int k, Map<Character, String[]> prodRules) {
        // start state
        String[] start = prodRules.get('S');
        // possible combinations
        for (String s : start) {
            pushdown(s, k - len(s), prodRules);
        }
    }

    public static void main(String[] args) {
        Map<Character, String[]> prodRules = new HashMap<>();
        prodRules.put('S', new String[]{"aSa", "bAb", "Bab", ""});
        prodRules.put('A', new String[]{"aA", ""});
        prodRules.put('B', new String[]{"b", ""});
        init(2, prodRules);
    }

}
