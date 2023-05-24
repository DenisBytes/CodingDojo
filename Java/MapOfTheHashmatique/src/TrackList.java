import java.util.Set;
import java.util.HashMap;
import java.util.Scanner;
public class TrackList {
    public static void main(String[] args) {
        HashMap<String, String> trackList = new HashMap<String, String >();
        Scanner scanner = new Scanner (System.in);


        trackList.put("Billie Jean","Billie Jean is not my lover, uh\n" +
                                    "She's just a girl who claims that I am the one (Oh, baby)\n" +
                                    "But the kid is not my son (Hoo)\n" +
                                    "She says I am the one (Oh, baby)\n" +
                                    "But the kid is not my son (Hee-hee-hee, no-no, hee-hee-hee, hoo)");
        trackList.put("Stayin Alive","Whether you're a brother or whether you're a mother\n" +
                                    "You're stayin' alive, stayin' alive\n" +
                                    "Feel the city breakin' and everybody shakin'\n" +
                                    "And we're stayin' alive, stayin' alive\n" +
                                    "Ah, ah, ah, ah\n" +
                                    "Stayin' alive, stayin' alive\n" +
                                    "Ah, ah, ah, ah\n" +
                                    "Stayin' alive\n" +
                                    "Oh, when you walk");
        trackList.put("I Will Survive","Oh no, not I, I will survive\n" +
                                    "Oh, as long as I know how to love, I know I'll stay alive\n" +
                                    "I've got all my life to live, and I've got all my love to give\n" +
                                    "And I'll survive, I will survive, hey hey");
        trackList.put("El Hijo de Toño","Dicen que el hijo de tigre, de tigre sale pinta'o\n" +
                                    "Pero Toñilas salió fue demasia'o cargado\n" +
                                    "Dicen quе el hijo de tigre, dе tigre sale pinta'o\n" +
                                    "Pero Toñilas salió fue demasia'o cargado");

        System.out.println("Enter the track list that you want to search.\n"+
                            "(Billie Jean, Stayin Alive, I Will Survive, El Hijo de Toño)"+
                            "Enter: ");

        String userSearch = scanner.nextLine();

        if (trackList.containsKey(userSearch)){
            System.out.println("The track title is: "+userSearch);
            System.out.println("\n"+trackList.get(userSearch));
            System.out.println("\n---------------------------");
        }
        else{
            System.out.println("Track "+userSearch+" does not exist\n");
            System.out.println("\n---------------------------");
        }

        System.out.println("\nBelow you can find the whole track list and their lyrics");
        System.out.println("\n---------------------------");

        Set<String> keys = trackList.keySet();
        for (String key : keys){
            System.out.println(key);
            System.out.println();
            System.out.println(trackList.get(key));
            System.out.println();
        }
    }
}

