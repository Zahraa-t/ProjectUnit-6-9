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
            System.out.println(list.get(i).getName() + ": "  + list.get(i).getText());
        }
        System.out.println("\n" + Colors.CYAN + "Gems collected: " + Colors.RESET);
        for (int i = 0; i < gems.size(); i++) {
            System.out.println(gems.get(i));
        }
    }

    public void addToTools(Item add1) {
        if (!((Tool) add1).isCollectedAlready()) {
            list.add((Tool) add1);
            ((Tool)add1).setCollectedAlready(true);
        }
    }

    public void removeTool(int add1) {
        list.remove(add1);
    }

    public void addGems(Gem element) {
        gems.add(element);
    }

    public int progressing(String checkForThis) {
        for (int l = 0; l < list.size(); l++) {
            if (list.get(l).getName().equals(checkForThis)) {
                return l;
            }
        }
        return 0;
    }

    public boolean exitCheck(Space move) {
        int result = 0;
        for (int g = 0; g < gems.size(); g++) {
            if (!gems.get(g).isTrick()) {
                result++;
            }
        }
        if (result == 3 ) {
            System.out.println("You opened the door ");
            return true;
        }
        if (result < gems.size()) {
            System.out.println("Some of the gems you're holding are not true");
        }
        return false;
    }
}