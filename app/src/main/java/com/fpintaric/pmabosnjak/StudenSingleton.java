package com.fpintaric.pmabosnjak;

import java.util.ArrayList;
import java.util.List;

public class StudenSingleton {
    private static StudenSingleton oInstance = null;
    private List<Student> studenti = new ArrayList<>();

    protected StudenSingleton() {

    }

    public static StudenSingleton getInstance() {
        if(oInstance == null) {
            oInstance = new StudenSingleton();
        }
        return oInstance;
    }

    public List<Student> getStudent() {
        return studenti;
    }

    public void dodjaStudent(Student student) {
        studenti.add(student);
    }

}
