public class Player extends Space {
    private String name;

    public Player(String name) {
        super("\uD800\uDC2A");
        this.name = name;
    }

    public String getName() {
        return name;
    }
}