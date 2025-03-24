public class Item extends Space{
    private String name;
    private String text;
    private boolean itemHasHint;
    private boolean collectedAlready;

    public Item(String symbol, String name, String text) {
        super(symbol);
        this.name = name;
        this.text = text;
    }


}
