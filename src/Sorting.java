import java.util.*;
import java.util.stream.Collectors;

public class Sorting {
    public static void main(String args[]){
        List<StudentDTO> studentDTOList = new ArrayList<>();
        studentDTOList.add(new StudentDTO("Jyous", 87));
        studentDTOList.add(new StudentDTO("Klusener", 82));
        studentDTOList.add(new StudentDTO("Xiangh", 91));
        studentDTOList.add(new StudentDTO("Anbu", 90));
        studentDTOList.add(new StudentDTO("Narayan", 95));
        studentDTOList.add(new StudentDTO("Anbu", 190));
        studentDTOList.add(new StudentDTO("Arunkumar", 86));
        studentDTOList.stream().sorted(Comparator.comparing(StudentDTO::getName).thenComparing(StudentDTO::getNo))
                .forEach(System.out::println);
        MyConfigManager myConfigManager = MyConfigManager.getInstance();


        studentDTOList.stream().collect(Collectors.groupingBy(StudentDTO::getName,Collectors.summingDouble(StudentDTO::getNo)))
                .entrySet().stream().sorted(Map.Entry.comparingByKey())
                .forEach(e->System.out.println(e.getKey()+":"+e.getValue()));
    }



}

