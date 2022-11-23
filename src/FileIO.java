import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileIO {
    public static ArrayList<AMedia> readMovieFile(String path){
        ArrayList<AMedia> MoviesArr = new ArrayList<>();
        File file = new File(path);
        try{
            Scanner scan = new Scanner(file);
            scan.nextLine();
            do{
                String input = scan.nextLine();
                String[] separatedInput = input.split(";");
                String mediaName = separatedInput[0];
                int movieReleaseYear = Integer.parseInt(separatedInput[1]);
                String movieCategory = separatedInput[2];
                String ratingRatingForParse = separatedInput[3].replace(',',',').replace(";", "");
                float movieRating = Float.parseFloat(ratingRatingForParse);
                AMedia media = new Movie(mediaName, movieCategory, movieRating, movieReleaseYear);
                MoviesArr.add(media);
            }while(scan.hasNextLine());

        }catch (FileNotFoundException e){
            System.out.println("Cant load movie data");
        }
        return MoviesArr;
    }
    public static ArrayList<AMedia> readSeriesFile(String path){
        ArrayList<AMedia> SeriesArr = new ArrayList<>();
        File file = new File(path);
        try{
            Scanner scan = new Scanner(file);
            scan.nextLine();
            do {
                String input = scan.nextLine();
                String[] separatedInput = input.split(";");
                String mediaName = separatedInput[0];
                String[] seperateYear = separatedInput[1].split("-");
                int seriesReleaseYearStart = Integer.parseInt(seperateYear[0].trim());
                int seriesReleaseYearEnd = 0;
                if(!seperateYear[1].equals(" ")){
                    seriesReleaseYearEnd = Integer.parseInt(seperateYear[1].trim());
                }
                String Seriescategory = separatedInput[2];
            }
        }
    }
}
