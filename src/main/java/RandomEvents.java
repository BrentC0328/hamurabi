package hammurabi.src.main.java;

import java.util.Random;

public class RandomEvents {
    Random random = new Random();

    public Integer plagueDeaths(int population) {
        int plagueChance = random.nextInt(100) + 1;
        int plagueDeaths = 0;
        if (plagueChance >= 15) {
            plagueDeaths = population / 2;
        }

        return plagueDeaths;
    }

    public Integer starvationDeaths(int population, int bushelsFedToPeople) {
        int peopleFed = bushelsFedToPeople / 20;
        if (peopleFed >= population){
            return 0;
        }

        //each population needs 20 bushels to be fed.
        return population - peopleFed;
    }

    public boolean uprising(int population, int howManyPeopleStarved) {
        //if more than 45% of the people starved, thrown out of office. end game.
        double fourtyFivePercentOfPeople = population * .45;

        if (howManyPeopleStarved > fourtyFivePercentOfPeople) {
            return true;
        }
        return false;
    }

    public Integer immigrants(int population, int acresOwned, int grainInStorage){
        Integer incomingImmigrants = (20 * acresOwned + grainInStorage) / (100 * population) + 1;

        return incomingImmigrants;
    }

    public Integer harvest(int acres){
        Integer plantedNumber = random.nextInt(6) + 1;

        return plantedNumber * acres;
    }

    public Integer grainEatenByRats(int bushels){
        int bushelsEatenChance = random.nextInt(100) + 1;
        double eatenBushels = 0.0;

        if (bushelsEatenChance >= 40){
            double eatenPercenage = random.nextDouble(.099, .301);
            eatenBushels = bushels * eatenPercenage;
        }
        return (int) eatenBushels;
    }

    public Integer newCostOfLand(){
        return random.nextInt(17,24);
    }
}
