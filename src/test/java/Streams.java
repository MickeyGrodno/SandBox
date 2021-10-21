import org.junit.Test;
import streamslessonclasses.Department;
import streamslessonclasses.Employee;
import streamslessonclasses.Event;
import streamslessonclasses.Position;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.*;

public class Streams {
    private List<Employee> emps = List.of(
            new Employee("Michael", "Smith",   243,  43, Position.CHEF),
            new Employee("Jane",    "Smith",   523,  40, Position.MANAGER),
            new Employee("Jury",    "Gagarin", 6423, 26, Position.MANAGER),
            new Employee("Jack",    "London",  5543, 53, Position.WORKER),
            new Employee("Eric",    "Jackson", 2534, 22, Position.WORKER),
            new Employee("Andrew",  "Bosh",    3456, 44, Position.WORKER),
            new Employee("Joe",     "Smith",   723,  30, Position.MANAGER),
            new Employee("Jack",    "Gagarin", 7423, 35, Position.MANAGER),
            new Employee("Jane",    "London",  7543, 42, Position.WORKER),
            new Employee("Mike",    "Jackson", 7534, 31, Position.WORKER),
            new Employee("Jack",    "Bosh",    7456, 54, Position.WORKER),
            new Employee("Mark",    "Smith",   123,  41, Position.MANAGER),
            new Employee("Jane",    "Gagarin", 1423, 28, Position.MANAGER),
            new Employee("Sam",     "London",  1543, 52, Position.WORKER),
            new Employee("Jack",    "Jackson", 1534, 27, Position.WORKER),
            new Employee("Eric",    "Bosh",    1456, 32, Position.WORKER)
    );

    private List<Department> deps = List.of(
            new Department(1, 0, "Head"),
            new Department(2, 1, "West"),
            new Department(3, 1, "East"),
            new Department(4, 2, "Germany"),
            new Department(5, 2, "France"),
            new Department(6, 3, "China"),
            new Department(7, 3, "Japan")
    );


    @Test
    public void creation() throws IOException {
        Stream<String> lines = Files.lines(Paths.get("SomeText.txt"));
        lines.forEach(System.out::println);

        Stream<Path> list = Files.list(Paths.get("./")); // получаем список файлов в директории
        list.forEach(System.out::println);

        Stream<Path> walk = Files.walk(Paths.get("./"), 3); //получаем объекты 3го уровня с путем
        walk.forEach(System.out::println);

        IntStream intStream = IntStream.of(1, 2, 3, 4);
        DoubleStream doubleStream = DoubleStream.of(1.1, 1.2, 1.3, 1.4);
        IntStream range = IntStream.range(10, 100); //10-99
        IntStream intStream1 = IntStream.rangeClosed(10, 100);//10-100

        int[] ints = {1, 2, 3, 4, 5};
        IntStream stream = Arrays.stream(ints);

        Stream<String> stringStream = Stream.of("1", "2", "3");

        Stream<String> build = Stream.<String>builder()
                .add("Mike")
                .add("Joe")
                .build();

        Stream<Employee> stream1 = emps.stream();

        Stream<Event> generate = Stream.generate(() ->
                new Event(UUID.randomUUID(), LocalDateTime.now(), "")); // при обращении к этому стриму произойдет создание объекта

        Stream<Integer> iterate = Stream.iterate(1950, val -> val + 3); //генерация стрима данных с шагом +3

        Stream<String> concat = Stream.concat(stringStream, build); //объединение двух стримов
    }

    @Test
    public void terminate() {
        emps.stream().count();
        emps.stream().forEach(employee -> System.out.println(employee.getAge()));

        emps.stream().collect(Collectors.toList()); //преобразование в коллекцию

        emps.stream().toArray(); //в массив

        Map<Integer, String> collect = emps.stream().collect(Collectors.toMap(
                emp -> emp.getId(),
                emp -> String.format("%s %s", emp.getLastName(), emp.getFirstName())
        ));//преобразуем в мапу

        IntStream intStream = IntStream.of(100, 200, 300, 400);
        int asInt = intStream.reduce(((left, right) -> left + right)).getAsInt(); //сложение всех элементов

        Department department = deps.stream().reduce(this::reducer).get();//объединение объектов в виде дерева
        System.out.println(department);

        emps.stream().max(((o1, o2) -> o1.getAge() - o2.getAge())); //поиск сотрудника с макс возрастом
        emps.stream().max((Comparator.comparingInt(Employee::getAge))); //поиск сотрудника с макс возрастом

        emps.stream().findAny(); //вернет произвольный элемент

        emps.stream().noneMatch(employee -> employee.getAge() > 60); //boolean проверка, что сотрудники с таким возрастом не найдены
        emps.stream().allMatch(employee -> employee.getAge() > 18); //boolean проверка, что сотрудники старше 18
        emps.stream().anyMatch(employee -> employee.getPosition() == Position.CHEF); //boolean проверка, что хоть один сотрудник имеет такую должность
    }

