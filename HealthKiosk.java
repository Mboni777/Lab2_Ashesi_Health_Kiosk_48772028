import java.util.Scanner;

public class HealthKiosk {
    public static void main(String[] args) {
        // creating a scanner object
        Scanner scanner = new Scanner(System.in);
        
        // declaration of variables that will be used in more than one task
        double bmi = 0;        
        int tablets = 0;       
        double x = 0;   

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
        // Task 2: Mini Health Metric

System.out.print("Enter health metric (1 is BMI, 2 is Dosage, 3 is Trig): ");
int metricChoice = scanner.nextInt();

if (metricChoice == 1) {
    //Option A, This is for calculating BMI
    System.out.print("Enter weight  (kg): ");
    double weight = scanner.nextDouble();
    System.out.print("Enter height  (m): ");
    double height = scanner.nextDouble();

     bmi = weight / (height * height);
    // Rounding BMI to one decimal place
     double bmiRounded = Math.round(bmi * 10) / 10.0; 

    System.out.print("BMI: " + bmiRounded + "  Category: ");
    if (bmiRounded < 18.5) {
        System.out.println("Underweight");
    } 
    else if (bmiRounded < 25) {
        System.out.println("Normal");
    } 
    else if (bmiRounded < 30) {
        System.out.println("Overweight");
    } 
    else {
        System.out.println("Obese");
    }

} 

else if (metricChoice == 2) {
    //Option B, Dosage round-up
    System.out.print("Enter required dosage in mg: ");
    double dosage = scanner.nextDouble();
    tablets = (int) Math.ceil(dosage / 250.0);
    System.out.println("Tablets needed: " + tablets);

} 

else if (metricChoice == 3) {
    //Option C, Trig helper
    System.out.print("Enter angle in degrees: ");
    double angleDegrees = scanner.nextDouble();

    // x is the angle after converting to radians
    x = Math.toRadians(angleDegrees);

    double sinValue = Math.sin(x);
    double cosValue = Math.cos(x);

    // Rounding to three decimal places
    sinValue = Math.round(sinValue * 1000) / 1000.0;
    cosValue = Math.round(cosValue * 1000) / 1000.0;

    System.out.println("sine of " + angleDegrees + " is " + sinValue);
    System.out.println("cosine of " + angleDegrees + " is " + cosValue);

} 
else {
    System.out.println("Invalid metric choice");
}
// Task 3: ID Sanity Check

// First of all, let's generate a random uppercase character
char randomCharacter = (char) ('A' + Math.random() * 26);

// Now, let's generate 4 random digits between 3 and 9 (inclusive)

int digit1 = (int) (Math.random() * 7) + 3; 
int digit2 = (int) (Math.random() * 7) + 3; 
int digit3 = (int) (Math.random() * 7) + 3; 
int digit4 = (int) (Math.random() * 7) + 3; 

// Let's combine them to match the correct ID format and also print it out
String formedID = "" + randomCharacter + digit1 + digit2 + digit3 + digit4;
System.out.println("Generated ID: " + formedID);

// Checking if the ID meets the criteria

// Checking if the length is exactly 5 characters
if (formedID.length() != 5) {
    System.out.println("Invalid ID");
}
else if (!Character.isUpperCase(formedID.charAt(0))) {
    System.out.println("Invalid ID, First character must be an uppercase letter");
    }
    // Checking if the last 4 characters are digits
else if (!(Character.isDigit(formedID.charAt(1)) && Character.isDigit(formedID.charAt(2)) &&
      Character.isDigit(formedID.charAt(3)) && Character.isDigit(formedID.charAt(4)))) {
    System.out.println("Invalid: last 4 must be digits");}
else {
    System.out.println("ID OK");
}
System.out.println();


// Task 4: Secure code Display
System.out.print("Enter your first name: ");
String firstName = scanner.next();

// Getting the first letter of the first name and converting it to uppercase
char firstNameInitialLetter = Character.toUpperCase(firstName.charAt(0));
System.out.println("Base code = " + firstNameInitialLetter);

// shifting the first letter by 2 positions
char shiftedFirstLetter = (char) ('A' + (firstNameInitialLetter - 'A' + 2) % 26);
System.out.println("Shifted letter of base code = " + shiftedFirstLetter);

// Taking last two characters from the ID generated above
String lastTwoIDChars = formedID.substring(formedID.length() - 2);
System.out.println("Last two characters for ID generated are: " + lastTwoIDChars);

// Let's get the metric value from Task 2
int metricValue = 0;

if (metricChoice == 1) {
     metricValue = (int) Math.round(bmi);
}
else if (metricChoice == 2) {
    // Because the tablets were already in int, there is no need for converting it
    metricValue = tablets;
}
else if (metricChoice == 3) {
    metricValue = (int) Math.round(Math.sin(x) * 100);
}

// Printing the code
String displayCode = shiftedFirstLetter + lastTwoIDChars + "-" + metricValue;
System.out.println("Display Code: " +  displayCode );

// Task 5: // Task 5: Service Summary

// Printing the summary of the actions performed based on the service code choosen
switch (serviceCode) {
    case 'P':
        System.out.println("Summary: PHARMACY | ID=" + formedID + " | Code=" + displayCode);
        break;
    case 'L':
        System.out.println("Summary: LAB | ID=" + formedID + " | Code=" + displayCode);
        break;
    case 'C':
        System.out.println("Summary: COUNSELING | ID=" + formedID + " | Code=" + displayCode);
        break;
    case 'T':
        System.out.println("Summary: TRIAGE | ID=" + formedID + " | BMI=" + (Math.round(bmi*10)/10.0) + " | Code=" + displayCode);
        break;
    default:
        System.out.println("Invalid service code Entered");
}


   }


}