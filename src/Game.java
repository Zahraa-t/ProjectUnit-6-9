import java.util.Scanner;

public class Game {
    Scanner scan;
    private Space[][] map;
    private Player p;
    private Journal journal;
    private boolean done;

    public Game() {
        scan = new Scanner(System.in);
        done = false;
        name();
        journal = new Journal(p.getName());
        setMap();
        menu();
    }

    public void name() {
        System.out.print("Enter you name: ");
        String n = scan.nextLine();
        p = new Player(n);
    }

    public void menu() {
        int start = 0;
        int r = map.length/2;
        int c = map[0].length/2;
        if (start == 0) {
            map[r][c] = p;
        }

        while (!done) {
            if (start == 0) {
                start++;
            }
            printMap();
            System.out.println("Enter a direction: W, A, S, D (up, left, down, right) / View journal: J");

            String ans = scan.nextLine();
            if (ans.equals("W")) {
                Space w = map[r-1][c];
                if ((r - 1) >= 1 && !(w instanceof Item)) {
                    map[r][c] = new Space(" ");
                    r--;
                } else {
                    if (w instanceof Item) {
                        System.out.println("Found: " + ((Item) w).getName());
                        System.out.println(((Item) w).getText());
                        if (w instanceof Gem) {
                            journal.addGems((Gem) w);
                            w = new Space(" ");
                        }
                        if (w instanceof Tool && !((Tool) w).isCollectedAlready()) {
                            shortcut(w);
                        }
                    } else {
                        System.out.println("You are moving out of bounds!");
                    }
                }
            }
            if (ans.equals("A")) {
                Space a = map[r][c-1];
                if (c - 1 >= 1 && !(a instanceof Item)) {
                    map[r][c] = new Space(" ");
                    c--;
                } else {
                    if (a instanceof Item) {
                        System.out.println("Found: " + ((Item) a).getName());
                        System.out.println(((Item) a).getText());
                        if (a instanceof Gem) {
                            journal.addGems((Gem) a);
                            a = new Space(" ");
                        }
                        if (a instanceof Tool) {
                            shortcut(a);
                        }
                    } else {
                        System.out.println("You are moving out of bounds!");
                    }
                }
            }
            if (ans.equals("S")) {
                Space s = map[r+1][c];
                if (r + 1 < map.length-1 && !(s instanceof Item)) {
                    map[r][c] = new Space(" ");
                    r++;
                } else {
                    if (s instanceof Item) {
                        System.out.println("Found: " + ((Item) s).getName());
                        System.out.println(((Item) s).getText());
                        if (s instanceof Gem) {
                            journal.addGems((Gem) s);
                            s = new Space(" ");
                        }
                        if (s instanceof Tool && !((Tool) s).isCollectedAlready()) {
                            shortcut(s);
                        }
                    } else {
                        System.out.println("You are moving out of bounds!");
                    }
                }
            }
            if (ans.equals("D")) {
                Space s = map[r][c+1];
                if ((c + 1) < map[0].length-1 && !(s instanceof Item)) {
                    map[r][c] = new Space(" ");
                    c++;
                } else {
                    if (s instanceof Item) {
                        System.out.println("Found: " + ((Item) s).getName());
                        System.out.println(((Item) s).getText());
                        if (s instanceof Gem) {
                            journal.addGems((Gem) s);
                            s = new Space(" ");
                        }
                        if (s instanceof Tool) {
                            shortcut(s);
                        }
                    } else {
                        System.out.println("You are moving out of bounds!");
                    }
                }
            }
            if (ans.equals("J")) {
                journal.getJournal();
            }
            if (!ans.equals("W") && !ans.equals("A") && !ans.equals("S") && !ans.equals("D") && !ans.equals("J")) {
                System.out.println("Invalid option. ");
            }
            map[r][c] = p;
        }

    }

    private void shortcut(Space e) {
        journal.chest(e);
        journal.floor(e);
        bookRiddle(e);
    }

    private void bookRiddle(Space move) {
        if (move.getSymbol().equals("\uD83D\uDCD6")) {
            int you = 0;
            System.out.println("What has keys but can’t open locks?");
            String a = scan.nextLine();
            while (you == 0) {
                if (a.toLowerCase().equals("keyboard")) {
                    System.out.println("You got it right!");
                    you++;
                } else {
                    System.out.println("That's so wrong...");
                }
            }
            journal.addToTools(new Tool("\uD83D\uDDDD", "Key", "Can unlock a treasure chest"));
        }
    }


    private void setMap() {
        map = new Space[8][20];
        for (int a = 1; a < map.length-1; a++) {
            map[a][0] = new Space("║");
            map[a][map[0].length-1] = new Space("║");
        }
        for (int b = 1; b < map[0].length-1; b++) {
            map[0][b] = new Space("═");
            map[map.length-1][b] = new Space("═");
        }

        map[0][map[0].length-1] = new Space("╗");
        map[0][0] = new Space("╔");
        map[map.length-1][0] = new Space("╚");
        map[map.length-1][map[0].length-1] = new Space("╝");
        map[6][17] = new Item("X", "The Exit", "It is sealed shut by some magic");
        map[1][7] = new Tool("#", "Crack in the floor ", "Maybe it can be broken open");
        map[6][1] = new Tool("\uD80C\uDEAF", "Table with holding items", "Vases and cups stand on a table");
        map[6][4] = new Tool("\uD80C\uDEB3", "Table", "A frayed book rests upon a lone pine table");
        map[1][18] = new Tool("⮹", "Treasure Chest", "Can unlock with a key");
        // 🛡 🧺 🫖

        map[2][2] = new Gem( Colors.BLUE + "\uD83D\uDC8EKashmir Sapphire\uD83D\uDC8E" + Colors.RESET, "A gem found with dark blue to lighter hues",false);
        map[4][14] = new Gem( Colors.GREEN + "\uD83D\uDC8EEmerald\uD83D\uDC8E" + Colors.RESET, "A gem that shows off a rich green shine", false);
        map[7][6] = new Gem("\uD83D\uDC8EOpal\uD83D\uDC8E", "A gem that displays a variety of colors", false);

        for (int r  = 0; r < map.length; r++) {
            for (int c  = 0; c < map[0].length; c++){
                if (map[r][c] == null) {
                    map[r][c] = new Space(" ");
                }
            }
        }
    }

    private void printMap() {
        for (Space[] row : map) {
            for (Space element : row) {
                System.out.print(element.getSymbol());
            }
            System.out.println();
        }
    }
}