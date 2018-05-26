/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.owary.faora.generate.homework4;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 *
 * @author OwaryLtd
 */
public class Main {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        FileInputStream fstream = new FileInputStream("file.txt");
        // Get the object of DataInputStream
        DataInputStream in = new DataInputStream(fstream);
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        String str; //the string read in
        
        while ((str = br.readLine()) != null) {
            System.out.println(str);
        }
    }
}
