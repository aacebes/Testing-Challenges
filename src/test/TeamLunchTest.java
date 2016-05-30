package test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

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
            throws NumberFormatException, IOException{
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
    public void outputTest() {
        fail("Not yet implemented");
    }

    @Test
    public void algorithmTest() {
        fail("Not yet implemented");
    }
}
