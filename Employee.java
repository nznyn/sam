package com.componentwise.eval;

import java.util.*;
import java.lang.*;
import java.io.*;

public class Employee{

    private String name;
    private int id;
    private Boolean managerFlag;
    Date dateHired = new Date();

    //Employee constructor
    public Employee(String name, int id, Boolean managerFlag, Date dateHired){
        this.name = name;
        this.id = id;
        this.managerFlag = managerFlag;
        this.dateHired = dateHired;
    }

    //Below are getter methods for "Employee"
    public String getName(){
        return name;
    }

    public int getID(){
        return id;
    }

    public Boolean isManager(){
        return managerFlag;
    }

    public Date getDate(){
        return dateHired;
    }

    //Method to print employees and save space in main
    public static void printEmployees(Employee x){

        System.out.println("Name: " + x.getName());
        System.out.println("Employee ID: " + x.getID());
        System.out.print("Manager: ");
        if(x.isManager()){
            System.out.println("Yes");
        }
        else
            System.out.println("No");
        //Less tidy formatting for date
        //System.out.println("Date Hired: " + no1.getDate());

        //Casting object method invocation to String
        //and Combining the simplified date information into new String
        String strDate = x.getDate().toString();
        String nDate = strDate.substring(4, 10) + " " + strDate.substring(24);
        System.out.println("Date Hired: " + nDate);        
        //Checking if Employee is Part Time
        if(x instanceof PartTimeEmployee)
            System.out.println("Status: Part Time Employee");
        System.out.println();

    }

    public static void main (String[] args) throws java.lang.Exception{

        Date date = new Date();

        //If changed to a number less than 40
        //information for part time employee will be displayed
        int hoursWorked = 40;

        //Set to null for personal purposes, I was unsure
        //Of how to set things up aside from the given template
        Employee numberOne = null;
        PartTimeEmployee numberTwo = null;

        if(hoursWorked >= 40){
        //Employee object receives parameters "name", "ID", "manager status" and "date"
            numberOne = new Employee("Nicholas", 100, true, date);
            printEmployees(numberOne);
        }
        else if(hoursWorked < 40){
        //PartTimeEmployee receives an additional parameter "hours worked"
            numberTwo = new PartTimeEmployee("Greg", 1000, false, date, 30);
                 printEmployees(numberTwo);
        }
    }
}
//Class for PartTimeEmployee includes hours worked
//The main difference between part time and full time
class PartTimeEmployee extends Employee{

    public int hoursWorked;

    public PartTimeEmployee(String name, int id, Boolean managerFlag, Date dateHired, int hoursWorked){
        super(name, id, managerFlag, dateHired);
        this.hoursWorked = hoursWorked;
    }

    public int getHoursWorked(){
        return hoursWorked;
    }    

}