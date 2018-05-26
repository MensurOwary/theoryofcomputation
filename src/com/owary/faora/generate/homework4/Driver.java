/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.owary.faora.generate.homework4;

import java.util.*;

/**
 *
 * @author OwaryLtd
 */
public class Driver {

    public static void main(String[] args) {
        Vertice S = new Vertice(), 
                A = new Vertice(),
                B = new Vertice();
        S.addProd(new String[]{"AB"});
        A.addProd(new String[]{"BB", "a"});
        B.addProd(new String[]{"AB", "b"});

        HashMap<String, Vertice> vertices = new HashMap<>();
        vertices.put("A", A);
        vertices.put("B", B);
        vertices.put("S", S);

        List<Vertice> vt = new ArrayList<>(vertices.values());
        char[] string = "aab".toCharArray();
        final int len = string.length;

        vertices.forEach((k, v) -> {
            v.initGen(len+1);
        });

        for (int i = 0; i < string.length; i++) {
            final int ii = i;
            vertices.forEach((k, v) -> {
                if (v.contains(string[ii])) {
                    v.generates(ii, ii);
                }
            });
        }

        for (int j = 1; j <= len; j++) {
            for (int i = j-1; i >= 0 ; i--) {
                for (Map.Entry<String, Vertice> entry : vertices.entrySet()) {
                    String key = entry.getKey();
                    Vertice value = entry.getValue();
                    for (String s : value.getCompounds()) {
                        String v1 = s.charAt(0) + "";
                        String v2 = s.charAt(1) + "";
                        Vertice ver1 = vertices.get(v1);
                        Vertice ver2 = vertices.get(v2);
                        for (int k = i; k < j; k++) {
                            if (ver1.getGenerates(i, k) && ver2.getGenerates(k + 1, j)) {
                                vertices.get(key).generates(i, j);
                            }
                        }
                    }
                }
            }
        }
        vertices.get("S").printGen();
    }

}

