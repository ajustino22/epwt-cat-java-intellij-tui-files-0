package cat.ilg.m3.uf3;

import java.util.Scanner;
import static cat.ilg.m3.uf3.Utils.stringToInt;

public class App {

    public static void main(String[] args) {

        Student [] students = initTui();

        //Imprimeix tots els estudiants
        printStudents(students, "Listado de estudiantes:");

    }

    //Mètode que imprimeix la llista d'estudiants
    //Delega la creació de l'String al mètode
    //buildStudentListString
    static void printStudents(Student [] students,
                              String message){
        System.out.println(buildStudentListString(students, message));
    }

    //Mètode que genera un String amb la llista d'estudiants
    static String buildStudentListString(Student [] students,
                                         String message){
        StringBuilder sb = new StringBuilder();
        sb.append("\n**** ");
        sb.append(message);
        sb.append("\n");
        int i = 1;
        for(Student s : students){
            sb.append("---- Student number " + i + " ----\n");
            sb.append(s.toString());
            sb.append("\n");
            i++;
        }
        return sb.toString();
    }

    static public Student[] initTui() {

        //Inicialment suposem que no tenim cap estudiant
        Student students[] = new Student[0];

        //Ara, hem de preguntar quants estudiants volem tenir
        Scanner in = new Scanner(System.in);
        System.out.println("Cuantos estudiantes??");
        String numberOfStudentsStr = in.nextLine();

        int numberOfStudents = stringToInt(numberOfStudentsStr);

        System.out.println("Number of students is: " + numberOfStudents);

        //Si el número d'estudiants és més gran que 0
        //preguntarem el nom, edat i subjects de cada estudiant
        if(numberOfStudents > 0) {

            students = new Student[numberOfStudents];


            for(int i = 0; i < numberOfStudents; i++){

                Student newStudent = new Student();

                System.out.println("Introduce nombre:");
                newStudent.name = in.nextLine();

                int age = -1;
                boolean validAge = false;
                while (!validAge) {
                    System.out.println("Introduce edad:");
                        age = stringToInt(in.nextLine());
                        if (age > 0 && age < 100) {
                            validAge = true;
                        } else {
                            System.out.println("La edad debe estar entre 1 y 99");
                        }
                }
                newStudent.age = age;

                int subjects = -1;
                boolean validSubjects = false;
                while (!validSubjects) {
                    System.out.println("Introduce numero de asignaturas matriculadas:");
                    subjects = stringToInt(in.nextLine());
                    if (subjects > 0 && subjects < 10) {
                        validSubjects = true;
                    } else {
                        System.out.println("Mínimo 1 asignatura, máximo 9");
                    }
                }
                newStudent.amountOfEnrolledSubjects = subjects;

                //Fiquem l'estudiant a l'array
                students[i] = newStudent;
            }
        }
        in.close();
        return students;
    }
}



