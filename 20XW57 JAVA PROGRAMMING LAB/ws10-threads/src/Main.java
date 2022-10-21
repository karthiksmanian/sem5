class Whiteboard{
    String text;
    int noOfStudents = 0;
    int count = 0;

    public void attendance(){
        noOfStudents++;
    }
    synchronized public void write(String txt){
        System.out.println("Teacher is writing.. " + txt);
//        System.out.println(txt);
        while (count!=0)
            try{wait();}catch (Exception e){}
        text = txt;
        count = noOfStudents;
        notifyAll();
    }

    synchronized public String read() {
        while (count==0)
            try{wait();}catch (Exception e){}
        String t = text;
        count--;
        if(count==0)
            notify();
        return t;
    }
}

class Teacher extends Thread{
    Whiteboard wh;
    String notes[] = {"Hello World","World Cup is coming","Position","end"};
    Teacher(Whiteboard w){
        wh = w;
    }
    @Override
    public void run() {
        for (int i = 0; i < notes.length; i++) {
            wh.write(notes[i]);
        }
    }
}

class Student extends Thread{
    String name;
    Whiteboard wh;
    Student(String n,Whiteboard w){
        name=n;
        wh=w;
    }
    @Override
    public void run() {
//        super.run();
        String text;
        wh.attendance();

        do {
            text = wh.read();
            System.out.println(name + " reading " + text);
            System.out.flush();
        }while (text!="end");
    }
}

public class Main {
    public static void main(String[] args) {
            Whiteboard wb = new Whiteboard();
            Teacher t = new Teacher(wb);

            Student s1 = new Student("Ajay Karthikeyan",wb);
            Student s2 = new Student("Karthik Manian",wb);

            t.start();
            s1.start();
            s2.start();
    }
}
