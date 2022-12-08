package lotto.domain;

public enum Rank {
    FIVE_PRICE(3, 0, 5_000L),
    FOUR_PRICE(4, 0, 50_000L),
    THREE_PRICE(5, 0, 1_500_000L),
    SECOND_PRICE(5, 1, 30_000_000L),
    FIRST_PRICE(6, 0, 2_000_000_000L);

    private final int matchCount;
    private final int bonusCount;
    private final long winningPrice;
    Rank(int matchCount, int bonusCount, long winningPrice) {
        this.matchCount = matchCount;
        this.bonusCount = bonusCount;
        this.winningPrice = winningPrice;
    }

    public static Rank getRank(int matchCount, int bonusCount) {
        for (Rank rank : Rank.values()) {
            if (matchCount == rank.matchCount && bonusCount <= rank.bonusCount) {
                return rank;
            }
        }
        throw new IllegalArgumentException();
    }

    public long getWinningPrice() {
        return winningPrice;
    }


}
