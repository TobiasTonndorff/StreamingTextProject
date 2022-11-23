import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Scanner;

public class FileIO {
    public static ArrayList<AMedia> readMovieFile(String path) {
        ArrayList<AMedia> MoviesArr = new ArrayList<>();
        File file = new File(path);
        try {
            Scanner scan = new Scanner(file);
            scan.nextLine();
            do {
                String input = scan.nextLine();
                String[] separatedInput = input.split(";");
                String mediaName = separatedInput[0];
                int movieReleaseYear = Integer.parseInt(separatedInput[1]);
                String movieCategory = separatedInput[2];
                String ratingparse = separatedInput[3].replace(',', ',').replace(";", "");
                float movieRating = Float.parseFloat(ratingparse);
                AMedia media = new Movie(mediaName, movieCategory, movieRating, movieReleaseYear);
                MoviesArr.add(media);
            } while (scan.hasNextLine());

        } catch (FileNotFoundException e) {
            System.out.println("Cant load movie data");
        }
        return MoviesArr;
    }

    public static ArrayList<AMedia> readSeriesFile(String path) {
        ArrayList<AMedia> SeriesArr = new ArrayList<>();
        File file = new File(path);
        try {
            Scanner scan = new Scanner(file);
            scan.nextLine();
            do {
                String input = scan.nextLine();
                String[] separatedInput = input.split(";");
                String mediaName = separatedInput[0];
                String[] seperateYear = separatedInput[1].split("-");
                int seriesReleaseYearStart = Integer.parseInt(seperateYear[0].trim());
                int seriesReleaseYearEnd = 0;
                if (!seperateYear[1].equals(" ")) {
                    seriesReleaseYearEnd = Integer.parseInt(seperateYear[1].trim());
                }
                String Seriescategory = separatedInput[2];
                String ratingParse = separatedInput[3].replace(',', '.');
                float seriesRating = Float.parseFloat(ratingParse);
                String[] seperateSeasons = separatedInput[4].split(",");
                for (int i = 0; i < seperateSeasons.length; i++) {
                    String[] separateEpisodes = seperateSeasons[i].split("-");
                    int seasons = Integer.parseInt(separateEpisodes[0].trim());
                    int numberOfEpisodes = Integer.parseInt(separateEpisodes[1].replace(";", "").trim());
                    for (int episode = 1; episode <= numberOfEpisodes; episode++) {
                        AMedia media = new Series(mediaName, Seriescategory, seriesRating, seriesReleaseYearStart, seasons, episode, seriesReleaseYearEnd);
                        SeriesArr.add(media);
                    }
                }
            } while (scan.hasNextLine());
        } catch (FileNotFoundException e) {
            System.out.println("Failed to load series data.");
        }
        return SeriesArr;
    }

    public static ArrayList<User> readUsersFile(String path, ArrayList<AMedia> allMedia) {
        ArrayList<User> usersArr = new ArrayList<>();
        File usersFile = new File(path);
        try {
            Scanner scan = new Scanner(usersFile);
            scan.nextLine();
            do {
                String input = scan.nextLine();
                String[] separatedInput = input.split("; ");
                String username = separatedInput[0];
                String password = separatedInput[1];
                String[] separatedWatchedMedia = separatedInput[2].split(",");
                ArrayList<AMedia> watchedMedia = new ArrayList<>();
                for (int i = 0; i < separatedWatchedMedia.length; i++) {
                    for (AMedia m : allMedia) {
                        if (m.getName().equals(separatedWatchedMedia[1])) {
                            watchedMedia.add(m);
                        }
                    }
                }
                String[] separatedSavedMedia = separatedInput[4].replace(";", "").split(",");
                ArrayList<AMedia> savedMedia = new ArrayList<>();
                for (int i = 0; i < separatedSavedMedia.length; i++) {
                    for (AMedia s : allMedia) {
                        if (s.getName().equals(separatedSavedMedia[i])) {
                            savedMedia.add(s);
                        }
                    }
                }
                User user = new User(username, password, watchedMedia, savedMedia);
                usersArr.add(user);
            } while (scan.hasNextLine());
        } catch (FileNotFoundException e) {
            System.out.println("Failed to load user data.");
        }
        return usersArr;
    }

    public static void writeUsersFile(String path, ArrayList<User> allUsers){
        File userFile = new File(path);
        try{
            FileWriter writer = new FileWriter(userFile);
            writer.write("username; password; watchedmedia; savedmedia;\n");
            for(User u: allUsers){
                String watchedMedia = "";
                String savedMedia = "";
                for(AMedia m: u.getWatchedMedia()){
                    watchedMedia += m.getName() + ", ";
                }
                if(watchedMedia.length() > 0) {
                    watchedMedia = watchedMedia.substring(0, (watchedMedia.length() - 2));
                }
                for(AMedia s: u.getSavedMedia()){
                    savedMedia += s.getName() + ", ";
                }
                if(savedMedia.length() > 0){
                    savedMedia = savedMedia.substring(0, (savedMedia.length() - 2));
                }
                writer.write(u.getUsername() + "; " + u.getPassword() + "; " + watchedMedia + "; " + savedMedia + ";\n");
            }
            writer.close();
        }catch (IOException ex){
            System.out.println("Failed to save user data");
        }
    }

    public static ArrayList<String> readCategoriesFile(String path){
        ArrayList<String> listOfCategories = new ArrayList<>();
        File file = new File(path);
        try{
            Scanner scan = new Scanner(file);
            scan.nextLine();
            do{
                String category = scan.nextLine();
                listOfCategories.add(category);
            }while(scan.hasNextLine());
        }catch (FileNotFoundException e){
            System.out.println("Failed to load  category data.");
        }
        return listOfCategories;
    }

}
