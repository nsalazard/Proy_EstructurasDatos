package main;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Juan carlos
 */
public class Procesador {
    public Procesador(String str) {
        String[] lstr = str.split(" ");
        int i, hour = 0;
        boolean[] day = new boolean[7];
        String name;
        for (i=0;i<lstr.length;i++) {
            if (lstr[i].toLowerCase().contains("coursename"));
                break;
        }
        name = lstr[++i];
        for (;i<lstr.length;i++) {
            if (lstr[i].contains("-")) {
                day[Integer.parseInt(lstr[i].substring(0,1))] = true;
                day[Integer.parseInt(lstr[i].substring(2,3))] = true;
            }
        }
        for (++i;i<lstr.length;i++) {
            if (lstr[i].contains("-")) {
                String[] hours = lstr[i].split("-");
                for (int j=Integer.parseInt(hours[0]);j<Integer.parseInt(hours[1]);j++) {
                    hour |= (1<<j);
                }
                break;
            }
        }
        Course course = new Course(name, new Schedule(
                day[0] ? hour : 0 ,    
                day[1] ? hour : 0 ,   
                day[2] ? hour : 0 ,   
                day[3] ? hour : 0 ,   
                day[4] ? hour : 0 ,   
                day[5] ? hour : 0 ,   
                day[6] ? hour : 0 
        ));
        
        for (++i;i<lstr.length;i++) {
            String pname;
            int score;
            int available;
            for (int j=i;j<lstr.length;i++) {
                i = j;
                if (lstr[i].toLowerCase().contains("profesor"));
                    break;
            }
            pname = lstr[++i];
            i++;
            for (int j=i;j<lstr.length;i++) {
                i = j;
                if (lstr[i].toLowerCase().contains("score"));
                    break;
            }
            score = Integer.parseInt(lstr[++i]);
            i++;
            for (int j=i;j<lstr.length;i++) {
                i = j;
                if (lstr[i].toLowerCase().contains("cupos"));
                    break;
            }
            available = Integer.parseInt(lstr[++i]);
            i++;
            for (int j=i;j<lstr.length;j++) {
                i = j;
                if (lstr[j].contains("-")) {
                    day[Integer.parseInt(lstr[j].substring(0,1))] = true;
                    day[Integer.parseInt(lstr[j].substring(2,3))] = true;
                }
            }
            for (int j=++i;j<lstr.length;j++) {
                i = j;
                if (lstr[j].contains("-")) {
                    String[] hours = lstr[j].split("-");
                    for (int k=Integer.parseInt(hours[0]);j<Integer.parseInt(hours[1]);k++) {
                        hour |= (1<<k);
                    }
                    break;
                }
            }
            course.append(new Group(new Professor(pname,score),available,new Schedule(
                    day[0] ? hour : 0 ,    
                    day[1] ? hour : 0 ,   
                    day[2] ? hour : 0 ,   
                    day[3] ? hour : 0 ,   
                    day[4] ? hour : 0 ,   
                    day[5] ? hour : 0 ,   
                    day[6] ? hour : 0 
            ),name));
        }
        course.sort();
    }
}
