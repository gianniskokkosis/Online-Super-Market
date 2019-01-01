
public class BonusCard {

    private int points;
    static BonusCard[] bonus = new BonusCard[20];
    private static int number = 0;

    public BonusCard(int points) {
        BonusCard.bonus[number] = this;
        number++;
        this.points = points;
    }

    public BonusCard() {
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    @Override
    public String toString() {
        return "BonusCard{" + "points=" + points + '}';
    }

}
