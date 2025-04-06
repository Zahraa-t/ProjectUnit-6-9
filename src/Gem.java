public class Gem extends Item {
    private boolean collected;
    private boolean trick;

    public Gem(String name, String description, boolean trick) {
        super("⟠", name, description);
        this.trick = trick;
        collected = false;
    }

    public boolean isTrick() {
        return trick;
    }

    public boolean isCollected() {
        return collected;
    }

    public void treasureChest() {
        System.out.println(
            "⠀⠀⠀___________________________⠀⠀⠀\n" +
            "⠀⠀⠀|                         |⠀⠀⠀\n" +
            "⠀⠀⠀|               ⊹         |⠀⠀⠀\n" +
            "⠀⠀⠀|         ⊹  ⟠            |⠀⠀⠀\n" +
            "⠀⠀⠀|              ⊹          |⠀⠀⠀\n" +
            "⠀⠀⢀⣿⡇⢸⣿⣿⠀⣿⣿⣿⠟⠛⠛⠛⠛⠻⣿⣿⣿⠀⣿⣿⡇⢸⣿⡀⠀⠀\n" +
            "⠀⠀⢈⡉⢁⣀⣉⣉⣀⣉⣉⣉⠀⣴⠖⠲⣦⠀⣉⣉⣉⣀⣉⣉⣀⡈⢉⡁⠀⠀\n" +
            "⠀⠀⢸⡇⢸⣿⣿⣿⣿⣿⣿⣿⠀⣿⣦⣴⣿⠀⣿⣿⣿⣿⣿⣿⣿⡇⢸⡇⠀⠀\n" +
            "⠀⠀⢸⡇⢸⣿⣿⣿⣿⣿⣿⣿⠀⣿⣿⣿⣿⠀⣿⣿⣿⣿⣿⣿⣿⡇⢸⡇⠀⠀\n" +
            "⠀⠀⢸⡇⢸⣿⣿⣿⣿⣿⣿⣿⣀⣉⣉⣉⣉⣀⣿⣿⣿⣿⣿⣿⣿⡇⢸⡇⠀⠀\n" +
            "⠀⠀⠘⠇⢸⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡇⠸⠃⠀⠀\n" +
            "The treasure chest opens and reveals a new gem. ");
    }
}
