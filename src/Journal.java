import java.util.ArrayList;

public class Journal {
    private String journal;
    private ArrayList<Tool> list;
    private ArrayList<Gem> gems;

    public Journal(String name) {
        journal =  Colors.PURPLE + "[" + name + "'s journal]" + Colors.RESET + Colors.YELLOW + "\nDiscoveries:" + Colors.RESET;
        list = new ArrayList<>();
        gems = new ArrayList<>();
    }

    public void getJournal() {
        System.out.println(journal);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        System.out.println(Colors.CYAN + "Gems collected: " + Colors.RESET);
        for (int i = 0; i < gems.size(); i++) {
            System.out.println(gems.get(i));
        }
    }

    public void addToJournal(Item add1) {
        if (((Tool)add1).isCollectedAlready()) {
            list.add((Tool) add1);
            ((Tool)add1).setCollectedAlready(true);
        }
    }

    public void use (Tool thing) {
        list.remove(thing);
    }

    public void addCollected(Gem element) {
        gems.add(element);
    }

}