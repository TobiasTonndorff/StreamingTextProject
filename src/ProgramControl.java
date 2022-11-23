
import java.util.ArrayList;
public class ProgramControl {
    private ArrayList<User> UsersList = new ArrayList<>();
    private ArrayList<AMedia> mediaList = new ArrayList<>();
    public static User defaultUser;
    public static MainMenu mainMenu;

    public ProgramControl(){

    }
    public void runProgram(){
        ArrayList<AMedia> movieList = FileIO.readMovieFile("Data/Movies.csv");
        ArrayList<AMedia> seriesList = FileIO.readSeriesFile("Data/Series.csv");
        for(AMedia m : movieList){
            mediaList.add(m);
        }
        for(AMedia m: seriesList){
            mediaList.add(m);
        }
        UsersList = FileIO.readUsersFile("Data/Users.csv", mediaList);

        StartMenu startMenu = new StartMenu(UsersList);
        defaultUser = startMenu.exeStartMenu();
        if(!UsersList.contains(defaultUser)){
            UsersList.add(defaultUser);
        }
        //Main Menu skal laves
        mainMenu = new MainMenu(UsersList, movieList, seriesList);
        mainMenu.runMainMenu();

        FileIO.writeUsersFile("Data/Users.csv", UsersList);

    }
}
