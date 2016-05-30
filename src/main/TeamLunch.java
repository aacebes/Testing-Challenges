package main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TeamLunch {

    private int casesAmount;

    private int[] dinnersForEachCase;

    private int[] tablesAmountForEachCase;

    public void initializeDinnersDataFromInputFile(String inputFileRoute) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new FileReader(inputFileRoute));
        casesAmount = Integer.parseInt(reader.readLine());
        loadDinnersData(reader);
        reader.close();
        initializeTablesResults();
    }

    private void loadDinnersData(BufferedReader reader) throws IOException {
        dinnersForEachCase = new int[casesAmount];
        for (int i = 0; i < casesAmount; i++) {
            dinnersForEachCase[i] = Integer.parseInt(reader.readLine());
        }
    }

    private void initializeTablesResults() {
        tablesAmountForEachCase = new int[casesAmount];
        for (int i = 0; i < casesAmount; i++) {
            tablesAmountForEachCase[i] = -1;
        }
    }

    public int getCasesAmount() {
        return casesAmount;
    }

    public int[] getDinnnersForEachCase() {
        return dinnersForEachCase;
    }

    public int[] getTablesAmountForEachCase() {
        return tablesAmountForEachCase;
    }

    public void writeResultsInFile(String outputFileRoute) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileRoute));
        for (int i = 0; i < casesAmount; i++) {
            writer.write("Case #" + (i + 1) + ": " + tablesAmountForEachCase[i] + "\n");
        }
        writer.close();
    }

    public void sitPeople() {
        for (int i = 0; i < dinnersForEachCase.length; i++) {
            if (dinnersForEachCase[i] == 0) {
                tablesAmountForEachCase[i] = 0;
            } else if (dinnersForEachCase[i] < 5) {
                tablesAmountForEachCase[i] = 1;
            } else if ((dinnersForEachCase[i] > 4) && (dinnersForEachCase[i] % 2 == 0)){
                tablesAmountForEachCase[i] = (dinnersForEachCase[i] - 2) / 2;
            }
        }
    }
}
