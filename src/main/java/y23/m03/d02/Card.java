package y23.m03.d02;

public enum Card {
    Ace("Ass", 11),
    Two("2", 2),
    Three("3", 3),
    Four("4", 4),
    Five("5", 5),
    Six("6", 6),
    Seven("7", 7),
    Eight("8", 8),
    Nine("9", 9),
    Ten("10", 10),
    Jack("Bube", 10),
    Lady("Dame", 10),
    King("König", 10);

    private final String name;
    private final int num;

    Card(String name, int num) {
        this.name = name;
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public int getNum() {
        return num;
    }
}
