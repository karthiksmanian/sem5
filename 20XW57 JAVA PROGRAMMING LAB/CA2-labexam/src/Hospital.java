public class Hospital{

    Nurse n;
    boolean reg = false;
    boolean inPatient = false;
    boolean appointment = false;

    void addNurse(Nurse n){
        this.n = n;
    }
    synchronized void Visit(Patient p){
        System.out.println("Patient "+ p.pno + " Enters the waiting room waits for receptionist." );
        inPatient = true;
        while (reg!=true)
        {
            try {wait();}catch (Exception e){}
        }
        System.out.println("Receptionist registers patient" + p.pno);
        System.out.println("Patient "+ p.pno + " leaves the receptionist and sits in waiting room." );
        inPatient = true;
        n.addPatient(p);
    }

    synchronized void doctorVisit(Nurse n,int dno){
        while (inPatient!=true){
            try {wait();}catch (Exception e){}
        }
        if(inPatient == true){
            System.out.println("Nurse "+n.nno+" take patient "+ " into the doctors office.");
            System.out.println("Doctor "+dno+" listens to symptoms from patient ");

            System.out.println("Patient Receives advice from doctor.");
            notify();
            reg = false;
        }
        else {
            while (inPatient!=true){
                try {wait();}catch (Exception e){}
            }
        }
    }

    public static void main(String[] args) {
        Hospital h =new Hospital();
        Patient p1 = new Patient(h,1);
        Patient p2 = new Patient(h,2);
        Patient p3 = new Patient(h,3);
        Nurse n1 = new Nurse(h,1);
        Doctor d1 = new Doctor(n1,h,1);
        Receptionist r = new Receptionist(h);
        h.addNurse(n1);

        p3.start();
        p1.start();
        p2.start();
        d1.start();
        n1.start();
        r.start();

        Thread mainthread = Thread.currentThread();
        try {
            mainthread.join();
        }catch (Exception e){

        }
    }
}

class Nurse extends Thread{
    Hospital h;
    int nno;
    Patient p;

    Nurse(Hospital h,int no){
        this.h = h;
        this.nno = no;
    }

    void addPatient(Patient p){
        this.p = p;
    }
    @Override
    public void run() {
//        System.out.println("Nurse Thread.");
        while(h.inPatient!=true){
            try{wait();}catch (Exception e){}
        }
        h.appointment=true;
    }

}

class Doctor extends Thread{
    Nurse n;
    Hospital h;
    int dno;

    Doctor(Nurse n,Hospital h,int no){
        this.n = n;
        this.h = h;
        this.dno = no;
    }

    @Override
    public void run() {
        while (h.appointment!=true){
            try{wait();}catch (Exception e){}
        }
        h.doctorVisit(n,dno);
    }
}

class Patient extends Thread{
    Hospital h;
    int pno;

    Patient(Hospital h,int no){
        this.h = h;
        this.pno = no;
    }
    @Override
    public void run() {
        h.Visit(this);
    }
}
class Receptionist extends Thread{
    Hospital h;

    Receptionist(Hospital h){
        this.h = h;
    }

    @Override
    public void run() {
//        System.out.println("Receptionist Thread.");
        while (h.inPatient!=true) {
            try {wait();} catch (Exception e) {}
        }
        h.reg = true;
    }

}




