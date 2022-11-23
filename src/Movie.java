

import static java.lang.Thread.sleep;


public class Movie extends AMedia {

    Movie(String name, String category, float rating, int releaseYear){
        super(name, category, rating, releaseYear);
    }
    @Override
    protected void playMedia(AMedia media) {
        //Mangler klasse der udfører følgende kode
        //if(ProgramControl.currentUser.getSavedMedia().contains(media)){
        //ProgramControl.currentUser.removeSavedMedia(media);
    //}
        //if(!ProgramControl.currentUser.getWatchedMedia().contains(media)){
        //ProgramControl.currentUser.addWatchedMedia(media);
        //}
        System.out.println("Your are now watching: " + name);
        try{
            sleep(2500);
        }catch (Exception e) {

        }
        System.out.println(name + "is now done. go get some fresh air nerd.");
        System.out.println("Returning to main menu.");
        try{
            sleep(2500);
        }catch (Exception e){

        }
        for(int i = 0; i < 25; i++){
            System.out.printf("\n");
        }
    }
}
