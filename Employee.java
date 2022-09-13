public class Employee package com.ideas2it.employeeManagement.model;

        import java.util.Date;
        import java.util.List;

        import com.ideas2it.projectManagement.model.Project;

/**
 * Pojo Class Containing Employee Details
 *
 * @version 2.1 21 April 2021
 * @author Sembiyan
 */
public class Employee {

    private int id;
    private String name;
    private float salary;
    private String mobileNumber;
    private Date dateOfBirth;
    private List<Project> projects;
    private List<Address> addresses;
    private boolean isDeleted;

    public Employee() { }

    public Employee(int id, String name, float salary, String mobileNumber,
                    Date dateOfBirth, boolean isDeleted, List<Address> addresses) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.mobileNumber = mobileNumber;
        this.dateOfBirth = dateOfBirth;
        this.isDeleted = isDeleted;
        this.addresses = addresses;
    }

    public String toString() {
        String listOfAddress = "";
        if (0 != addresses.size()) {
            for (Address address : addresses) {
                listOfAddress = listOfAddress + address.toString()
                        + "\n                  ";
            }
        } else {
            listOfAddress = listOfAddress + "no addresses present";
        }
        return ("\nEmployee ID: " + id + "\n\nEmployee name: " + name
                + "\n\nEmployee salary: " + salary + "\n\nEmployee mobile number: "
                + mobileNumber +  "\n\nEmployee DOB: " + dateOfBirth
                + "\n\nEmployee address: " + listOfAddress);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
