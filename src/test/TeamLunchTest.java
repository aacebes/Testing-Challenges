package test;

import static org.junit.Assert.*;

import org.junit.Test;

import main.TeamLunch;

public class TeamLunchTest {

    TeamLunch teamLunch = new TeamLunch();

    @Test
    public void shouldCorrectlyInitializeDataStructureFromAnInputFile() throws FileNotFoundException {
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
    public void outputTest() {
        fail("Not yet implemented");
    }

    @Test
    public void algorithmTest() {
        fail("Not yet implemented");
    }
}
