import java.util.ArrayList;

public class Journal {
    private String journal;
    private ArrayList<Tool> list;
    private ArrayList<Gem> gems;

    public Journal(String name) {
        journal =  Colors.BLUE + "[" + name + "'s journal]\nDiscoveries:\n" + Colors.RESET;
        list = new ArrayList<>();
        gems = new ArrayList<>();
    }

    public void getJournal() {
        System.out.println(journal);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        System.out.println("\nGems collected: ");
        for (int i = 0; i < gems.size(); i++) {
            System.out.println(gems.get(i));
        }
    }

    public void addToJournal(Tool add1) {
        list.add(add1);
    }

    public void addCollected(Gem element) {
        gems.add(element);
    }
}