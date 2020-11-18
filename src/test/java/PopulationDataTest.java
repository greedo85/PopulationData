import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PopulationDataTest {

    /*static PopulationData populationData;

    @BeforeAll
    public static void init() {
        populationData = new PopulationData(10);
    }*/

    @Test
    public void generatePersonTest() {
        //when
        PopulationData populationData=new PopulationData(10);
       // populationData.generatePeople(10);
        System.out.println(populationData.citizens);
        //then
        assertEquals(10, populationData.citizens.size());
    }

}
