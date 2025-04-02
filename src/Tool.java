public class Tool extends Item {
    private boolean collectedAlready;

    public Tool(String symbol, String name, String instructions, boolean collectedAlready) {
        super(symbol, name, instructions);
        this.collectedAlready = collectedAlready;
    }

    public boolean isCollectedAlready() {
        return collectedAlready;
    }

    public void setCollectedAlready(boolean collectedAlready) {
        this.collectedAlready = collectedAlready;
    }

    @Override
    public String toString() {
        return super.toString() + ", is collected: ";
    }

    public void use() {
        System.out.println("You used this item. You can't use it anymore. It's gone forever. ");
    }
}