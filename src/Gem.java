public class Gem extends Tool {
    private boolean trick;

    public Gem(String name, String description , boolean trick) {
        super("⟠", name, description);
        this.trick = trick;
    }

    @Override
    public String getSymbol() {
        return super.getSymbol();
    }

    public boolean isTrick() {
        return trick;
    }
}