    @Test
    public void transform() {
        LongStream longStream = IntStream.of(100, 200, 300, 400).mapToLong(Long::valueOf); // Преобразовать стрим примитивов в лонг.
        Stream<Event> eventStream = IntStream.of(100, 200, 300, 400).mapToObj(value ->
                new Event(UUID.randomUUID(), LocalDateTime.of(value, 12, 1, 12, 0), "")); //получить список объектов из инт стрима

        IntStream distinct = IntStream.of(100, 200, 300, 400, 100, 200).distinct(); //Исключение дубликатов из стрима
        distinct.forEach(System.out::println);

        emps.stream().filter(employee -> employee.getPosition() != Position.CHEF); //фильтр стрима по параметрам

        emps.stream().skip(3); // Получить стрим, начинающийся с 3й позиции списка
        emps.stream().limit(5); //Ограничить стрим количеством записей (первые 5)

//        emps.stream().sorted((o1, o2) -> o1.getAge() - o2.getAge());
        emps.stream()
                .sorted(Comparator.comparingInt(Employee::getAge)) //сортировка по возрасту
                .peek(emp -> emp.setAge(18)) //выполнить действие для всех элементов стрима
                .map(emp -> String.format("%s %s", emp.getLastName(), emp.getFirstName())); //преобразуем в фамилию и имя


        emps.stream().takeWhile(employee -> employee.getAge() > 30); // получить сотрудников до тех пор, пока возраст не превышает 30 лет

        emps.stream().dropWhile(employee -> employee.getAge() > 30); // не брать сотрудников, пока возраст не станет больше 30 лет

        IntStream.of(100, 200, 300, 400)
                .flatMap(value -> IntStream.of(value - 50, value)) //можно задать шаги. будет выведено 50 100 150 200 250 300 350 400
                .forEach(System.out::println);
    }

    @Test
    public void realCase() {
        Stream<Employee> sorted = emps.stream()
                .filter(employee -> employee.getAge() <= 30 && employee.getPosition() != Position.WORKER)
                .sorted(Comparator.comparing(Employee::getLastName));
        print(sorted);

        Stream<Employee> sorted1 = emps.stream()
                .filter(employee -> employee.getAge() > 40)
                .limit(4)
                .sorted(Comparator.comparing(Employee::getAge));
        print(sorted1);

        Stream<Employee> sorted2 = emps.stream()
                .filter(employee -> employee.getAge() > 40)
                .sorted(((o1, o2) -> o2.getAge() - o1.getAge()))
                .limit(4);
        print(sorted2);

        IntSummaryStatistics intSummaryStatistics = emps.stream()
                .mapToInt(Employee::getAge)
                .summaryStatistics();

        System.out.println(intSummaryStatistics);
    }

    private void print(Stream<Employee> stream) {
        stream
                .map(emp -> String.format(
                        "%4d | %-15s %-10s age %s %s",
                        emp.getId(),
                        emp.getLastName(),
                        emp.getFirstName(),
                        emp.getAge(),
                        emp.getPosition()
                ))
                .forEach(System.out::println);

        System.out.println();
    }




