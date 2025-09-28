import java.util.Scanner;

public class HealthKiosk {
    public static void main(String[] args) {
        // creating a scanner object
        Scanner scanner = new Scanner(System.in);

        // printing a welcome message
        System.out.println("Welcome to the Ashesi Health Kiosk!");

        // Task 1: Service Router
        System.out.print("Enter service code (P/L/T/C): ");
        // reading the service code input and converting it to uppercase and taking the first character
        char serviceCode = scanner.next().toUpperCase().charAt(0); 

        // using switch statement to route to the correct service
        switch (serviceCode) {
            case 'P':
                System.out.println("Go to: Pharmacy Desk");
                break;
            case 'L':
                System.out.println("Go to: Lab Desk");
                break;
            case 'T':
                System.out.println("Go to: Triage Desk");
                break;
            case 'C':
                System.out.println("Go to: Counseling Desk");
                break;
                // handling invalid service code
            default:
                System.out.println("Invalid service code"); 
        }
    }
}
