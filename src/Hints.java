public class Hints extends Item {
    private String name;
    private String hint;
    private boolean itemHasHint;
    private boolean collectedAlready;

    public Hints(String symbol, String name, String hint, boolean itemHasHint) {
        super(symbol, name, hint);
        this.itemHasHint = itemHasHint;
        collectedAlready = false;
    }
}
