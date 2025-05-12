package App;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.CSVParserBuilder;
import model.Person;
import model.Subdivision;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class App {
    public static List<Person> readPeopleFromCSV(String csvFilePath, char separator) throws Exception {
        List<Person> people = new ArrayList<>();
        Map<String, Subdivision> subdivisionsMap = new HashMap<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        int personId = 1;

        try (InputStream in = App.class.getClassLoader().getResourceAsStream(csvFilePath);
             CSVReader reader = in == null ? null :
                     new CSVReaderBuilder(new InputStreamReader(in))
                             .withCSVParser(new CSVParserBuilder().withSeparator(separator).build())
                             .build()) {

            if (reader == null) {
                throw new FileNotFoundException("Не удалось найти файл: " + csvFilePath);
            }

            String[] nextLine;
            reader.readNext();

            while ((nextLine = reader.readNext()) != null) {
                if (nextLine.length < 6) continue;

                String name = nextLine[1].trim();
                String gender = nextLine[2].trim();
                LocalDate birthDate = LocalDate.parse(nextLine[3].trim(), formatter);
                String subdivisionName = nextLine[4].trim();
                double salary = Double.parseDouble(nextLine[5].trim());

                Subdivision subdivision = subdivisionsMap.computeIfAbsent(subdivisionName, Subdivision::new);
                people.add(new Person(personId++, name, gender, subdivision, salary, birthDate));
            }
        }

        return people;
    }

    public static void main(String[] args) {
        try {
            List<Person> people = readPeopleFromCSV("people.csv", ';');
            people.forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
