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
        // Task 2: Mini Health Metric

System.out.print("Enter health metric (1 is BMI, 2 is Dosage, 3 is Trig): ");
int metricChoice = scanner.nextInt();

if (metricChoice == 1) {
    //Option A, This is for calculating BMI
    System.out.print("Enter weight  (kg): ");
    double weight = scanner.nextDouble();
    System.out.print("Enter height  (m): ");
    double height = scanner.nextDouble();

    double bmi = weight / (height * height);
    // Rounding BMI to one decimal place
     double bmiRounded = Math.round(bmi * 10) / 10.0; 

    System.out.print("BMI: " + bmiRounded + "  Category: ");
    if (bmi < 18.5) {
        System.out.println("Underweight");
    } 
    else if (bmi < 25) {
        System.out.println("Normal");
    } 
    else if (bmi < 30) {
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
    int tablets = (int) Math.ceil(dosage / 250.0);
    System.out.println("Tablets needed: " + tablets);

} 

else if (metricChoice == 3) {
    //Option C, Trig helper
    System.out.print("Enter angle in degrees: ");
    double angleDegrees = scanner.nextDouble();

    // x is the angle after converting to radians
    double x = Math.toRadians(angleDegrees);

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







    }
}
