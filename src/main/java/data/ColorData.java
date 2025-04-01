package data;

public enum ColorData {
    RED("красный"),
    GREEN("зеленый"),
    WHITE("белый");

    private String name;

    ColorData(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
