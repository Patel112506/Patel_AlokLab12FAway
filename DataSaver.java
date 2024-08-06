import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.IOException;

public class DataSaver {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<String> records = new ArrayList<>();

        boolean continueInput;
        do {
            String firstName = SafeInput.getString(in, "Enter first name: ");
            String lastName = SafeInput.getString(in, "Enter last name: ");
            String idNumber = String.format("%06d", SafeInput.getInt(in, "Enter ID number: "));
            String email = SafeInput.getString(in, "Enter email: ");
            int yearOfBirth = SafeInput.getInt(in, "Enter year of birth: ");

            String record = String.format("%s, %s, %s, %s, %d", firstName, lastName, idNumber, email, yearOfBirth);
            records.add(record);

            continueInput = SafeInput.getYNConfirm(in, "Do you want to add another record?");
        } while (continueInput);

        String fileName = SafeInput.getString(in, "Enter file name to save (without extension): ") + ".csv";

        Path file = Paths.get(System.getProperty("user.dir") + "/src/" + fileName);

        try (BufferedWriter writer = Files.newBufferedWriter(file)) {
            for (String record : records) {
                writer.write(record);
                writer.newLine();
            }
            System.out.println("Records saved to " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
