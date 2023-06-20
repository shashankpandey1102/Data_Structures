package JavaWork;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Student {
    int roll;
    String name;

    public Student(int roll, String name){
        this.roll = roll;
        this.name = name;
    }

//The toString() method returns the String representation of the object.

//If you print any object, Java compiler internally invokes the toString() method on the object. 
//So overriding the toString() method, returns the desired output, it can be the state of an object etc. 
//depending on your implementation.

@Override
public String toString() {
    // TODO Auto-generated method stub
    return this.roll + " " + this.name;
}
}

class SortByRoll implements Comparator<Student>{
    
    public int compare(Student obj1, Student obj2) {
        return obj1.roll - obj2.roll;
    }
}

class SortByName implements Comparator<Student>{
    public int compare(Student a, Student b) {
        return a.name.compareTo(b.name);
    }
}

public class comp {

   

    public static void main(String[] args) {
        ArrayList<Student> arr = new ArrayList<>();
        arr.add(new Student(4, "Shashank"));
        arr.add(new Student(3, "Aman"));
        arr.add(new Student(2, "Nishant"));
        arr.add(new Student(1, "Choota"));

        System.out.println("Unsorted");
        for(int i = 0; i < arr.size(); i++){
            System.out.println(arr.get(i));
        }

        Collections.sort(arr, new SortByRoll());
        System.out.println("Sorted By Roll No");
        for(int i = 0; i < arr.size(); i++){
            System.out.println(arr.get(i));
        }

        Collections.sort(arr, new SortByName());
        System.out.println("Sorted By name");
        for(int i = 0; i < arr.size(); i++){
            System.out.println(arr.get(i));
        }
    }
}
