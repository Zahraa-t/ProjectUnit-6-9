import java.util.ArrayList;

public class Journal {
    private String journal;
    private ArrayList<Gem> list;

    public Journal(String name, String description) {
        journal =  "Your journal\nDiscoveries:\n";
        list = new ArrayList<>();
    }

    public String getJournal() {
        return journal;
    }


}
