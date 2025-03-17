import java.util.Scanner;

public class Game {
    Scanner scan = new Scanner(System.in);
    private String name;

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
        new Gems("Opal", "Shiny gem that displays a range of colors", false);
        new Gems("Amethyst", "Mineral that shines purple", false);
        new Gems("Sapphire", "Gem with a deep blue hue", false);
        int num = (int) (Math.random() * 3 ) + 1;

    }



}
