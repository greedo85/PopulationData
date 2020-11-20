import lombok.Getter;

import java.time.LocalDate;


@Getter

public class Citizen  {
    private LocalDate birthDate;
    private LocalDate passDate;
    private String adress;
    private char gender;
    private char martialStatus;

    public Citizen() {
        setDates();
        this.adress = generateAdress();
        this.gender = generateGender();
        this.martialStatus = generateMartialStatus();
    }

    public LocalDate generateDate() {

        int year = (int) (2020 - ((Math.random() * (2020 - 1929)) + 1));
        int month = (int) (Math.random() * (12 - 1)) + 1;
        int day = (int) (Math.random() * (28 - 1)) + 1;
        return LocalDate.of(year, month, day);
    }

    public void setDates() {
        birthDate = generateDate();
        passDate = null;
        if (Math.random() <= 0.7) {
            passDate = null;
        } else {
            passDate = generateDate();
            while (birthDate.isEqual(passDate) || birthDate.isAfter(passDate)) {
                passDate = generateDate();
            }
        }
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

    FunctionalInterface generateGender = () ->
    {
        int number = (int) (Math.random() * (3 - 1) + 1);
        if (number == 1) {
            return 'K';
        } else
            return 'M';
    };

    FunctionalInterface generateMartialStatus = () ->
    {
        int number = (int) (Math.random() * (3 - 1) + 1);
        if (number == 1) {
            return 'Z';
        } else
            return 'W';
    };

    public char generateMartialStatus() {
        return generateMartialStatus.method();
    }

    public char generateGender() {
        return generateGender.method();
    }


    @Override
    public String toString() {
        return "Citizen{" +
                "birthDate=" + birthDate +
                ", passDate=" + passDate +
                ", adress='" + adress + '\'' +
                ", gender=" + gender +
                ", martialStatus=" + martialStatus +
                '}'+'\n';
    }


}
