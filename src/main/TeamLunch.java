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
            sitPeopleInCase(i);
        }
    }

    private void sitPeopleInCase(int numOfCase) {
        double dinners = dinnersForEachCase[numOfCase];
        
        if (dinners == 0) {
            tablesAmountForEachCase[numOfCase] = 0;
        } else if (dinners < 3) {
            tablesAmountForEachCase[numOfCase] = 1;
        } else {
            tablesAmountForEachCase[numOfCase] = (int)Math.ceil((dinners - 2) / 2);
        }
    }

    public static void main(String[] args) {
        String inputFile = "files/input/submit_input.txt";
        TeamLunch teamLunch = new TeamLunch();
        try {
            teamLunch.initializeDinnersDataFromInputFile(inputFile);
            teamLunch.sitPeople();
            teamLunch.writeResultsInFile("files/input/submit_output.txt");
        }
        // In case file doesn't exist or can't be readed/writed.
        catch (IOException e) {
            e.printStackTrace();
        }

    }
}
