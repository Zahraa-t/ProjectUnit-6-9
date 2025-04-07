public class Tool extends Item {
    private boolean collectedAlready;

    public Tool(String symbol, String name, String instructions, boolean collectedAlready) {
        super(symbol, name, instructions);
        this.collectedAlready = collectedAlready;
    }

    public boolean isCollectedAlready() {
        return collectedAlready;
    }

    @Override
    public String toString() {
        return super.toString() + " [" + getSymbol() + "]";
    }
}