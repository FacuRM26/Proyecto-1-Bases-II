package com.example.proyecto12;
 import javax.persistence.*;

@Entity
    @Table(name = "Students")
public class Student{
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)

     private int ID;
    private String NAME;
    private String EMAIL;


    public int getId() {
        return ID;
    }

    public void setId(int id) {
        this.ID = id;
    }

    public String getName() {
        return NAME;
    }

    public void setName(String name) {
        this.NAME = name;
    }

    public String getEmail() {
        return EMAIL;
    }

    public void setEmail(String email) {
        this.EMAIL = email;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + ID+
                ", name='" + NAME + '\'' +
                ", email='" + EMAIL+ '\'' +
                '}';
    }
}
