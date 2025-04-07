public class Gem extends Item {
    private boolean trick;

    public Gem(String name, String description, boolean trick) {
        super("⟠", name, description);
        this.trick = trick;
    }

    public boolean isTrick() {
        return trick;
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
