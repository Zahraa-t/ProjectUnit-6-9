public class Tool extends Item {
    private boolean collectedAlready;

    public Tool(String symbol, String name, String instructions) {
        super(symbol, name, instructions);
        this.collectedAlready = false;
    }

    public boolean isCollectedAlready() {
        return collectedAlready;
    }

    public void setCollectedAlready(boolean collectedAlready) {
        this.collectedAlready = collectedAlready;
    }

    @Override
    public String toString() {
        if (isCollectedAlready()) {
            return "Already discovered." + super.toString();
        } else {
            return "New discovery! " + super.toString();
        }
    }

    public String chest() {
         return "⠀⠀⠀⢠⡄⢠⣤⣤⠀⣤⣤⣤⣤⣤⣤⣤⣤⣤⣤⣤⣤⠀⣤⣤⡄⢠⡄⠀⠀⠀\n" +
                "⠀⠀⠀⢸⡇⢸⣿⣿⠀⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠀⣿⣿⡇⢸⡇⠀⠀⠀\n" +
                "⠀⠀⠀⣿⡇⢸⣿⣿⠀⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠀⣿⣿⡇⢸⣿⠀⠀⠀\n" +
                "⠀⠀⢀⣿⡇⢸⣿⣿⠀⣿⣿⣿⠟⠛⠛⠛⠛⠻⣿⣿⣿⠀⣿⣿⡇⢸⣿⡀⠀⠀\n" +
                "⠀⠀⢈⡉⢁⣀⣉⣉⣀⣉⣉⣉⠀⣴⠖⠲⣦⠀⣉⣉⣉⣀⣉⣉⣀⡈⢉⡁⠀⠀\n" +
                "⠀⠀⢸⡇⢸⣿⣿⣿⣿⣿⣿⣿⠀⣿⡄⢠⣿⠀⣿⣿⣿⣿⣿⣿⣿⡇⢸⡇⠀⠀\n" +
                "⠀⠀⢸⡇⢸⣿⣿⣿⣿⣿⣿⣿⠀⣿⣧⣼⣿⠀⣿⣿⣿⣿⣿⣿⣿⡇⢸⡇⠀⠀\n" +
                "⠀⠀⢸⡇⢸⣿⣿⣿⣿⣿⣿⣿⣀⣉⣉⣉⣉⣀⣿⣿⣿⣿⣿⣿⣿⡇⢸⡇⠀⠀\n" +
                "⠀⠀⠘⠇⢸⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡇⠸⠃⠀⠀\n" +
                "⠀⠀⢰⣄⠈⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠁⣠⡆⠀⠀\n" +
                "⠀⠀⠘⠛⠃⠈⠙⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠋⠁⠘⠛⠃⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "The treasure chest clicks. Turns out there is a secret compartment. ";
    }
}