public class Hints extends Item {
    private String name;
    private String hint;
    private boolean itemHasHint;
    private boolean collectedAlready;

    public Hints(String symbol, String name, String hint, boolean itemHasHint, boolean collectedAlready) {
        super(symbol, name, hint);
        this.itemHasHint = itemHasHint;
        collectedAlready = false;
    }

    public String deliverHint() {
        if (itemHasHint && !collectedAlready) {
            collectedAlready = true;
            return hint;
        } else {
            return "Nothing helpful is around. Only dust. ";
        }
    }
}
