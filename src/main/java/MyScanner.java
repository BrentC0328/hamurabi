package hammurabi.src.main.java;

import java.util.Scanner;

public class MyScanner {
    Scanner scanner = new Scanner(System.in);


    public Integer askHowManyAcresToBuy(Integer landValue, Integer bushelsOfGrain){
        Integer acres = 0;
        while (acres < (landValue * bushelsOfGrain)){

            System.out.println("How many acres of land are you buying?");
            acres = scanner.nextInt();

            if (acres < (landValue * bushelsOfGrain)){
                System.out.println("You do not have enough bushels to buy this. Try again");
            }
        }


        return acres;
    }

    public Integer askHowManyAcresToSell(Integer acresOwned){

        System.out.println("How many acres of your land would you like to sell?");
        Integer acres = scanner.nextInt();
        return acres;

    }

    public Integer askHowMuchGrainToFeedPeople(Integer bushelsOfGrain){
        Integer bushelsToFeedPeople = 0;
        while (bushelsToFeedPeople > bushelsOfGrain){

            System.out.println("How much grain should we feed our people");
      bushelsToFeedPeople = scanner.nextInt();
      if ( bushelsToFeedPeople > bushelsOfGrain){
          System.out.println("We do not have enough grain to feed people that much");
      }
        }

        return bushelsToFeedPeople;

    }

    public Integer askHowManyAcresToPlant(Integer acresOwned, Integer people, Integer bushelsOfGrain){
        System.out.println("How many acres would you plant with our grains?");
        Integer acresToPlant = scanner.nextInt();

        //Check if they have enough acresOwned to hold the planting, enough people to do the planting.
        //also enough bushelOfGrain to plant.

        return acresToPlant;
    }

    public String printSummary(Integer year, Integer peopleDead, Integer peopleEntered, Integer population,
                               Integer bushelsHarvested, Integer bushelsPerAcre, Integer acresOfLand, Integer landValue){

        StringBuilder summary = new StringBuilder();
        summary.append("O great Hammurabi!").append("\n")
                .append("You are in year ").append(year).append(" of your ten year rule.").append("\n")
                .append("In the previous year, ").append(peopleDead).append(" starved to death").append("\n")
                .append("In the previous year ").append(peopleEntered).append(" entered the kingdom").append("\n")
                .append("The population is now ").append(population).append("\n")
                .append("We harvested ").append(bushelsHarvested).append(" at ").append(bushelsPerAcre).append(" per acre.").append("\n")
//Write the rats part. Rats destroyed 200 bushels, leaving 2800 bushels in storage.
                .append("The city currently owns ").append(acresOfLand).append(" acres of land.").append("\n")
                .append("Land is currently worth ").append(landValue).append(" bushels per acre.").append("\n");

        return summary.toString();
    }

}
