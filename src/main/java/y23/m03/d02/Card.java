package y23.m03.d02;

public enum Card {
    Ace("Ass", 11),
    Two("2", 2),
    Three("3", 2),
    Four("4", 2),
    Five("5", 2),
    Six("6", 2),
    Seven("7", 2),
    Eight("8", 2),
    Nine("9", 2),
    Ten("10", 2),
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
