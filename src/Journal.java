import java.util.ArrayList;

public class Journal {
    private String owner;
    private String journal;
    private ArrayList<Monsters> list;

    public Journal(String name) {
        owner = name;
        journal = name + "'s journal\nDiscoveries:\n";
        list = new ArrayList<>();
    }

    public String getJournal() {
        return journal;
    }


}
