import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
@ToString
public class PopulationData {

    List<Citizen> citizens = new ArrayList<>();

    public PopulationData( int number ) {
        generatePeople(number);
    }

    public void generatePeople( int number ) {
        for (int i = 0; i < number; i++) {
            citizens.add(new Citizen());
        }
    }
}
