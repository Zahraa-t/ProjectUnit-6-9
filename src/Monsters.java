public class Monsters {
    private String name;
    private String description;
    private int dangerLevel;

    public Monsters(String name, String description, int dangerLevel) {
        this.name = name;
        this.description = description;
        this.dangerLevel = dangerLevel;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getDangerLevel() {
        return dangerLevel;
    }
}
