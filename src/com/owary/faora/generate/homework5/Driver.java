/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.owary.faora.generate.homework5;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 *
 * @author OwaryLtd
 */
public class Driver {

    static int lenn = 0;

    public static void main(String[] args) {
//        Vertex S = new Vertex("S"),
//                A = new Vertex("A"),
//                T = new Vertex("T"),
//                B = new Vertex("B"),
//                C = new Vertex("C");
//
//        S.addProd(T, A);
//        S.addProd(B, A);
//        S.addProd(A, B);
//        S.addProd("b");
//        A.addProd(A, C);
//        A.addProd("a");
//        T.addProd(A, B);
//        B.addProd("b");
//        C.addProd("a");

        Vertex S = new Vertex("S"),
                A = new Vertex("A"),
                B = new Vertex("B");

        S.addProd(A, B);
        A.addProd(B, B);
        A.addProd("a");
        B.addProd(A, B);
        B.addProd("b");

        read(S, "file2.txt");

    }

    public static boolean generates(Vertex v, String input) {
        int len = input.length();
        boolean res = false;
        if (len <= 1 && v.canDerive(input)) {
            return true;
        } else {
            for (int i = 1; i < len; i++) {
                String str1 = input.substring(0, i);
                String str2 = input.substring(i, len);
                List<Vertex> vv = v.nonTermProductions;
                for (int kk = 0; kk < vv.size(); kk += 2) {
                    Vertex v1 = vv.get(kk);
                    Vertex v2 = vv.get(kk + 1);
                    boolean t1 = generates(v1, str1);
                    boolean t2 = generates(v2, str2);
                    res = t1 && t2;
                    if(res){return res;}
                }
            }
        }
        return res;
    }
    
    public static boolean generates1(Vertex v, String input) {
        int len = input.length();
        boolean res = false;
        if (len <= 1 && v.canDerive(input)) {
            return true;
        } else {
            for (int i = 1; i < len; i++) {
                String str1 = input.substring(0, i);
                String str2 = input.substring(i, len);
                List<Vertex> vv = v.nonTermProductions;
                for (int kk = 0; kk < vv.size(); kk += 2) {
                    Vertex v1 = vv.get(kk);
                    Vertex v2 = vv.get(kk + 1);
                    boolean t1 = generates1(v1, str1);
                    boolean t2 = generates1(v2, str2);
                    res = t1 && t2;
                    if(res){return res;}else{continue;}
                }
            }
        }
        return res;
    }

    public static void read(Vertex v, String filename) {
        try {
            FileInputStream fstream = new FileInputStream(filename);
            // Get the object of DataInputStream
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String str; //the string read in

            while ((str = br.readLine()) != null) {
                str = str.trim();
                boolean res = generates(v, str);
                System.out.printf("%s - %b\n", str, res);
            }
        } catch (FileNotFoundException fnfe) {
            System.out.println("File Not Found Exception");
        } catch (IOException io) {
            System.out.println("IO Exception");
        }
    }

}
