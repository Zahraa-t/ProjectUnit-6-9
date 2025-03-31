import java.util.ArrayList;

public class Journal {
    private String journal;
    private ArrayList<Tool> list;
    private ArrayList<Gem> gems;

    public Journal() {
        journal =  "Your journal\nDiscoveries:\n";
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

    public void gemsCollectd() {
        Gem one = new Gem( "Kashmir Sapphire", "A gem found with dark blue to lighter hues.", false);
        Gem two = new Gem("Emerald", "A gem that displays a rich green hue", false);
        Gem three = new Gem("Yowah Nut Opal", "A gem that displays a variety of colors", false);
        gems.add(one);
        gems.add(two);
        gems.add(three);
    }




}