import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;
import java.util.Random;


@Getter
public class Citizen {
    private LocalDate birthDate;
    private LocalDate passDate;
    private String adress;
    private char gender;
    private char martialStatus;

    public Citizen() {
        this.birthDate =generateDate();
        this.passDate = generateDate();
        this.adress = adress;
        this.gender = gender;
        this.martialStatus = martialStatus;
    }

    public LocalDate generateDate() {

        int year = (int) (Math.random() * ((2020 - 1920) + 1));
        int month = (int) (Math.random() * ((12 - 1) + 1));
        int day = (int) (Math.random() * ((30-1) + 1));
        return LocalDate.of(year,month,day);
    }
    //zakres adresów musi być taki żeby się powtarzały
    public String generateAdress()
    {
        return String adress=
    }
}
