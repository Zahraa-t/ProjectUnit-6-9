public class Gem extends Space {
    private String name;
    private String description;

    public Gem(String symbol, String name, String description) {
        super(symbol);
        this.name = name;
        this.description = description;
    }

    @Override
    public String getSymbol() {
        return super.getSymbol();
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
