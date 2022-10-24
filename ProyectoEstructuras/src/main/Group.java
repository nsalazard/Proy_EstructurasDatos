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
    private int availability;
    private Schedule schedule;
    private String courseName;
    
    public static final Comparator<Group> BY_SCORE = new ByScore();    
    public static final Comparator<Group> BY_AVAILABILITY = new ByAvailability();
    
    public Group() {
        
    }
    
    public Group(Professor professor, int availability, Schedule schedule, String courseName) {
        this.professor = professor;
        this.availability = availability;
        this.schedule = schedule;
        this.courseName = courseName;
    }
    
    public Professor getProfessor() {
        return professor;
    }
    
    public void setProfessor(Professor professor) {
        this.professor = professor;
    }
    
    public int getAvailability() {
        return availability;
    }
    
    public void setAvailability(int availability) {
        this.availability = availability;
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
    
    private static class ByAvailability implements Comparator<Group> {
        @Override
        public int compare(Group x, Group y) {
            return x.getAvailability() - y.getAvailability();
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
        if (this.availability != other.getAvailability()) {
            return false;
        }
        if (!this.courseName.equals(other.getCourseName())) {
            return false;
        }
        return this.schedule.equals(other.getSchedule());
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n\n\n").append(professor.toString()).append("\n");
        sb.append("Cupos: ").append(Integer.toString(availability));
        return sb.toString();
    }
}
