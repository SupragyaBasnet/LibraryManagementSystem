/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javatest;

import static org.junit.Assert.*;

public class RegistrationTest {

    public static void main(String[] args) {
        // Set up test data
        String userName = "bib123";
        String firstName = "bibhakta";
        String lastName = "lamsal";
        String email = "bibhaktalamsal8@gmail.com";
        int phoneNumber = 981305616;
        String password = "123456";
        String confirmPassword = "123456";
        String food = "momo";

        // Invoke the register() method
        String result = register(userName, firstName, lastName, email, phoneNumber, password, confirmPassword, food);

        // Verify the result
        assertEquals("bib123,bibhakta,lamsal, bibhaktalamsal8@gmail.com, 981305616, 123456,123456, momo", result);
    }

    public static String register(String userName, String firstName, String lastName, String email, int phoneNumber,
            String password, String confirmPassword, String food) {
        return userName + "," + firstName + "," + lastName + ", " + email + ", " + phoneNumber + ", " + password + ","
                + confirmPassword + ", " + food;
    }
}
