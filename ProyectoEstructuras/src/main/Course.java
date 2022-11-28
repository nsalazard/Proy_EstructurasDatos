/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import java.util.Comparator;
import structures.DynamicArray;

/**
 *
 * @author Juan carlos
 */
public class Course {
    private String name;
    private DynamicArray<Group> groups;
    private final Schedule selected_schedule;
    private final Comparator<Group> comparator;
    private static final Comparator<Group> BY_DEFAULT = new ByDefault();
    private final Comparator<Group> BY_SCHEDULE;

    public Course() {
        name = null;
        selected_schedule = null;
        comparator = BY_DEFAULT;
        BY_SCHEDULE = null;
        groups = new DynamicArray<>();
    }
    
    public Course(String name) {
        this.name = name;
        selected_schedule = null;
        comparator = BY_DEFAULT;
        BY_SCHEDULE = null;
        groups = new DynamicArray<>();
    }
    
    public Course(String name, Schedule selected_schedule) {
        this.name = name; 
        this.selected_schedule = selected_schedule;
        BY_SCHEDULE = new BySchedule();
        comparator = BY_SCHEDULE;
        groups = new DynamicArray<>();
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public DynamicArray<Group> getGroups() {
        return groups;
    }
    
    public void setGroups(DynamicArray<Group> groups) {
        this.groups = groups;
    }
    
    public void append(Group group) {
        groups.pushBack(group);
    }
    
    public void sort() {
        groups.sort(comparator);
    }
    
    private static class ByDefault implements Comparator<Group> {
        @Override
        public int compare(Group x, Group y) {
            if (x.getAvailability() != 0 && y.getAvailability() != 0) {
                if (Group.BY_SCORE.compare(x, y) != 0) {
                    return Group.BY_SCORE.compare(x,y);
                }
            }
            return Group.BY_AVAILABILITY.compare(x,y);
        }
    }
    
    private class BySchedule implements Comparator<Group> {
        @Override
        public int compare(Group x, Group y) {
            if (x.getAvailability() != 0 && y.getAvailability() != 0) {
                boolean[] weekx = new boolean[7];
                boolean[] weeky = new boolean[7];
                weekx[0] = (x.getSchedule().getMonday() == 0 || (x.getSchedule().getMonday()&selected_schedule.getMonday()) != 0);
                weekx[1] = (x.getSchedule().getTuesday() == 0 || (x.getSchedule().getTuesday()&selected_schedule.getTuesday()) != 0);
                weekx[2] = (x.getSchedule().getWednesday() == 0 || (x.getSchedule().getWednesday()&selected_schedule.getWednesday()) != 0);
                weekx[3] = (x.getSchedule().getThursday() == 0 || (x.getSchedule().getThursday()&selected_schedule.getThursday()) != 0);
                weekx[4] = (x.getSchedule().getFriday() == 0 || (x.getSchedule().getFriday()&selected_schedule.getFriday()) != 0);
                weekx[5] = (x.getSchedule().getSaturday() == 0 || (x.getSchedule().getSaturday()&selected_schedule.getSaturday()) != 0);
                weekx[6] = (x.getSchedule().getSunday() == 0 || (x.getSchedule().getSunday()&selected_schedule.getSunday()) != 0);
                weeky[0] = (x.getSchedule().getMonday() == 0 || (y.getSchedule().getMonday()&selected_schedule.getMonday()) != 0);
                weeky[1] = (x.getSchedule().getTuesday() == 0 || (y.getSchedule().getTuesday()&selected_schedule.getTuesday()) != 0);
                weeky[2] = (x.getSchedule().getWednesday() == 0 || (y.getSchedule().getWednesday()&selected_schedule.getWednesday()) != 0);
                weeky[3] = (x.getSchedule().getThursday() == 0 || (y.getSchedule().getThursday()&selected_schedule.getThursday()) != 0);
                weeky[4] = (x.getSchedule().getFriday() == 0 || (y.getSchedule().getFriday()&selected_schedule.getFriday()) != 0);
                weeky[5] = (x.getSchedule().getSaturday() == 0 || (y.getSchedule().getSaturday()&selected_schedule.getSaturday()) != 0);
                weeky[6] = (x.getSchedule().getSunday() == 0 || (y.getSchedule().getSunday()&selected_schedule.getSunday()) != 0);
                for (int i=0;i<7;i++) {
                    if (weekx[i] && !weeky[i]) {
                        return -1;
                    }
                    if (weeky[i] && !weekx[i]) {
                        return 1;
                    }
                }
                if (Group.BY_SCORE.compare(x, y) != 0) {
                    return -1*Group.BY_SCORE.compare(x,y);
                }
            }
            return -1*Group.BY_AVAILABILITY.compare(x,y);
        }
    }
}
