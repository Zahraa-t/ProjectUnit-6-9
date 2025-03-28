import java.util.ArrayList;

public class Journal {
    private String journal;
    private ArrayList<Item> list;

    public Journal() {
        journal =  "Your journal\nDiscoveries:\n";
        list = new ArrayList<>();
    }

    public void getJournal() {
        System.out.println(journal);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        System.out.println(new Player);
    }

    public void addToJournal(Item add1) {
        list.add(add1);
    }

    public void gemsCollectd() {
        Gem one = new Gem( "Kashmir Sapphire", "A gem found with dark blue to lighter hues.", false);
        Gem two = new Gem("Emerald", "A gem that displays a rich green hue", false);
        Gem three = new Gem("Yowah Nut Opal", "A gem that displays a variety of colors", false);
        list.add(one);
        list.add(two);
        list.add(three) ;
    }




}
