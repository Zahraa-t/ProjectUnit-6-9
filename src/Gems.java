public class Gems extends Item {
    private boolean correct;

    public Gems(String name, String description, boolean correct) {
        super(name, description);
        this.correct = correct;
    }

    public boolean isCorrect() {
        return correct;
    }
}
