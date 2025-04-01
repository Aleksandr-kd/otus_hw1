package data;

public enum AnimalTypeData {
    CAT("cat"),
    DOG("dog"),
    DUCK("duck");

    private String name;

    AnimalTypeData(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
