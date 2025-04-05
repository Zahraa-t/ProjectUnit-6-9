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
        return "\n" + getSymbol() + "\n" + super.toString();
    }
}