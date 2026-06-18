import java.util.*;

// Employee class
class Employee implements Comparable<Employee> {
    int id;
    String name;
    String department;

    // Constructor
    public Employee(int id, String name, String department) {
        this.id = id;
        this.name = name;
        this.department = department;
    }

    // toString method (for printing)
    public String toString() {
        return id + " - " + name + " (" + department + ")";
    }

    // equals method (for Set uniqueness)
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Employee)) return false;
        Employee e = (Employee) obj;
        return this.id == e.id;
    }

    // hashCode (important when using Set)
    public int hashCode() {
        return id;
    }

    // compareTo (for sorting by ID)
    public int compareTo(Employee e) {
        return this.id - e.id;
    }
}

// Generic class for sorting
class DataSorter<T extends Comparable<T>> {

    public void sortList(List<T> list) {
        Collections.sort(list);
    }
}

public class Task4Program {

    public static void main(String[] args) {

        List<Employee> empList = new ArrayList<>();
        empList.add(new Employee(3, "Arun", "IT"));
        empList.add(new Employee(1, "Bala", "HR"));
        empList.add(new Employee(2, "Charan", "Finance"));


        Set<Employee> empSet = new HashSet<>(empList);


        Map<Integer, Employee> empMap = new HashMap<>();
        for (Employee e : empList) {
            empMap.put(e.id, e);
        }

        DataSorter<Employee> sorter = new DataSorter<>();
        sorter.sortList(empList);


        System.out.println("=== Sorted Employee List ===");
        for (Employee e : empList) {
            System.out.println(e);
        }

        System.out.println("\n=== Employee Set ===");
        for (Employee e : empSet) {
            System.out.println(e);
        }

        System.out.println("\n=== Employee Map ===");
        for (Integer id : empMap.keySet()) {
            System.out.println(id + " → " + empMap.get(id));
        }
    }
}