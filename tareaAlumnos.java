class Student{
    private String name;
    private String lastName;
    private String code;

    //Constructores
    Student(String name, String lastName, String code){
        this.name = name;
        this.lastName = lastName;
        this.code = code;
    }

    //getters
    public String getName(){
        return name;
    }

    public String getLastName(){
        return lastName;
    }

    public String getCode(){
        return code;
    }
}

class Group{
    private String code;
    private Student[] students;
    private int enrolled;
    private int rejected;
    private int eliminated;

    public String getCode(){
        return code;
    }

    Group(String code, int capacity){
        this.code = code;
        students = new Student[capacity];
    }

    //Métodos
    public boolean addStudent(Student student){
        if(enrolled < students.length){
            students[enrolled++] = student;
            return true;
        }
        rejected++;
        return false;
    }

    public void removeStudent(String code) {//¿cómo poner especificamente el código del alumno si está privado?
        int i;
        for (i = 0; i < enrolled && students[i].getCode() != code; i++);//Este es el ciclo de la busqueda

            if(i != enrolled){//Comprueba que se haya encontrado la clave
                for(int j = i; j < enrolled-1; j++) {//Hace el recorrido de las posiciones para borrar
                    students[j] = students[j+1];//Sobreescribe
                }
                enrolled--;
                eliminated++;
            }
         //       System.out.println("No se encontró el código: "+code);

    }

    //Getters
    public int getEnrolled(){
        return enrolled;
    }

    public int getRejected(){
        return rejected;
    }

    public Student getStudent(int index){
        return students[index];
    }
    public int getEliminated(){
        return eliminated;
    }

}

public class tareaAlumnos {

    public static void main(String[] args) {
        Student student1;//Referencia a un Alumno
        Student student2 = new Student("Iván", "Uresti", "1");
        student1 = new Student("Rita", "Monreal","8");//Creando un objeto alumno

        Group group = new Group("1", 5);
        Group group2 = new Group("2", 5);


        if(!group.addStudent(student2)){
            System.out.println("Estudiante no fue añadido: " + student1.getName() + " " + student1.getLastName());
        }

        //Agregando estudiantes
        group.addStudent(new Student("Jorge", "Acosta", "1"));
        group.addStudent(new Student("Arturo", "Aleman", "2"));
        group.addStudent(new Student("Antonio", "Angel", "3"));
        group.addStudent(new Student("Francisco", "Arreguin", "4"));
        group.addStudent(new Student("Juan", "Coronado", "5"));
        group.addStudent(new Student("José", "González", "6"));
        group.addStudent(new Student("Jesús", "Lara", "7"));

        group2.addStudent(student1);
        group2.addStudent(new Student("Diego", "Sanchez", "9"));
        group2.addStudent(new Student("Misael", "Cabrera", "10"));
        group2.addStudent(new Student("Roberto", "Cisneros", "11"));
        group2.addStudent(new Student("Andrea", "Marquez", "12"));
        group2.addStudent(new Student("Sofia", "Medina", "13"));
        group2.addStudent(new Student("Oscar", "Vieyra", "14"));
        group2.addStudent(new Student("Frida", "Cervantes", "15"));


        System.out.printf("\n<<Inscribiendo alumnos>>....\n\nGrupo: " + group.getCode() + ", inscritos: " + group.getEnrolled() + ", rechazados: " + group.getRejected());
        System.out.printf("Grupo: %s, inscritos: %d, rechazados: %d%n", group2.getCode(), group2.getEnrolled(), group2.getRejected());

        //Eliminando estudiantes
        group.removeStudent("1");
        group.removeStudent("5");
        group.removeStudent("3");
        group2.removeStudent("9");
        group2.removeStudent("16");

        System.out.printf("\n<<Eliminando alumnos>>....\n\n");
        System.out.printf("Grupo: %s, inscritos: %d, rechazados: %d, eliminados: %d", group.getCode(), group.getEnrolled(), group.getRejected(), group.getEliminated());
        System.out.printf("\nGrupo: %s, inscritos: %d, rechazados: %d, eliminados: %d", group2.getCode(), group2.getEnrolled(), group2.getRejected(), group2.getEliminated());
        System.out.println();
        System.out.println();

        //Imprimiendo alumnos
        System.out.printf("\n<<Imprimiendo listas>>....\n\n");
        System.out.println("Alumnos del grupo: " + group.getCode());
        for (int i = 0; i < group.getEnrolled(); i++) {
            Student student = group.getStudent(i);
            System.out.println(student.getCode() + ": " + student.getName() + " " + student.getLastName());
        }

        System.out.println();
        System.out.println("Alumnos del grupo: " + group2.getCode());
        for (int j = 0; j < group2.getEnrolled(); j++) {
            Student student = group2.getStudent(j);
            System.out.println(student.getCode() + ": " + student.getName() + " " + student.getLastName());
        }
    }
}