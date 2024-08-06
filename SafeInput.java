import java.util.Scanner;

public class SafeInput {
    public static int getInt(Scanner pipe, String prompt) {
        int retVal = 0;
        boolean valid = false;

        do {
            System.out.print(prompt);
            if (pipe.hasNextInt()) {
                retVal = pipe.nextInt();
                pipe.nextLine(); // clear buffer
                valid = true;
            } else {
                System.out.println("Invalid input. Please enter an integer.");
                pipe.nextLine(); // clear buffer
            }
        } while (!valid);

        return retVal;
    }

    public static double getDouble(Scanner pipe, String prompt) {
        double retVal = 0.0;
        boolean valid = false;

        do {
            System.out.print(prompt);
            if (pipe.hasNextDouble()) {
                retVal = pipe.nextDouble();
                pipe.nextLine(); // clear buffer
                valid = true;
            } else {
                System.out.println("Invalid input. Please enter a double.");
                pipe.nextLine(); // clear buffer
            }
        } while (!valid);

        return retVal;
    }

    public static String getString(Scanner pipe, String prompt) {
        System.out.print(prompt);
        return pipe.nextLine();
    }

    public static boolean getYNConfirm(Scanner pipe, String prompt) {
        boolean retVal = false;
        boolean valid = false;

        do {
            System.out.print(prompt + " [Y/N]: ");
            String response = pipe.nextLine().trim().toLowerCase();

            if (response.equals("y")) {
                retVal = true;
                valid = true;
            } else if (response.equals("n")) {
                valid = true;
            } else {
                System.out.println("Invalid input. Please enter 'Y' or 'N'.");
            }
        } while (!valid);

        return retVal;
    }
}
