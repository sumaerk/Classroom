import java.util.Random;
import java.io.File;
import java.io.IOException;
import java.io.FileReader;
import java.util.Scanner;

class Classroom {
        Scanner reader = null;
        Random r = new Random();
        String[] x;


        public Classroom(){
                try{
                        this.reader = new Scanner(new File("class.csv"));
                }catch(IOException e){
                        System.out.println("class.csv not found");
                }
                this.x = readFile();                
        }


        public String[] readFile(){
                String[] students = new String[reader.nextInt()];
                reader.nextLine();
                students = reader.nextLine().split(",");
                return students;
        }

        public void randomStudent(){
                System.out.println(this.x[this.r.nextInt(this.x.length)]);
        }
        public void groupStudents(int size){
                String temp;
                int j;
                for (int i = x.length-1; i>=0; i--) {
                        j = r.nextInt(i+1);
                        temp = x[i];
                        x[i] = x[j];
                        x[j] = temp;
                }
                int b = 0;
                while (b<x.length) {
                        for (int k = 0; k<size; k++) {
                                if (b<x.length) {
                                        System.out.println(x[b]);
                                        b++;
                                }
                        }
                        System.out.println();
                }

        }

        public static void main(String[] args) {
                Classroom a = new Classroom();
                System.out.println();
                System.out.println("Random Student:");
                System.out.println();
                a.randomStudent();
                System.out.println();
                System.out.println("Groups of 5:");
                System.out.println();
                a.groupStudents(5);
        }

}