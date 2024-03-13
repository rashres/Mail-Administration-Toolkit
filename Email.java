import java.security.SecureRandom;
import java.util.Scanner;

public class Email {

    private static final int DEFAULT_PASSWORD_LENGTH = 10;
    private static final String COMPANY_SUFFIX = "company.com";
    private static final String DEFAULT_DEPARTMENT = "none";

    private String firstName;
    private String lastName;
    private String password;
    private String email;
    private String department;
    private int mailBoxCapacity = 10;
    private String alternateEmail;

    public Email(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = setDepartment();
        this.password = generateRandomPassword(DEFAULT_PASSWORD_LENGTH);
        this.email = generateEmail();
    }

    private String setDepartment() {
        System.out.println("New Worker: " + firstName + " " + lastName +
                "\nDEPARTMENT CODES:\n1 for Sales\n2 for Development\n3 for Accounting\n0 for none\nEnter department code:");
        try (Scanner scanner = new Scanner(System.in)) {
            int depChoice = scanner.nextInt();
            switch (depChoice) {
                case 1:
                    return "sales";
                case 2:
                    return "dev";
                case 3:
                    return "accounting";
                default:
                    return DEFAULT_DEPARTMENT;
            }
        } catch (Exception e) {
            System.out.println("Invalid input. Setting department to default.");
            return DEFAULT_DEPARTMENT;
        }
    }

    private String generateRandomPassword(int length) {
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()-_";
        SecureRandom random = new SecureRandom();
        StringBuilder password = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(passwordSet.length());
            password.append(passwordSet.charAt(index));
        }
        return password.toString();
    }

    private String generateEmail() {
        return firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + "." + COMPANY_SUFFIX;
    }

    public void setMailBoxCapacity(int capacity) {
        this.mailBoxCapacity = capacity;
    }

    public void setAlternateEmail(String altEmail) {
        this.alternateEmail = altEmail;
    }

    public void changePassword(String password) {
        this.password = password;
    }

    public int getMailboxCapacity() {
        return mailBoxCapacity;
    }

    public String getAlternateEmail() {
        return alternateEmail;
    }

    public String getPassword() {
        return password;
    }

    public String showInfo() {
        return  "Welcome to the company!" + 
        		"\nDISPLAY NAME: " + firstName + " " + lastName +
                "\nCOMPANY EMAIL: " + email +
                "\nMAILBOX CAPACITY: " + mailBoxCapacity + "GB";
    }

    // Add additional features like password strength checker, email validator, etc.
}
