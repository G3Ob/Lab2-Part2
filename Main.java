import java.util.*;

class Student {
    String numePrenume;
    String grupa;
    List<Integer> note;

    public Student(String numePrenume, String grupa) {
        this.numePrenume = numePrenume;
        this.grupa = grupa;
        this.note = new ArrayList<>();
    }

    public double calculMedie() {
        int suma = 0;
        for (int nota : note) {
            suma += nota;
        }
        return suma / (double) note.size();
    }

    public int numarRestante() {
        int restante = 0;
        for (int nota : note) {
            if (nota < 5) {
                restante++;
            }
        }
        return restante;
    }

    @Override
    public String toString() {
        return "Student: " + numePrenume + ", Grupa: " + grupa + ", Note: " + note + ", Medie: " + calculMedie();
    }
}

public class Main {
    public static void main(String[] args) {
        Random rand = new Random();

        List<Student> studenti = new ArrayList<>();

        studenti.add(new Student("Popescu Ion", "Grupa 1"));
        studenti.add(new Student("Ionescu Maria", "Grupa 1"));
        studenti.add(new Student("Georgescu Mihai", "Grupa 2"));
        studenti.add(new Student("Constantinescu Ana", "Grupa 2"));
        studenti.add(new Student("Dumitrescu Andrei", "Grupa 1"));

        for (Student student : studenti) {
            for (int i = 0; i < 5; i++) {
                student.note.add(rand.nextInt(7) + 4);
            }
        }

        System.out.println("Studenți ordonați alfabetic pe grupe:");
        studenti.sort(Comparator.comparing((Student s) -> s.grupa).thenComparing(s -> s.numePrenume));
        for (Student student : studenti) {
            System.out.println(student);
        }

        System.out.println("\nIntegraliști ordonați descrescător după medie:");
        List<Student> integraliști = new ArrayList<>();
        for (Student student : studenti) {
            if (student.numarRestante() == 0) {
                integraliști.add(student);
            }
        }
        integraliști.sort((s1, s2) -> Double.compare(s2.calculMedie(), s1.calculMedie()));
        for (Student student : integraliști) {
            System.out.println(student);
        }

        System.out.println("\nRestanțieri ordonați crescător după numărul de restanțe:");
        List<Student> restantieri = new ArrayList<>();
        for (Student student : studenti) {
            if (student.numarRestante() > 0) {
                restantieri.add(student);
            }
        }
        restantieri.sort(Comparator.comparingInt(Student::numarRestante));
        for (Student student : restantieri) {
            System.out.println(student);
        }
    }
}
