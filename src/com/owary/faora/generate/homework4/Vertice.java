/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.owary.faora.generate.homework4;

import java.util.*;
import java.util.stream.Collectors;

/**
 *
 * @author OwaryLtd
 */
public class Vertice {
   
    private List<String> productions;
    private boolean[][] generated;
    
    public Vertice(){
        productions=new ArrayList<>();
    }
    
    public void addProd(String[] prod){
        productions.addAll(Arrays.asList(prod));
    }
    
    public boolean contains(char input){
        return this.productions.contains(input+"");
    }
    
    public void generates(int i, int j){
        generated[i][j]=true;
    }
    
    public void initGen(int size){
        generated = new boolean[size][size];
    }
    
    public List<String> getCompounds(){
        return this.productions.stream().filter((String p)->{
            return p.matches("[A-Z]+");
        }).collect(Collectors.toList());
    }
    
    public boolean getGenerates(int i, int j){
        return generated[i][j];
    }
    
    public boolean[][] get(){
        return generated;
    }
    
    public boolean printGen(){
//        System.out.println("ans : "+generated[0][generated[0].length-2]);
        return generated[0][generated[0].length-2];
    }
    
}
