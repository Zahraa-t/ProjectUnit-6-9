import java.util.Scanner;

public class Game {
    Scanner scan = new Scanner(System.in);
    private String name;
    private Gem[] gemOrder;

    public void Start() {
        name();
        menu();
    }

    public void name() {
        System.out.println("What is your name?");
        String n = scan.nextLine();
        name = n;
    }

    public void menu() {

    }

    private String gemSelect() {
        new Gem("K", "Kashmir Sapphire", "A gem normally found in the Himalayas in North India with dark blue to lighter hues.");
        new Gem("E","Emerald", "A gem that displays a rich green hue");
        new Gem("Y","Yowah Nut Opal", "A gem that displays a range of colors");
    }



}
