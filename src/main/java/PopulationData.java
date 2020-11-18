import java.util.ArrayList;
import java.util.List;

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
