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
public class Group {
    private Professor professor;
    private Schedule schedule;
    private String courseName;
    
    public static final Comparator<Group> BY_SCORE = new ByScore();
    
    public Group() {
        
    }
    
    public Group(Professor professor, Schedule schedule, String courseName) {
        this.professor = professor;
        this.schedule = schedule;
        this.courseName = courseName;
    }
    
    public Professor getProfessor() {
        return professor;
    }
    
    public void setProfessor(Professor professor) {
        this.professor = professor;
    }
    
    public Schedule getSchedule() {
        return schedule;
    }
    
    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }
    
    public String getCourseName() {
        return courseName;
    }
    
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
    
    private static class ByScore implements Comparator<Group> {
        @Override
        public int compare(Group x, Group y) {
            return Professor.BY_SCORE.compare(x.getProfessor(), y.getProfessor());
        }
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == null) {
            return false;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Group other = (Group)obj;
        if (!this.professor.equals(other.getProfessor())) {
            return false;
        }
        if (!this.courseName.equals(other.getCourseName())) {
            return false;
        }
        return this.schedule.equals(other.getSchedule());
    }
}
