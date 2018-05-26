/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.owary.faora.generate.homework4;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author OwaryLtd
 */
public class CYKParser {
    
    
    public static boolean parse(String input, Map<String, Vertice> vertices){
        char[] string = input.toCharArray();
        int len = string.length;
        
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
                        Vertice ver1 = vertices.get(s.charAt(0) + "");
                        Vertice ver2 = vertices.get(s.charAt(1) + "");
                        for (int k = i; k < j; k++) {
                            if (ver1.getGenerates(i, k) && ver2.getGenerates(k + 1, j)) {
                                vertices.get(key).generates(i, j);
                            }
                        }
                    }
                }
            }
        }
        return vertices.get("S").printGen();
    }
    
    public static void read(String filename,HashMap<String, Vertice> vertices){
        try{
        FileInputStream fstream = new FileInputStream(filename);
        // Get the object of DataInputStream
        DataInputStream in = new DataInputStream(fstream);
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        String str; //the string read in
        
        while ((str = br.readLine()) != null) {
            str = str.trim();
            boolean res = parse(str, vertices);
            System.out.printf("%s - %b\n", str, res);
        }
        }catch(FileNotFoundException fnfe){
            System.out.println("File Not Found Exception");
        }catch(IOException io){
            System.out.println("IO Exception");
        }
    }
    
//    public static void main(String[] args) {
//        Vertice S = new Vertice();
//        Vertice A = new Vertice();
//        Vertice T = new Vertice();
//        Vertice B = new Vertice();
//        Vertice C = new Vertice();
//        
//        S.addProd(new String[]{"TA", "BA", "AB", "b"});
//        A.addProd(new String[]{"AC", "a"});
//        T.addProd(new String[]{"AB"});
//        B.addProd(new String[]{"b"});
//        C.addProd(new String[]{"a"});
//
//        HashMap<String, Vertice> vertices = new HashMap<>();
//        vertices.put("S", S);
//        vertices.put("A", A);
//        vertices.put("T", T);
//        vertices.put("B", B);
//        vertices.put("C", C);
//
//        read("file1.txt", vertices);
//        
//    }
    
    
    
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

        read("file2.txt", vertices);
        
    }
}
