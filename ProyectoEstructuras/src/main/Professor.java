/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import java.util.Comparator;

/**
 *
 * @author Usuario
 */
public class Professor {
    private String name;
    private float score;
    
    public static final Comparator<Professor> BY_SCORE = new ByScore();
    
    public Professor() {
        
    }
    
    public Professor(String name, float score) {
        this.name = name;
        this.score = score;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public float getScore() {
        return score;
    }
    
    public void setScore(float score) {
        this.score = score;
    }
    

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Professor other = (Professor) obj;
        if (this.score != other.getScore()) {
            return false;
        }
        return this.name.equals(other.getName());
    }
    
    private static class ByScore implements Comparator<Professor> {
        @Override
        public int compare(Professor x, Professor y) {
            return x.getScore() < y.getScore() ? -1 : x.getScore() == y.getScore() ? 0 : 1;
        }
    }
}
