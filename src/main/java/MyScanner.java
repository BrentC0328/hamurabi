package hammurabi.src.main.java;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MyScanner {
    Scanner scanner = new Scanner(System.in);


    public Integer askHowManyAcresToBuy(Integer landValue, Integer bushelsOfGrain) {
        Integer acres = null;

        do {
            System.out.println("How many acres of land are you buying?");
            try {
                acres = scanner.nextInt();

                if (bushelsOfGrain < (landValue * acres)) {
                    System.out.println("You do not have enough bushels to buy this. Try again");
                    acres = null;
                }
            } catch (InputMismatchException e) {
                System.out.println("\"" + scanner.next() + "\" isn't a number!");
            }

        } while (acres == null);


        return Math.abs(acres);
    }

    public Integer askHowManyAcresToSell(Integer acresOwned) {
        Integer acres = null;

        do {
            System.out.println("How many acres of your land would you like to sell?");
            try {
                acres = scanner.nextInt();

                if (acresOwned < acres) {
                    System.out.println("You do not have that many acres to sell.");
                    acres = null;
                }
            } catch (InputMismatchException e) {
                System.out.println("\"" + scanner.next() + "\" isn't a number!");
            }
        } while (acres == null);

        return Math.abs(acres);

    }

    public Integer askHowMuchGrainToFeedPeople(Integer bushelsOfGrain) {
        int bushelsToFeedPeople = 1000000;
        while (bushelsToFeedPeople > bushelsOfGrain) {

            System.out.println("How much grain should we feed our people");
            try {
                bushelsToFeedPeople = scanner.nextInt();

                if (bushelsToFeedPeople > bushelsOfGrain) {
                    System.out.println("We do not have enough grain to feed people that much");
                }
            } catch (InputMismatchException e) {
                System.out.println("\"" + scanner.next() + "\" isn't a number!");
            }
        }

        return Math.abs(bushelsToFeedPeople);

    }

    public Integer askHowManyAcresToPlant(Integer acresOwned, Integer people, Integer bushelsOfGrain) {
        Integer acresToPlant = null;
        boolean acresCheck = true;

        do {
            System.out.println("How many acres would you plant with our grains?");
            try {
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

            } catch (InputMismatchException e) {
                System.out.println("\"" + scanner.next() + "\" isn't a number!");
            }

        } while (!acresCheck);

        return Math.abs(acresToPlant);
    }

    public String printSummary(Integer year, Integer peopleDead, Integer peopleEntered, Integer population,
                               Integer bushelsHarvested, Integer grainsEatenByRats, Integer bushels, Integer acresOfLand, Integer landValue) {

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

    public String finalSummary(int acresOwned, int acresPerPerson, int peopleStarved, int bushelsOfGrain){

        StringBuilder summary = new StringBuilder();
        summary.append("My Lord. You have survived the 10 year reign.\n");
        summary.append("Your lands span a total of ").append(acresOwned).append(" acres. This is ").append(acresPerPerson).append(" acres for each of your loyal subjects.\n");
        summary.append("A total of ").append(peopleStarved).append(" people have starved during this reign. A hard choice that many rulers would not have had the fortitude to make.\n");
        summary.append("We have ").append(bushelsOfGrain).append(" bushels remaining.\n");
        summary.append("The kingdom is set to flourish going into the next decade.");

        return summary.toString();

    }

}
