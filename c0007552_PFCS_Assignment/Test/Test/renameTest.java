package Test;

import org.junit.Test;

import java.io.File;
import java.util.Scanner;

import static org.junit.Assert.fail;

/*
 * This is the TDD class file for the rename functionality within my program, in order for this to work as intended and
 * pass my test, the function must take in the users new name for the file and then successfully rename the pre-existing
 * file to their new name.
 */


public class renameTest {

    @Test
    public void renameTest1(){ // Preliminary intentional test fail.
        fail();
    }



    @Test
    public void renameTest2() { // Test passes when the user enters a new name for the file containing the disk details.
        String fileName = "";


        Scanner newFileNameIn = new Scanner(System.in); // This takes in the users new name for the file.
        String newFileName = newFileNameIn.nextLine();

        new File(fileName).renameTo(new File(newFileName + ".csv")); // This renames the file containing the disk information.


    }
}
