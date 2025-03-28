import java.util.Scanner;

public class Game {
    Scanner scan;
    private Space[][] map;
    private Player p;
    private Journal jou;

    public Game() {
        scan = new Scanner(System.in);
        jou = new Journal();
        name();
        setMap();
        System.out.println(Player.class.getName());
        menu();
    }

    public void name() {
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
            start++;
            printMap();
            System.out.println("Enter a direction: W, A, S, D (up, left, down, right)");

            String ans = scan.nextLine();
            if (ans.equals("W")) {
                if ((r - 1) >= 1) {
                    map[r][c] = new Space(" ");
                    r--;
                } else {
                    System.out.println("You are moving out of bounds!");
                }
            }
            if (ans.equals("A")) {
                if (c - 1 >= 1) {
                    map[r][c] = new Space(" ");
                    c--;
                } else {
                    System.out.println("You are moving out of bounds!");
                }
            }
            if (ans.equals("S")) {
                if (r + 1 < map.length-1) {
                    map[r][c] = new Space(" ");
                    r++;
                } else {
                    System.out.println("You are moving out of bounds!");
                }
            }
            if (ans.equals("D")) {
                if ((c + 1) < map[0].length-1) {
                    map[r][c] = new Space(" ");
                    c++;
                } else {
                    System.out.println("You are moving out of bounds!");
                }
            }
            if (!ans.equals("W") && !ans.equals("A") && !ans.equals("S") && !ans.equals("D")) {
                System.out.println("Invalid direction. ");
            }
            map[r][c] = p;
        }

    }

    private void setMap() {
        map = new Space[20][20];
        for (int a = 1; a < map.length-1; a++) {
            map[a][0] = new Space("║");
            map[a][map[0].length-1] = new Space("║");
        }
        for (int b = 1; b < map[0].length-1; b++) {
            map[0][b] = new Space("═");
            map[map[0].length-1][b] = new Space("═");
        }
        for (int b = 1; b < map.length-1; b++) {

        }

        map[0][map.length-1] = new Space("╗");
        map[0][0] = new Space("╔");
        map[map.length-1][0] = new Space("╚");
        map[map.length-1][map.length-1] = new Space("╝");
        map[14][2] = new Item("w", "Table with a book", "A frayed book rests upon a lone pine table. ");


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
