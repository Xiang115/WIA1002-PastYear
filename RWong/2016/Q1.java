/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PYQ2016;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author HP
 */
public class Q1 {
    public static void main(String[] args){
        String[] days={"Sunday","Monday","Tuesday","Wednesday","Thursday",
        "Friday","Saturday"};
        Day<String> calendar=new Day(days);
        calendar.display();
        
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        System.out.println("The name of the day is : "+calendar.getDay(a));
        System.out.println("The following day of "+calendar.getDay(a)+" is : "+calendar.getnextday(a));
        System.out.println("The previous day of "+calendar.getDay(a)+" is : "+calendar.getprevday(a));
        
        System.out.print("How many days to add to the specified/current day ("+calendar.getDay(a)+")? : ");
        int input=sc.nextInt();
        System.out.println("The new day after the addition of "+input+" day(s) is : "
                +calendar.getnumofdaysahead(a, input));
    }
}

class Day<String>{
    ArrayList<String> day;
    
    public Day(){
        day=new ArrayList<>();
    }
    
    public Day(String[] daynames){
        day=new ArrayList<>();
        for(String dayname:daynames){
            day.add(dayname);
        }
    }
    
    public int getSize(){
        return day.size();
    }
    
    public String getDay(int i){
        return day.get(i%7);
    }
    
    public String getprevday(int i){
        return day.get((i-1)%7);
    }
    
    public String getnextday(int i){
        return day.get((i+1)%7);
    }
    
    public String getnumofdaysahead(int before,int add){
        int total=before+add;
        return day.get(total%7);
    }
    
    public void display(){
        System.out.println("Specify your day in number:");
        for(int i=1;i<=7;i++){
            System.out.println(i+" for "+getDay(i));
        }
    }
}