package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TeamLunch {

    private int casesAmount;

    private int[] dinnersForEachCase;

    public void initializeDinnersDataFromInputFile(String inputFileRoute) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new FileReader(inputFileRoute));
        casesAmount = Integer.parseInt(reader.readLine());
        dinnersForEachCase = new int[casesAmount];
        for (int i = 0; i < casesAmount; i++) {
            dinnersForEachCase[i] = Integer.parseInt(reader.readLine());
        }
        reader.close();
    }

    public int getCasesAmount() {
        return casesAmount;
    }

    public int[] getDinnnersForEachCase() {
        return dinnersForEachCase;
    }

}
