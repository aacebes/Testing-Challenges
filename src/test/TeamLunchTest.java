package test;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.junit.Test;

import main.TeamLunch;

public class TeamLunchTest {

    TeamLunch teamLunch = new TeamLunch();

    @Test
    public void shouldCorrectlyInitializeDataStructureFromAnInputFile() throws NumberFormatException, IOException {
        // Given
        String inputFileRoute = "files/tests/test_input.txt";

        // When
        teamLunch.initializeDinnersDataFromInputFile(inputFileRoute);

        // Then
        int casesAmount = teamLunch.getCasesAmount();
        assertThat(casesAmount, is(3));

        int[] dinnersToSitForEachCase = teamLunch.getDinnnersForEachCase();
        assertThat(dinnersToSitForEachCase.length, is(casesAmount));
        assertThat(dinnersToSitForEachCase[0], is(24));
        assertThat(dinnersToSitForEachCase[1], is(5913));
        assertThat(dinnersToSitForEachCase[2], is(3));
    }

    @Test
    public void shouldCorrectlyInitilizeStructuresForResultsAfterReadingFromFile()
            throws NumberFormatException, IOException {
        // Given
        String inputFileRoute = "files/tests/test_input.txt";

        // When
        teamLunch.initializeDinnersDataFromInputFile(inputFileRoute);

        // Then
        int casesAmount = teamLunch.getCasesAmount();
        assertThat(casesAmount, is(3));

        int[] tablesAmountForEachCase = teamLunch.getTablesAmountForEachCase();
        assertThat(tablesAmountForEachCase.length, is(casesAmount));
        for (int i = 0; i < teamLunch.getCasesAmount(); i++) {
            assertThat(tablesAmountForEachCase[i], is(-1));
        }
    }

    @Test
    public void shouldCreateAnOutputFileWithOneLineDescribingEachCase() throws IOException {
        // Given
        String outputFileRoute = "files/tests/test_output.txt";

        // When
        teamLunch.writeResultsInFile(outputFileRoute);

        // Then
        BufferedReader reader = new BufferedReader(new FileReader(outputFileRoute));
        int[] tablesAmountForEachCase = teamLunch.getTablesAmountForEachCase();
        for (int i = 0; i < teamLunch.getCasesAmount(); i++) {
            assertThat(reader.readLine(), equalTo("Case #" + i + ": " + tablesAmountForEachCase[0]));
        }
        assertThat(reader.read(), is(-1));
        reader.close();
    }

    @Test
    public void shouldNeedZeroTableWhenThereAreNoDinners() throws NumberFormatException, IOException {
        // Given
        String inputFileRoute = "files/tests/test_zero_dinners.txt";
        teamLunch.initializeDinnersDataFromInputFile(inputFileRoute);

        // When
        teamLunch.sitPeople();

        // Then
        int[] tablesAmountForEachCase = teamLunch.getTablesAmountForEachCase();
        assertThat(tablesAmountForEachCase[0], is(0));
    }
}
