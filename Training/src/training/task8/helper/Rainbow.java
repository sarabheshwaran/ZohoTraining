package training.task8.helper;

public enum Rainbow {

	VIOLET(1),
    INDIGO(2),
    BLUE(3),
    GREEN(4),
    YELLOW(5),
    ORANGE(6),
    RED(7);

    private final int colorCode;

    Rainbow(int colorCode) {
        this.colorCode = colorCode;
    }

    public int getCode() {
        return colorCode;
    }
	
}
