public class Gem extends Item {
    private boolean collected;

    public Gem(String name, String description, boolean collected) {
        super("\uD83D\uDC8E", name, description);
        this.collected = collected;
    }

    @Override
    public String getSymbol() {
        return super.getSymbol();
    }

    public void setCollected(boolean collected) {
        this.collected = collected;
    }
}
