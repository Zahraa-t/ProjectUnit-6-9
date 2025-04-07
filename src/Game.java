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

        System.out.println("You find yourself in a mysterious room. Find your way out.");

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
                        System.out.println(w);
                        if (w instanceof Gem) {
                            journal.addGems((Gem) w);
                            map[r-1][c] = new Space(" ");
                        }
                        if (w instanceof Tool && !((Tool) w).isCollectedAlready()) {
                            shortcut(w);
                        }
                        if (journal.exitCheck(w)) {
                            done = true;
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
                            map[r][c-1] = new Space(" ");
                        }
                        if (a instanceof Tool) {
                            shortcut(a);
                        }
                        if (journal.exitCheck(a)) {
                            done = true;
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
                            map[r+1][c] = new Space(" ");
                        }
                        if (s instanceof Tool && !((Tool) s).isCollectedAlready()) {
                            shortcut(s);
                        }
                        if (journal.exitCheck(s)) {
                            done = true;
                        }
                    } else {
                        System.out.println("You are moving out of bounds!");
                    }
                }
            }
            if (ans.equals("D")) {
                Space d = map[r][c+1];
                if ((c + 1) < map[0].length-1 && !(d instanceof Item)) {
                    map[r][c] = new Space(" ");
                    c++;
                } else {
                    if (d instanceof Item) {
                        System.out.println("Found: " + ((Item) d).getName());
                        System.out.println(((Item) d).getText());
                        if (d instanceof Gem) {
                            journal.addGems((Gem) d);
                            map[r][c+1] = new Space(" ");
                        }
                        if (d instanceof Tool) {
                            shortcut(d);
                        }
                        if (journal.exitCheck(d)) {
                            done = true;
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
        win();
    }

    private void shortcut(Space e) {
        bookRiddle(e);
        journal.chest(e);
        if (journal.floor(e)) {
            System.out.println("\nYou hear a strange click...What was that? ");
            map[2][13] = new Tool("⬓", "Treasure Chest Secret Compartment", "The chest now has a secret compartment that can be opened with a circular object", false);
            map[2][4] = new Tool("-", "Opened floor ", "You previously found a crowbar", false);
        }
        journal.chest2(e);
    }

    private void bookRiddle(Space move) {
        if (((Item)move).getName().equals("Table")) {
            if (journal.findDiscoveries("Key") == -1) {
                int guessRight = 0;
                    System.out.println("You've found a very special book. Maybe if you solve its riddle you'll get something that can help you.");
                while (guessRight == 0) {
                    System.out.println("\nWhat has keys but can’t open locks?");
                    String a = scan.nextLine();
                    if (a.toLowerCase().equals("keyboard")) {
                        Tool f = new Tool("\uD83D\uDDDD", "Key", "Can unlock a treasure chest", false);
                        System.out.println("You got it right!");
                        System.out.println("You gained a key. \uD83D\uDDDD\n");
                        journal.addToTools(f);
                        guessRight++;
                    } else {
                        System.out.println("That's wrong...\n");
                    }
                }
            } else {
                System.out.println("You've already obtained its key. Look around for its use. ");
            }
        }
    }



    private void win() {

        System.out.println(
                "\n-------------------------\n" +
                "---\\    /---|---|\\ |-----\n" +
                "----\\/\\/----|---| \\|-----\n" +
                "-------------------------\n"
        );
    }


    private void setMap() {
        map = new Space[7][15];
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
        map[5][14] = new Item("X", "The Exit", "It is sealed shut by some magic. It requires 4 gemstones to open. ");
        map[2][4] = new Tool("#", "Crack in the floor ", "Maybe it can be broken open", false);
        map[5][1] = new Tool("▤", "Table with holding items", "Vases and cups stand on a table", false);
        map[4][1] = new Tool("▬", "Table", "A frayed book rests upon a lone pine table", false);
        map[2][13] = new Tool("⮹", "Treasure Chest", "Can unlock with a key", false);
        map[1][9] = new Tool("▣", "Crate", "It stands on its own", false);


        map[1][2] = new Gem( Colors.BLUE + "\uD83D\uDC8ESapphire\uD83D\uDC8E" + Colors.RESET, "A gem found with dark blue to lighter hues",false);
        map[3][11] = new Gem( Colors.GREEN + "\uD83D\uDC8EEmerald\uD83D\uDC8E" + Colors.RESET, "A gem that shows off a rich green shine", false);
        map[5][6] = new Gem("\uD83D\uDC8EOpal\uD83D\uDC8E", "A gem that displays a variety of colors", false);

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