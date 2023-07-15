package hammurabi.src.main.java;

import java.util.Random;

public class RandomEvents {
    Random random = new Random();

    public Integer plagueDeaths(int population) {
        int plagueDeaths = 0;
        int beforePop = population;
        if (random.nextDouble() >= .15) {
            population = population / 2;
            plagueDeaths = beforePop - population;
        }

        return population;
    }

    public Integer starvationDeaths(int population, int bushelsFedToPeople) {
        int peopleFed = bushelsFedToPeople / 20;

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
        double randomPercentageEaten = (random.nextInt(3) + 1) * .1;
        if (random.nextDouble() >= .40){
            double ratEaten = bushels * randomPercentageEaten;
            bushels = (int) (bushels - ratEaten);

        }
        return bushels;
    }

    public Integer newCostOfLand(){
        return random.nextInt(17,24);
    }
}
