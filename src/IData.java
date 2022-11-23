
import java.util.ArrayList;

public interface IData {

    ArrayList<User> readUserFile(String path, ArrayList<AMedia> allMedia);
    void writeToUserFile(String path, ArrayList<User> allUsers);
    ArrayList<AMedia> readMovieFile(String path);
    ArrayList<AMedia> readSeriesFile(String path);
    ArrayList<String> readCategoriesFile(String path);

}
