import java.util.*;
import java.util.stream.Collectors;

public class SortMapByKeyProgram {
    public static void main(String[] args) {
       // Map<String, Integer> studentMap = new HashMap<>();
        List<StudentDTO> studentDTOList = new ArrayList<>();
        studentDTOList.add(new StudentDTO("Jyous", 87));
        studentDTOList.add(new StudentDTO("Klusener", 82));
        studentDTOList.add(new StudentDTO("Xiangh", 91));
        studentDTOList.add(new StudentDTO("Lisa", 89));
        studentDTOList.add(new StudentDTO("Narayan", 95));
        studentDTOList.add(new StudentDTO("Arunkumar", 86));
        System.out.println("--------------Student Name Sorting ------------------");
        studentDTOList.stream()
                .sorted(Comparator.comparing(StudentDTO::getName))
                .forEach(e->System.out.println(e.getName()+":"+e.getNo()));
        System.out.println("--------------Student No Sorting ------------------");
        studentDTOList.stream()
                .sorted(Comparator.comparing(StudentDTO::getNo))
                .forEach(e->System.out.println(e.getName()+":"+e.getNo()));

    }
}
class StudentDTO{
    private String name;
    private long no;

    public StudentDTO(String name, long no) {
        this.name = name;
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getNo() {
        return no;
    }

    public void setNo(long no) {
        this.no = no;
    }

    @Override
    public String toString() {
        return "StudentDTO{" +
                "name='" + name + '\'' +
                ", no=" + no +
                '}';
    }
}