import java.util.Scanner;

public class Game {
    Scanner scan = new Scanner(System.in);
    private String name;
    private Gem[] gemOrder;
    private Space[][] map;

    public Game() {
        setUp();
    }

    public void Start() {
        name();
        setUp();
        printMap();
        menu();
    }

    public void name() {
        System.out.println("What is your name?");
        String n = scan.nextLine();
        name = n;
    }

    public void menu() {

    }

    private void setMap() {
        map = new Space[15][15];
    }

    private void printMap() {
        for(Space[] row : map) {
            for(Space space : row) {
                System.out.print(new Space());
            }
            System.out.println();
        }

    }

    private void setUp() {
        Gem one = new Gem("K", "Kashmir Sapphire", "A gem normally found in the Himalayas in North India with dark blue to lighter hues.");
        Gem two = new Gem("E","Emerald", "A gem that displays a rich green hue");
        Gem three = new Gem("Y","Yowah Nut Opal", "A gem that displays a variety of colors");
        gemOrder[0] = one;
        gemOrder[1] = two;
        gemOrder[2] = three;
    }



}