    public Department reducer(Department parent, Department child) {
        if(child.getParent() == parent.getId()) {
            parent.getChild().add((child));
        } else {
            parent.getChild().forEach(subParent -> reducer(subParent, child));
        }
        return parent;
    }







































//    @Test
//    public void creation() throws IOException {
//        Stream<String> lines = Files.lines(Paths.get("some.txt"));
//        Stream<Path> list = Files.list(Paths.get("./"));
//        Stream<Path> walk = Files.walk(Paths.get("./"), 3);
//
//        IntStream intStream = IntStream.of(1, 2, 3, 4);
//        DoubleStream doubleStream = DoubleStream.of(1.2, 3.4);
//        IntStream range = IntStream.range(10, 100); // 10 .. 99
//        IntStream intStream1 = IntStream.rangeClosed(10, 100); // 10 .. 100
//
//        int[] ints = {1, 2, 3, 4};
//        IntStream stream = Arrays.stream(ints);
//
//        Stream<String> stringStream = Stream.of("1", "2", "3");
//        Stream<? extends Serializable> stream1 = Stream.of(1, "2", "3");
//
//        Stream<String> build = Stream.<String>builder()
//                .add("Mike")
//                .add("joe")
//                .build();
//
//        Stream<Employee> stream2 = emps.stream();
//        Stream<Employee> employeeStream = emps.parallelStream();
//
//        Stream<Event> generate = Stream.generate(() ->
//                new Event(UUID.randomUUID(), LocalDateTime.now(), "")
//        );
//
//        Stream<Integer> iterate = Stream.iterate(1950, val -> val + 3);
//
//        Stream<String> concat = Stream.concat(stringStream, build);
//    }
//
//    @Test
//    public void terminate() {
//        Stream<Employee> stream = emps.stream();
//        stream.count();
//
//        emps.stream().forEach(employee -> System.out.println(employee.getAge()));
//        emps.forEach(employee -> System.out.println(employee.getAge()));
//
//        emps.stream().forEachOrdered(employee -> System.out.println(employee.getAge()));
//
//        emps.stream().collect(Collectors.toList());
//        emps.stream().toArray();
//        Map<Integer, String> collect = emps.stream().collect(Collectors.toMap(
//                Employee::getId,
//                emp -> String.format("%s %s", emp.getLastName(), emp.getFirstName())
//        ));
//
//        IntStream intStream = IntStream.of(100, 200, 300, 400);
//        intStream.reduce((left, right) -> left + right).orElse(0);
//
//        System.out.println(deps.stream().reduce(this::reducer));
//
//        IntStream.of(100, 200, 300, 400).average();
//        IntStream.of(100, 200, 300, 400).max();
//        IntStream.of(100, 200, 300, 400).min();
//        IntStream.of(100, 200, 300, 400).sum();
//        IntStream.of(100, 200, 300, 400).summaryStatistics();
//
//        emps.stream().max(Comparator.comparingInt(Employee::getAge));
//
//        emps.stream().findAny();
//        emps.stream().findFirst();
//
//        emps.stream().noneMatch(employee -> employee.getAge() > 60); // true
//        emps.stream().anyMatch(employee -> employee.getPosition() == Position.CHEF); // true
//        emps.stream().allMatch(employee -> employee.getAge() > 18); // true
//    }
//
//    @Test
//    public void transform() {
//        LongStream longStream = IntStream.of(100, 200, 300, 400).mapToLong(Long::valueOf);
//        IntStream.of(100, 200, 300, 400).mapToObj(value ->
//                new Event(UUID.randomUUID(), LocalDateTime.of(value, 12, 1, 12, 0), "")
//        );
//
//        IntStream.of(100, 200, 300, 400, 100, 200).distinct(); // 100, 200, 300, 400
//
//        Stream<Employee> employeeStream = emps.stream().filter(employee -> employee.getPosition() != Position.CHEF);
//
//        emps.stream()
//                .skip(3)
//                .limit(5);
//
//        emps.stream()
//                .sorted(Comparator.comparingInt(Employee::getAge))
//                .peek(emp -> emp.setAge(18))
//                .map(emp -> String.format("%s %s", emp.getLastName(), emp.getFirstName()));
//
//        emps.stream().takeWhile(employee -> employee.getAge() > 30).forEach(System.out::println);
//        System.out.println();
//        emps.stream().dropWhile(employee -> employee.getAge() > 30).forEach(System.out::println);
//
//        System.out.println();
//
//        IntStream.of(100, 200, 300, 400)
//                .flatMap(value -> IntStream.of(value - 50, value))
//                .forEach(System.out::println);
//    }
//
//    @Test
//    public void real() {
//        Stream<Employee> empl = emps.stream()
//                .filter(employee ->
//                        employee.getAge() <= 30 && employee.getPosition() != Position.WORKER
//                )
//                .sorted(Comparator.comparing(Employee::getLastName));
//
//        print(empl);
//
//        Stream<Employee> sorted = emps.stream()
//                .filter(employee -> employee.getAge() > 40)
//                .sorted((o1, o2) -> o2.getAge() - o1.getAge())
//                .limit(4);
//
//        print(sorted);
//
//        IntSummaryStatistics statistics = emps.stream()
//                .mapToInt(Employee::getAge)
//                .summaryStatistics();
//
//        System.out.println(statistics);
//    }
//
//    private void print(Stream<Employee> stream) {
//        stream
//                .map(emp -> String.format(
//                        "%4d | %-15s %-10s age %s %s",
//                        emp.getId(),
//                        emp.getLastName(),
//                        emp.getFirstName(),
//                        emp.getAge(),
//                        emp.getPosition()
//                ))
//                .forEach(System.out::println);
//
//        System.out.println();
//    }
//
//    public Department reducer(Department parent, Department child) {
//        if (child.getParent() == parent.getId()) {
//            parent.getChild().add(child);
//        } else {
//            parent.getChild().forEach(subParent -> reducer(subParent, child));
//        }
//
//        return parent;
//    }
}
