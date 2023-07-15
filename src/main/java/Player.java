package hammurabi.src.main.java;

public class Player {

    private Integer people;
    private Integer bushelsOfGrain;
    private Integer acresOfLand;
    private Integer landValue;

    public Player(Integer people, Integer bushelsOfGrain, Integer acresOfLand, Integer landValue) {
        this.people = people;
        this.bushelsOfGrain = bushelsOfGrain;
        this.acresOfLand = acresOfLand;
        this.landValue = landValue;
    }

    public Integer getPeople() {
        return people;
    }

    public void setPeople(Integer people) {
        this.people = people;
    }

    public Integer getBushelsOfGrain() {
        return bushelsOfGrain;
    }

    public void setBushelsOfGrain(Integer bushelsOfGrain) {
        this.bushelsOfGrain = bushelsOfGrain;
    }

    public Integer getAcresOfLand() {
        return acresOfLand;
    }

    public void setAcresOfLand(Integer acresOfLand) {
        this.acresOfLand = acresOfLand;
    }

    public Integer getLandValue() {
        return landValue;
    }

    public void setLandValue(Integer landValue) {
        this.landValue = landValue;
    }

    @Override
    public String toString() {
        return "Player{" +
                "people=" + people +
                ", bushelsOfGrain=" + bushelsOfGrain +
                ", acresOfLand=" + acresOfLand +
                ", landValue=" + landValue +
                '}';
    }
}
