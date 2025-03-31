public class Tool extends Item {
    private boolean collectedAlready;

    public Tool(String symbol, String name, String instructions, boolean collectedAlready) {
        super(symbol, name, instructions);
        this.collectedAlready = collectedAlready;
    }

    public String adding() {
        if (!collectedAlready) {
            collectedAlready = true;
            return Journal.;
        } else {
            return "This spot is empty. Nothing to collect here. ";
        }
    }
}