package com.fpintaric.pmabosnjak;

public class Student {
    private String Ime;
    private String Prezime;
    private String Predmet;

    public Student(String ime, String prezime, String predmet)
    {
        this.Ime = ime;
        this.Prezime=prezime;
        this.Predmet=predmet;
    }

    public String getIme() {
        return Ime;
    }

    public String getPredmet() {
        return Predmet;
    }

    public String getPrezime() {
        return Prezime;
    }


}
