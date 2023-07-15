package hammurabi.src.main.java;

import java.util.Random;
import java.util.Scanner;

public class Hammurabro {
    MyScanner scanner = new MyScanner();

    public static void main(String[] args) {
        new Hammurabro().playGame();
    }

    void playGame() {

        Integer year = 1;
        Integer population = 100;
        Integer bushelsOfGrain = 2800;
        Integer acresOfLand = 1000;
        Integer landValue = 19;

        Integer peopleDead = 0;
        Integer peopleEntered = 0;
        Integer bushelsPerAcre = 0;
        Integer bushelsHarvested = 0;


        Player player = new Player(population, bushelsOfGrain, acresOfLand, landValue);

        while (year <= 10) {

            System.out.println(scanner.printSummary(year, peopleDead, peopleEntered, player.getPeople(), bushelsHarvested,
                    bushelsPerAcre, player.getBushelsOfGrain(), player.getAcresOfLand(), player.getLandValue()));

            Integer boughtAcres = scanner.askHowManyAcresToBuy(landValue, bushelsOfGrain);
            player.setAcresOfLand(acresOfLand + boughtAcres);
            player.setBushelsOfGrain(bushelsOfGrain - (boughtAcres * landValue));

            if (boughtAcres == 0) {
                Integer soldAcres = scanner.askHowManyAcresToSell(acresOfLand);
                player.setAcresOfLand(acresOfLand - soldAcres);
                player.setBushelsOfGrain(bushelsOfGrain - (soldAcres * landValue));
            }

            Integer grainsToFeedPeople = scanner.askHowMuchGrainToFeedPeople(bushelsOfGrain);
            player.setPeople(player.getPeople() - (player.getPeople() - (grainsToFeedPeople / 20)));

            Integer acresToPlant = scanner.askHowManyAcresToPlant(acresOfLand, population, bushelsOfGrain);
            player.setAcresOfLand(player.getAcresOfLand() + acresToPlant);
            player.setBushelsOfGrain(player.getBushelsOfGrain() - (acresToPlant * 2));






            year += 1;


        }


    }
}
