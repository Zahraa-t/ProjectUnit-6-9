public class Item extends Space{
    private String name;
    private String text;

    public Item(String symbol, String name, String text) {
        super(symbol);
        this.name = name;
        this.text = text;
    }

    @Override
    public String getSymbol() {
        return super.getSymbol();
    }
}