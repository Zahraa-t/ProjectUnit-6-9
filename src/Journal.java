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
            System.out.println(list.get(i).getText());
        }
        System.out.println(Colors.CYAN + "Gems collected: " + Colors.RESET);
        for (int i = 0; i < gems.size(); i++) {
            System.out.println(gems.get(i));
        }
    }

    public void addToTools(Item add1) {
        if (!((Tool) add1).isCollectedAlready()) {
            System.out.println("hi");
            list.add((Tool) add1);
            ((Tool)add1).setCollectedAlready(true);
        }
    }

    public void addGems(Gem element) {
        gems.add(element);
    }

    public boolean exitCheck() {
        int result = 0;
        for (int g = 0; g < gems.size(); g++) {
            if (!gems.get(g).isTrick()) {
                result++;
            }
        }
        if (result == 3 ) {
            return true;
        }
        return false;
    }

    private boolean progressing(String checkForThis) {
        for (int l = 0; l < list.size(); l++) {
            if (list.get(l).getName().equals(checkForThis)) {
                return true;
            }
        }
        return false;
    }

    public void chest(Space move) {
        if (progressing("Key") && move.getSymbol().equals("⬓")) {
            Tool t = new Tool("˥","Crowbar", "You can pry things open now");
            list.add(t);
            System.out.println("You've obtained: " + t);
        }
    }

    public boolean floor(Space move) {
        if (progressing("Crowbar") && move.getSymbol().equals("#")) {
            Gem h = new Gem(Colors.RED + "\uD83D\uDC8ERuby\uD83D\uDC8E" + Colors.RESET, "A gem sporting a vivid red color", true);;
            gems.add(h);
            Tool t = new Tool("˥","Crowbar", "You can pry things open now");
            t.treasureChest();
            return true;
        }
        return false;
    }
}