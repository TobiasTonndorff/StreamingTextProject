import java.util.Scanner;
public abstract class AMedia {

    Scanner scan = new Scanner(System.in);
    protected String name;
    protected String category;
    protected float rating;
    protected int releaseYear;

    AMedia(String name, String category, float rating, int releaseYear){
        this.name = name;
        this.category = category;
        this.rating = rating;
        this.releaseYear = releaseYear;
    }
    public String getName(){
        return name;
    }

    public String getCategory(){
        return category;
    }

    public float getRating() {
        return rating;
    }

    public int getReleaseYear() {
        return releaseYear;
    }
    abstract protected void playMedia(AMedia media);
    public void chooseMedia() {
        System.out.println("You chose: " + name + "\n");
        System.out.println("Choose an option below: ");
        System.out.println("1. Play selected media: ");
        // TILFØJ noget programkontrol der kører forksellige funktioner efter userinput
        //if(ProgramControl.currentUser.getSavedMedia().contains(this)){
        System.out.println("2. would you like to remove: " + name + " from your saved list? \n");
        //}else{
        System.out.println("2. Do you want to save this to your list of media? \n");
        //}
        System.out.println("3. Return to main menu");
        String userInput = scan.nextLine().trim();

        switch (userInput) {
            case "1":
                playMedia(this);
                //ProgramControl.mainMenu.runMainMenu();
                break;
            case "2":
                //if(ProgramControl.currentUser.getSavedMedia().contains(this)){
                //ProgramControl.currentUser.removeSavedMedia(this);
                //}else{
                //ProgramControl.currentUser.addSavedMedia(this);
                //}
                //ProgramControl.mainMenu.runMainMenu();
                break;
            case "3":
                //ProgramControl.mainMenu.runMainMenu();
                break;
            default:
                System.out.println("Wrong button, try again Scrub!");
                //chooseMedia
        }
    }
}
