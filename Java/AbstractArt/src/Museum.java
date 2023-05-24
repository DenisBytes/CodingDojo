import java.util.ArrayList;
import java.util.Collections;

public class Museum {
    public static void main(String[] args) {

        Painting p1 = new Painting("Blue","1","Sky","Oil");
        Painting p2 = new Painting("Red","2","Rose","Watercolor");
        Painting p3 = new Painting("Black","3","Night","Acrylic");

        Sculpture s1 = new Sculpture("Scul 1","Auth 1","Scul 1 desc","Marble");
        Sculpture s2 = new Sculpture("Scul 2","Auth 2","Scul 2 desc","Bronze");

        ArrayList<Art> museum = new ArrayList<Art> ();

        museum.add(p1);
        museum.add(p2);
        museum.add(p3);

        museum.add(s1);
        museum.add(s2);

        Collections.shuffle(museum);

        for (Art a : museum){
            a.viewArt();
        }
    }
}