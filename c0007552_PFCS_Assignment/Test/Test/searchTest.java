package Test;
import java.util.*;
import java.io.*;
import org.junit.Test;
import static org.junit.Assert.*;

/*
* This is the TDD class file for the search functionality within my program, in order for this to work as intended and pass my test the function must
* take data from the .csv file created by either the Music or Game creation part of my application and print them out in the rows
* that the data is entered into by the user when creating a music or game disk.
*/



public class searchTest {

    private static List<String> searchMethod(String line) { // Method of taking in each row of the .csv file and adding it into a array list.
        List<String> values = new ArrayList<>();
        try (Scanner rowScanner = new Scanner(line)) {
            rowScanner.useDelimiter(",");
            while (rowScanner.hasNext()) {
                values.add(rowScanner.next());

            }
        }
        return values;
    }

    @Test
    public void searchTest1(){ // Preliminary intentional test fail.
        fail();
    }

    @Test
    public void searchTest2() throws FileNotFoundException { // Tests passes for searching for the CD details and printing them to the user.
        List<List<String>> search = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File("Disks.csv"))) { // Pathname can be changed to variable to be used when creating renaming case to prevent file not found exceptions.
            while (scanner.hasNextLine()) {
                search.add(searchMethod(scanner.nextLine()));

            }
        }
        System.out.println(search); // Test passes even if there are multiple rows within the .csv file.
    }

}
