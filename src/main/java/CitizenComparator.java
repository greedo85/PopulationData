import java.util.Comparator;

public class CitizenComparator implements Comparator<Citizen> {
    @Override
    public int compare( Citizen o1, Citizen o2 ) {
        return o1.getBirthDate().compareTo(o2.getBirthDate());
    }
}
