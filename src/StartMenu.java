import java.util.ArrayList;
import java.util.Scanner;

public class StartMenu {
    ArrayList<User> userList;
    Scanner scanner = new Scanner(System.in);

    public StartMenu(ArrayList<User> userList){
        this.userList = userList;
    }
    //STARTMENU

    public User exeStartMenu(){
        System.out.println("\n Welcome to PopcornTime 2.0 \n");
        System.out.println("choose one of the numbers on screen: \n" +
                            "then press: ENTER\n");
        System.out.println("You have the following options:");
        System.out.println("1. Login");
        System.out.println("2. Create new user");
        while(true){
            String userInput = scanner.nextLine();
            if("1".equals(userInput)){
                return login(); //Login skal laves
            }
            if("2".equals(userInput)){
                return createUser(); //Create User skal laves
            }
            System.out.println("Bad input");
            System.out.println("Try again");
        }


    }
    //USERLOGIN
    private User login(){
        System.out.println("Enter Username:");
        System.out.println("or type quit to quit");
        String username = scanner.nextLine();
        for( User u : userList){
            if(u.getUsername().equals(username)){
                System.out.println("Enter password:");
                String password = scanner.nextLine();
                if(password.equalsIgnoreCase("quit")){
                    username = "quit";
                    break;
                }
                if(u.getPassword().equals(password)){
                    return u;
                }
                System.out.println("You have entered a wrong username or password: ");
                System.out.println("Try again");
            }
        }
        if(username.equalsIgnoreCase("quit")){
            exeStartMenu();
        }
        System.out.println("user doesnt exist.");
        User defaultUser = exeStartMenu();
        return defaultUser;
    }
    //Account Creation
    private User createUser(){
        String username;
        String password;
            System.out.println("Enter your desired Username: ");
            username = scanner.nextLine();
            System.out.println("Enter your desired Password: ");
            password = scanner.nextLine();
            return new User(username, password, new ArrayList<AMedia>(), new ArrayList<AMedia>());
    }
}
