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
                String ratingparse = separatedInput[3].replace(',',',').replace(";", "");
                float movieRating = Float.parseFloat(ratingparse);
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
                String ratingParse = separatedInput[3].replace(',', '.');
                float seriesRating = Float.parseFloat(ratingParse);
                String[] seperateSeasons = separatedInput[4].split(",");
                for(int i = 0; i < seperateSeasons.length; i++){
                    String[] separateEpisodes = seperateSeasons[i].split("-");
                    int seasons = Integer.parseInt(separateEpisodes[0].trim());
                    int numberOfEpisodes = Integer.parseInt(separateEpisodes[1].replace(";", "").trim());
                    for(int episode = 1; episode <= numberOfEpisodes; episode++){
                        AMedia media = new Series(mediaName, Seriescategory, seriesRating, seriesReleaseYearStart,  seasons, episode, seriesReleaseYearEnd  );
                        SeriesArr.add(media);
                    }
                }
            }while (scan.hasNextLine());
        }catch (FileNotFoundException e){
            System.out.println("Failed to load series data.");
        }
        return SeriesArr;
    }
}
