import model.Person;
import App.App;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Юнит-тесты для класса App.
 */
public class AppTest {

    /**
     * Проверяет корректность чтения и парсинга CSV-файла.
     *
     * @throws Exception если чтение не удалось
     */
    @Test
    public void testReadPeopleFromCSV() throws Exception {
        List<Person> people = App.readPeopleFromCSV("people.csv", ';');

        assertNotNull(people, "Список не должен быть null");
        assertFalse(people.isEmpty(), "Список не должен быть пустым");

        Person first = people.get(0);
        assertNotNull(first.getName(), "Имя должно быть задано");
        assertNotNull(first.getGender(), "Пол должен быть задан");
        assertNotNull(first.getSubdivision(), "Подразделение должно быть задано");
        assertTrue(first.getSalary() > 0, "Зарплата должна быть положительной");
        assertNotNull(first.getBirthDate(), "Дата рождения должна быть задана");
    }
}
