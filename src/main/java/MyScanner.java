package hammurabi.src.main.java;

import java.util.Scanner;

public class MyScanner {
    Scanner scanner = new Scanner(System.in);


    public Integer askHowManyAcresToBuy(Integer landValue, Integer bushelsOfGrain) {
        Integer acres;

        do {
            System.out.println("How many acres of land are you buying?");
            acres = scanner.nextInt();

            if (bushelsOfGrain < (landValue * acres)) {
                System.out.println("You do not have enough bushels to buy this. Try again");
                acres = null;
            }

        } while (acres == null);


        return acres;
    }

    public Integer askHowManyAcresToSell(Integer acresOwned) {
        Integer acres;

        do {
            System.out.println("How many acres of your land would you like to sell?");
             acres = scanner.nextInt();

            if (acresOwned < acres){
                System.out.println("You do not have that many acres to sell.");
                acres = null;
            }
        } while (acres == null);

        return acres;

    }

    public Integer askHowMuchGrainToFeedPeople(Integer bushelsOfGrain) {
        Integer bushelsToFeedPeople = 1000000;
        while (bushelsToFeedPeople > bushelsOfGrain) {

            System.out.println("How much grain should we feed our people");
            bushelsToFeedPeople = scanner.nextInt();

            if (bushelsToFeedPeople > bushelsOfGrain) {
                System.out.println("We do not have enough grain to feed people that much");
            }
        }

        return bushelsToFeedPeople;

    }

    public Integer askHowManyAcresToPlant(Integer acresOwned, Integer people, Integer bushelsOfGrain) {
        Integer acresToPlant;
        boolean acresCheck = true;

        do {
            System.out.println("How many acres would you plant with our grains?");
            acresToPlant = scanner.nextInt();
            acresCheck = true;

            if (people * 10 < (acresToPlant)) {
                System.out.println("We do not have enough people to plant these many acres.");
                acresCheck = false;
            }
            if (bushelsOfGrain < acresToPlant * 2) {
                System.out.println("We do not have enough Bushels to plant the lands!");
               acresCheck = false;
            }
            if (acresToPlant > acresOwned) {
                System.out.println("We cannot plant on more acres than we have!");
                acresCheck = false;
            }
        } while (!acresCheck);

        return acresToPlant;
    }

    public String printSummary(Integer year, Integer peopleDead, Integer peopleEntered, Integer population,
                               Integer bushelsHarvested,Integer grainsEatenByRats, Integer bushels, Integer acresOfLand, Integer landValue) {

        StringBuilder summary = new StringBuilder();
        summary.append("O great Hammurabi!").append("\n")
                .append("You are in year ").append(year).append(" of your ten year rule.").append("\n")
                .append("In the previous year, ").append(peopleDead).append(" citizens starved to death").append("\n")
                .append("In the previous year ").append(peopleEntered).append(" new citizens have entered the kingdom").append("\n")
                .append("The population is now ").append(population).append("\n")
                .append("We harvested ").append(bushelsHarvested).append(" bushels from the fields. ").append("\n")
                .append("Rats have eaten ").append(grainsEatenByRats).append(" bushels, leaving ").append(bushels).append(" in storage.").append("\n")
                .append("The city currently owns ").append(acresOfLand).append(" acres of land.").append("\n")
                .append("Land is currently worth ").append(landValue).append(" bushels per acre.").append("\n");

        return summary.toString();
    }

}
