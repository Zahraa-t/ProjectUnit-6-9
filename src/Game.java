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
        player();
        setUp();
        printMap();
        menu();
    }

    public void player() {
        new Space(".");
    }

    public void menu() {
        int r = map.length-1;
        int c = 0;


        while (map[r][c] != map[0][map[0].length-1]) {
            printMap();
            System.out.println("Enter a direction: W, A, S, D (up, left, down, right)");

            String ans = scan.nextLine();
            if (ans.equals("W")) {
                if ((r - 1) >= 0) {
                    map[r][c] = new Space("_");
                    r--;
                } else {
                    System.out.println("You are moving out of bounds!");
                }
            }
            if (ans.equals("A")) {
                if (c - 1 >= 0) {
                    map[r][c] = new Space("_");
                    c--;
                } else {
                    System.out.println("You are moving out of bounds!");
                }
            }
            if (ans.equals("S")) {
                if (r + 1 < map.length) {
                    map[r][c] = new Space("_");
                    r++;
                } else {
                    System.out.println("You are moving out of bounds!");
                }
            }
            if (ans.equals("D")) {
                if ((c + 1) < map[0].length) {
                    map[r][c] = new Space("_");
                    c++;
                } else {
                    System.out.println("You are moving out of bounds!");
                }
            }
            if (!ans.equals("W") && !ans.equals("A") && !ans.equals("S") && !ans.equals("D")) {
                System.out.println("Invalid direction. ");
            }
        }



    }

    private void setMap() {
        map = new Space[16][16];
        //edgeSum method
//        for (int f = 1; f < map[0].length-1; f++) {
//            new Space("┏")
//        }
//        for (int l = 1; l < map[map.length-1].length-1; l++) {
//        }
//        for (int s1 = 0; s1 < map.length; s1++) {
//        }
//        for (int s2 = 0; s2 < map.length; s2++) {
//
//        }
    }

    private void printMap() {
        for(Space[] row : map) {
            for(Space space : row) {
                System.out.print(new Space("_"));
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
