import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.Random;


@Getter
@ToString
public class Citizen {
    private LocalDate birthDate;
    private LocalDate passDate;
    private String adress;
    private char gender;
    private char martialStatus;

    public Citizen() {
        this.birthDate = generateDate();
        this.passDate = generateDate();
        this.adress = generateAdress();
        this.gender = generateGender();
        this.martialStatus = 'Z';
    }

    public LocalDate generateDate() {

        int year = (int) (2020 - ((Math.random() * (2020 - 1929)) + 1));
        int month = (int) (Math.random() * (12 - 1)) + 1;
        int day = (int) (Math.random() * (28 - 1)) + 1;
        return LocalDate.of(year, month, day);
    }

    //zakres adresów musi być taki żeby się powtarzały
    public String generateAdress() {
        String adress = "";
        for (int i = 0; i < 4; i++) {
            int max = 68;
            int min = 65;
            adress += (char) (min + Math.random() * (max - min) + 1);
        }
        return adress;
    }

    public char generateGender() {

        int number = (int)( Math.random() * (3 - 1) + 1);
        System.out.println("Numer"+number);
        if (number ==1) {
            return 'K';
        } else
            return 'M';
    }
}
