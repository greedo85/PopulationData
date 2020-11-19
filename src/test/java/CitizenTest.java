import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CitizenTest {

    @Test
    public void datesTest() {
        //given
        PopulationData populationData = new PopulationData(1000);
        //when
        boolean checkDates = true;
        try {
            for (Citizen c : populationData.citizens) {
                if (c.getPassDate().isBefore(c.getBirthDate()) && !(c.getPassDate().equals(null))) {
                    checkDates = false;
                    break;
                }
            }
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
        //then
        assertTrue(checkDates);
    }
}
