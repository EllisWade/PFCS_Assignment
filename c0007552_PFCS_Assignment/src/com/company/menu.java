package com.company;
import java.util.*;
import java.io.*;



public class menu {
    public static String Title;         // This sets strings that are to be used between the two creation tools and for the variables that require the user to pick
    public static String Genre;         // rather than enter information.
    public static String releaseDate;
    public static String PEGI;
    public static String Duration;

    public static void main(String[] args) throws IOException {

        Scanner menuIn = new Scanner(System.in);
        int menu;
        do {
            System.out.println("\nDisc Creation and Management tool" + "\nPlease enter the number of the tool that you would like to use!" + "\n***********************" +
                    "\n1) Music Disc Creation tool" + "\n2) Game Disc Creation tool" + "\n3) Display disk entries" + "\n4) Rename disk file" + "\n9) Exit" + "\n***********************" + "\nPlease enter the number: ");

            menu = menuIn.nextInt();
            int errorList;
            String fileName = "";
            switch (menu) {
                case 1: // This is the tool for creating a music disk entry.
                    Scanner discCreate = new Scanner(System.in);
                    System.out.println("Music Disc Creation tool" + "\n");

                    System.out.println("Artist: ");             // These strings take in the users details to be later flushed onto the .csv file.
                    String Name = discCreate.nextLine();
                    System.out.println("\n" + "Title: ");
                    Title = discCreate.nextLine();
                    System.out.println("\n" + "Release Date:        (In the format, DD/MM/YYYY)");
                    releaseDate = discCreate.nextLine();
                    System.out.println("\n" + "Number of songs: ");
                    int numbOfSongs = discCreate.nextInt();
                    System.out.println("\n" + "Total Duration:            (In the format of seconds, s)");
                    Duration = discCreate.nextLine();


                    do {
                        Scanner userGenre = new Scanner(System.in);

                        errorList = 1;
                        System.out.println("Pick a genre: " + "\nPop" + "\nHip-Hop" + "\nRap" + "\nRock" + "\nEDM" + "\nOther");
                        Genre = userGenre.nextLine();

                        String[] musicGenres = {"Pop", "Hip-Hop", "Rap", "Rock", "EDM", "Other"};

                        boolean entry = false;                  // This allows the users information to be entered in either uppercase or lowercase.
                        for (String g : musicGenres) {
                            if (Genre.equalsIgnoreCase(g)) {
                                entry = true;
                            }
                        }
                        if (entry) {
                            System.out.println("\nYou chose " + Genre);
                        } else { // Prompts the user to enter the genre again if they provided one that isn't an option.
                            System.out.println("That is not a genre option. Please choose from the list provided.");
                            errorList --;
                        }
                    } while (errorList != 1);



                    if (fileName.equals("")){
                        fileName = "Disks.csv";
                    }
                    // This adds the users new entry into the file if it already exists and if it doesnt, it creates a .csv file for the data.
                    try (FileWriter fw = new FileWriter(fileName, true); BufferedWriter bw = new BufferedWriter(fw); PrintWriter pw = new PrintWriter(bw)) {

                        pw.println("Music: " + Name + ", " + Title + ", " + releaseDate + ", " + numbOfSongs + ", " + Duration + ", " + Genre);
                        pw.flush(); // Adds the users information into the file

                        System.out.println("Your entry has been made!");
                    }
                    break;

                case 2: // This is the tool for creating a game disk entry

                    Scanner discCreateG = new Scanner(System.in);
                    System.out.println("Game Disc Creation tool" + "\n");

                    System.out.println("\n" + "Title: ");
                    Title = discCreateG.nextLine();
                    System.out.println("\n" + "Release Date:        (In the format, DD/MM/YYYY)");
                    releaseDate = discCreateG.nextLine();

                    do {
                        errorList = 1;
                        System.out.println("\n" + "Pick a genre: " + "\nAction" + "\nSports" + "\nAdventure" + "\nRole-Playing" + "\nRacing" + "\nOther");
                        Genre = discCreateG.nextLine();

                        String[] gameGenres = {"Action", "Sports", "Adventure", "Role-Playing", "Racing", "Other"};

                        boolean entry = false;
                        for (String g : gameGenres) {
                            if (Genre.equalsIgnoreCase(g)) {
                                entry = true;
                            }
                        }
                        if (entry) {
                            System.out.println("You chose " + Genre);
                        } else { // Prompts the user to enter the genre again if they provided one that isn't an option.
                            System.out.println("That is not a genre option. Please choose from the list provided.");
                            errorList --;
                        }
                    } while (errorList != 1);

                    do {
                        errorList = 1;
                        System.out.println("\n" + "Pick a PEGI rating: " + "\n3" + "\n7" + "\n12" + "\n16" + "\n18");
                        PEGI = discCreateG.nextLine();

                        String[] pegiRating = {"3", "7", "12", "16", "18"};

                        boolean entry = false;
                        for (String p : pegiRating) {
                            if (PEGI.equalsIgnoreCase(p)) {
                                entry = true;
                                break;
                            }
                        }
                        if (entry) {
                            System.out.println("You chose " + PEGI);
                        } else { // Prompts the user to enter the PEGI again if they provided one that isn't an option.
                            System.out.println("That is not a PEGI rating. Please choose from the list provided.");
                            errorList --;
                        }
                    } while (errorList != 1);
                    System.out.println("\n" + "Gaming Platform: ");
                    String Platform = discCreateG.nextLine();

                    if (fileName.equals("")){
                        fileName = "Disks.csv";
                    }

                    try (FileWriter fw = new FileWriter(fileName, true); BufferedWriter bw = new BufferedWriter(fw); PrintWriter pw = new PrintWriter(bw)) {

                        pw.println("Game: " + Title + ", " + releaseDate + ", " + Genre + ", " + PEGI + ", " + Platform);
                        pw.flush();

                        System.out.println("Your entry has been made!");

                    }

                    break;

                case 3:
                    if (fileName.equals("")){
                        fileName = "Disks.csv";
                    }

                    List<List<String>> search = new ArrayList<>();
                    try (Scanner scanner = new Scanner(new File(fileName))) { // Pathname can be changed to variable to be used when creating renaming case to prevent file not found exceptions.
                        while (scanner.hasNextLine()) {
                            search.add(searchMethod(scanner.nextLine()));

                        }
                    }
                    System.out.println(search);
                    break;

                case 4:
                    if (fileName.equals("")){
                        fileName = "Disks.csv";
                    }


                    Scanner newFileNameIn = new Scanner(System.in);
                    String newFileName = newFileNameIn.nextLine();

                    new File(fileName).renameTo(new File(newFileName + ".csv"));


                case 9: //Exits the menu system which ends the program
                    break;

                default: // This is the default case if the user enters a value that isn't available on the menu.
                    System.out.println("You have entered a value that isn't available on the menu, please try again");
                    break;
            }

        } while (menu != 9);

    }

    private static List<String> searchMethod(String line) { // This is the method for writing each entry within the disk file to an array list.
        List<String> values = new ArrayList<>();
        try (Scanner rowScanner = new Scanner(line)) {
            rowScanner.useDelimiter(",");
            while (rowScanner.hasNext()) {
                values.add(rowScanner.next());

            }
        }

        return values;
    }
}