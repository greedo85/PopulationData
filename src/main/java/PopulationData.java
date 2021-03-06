import javafx.collections.ObservableList;
import lombok.ToString;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

    public List findKids() {
        List<Citizen> kids = citizens.stream().filter(x ->
        {
            LocalDate years = LocalDate.now().minusYears(5);
            return x.getBirthDate().isAfter(years) && x.getPassDate() == null;

        }).collect(Collectors.toList());
        System.out.println("Dzieci nie starsze niż 5 lat: " + kids);
        return kids;
    }

    public List passedIn5Years() {
        List<Citizen> passedIn5 = citizens.stream().filter(c ->
        {
            LocalDate fiveYearsBack = LocalDate.now().minusYears(5);
            return c.getPassDate() != null && c.getPassDate().isAfter(fiveYearsBack);
        }).collect(Collectors.toList());
        System.out.println("Zmarli w ciągu ostatnich 5 lat: \n" + passedIn5);
        return passedIn5;
    }

    public List threeOldesSingles() {
        List<Citizen> threeOldesSingles=null;
        List<Citizen> oldestSingles = citizens.stream().filter(v ->
        {
            return v.getMartialStatus() == 'W' && v.getPassDate() == null && v.getGender() == 'K';
        }).sorted(new BirthDateComparator()).distinct().collect(Collectors.toList());
        try {
            threeOldesSingles = oldestSingles.subList(0, 2);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Brak singielek");
        }
        System.out.println("Najstarsze singielki: " + threeOldesSingles);
        return threeOldesSingles;
    }

    public void averageLifetime() {
        List<Citizen> notDead = citizens.stream().filter(( p ) -> (p.getPassDate() != null)).collect(Collectors.toList());
        List<Long> lifeTime = notDead.stream().map(c -> (ChronoUnit.YEARS.between(c.getBirthDate(), c.getPassDate()))).collect(Collectors.toList());
        long averageLifetime = (lifeTime.stream().reduce((long) 0, ( x, y ) -> x + y)) / notDead.size();
        System.out.println("Lifetime: " + lifeTime);
        System.out.println("Średnia: " + averageLifetime);

        //(ChronoUnit.YEARS.between(p.getBirthDate(),p.getPassDate())));

        //return averageLifetime;
    }
}
