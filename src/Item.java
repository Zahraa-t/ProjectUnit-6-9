public class Item extends Space{
    private String name;
    private String text;

    public Item(String symbol, String name, String text) {
        super(symbol);
        this.name = name;
        this.text = text;
    }

    public String getName() {
        return name;
    }

    public String getText() {
        return text;
    }

    @Override
    public String toString() {
        return getName() + ", " + getText();
    }
}