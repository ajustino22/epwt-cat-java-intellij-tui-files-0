import java.io.*;

public class    App {

    public static void main(String[] args) throws IOException{
        //Creem l'array d'estudiants:
        Student[] students = init();

        File file = new File("students.out");

        String message = "Llista desordenada:";

        //Imprimeix tots els estudiants
        //de forma desordenada
        printStudents(students, message);

        saveToFile(students, file);

        System.out.println(readFromFile(file));

    }

    static String readFromFile(File file) {

        try {
            FileReader fr = new FileReader(file);
            String contents = "";
            int c;
            while((c = fr.read()) != -1) {
                contents += (char)c;
            }
            fr.close();
            return contents;
        } catch (IOException e) {
            return "Error al leer el fichero";
        }

    }

    static void saveToFile(Student[] students, File file) {

        try {
            FileWriter writer = new FileWriter(file);
            writer.write("Archivo" + "\n");
            for (Student student : students) {
                writer.write(student + "\n");
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("Error al escribir en el fichero");
        }
    }

    //Mètode que imprimeix la llista d'estudiants
    //Delega la creació de l'String al mètode
    //buildStudentListString
    static void printStudents(Student [] students,
                              String message){
        System.out.println(buildListString(students, message));
    }

    //Mètode que genera un String amb la llista d'estudiants
    static String buildListString(Student[] students, String message){
        StringBuffer sb = new StringBuffer();
        sb.append("\n****");
        sb.append(" ");
        sb.append(message);
        sb.append("\n");
        for(Student s: students){
            sb.append(s.toString());
            sb.append("\n");
        }
        sb.append("\n");
        return sb.toString();
    }

    //Mètode que genera un array d'estudiants
    static public Student[] init() {

        Student[] students = new Student[10];

        Student s0 = new Student();
        s0.name = "Laura";
        s0.age = 25;
        s0.amountOfEnrolledSubjects = 6;
        students[0] = s0;

        Student s1 = new Student();
        s1.name = "Joan";
        s1.age = 29;
        s1.amountOfEnrolledSubjects = 7;
        students[1] = s1;

        Student s2 = new Student();
        s2.name = "Carme";
        s2.age = 38;
        s2.amountOfEnrolledSubjects = 4;
        students[2] = s2;

        Student s3 = new Student();
        s3.name = "Oriol";
        s3.age = 21;
        s3.amountOfEnrolledSubjects = 9;
        students[3] = s3;

        Student s4 = new Student();
        s4.name = "Sergi";
        s4.age = 36;
        s4.amountOfEnrolledSubjects = 7;
        students[4] = s4;

        Student s5 = new Student();
        s5.name = "Laia";
        s5.age = 31;
        s5.amountOfEnrolledSubjects = 5;
        students[5] = s5;

        Student s6 = new Student();
        s6.name = "Abril";
        s6.age = 41;
        s6.amountOfEnrolledSubjects = 4;
        students[6] = s6;

        Student s7 = new Student();
        s7.name = "Jordi";
        s7.age = 30;
        s7.amountOfEnrolledSubjects = 7;
        students[7] = s7;

        Student s8 = new Student();
        s8.name = "Carla";
        s8.age = 32;
        s8.amountOfEnrolledSubjects = 6;
        students[8] = s8;

        Student s9 = new Student();
        s9.name = "Ritxi";
        s9.age = 28;
        s9.amountOfEnrolledSubjects = 3;
        students[9] = s9;

        return students;
    }
}

