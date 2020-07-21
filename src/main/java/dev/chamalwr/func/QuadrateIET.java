package dev.chamalwr.func;

import dev.chamalwr.util.CollectionsUtility;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QuadrateIET {

    private static final int[] RICE_BAGS = {1, 2, 4};
    private static final List<Double> remainingRiceBags = new ArrayList<>();
    private static Map<Integer, Integer> solutionMap = new HashMap<>();
    private static final List<Integer> providedRiceBags = new ArrayList<>();

    public void takeOrder(double weight){
        if (weight - ((int) weight) > 0.5 || weight - (int) weight < 0.0 || weight - ((int) weight) != 0.5){
            System.out.println("We are unable to process this order");
        }else{
            processOrder(weight);
        }
    }

    public static void processOrder(double weight){
        int kilogramAmount = (int) weight;
        double gramAmount = weight - (int) weight;
        findSolution(kilogramAmount, gramAmount);
    }

    public static void findSolution(int kilogramAmount, double gramAmount){

        if (kilogramAmount == 0 && gramAmount == 0.00){
            System.out.println("Order Completed Using : ");
            providedRiceBags
                    .forEach((val) -> System.out.println(val + "Kg packet"));
            return;
        }

        while (kilogramAmount > 0){
            for (int i = 0; i < RICE_BAGS.length; i++) {
                if (kilogramAmount - RICE_BAGS[i] >= 0) {
                    solutionMap.put(i, kilogramAmount - RICE_BAGS[i]);
                }
            }

            solutionMap = CollectionsUtility.sortHashMapByKey(solutionMap);

            int minimumPossiblePacket = (int) solutionMap.keySet().toArray()[0];
            providedRiceBags.add(RICE_BAGS[minimumPossiblePacket]);
            kilogramAmount -= RICE_BAGS[minimumPossiblePacket];
        }

        if (gramAmount != 0.00){
            providedRiceBags.add(RICE_BAGS[0]);
            remainingRiceBags.add(RICE_BAGS[0] - gramAmount);
            gramAmount -= gramAmount;
        }

        findSolution(kilogramAmount, gramAmount);
    }
}
