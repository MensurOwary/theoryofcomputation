/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.owary.faora.generate.homework5;

import java.util.*;

/**
 *
 * @author OwaryLtd
 */
public class Vertex {
    
    String name;
    List<Vertex> nonTermProductions;
    List<String> termProductions;
    
    public Vertex(String name){
        this.name = name;
        nonTermProductions=new ArrayList<>();
        termProductions = new ArrayList<>();
    }
    
    public void addProd(Vertex a, Vertex b){
        nonTermProductions.add(a);nonTermProductions.add(b);
    }
    
    public void addProd(String a){
        termProductions.add(a);
    }
    
    public boolean canDerive(String input){
        return termProductions.contains(input);
    }
    
    @Override
    public String toString(){
        return name;
    }
    
}
