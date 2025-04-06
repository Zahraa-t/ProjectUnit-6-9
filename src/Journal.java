import java.util.ArrayList;

public class Journal {
    private String journal;
    private ArrayList<Tool> list;
    private ArrayList<Gem> gems;

    public Journal(String name) {
        journal =  Colors.PURPLE + "[" + name + "'s journal]" + Colors.RESET + Colors.YELLOW + "\nHolding:" + Colors.RESET;
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
        System.out.println();
    }

    public void addToTools(Item add1) {
        list.add((Tool) add1);
    }

    public void removeTool(int add1) {
        list.remove(add1);
    }

    public void addGems(Gem element) {
        gems.add(element);
    }

    public int findDiscoveries(String checkForThis) {
        for (int l = 0; l < list.size(); l++) {
            if (list.get(l).getName().equals(checkForThis)) {
                return l;
            }
        }
        return -1;
    }

    public void chest(Space move) {
        if (findDiscoveries("Key") != -1 && ((Item)move).getName().equals("Treasure Chest")) {
            Tool t = new Tool("˥","Crowbar", "You can pry things open now");
            addToTools(t);
            removeTool(findDiscoveries("Key"));
            System.out.println("\nYou used your key");
            System.out.println("You've obtained: " + t.getName());
        }
    }

    public boolean floor(Space move) {
        if (findDiscoveries("Crowbar") != -1 && move.getSymbol().equals("#")) {
            Gem h = new Gem(Colors.RED + "\uD83D\uDC8ERuby\uD83D\uDC8E" + Colors.RESET, "A gem sporting a vivid red color", true);
            System.out.print("...with your crowbar?\n\nYou used your crowbar\nYou've obtained: " + h.getName());
            list.remove(findDiscoveries("Crowbar"));
            addGems(h);
            return true;
        }
        return false;
    }

    public void chest2(Space move) {
        int idx = 1;
        for (int l = 0; l < gems.size(); l++) {
            if (gems.get(l).getName().equals(Colors.RED + "\uD83D\uDC8ERuby\uD83D\uDC8E" + Colors.RESET)) {
                idx = l;
            }
        }
        if (idx != 1 && move.getSymbol().equals("⬓")) {
            Gem a = new Gem(Colors.YELLOW + "\uD83D\uDC8EAmber\uD83D\uDC8E" + Colors.RESET, "An glowing orange gem ", false);
            a.treasureChest();
            System.out.println("Turns out the ruby was just a key for a hidden part of this chest. ");
            gems.remove(idx);
            addGems(a);
        }
    }

    public boolean exitCheck(Space move) {
        if (((Item)move).getName().equals("The Exit")) {
            int result = 0;
            for (int g = 0; g < gems.size(); g++) {
                if (!gems.get(g).isTrick()) {
                    result++;
                }
                if(gems.get(g).isTrick()) {
                    System.out.println("\nOne of your gems (the " + gems.get(g).getName() + ") isn't real!");
                }
            }
            if (result == 4 ) {
                System.out.println("\nYou met the requirement! You are holding the 4 gems. \nThe door opens \nYou can finally escape");
                return true;
            }
            System.out.println("You can't open the door. You don't meet the requirements. ");
        }
        return false;
    }
}