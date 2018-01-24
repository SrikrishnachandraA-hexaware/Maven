package com.hexaware.ftp15.util;
import java.util.Scanner;

import com.hexaware.ftp15.model.Employee;

/**
 * Class CliMain provides the command line interface to the leavemanagement
 * application.
 */
public class CliMain {
  private Scanner option = new Scanner(System.in, "UTF-8");

  private void mainMenu() {
    System.out.println("Leave Management System");
    System.out.println("-----------------------");
    System.out.println("1. List All Employees Info");
    System.out.println("2. Display Employee Info");
    System.out.println("3. Apply For Leave");
    System.out.println("4. Display Leave History");
    System.out.println("5. Display Pending Leave Application");
    System.out.println("6. Approve/Deny Leave Application");
    System.out.println("7. Exit");
    System.out.println("Enter your choice:");
    int menuOption = option.nextInt();
    mainMenuDetails(menuOption);
  }
  private void mainMenuDetails(final int selectedOption) {
    switch (selectedOption) {
      case 1:
        listEmployeesDetails();
        break;
      case 2:
        listEmployeeDetail();
        break;
      case 3:
        applyLeave();
        break;
      case 4:
        leaveHistory();
        break;
      case 5:
        pendingLeave();
        break;
      case 6:
        approveDeny();
        break;
      case 7:
        // halt since normal exit throws a stacktrace due to jdbc threads not responding
        Runtime.getRuntime().halt(0);
      default:
        System.out.println("Choose either 1, 2, 3, 4, 5, 6 or 7");
    }
    mainMenu();
  }
  private void listEmployeeDetail() {
    System.out.println("Enter an Employee Id");
    int empId = option.nextInt();
    Employee employee = Employee.listById(empId);
    if (employee == null) {
      System.out.println("Sorry, No such employee");
    } else {
      System.out.println(employee.toString());
    }
  }
  private void listEmployeesDetails() {
    Employee[] employee = Employee.listAll();
    for (Employee e : employee) {
      System.out.println(e.toString());
      }
  }
  private void applyLeave(){
    System.out.println("Enter the no.of days");
    int noOfDays = option.nextInt();
    System.out.println("Enter the start date");
    SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-mm-dd");
    String startDate = option.next();
    try {
      date1 = (Date) sdf1.parse(startDate);
    }
    catch(Exception e){
      System.out.println(e);
    }
    System.out.println("Enter the end date");
    SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-mm-dd");
    String endDate = option.next();
    try {
      date2 = (Date) sdf2.parse(endDate);
    }
    catch(Exception e){
      System.out.println(e);
    }
    String status = "Pending";
    System.out.println("Enter the reason");
    String reason = option.next();
    System.out.println("Enter the applied date");
    SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy-mm-dd");
    String appliedDate = option.next();
    try {
      date3 = (Date) sdf3.parse(appliedDate);
    }
    catch(Exception e){
      System.out.println(e);
    }
    System.out.println("Enter the employee id");
    int emplId = option.nextInt();
    //LeaveDetail ld = new LeaveDetail();
    //ld.setName
    String insert= LeaveDetails.applyLev(noOfDays,startDate,endDate,status,
     reason,appliedDate,emplId);
     
  }
  private void leaveHistory(){
    System.out.println("Enter the employee id");
    int emplId = option.nextInt();
    LeaveDetails[] leavehis = LeaveDetails.listHistory(emplId);
  }
  
  private void pendingLeave(){
    System.out.println("")
  }
  /**
   * The main entry point.
   * @param ar the list of arguments
   */
  public static void main(final String[] ar) {
    final CliMain mainObj = new CliMain();
    mainObj.mainMenu();
  }
}