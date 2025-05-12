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

/**
 * Главный класс приложения, выполняющего чтение CSV-файла
 * с данными о людях и преобразование их в объекты Java.
 */
public class App {
    /**
     * Считывает CSV-файл и возвращает список объектов Person.
     * CSV-файл должен иметь следующую структуру:
     * id;name;gender;BirtDate;Division;Salary
     *
     * @param csvFilePath путь к CSV-файлу в ресурсах
     * @param separator символ-разделитель (обычно ';')
     * @return список объектов Person, считанных из файла
     * @throws Exception если файл не найден или возникает ошибка при парсинге
     */
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

    /**
     * Точка входа в приложение. Печатает список людей из CSV-файла.
     *
     * @param args не используются
     */
    public static void main(String[] args) {
        try {
            List<Person> people = readPeopleFromCSV("people.csv", ';');
            people.forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
