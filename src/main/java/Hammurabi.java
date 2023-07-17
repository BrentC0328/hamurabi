package hammurabi.src.main.java;

import java.util.Random;

public class Hammurabi {
    MyScanner scanner = new MyScanner();
    Random randomer = new Random();

    public static void main(String[] args) {
        new Hammurabi().playGame();
    }

    void playGame() {

        Integer year = 1;
        Integer population = 100;
        Integer bushelsOfGrain = 2800;
        Integer acresOfLand = 1000;
        Integer landValue = 19;
        Integer plagueDeaths = 0;
        Integer plagueCount = population;

        Integer peopleStarved = 0;
        Integer peopleEntered = 5;
        Integer bushelsPlanted = 0;
        Integer bushelsHarvested = 0;
        Integer grainsEatenByRats = 0;
        Integer totalPeopleStarved = 0;


        Player player = new Player(population, bushelsOfGrain, acresOfLand, landValue);

        while (year <= 10) {

            System.out.println(scanner.printSummary(year, peopleStarved, peopleEntered, player.getPeople(), bushelsHarvested,
                   grainsEatenByRats, player.getBushelsOfGrain(), player.getAcresOfLand(), player.getLandValue()));


            Integer boughtAcres = scanner.askHowManyAcresToBuy(player.getLandValue(), player.getBushelsOfGrain());

            player.setAcresOfLand(player.getAcresOfLand() + boughtAcres);
            player.setBushelsOfGrain(player.getBushelsOfGrain() - (boughtAcres * player.getLandValue()));

            if (boughtAcres == 0) {
                Integer soldAcres = scanner.askHowManyAcresToSell(player.getAcresOfLand());
                player.setAcresOfLand(player.getAcresOfLand() - soldAcres);
                player.setBushelsOfGrain(player.getBushelsOfGrain() + (soldAcres * player.getLandValue()));
            }

            Integer grainsToFeedPeople = scanner.askHowMuchGrainToFeedPeople(player.getBushelsOfGrain());
            player.setBushelsOfGrain(player.getBushelsOfGrain() - grainsToFeedPeople);



            bushelsPlanted = scanner.askHowManyAcresToPlant(player.getAcresOfLand(), player.getPeople(), player.getBushelsOfGrain());

            //Year events start here
            //Plague deaths. (working)
            plagueDeaths = plagueDeaths(player.getPeople());
            plagueCount = player.getPeople() - plagueDeaths;

            if (!plagueCount.equals(player.getPeople())){
                System.out.println("There was a horrible plague! " + plagueDeaths + " of our citizens have perished!" );
            }
            player.setPeople(plagueCount);

            //This is where people starve (working)
            peopleStarved = starvationDeaths(player.getPeople(), grainsToFeedPeople);
            totalPeopleStarved += peopleStarved;
            player.setPeople(player.getPeople() - peopleStarved);

            //This is where there is an uprising if too many people. (This works) !
            if (uprising(player.getPeople(), peopleStarved)){
                System.out.println("Too many people have starved." + "\n" + "The remaining citizens have gathered at the front door to throw us out." +"\n"
                + "Goodbye!");
                break;
            }

            //This is where we get the immigrants to come in (working)
            if (peopleStarved == 0){
            peopleEntered = immigrants(player.getPeople(), player.getAcresOfLand(), player.getBushelsOfGrain());
            player.setPeople(player.getPeople() + peopleEntered);
            } else { peopleEntered = 0;}

            //This is where the planted bushels are harvested (working)
            bushelsHarvested = harvest(bushelsPlanted);
            player.setBushelsOfGrain(player.getBushelsOfGrain() + bushelsHarvested);

            //This is where the rats eat my shit. (working)
            grainsEatenByRats = grainEatenByRats(bushelsOfGrain);
            player.setBushelsOfGrain(player.getBushelsOfGrain() - grainsEatenByRats);


            //Random value to setup the next years land value (works).
            player.setLandValue(newCostOfLand());



            year += 1;


        }

        if (year > 10){ //(this is untested)
            int acresPerPerson = player.getAcresOfLand() / player.getPeople();
            System.out.println(scanner.finalSummary(player.getAcresOfLand(),acresPerPerson, totalPeopleStarved, player.getBushelsOfGrain() ));
        }


    }

    public Integer plagueDeaths(int population) {
        int plagueChance = randomer.nextInt(100) + 1;
        int plagueDeaths = 0;
        if (plagueChance <= 15) {
            plagueDeaths = population / 2;
        }

        return plagueDeaths;
    }

    public Integer starvationDeaths(int population, int bushelsFedToPeople) {
        int peopleFed = bushelsFedToPeople / 20;

        if (peopleFed > population){
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
        Integer plantedNumber = randomer.nextInt(6) + 1;

        return plantedNumber * acres;
    }

    public Integer grainEatenByRats(int bushels){
        int bushelsEatenChance = randomer.nextInt(100) + 1;
        double eatenBushels = 0.0;

        if (bushelsEatenChance <= 40){
            double eatenPercenage = randomer.nextDouble(.1, .301);
            eatenBushels = bushels * eatenPercenage;
        }
        return (int) eatenBushels;
    }

    public Integer newCostOfLand(){
        return randomer.nextInt(17,24);
    }
}
