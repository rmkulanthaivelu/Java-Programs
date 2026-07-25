import java.util.*;
import java.util.stream.Collectors;

public class EmployeesProgram {
    public static void main(String arg[]) {
        List<EmployeeDTO> employees = Arrays.asList(
                new EmployeeDTO(1, "John", 50000, "IT"),
                new EmployeeDTO(2, "Sara", 70000, "HR"),
                new EmployeeDTO(3, "Mike", 60000, "IT"),
                new EmployeeDTO(4, "David", 90000, "Finance"),
                new EmployeeDTO(5, "Velu", 80000, "IT")
        );
        System.out.println("------------Sorting Employee Salary---------------");
        employees.stream()
                .sorted(Comparator.comparing(EmployeeDTO::getSalary).reversed())
                .forEach(System.out::println);
        System.out.println("------------Sorting Employee Name---------------");
        employees.stream()
                .sorted(Comparator.comparing(EmployeeDTO::getName))
                .forEach(System.out::println);
        System.out.println("------------Sorting Employee Salary and Name ---------------");
        employees.stream()
                .sorted(Comparator.comparing(EmployeeDTO::getSalary)
                        .thenComparing(EmployeeDTO::getName))
                .forEach(System.out::println);

        employees.stream()
                .sorted(Comparator.comparing(EmployeeDTO::getName))
                .forEach(System.out::println);

        System.out.println("------------Highest salary per department---------------");
        employees.stream()
                .collect(Collectors.groupingBy(
                        EmployeeDTO::getDepartment,
                        Collectors.maxBy(Comparator.comparing(EmployeeDTO::getSalary))
                )).forEach((department, salary) -> System.out.println(department + ":" + salary));

        employees.stream()
                .collect(Collectors.groupingBy(
                        EmployeeDTO::getDepartment, Collectors.counting()
                )).forEach((department, count) ->
                        System.out.println("Department: " + department + " | Count: " + count)
                );

        double avg = employees.stream()
                .mapToDouble(EmployeeDTO::getSalary)
                .average()
                .orElse(0);

        employees.stream().collect(Collectors.groupingBy(EmployeeDTO::getDepartment, Collectors.counting()))
                .entrySet().stream().forEach(e -> System.out.println(e.getKey() + ":" + e.getValue()));

        int[] intDupArray = {9, 4, 1, 3, 2, 6, 92, 3, 8, 7, 2, 1, 89};
        int max = Arrays.stream(intDupArray).boxed().max(Comparator.comparing((a) -> a)).get();
        System.out.println(max);
        call();

       // Nth Highest Salary
        int n = 3;

        EmployeeDTO emp = employees.stream()
                .sorted(Comparator.comparing(EmployeeDTO::getSalary).reversed())
                .skip(n - 1)
                .findFirst()
                .get();
        System.out.println(emp);
        System.out.println("-----START----Highest Salary in Each Department----------");
        //Highest Salary in Each Department
    //    Map<String, Optional<EmployeeDTO>> result =
                employees.stream()
                        .collect(Collectors.groupingBy(
                                EmployeeDTO::getDepartment,
                                Collectors.maxBy(
                                        Comparator.comparing(EmployeeDTO::getSalary)
                                )
                        )).forEach((dept,salary)->System.out.println(dept+":"+salary));
       // System.out.println(result);
        System.out.println("-----END----Highest Salary in Each Department----------");

        System.out.println("-----START----Sum Salary in Each Department----------");
        //Highest Salary in Each Department
        //    Map<String, Optional<EmployeeDTO>> result =
        employees.stream()
                .collect(Collectors.groupingBy(
                        EmployeeDTO::getDepartment,
                        Collectors.summingDouble(EmployeeDTO::getSalary)
                )).forEach((dept,salary)->System.out.println(dept+":"+salary));
        // System.out.println(result);
        System.out.println("-----END----Sum Salary in Each Department----------");

        //Count Employees by Department

        Map<String, Long> result1 =
                employees.stream()
                        .collect(Collectors.groupingBy(
                                EmployeeDTO::getDepartment,
                                Collectors.counting()
                        ));
        System.out.println(result1);
        //Average Salary by Department
        Map<String, Double> result2 =
                employees.stream()
                        .collect(Collectors.groupingBy(
                                EmployeeDTO::getDepartment,
                                Collectors.averagingDouble(EmployeeDTO::getSalary)
                        ));
        System.out.println(result2);
        //Sum of All Salaries
        double total = employees.stream()
                .mapToDouble(EmployeeDTO::getSalary)
                .sum();
        System.out.println("-------------Multi-Level Grouping------------------");
        Map<String, Map<Double, List<EmployeeDTO>>> listEmployeeDTO =
                employees.stream()
                        .collect(Collectors.groupingBy(
                                EmployeeDTO::getDepartment,
                                Collectors.groupingBy(EmployeeDTO::getSalary)
                        ));

        listEmployeeDTO.forEach((dept, salaryMap) -> {
            System.out.println("Department: " + dept);

            salaryMap.forEach((salary, empList) -> {
                System.out.println("  Salary: " + salary);

                empList.forEach(emp1 ->
                        System.out.println("    " + emp1.getName()));
            });
        });
        System.out.println("-------------Each Word Capital Letter------------------");

        String str = "hello how are you";

        String initCap = Arrays.stream(str.split(" "))
                .map(word -> Character.toLowerCase(word.charAt(0)) + word.substring(1).toUpperCase())
                .collect(Collectors.joining(" "));
        System.out.println(initCap);

        List<String> names = Arrays.asList("Ram", "John", "Peter");

        System.out.println("-------------Reverse Sorting String List------------------");
        names.stream()
                .sorted(Comparator.reverseOrder())
                .forEach(System.out::println);

        System.out.println("------------- Partition Employees by Salary------------------");
        Map<Boolean, List<EmployeeDTO>> partitioningBy =
                employees.stream()
                        .collect(Collectors.partitioningBy(
                                e -> e.getSalary() > 70000
                        ));
        System.out.println(partitioningBy);
        String users = "welcome to java micro service application jsp";

        String st = Arrays.stream(users.split(" "))
                .filter(u -> u.startsWith("j"))
                .collect(Collectors.joining(" "));
        System.out.println(st);

        EmployeeDTO salary = employees.stream().sorted(Comparator.comparing(EmployeeDTO::getSalary).reversed())
                .skip(1).findFirst().get();
        System.out.println(salary.getSalary());
        employees.stream().collect(Collectors.groupingBy(EmployeeDTO::getDepartment,Collectors.maxBy(Comparator.comparing(EmployeeDTO::getSalary))))
                .forEach((department,salary1)->System.out.println(salary1.get().department+":"+salary1.get().salary));
        List<Integer> numbers =
                Arrays.asList(1, 2, 3, 4, 2, 5, 3, 6, 7, 1);
        Set<Integer> set = new HashSet<>();
        numbers.stream().filter(num->!set.add(num))
                .forEach(System.out::println);
        String norRepeat = "welcomewlccom";
        Map.Entry<Character,Long> ch = norRepeat.chars().mapToObj(c->(char)c)
                .collect(Collectors.groupingBy(c->c,LinkedHashMap::new,Collectors.counting()))
                .entrySet().stream().filter(e->e.getValue()==1)
                        .findFirst().orElse(null);
        System.out.println(ch);
        System.out.println("------------- LOW MEDIUM HIGH Employees by Salary------------------");
        Map<String, List<String>> resultRange =
                employees.stream()
                        .collect(Collectors.groupingBy(empDTO -> {
                            if (empDTO.getSalary() < 60000)
                                return "LOW";
                            else if (empDTO.getSalary() <=70000)
                                return "MEDIUM";
                            else
                                return "HIGH";
                        },Collectors.mapping(EmployeeDTO::getName,Collectors.toList())));
        System.out.println(resultRange);
        for(Map.Entry mapEn:resultRange.entrySet()){
            System.out.println("---------"+mapEn.getKey()+"--------");
            List<String> list = (List<String>)mapEn.getValue();
            for(String empDto:list){
                System.out.println(empDto);
            }
       }
        //System.out.println(resultRange);
    }

    public static void call(){
        MyConfigManager Instance = MyConfigManager.getInstance();
        MyConfigManager Instance1 = MyConfigManager.getInstance();
        SingletonBillPug singletonBillPug = SingletonBillPug.getInstance();
        SingletonBillPug singletonBillPug1 = SingletonBillPug.getInstance();
        if(singletonBillPug1 == singletonBillPug){
            System.out.println("true");
        }
        if(Instance == Instance1){
            System.out.println("true");
        }
        EmployeesProgram employeesProgram = new EmployeesProgram();
        EmployeesProgram employeesProgram1 = new EmployeesProgram();
        if(employeesProgram1 == employeesProgram)
            System.out.println("employeesProgram true");
        else
            System.out.println("employeesProgram false");

        Deque<String> dq = new ArrayDeque<>();
        dq.offerFirst("A");
        dq.offerLast("B");
        dq.offerFirst("C");

        System.out.println(dq);

    }

}