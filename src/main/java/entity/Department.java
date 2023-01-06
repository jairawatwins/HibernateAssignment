package entity;

import jakarta.persistence.*;

import java.util.Set;
@Entity
@Table
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DEPT_ID")
    private int depId;
    @Column(name = "DEP_NAME")
    private String depName;

    private Set<Student> students;

    public Department() {
    }

    public Department(int depId, String depName, Set<Student> students) {
        this.depId = depId;
        this.depName = depName;
        this.students = students;
    }

    public int getDepId() {
        return depId;
    }

    public void setDepId(int depId) {
        this.depId = depId;
    }

    public String getDepName() {
        return depName;
    }

    public void setDepName(String depName) {
        this.depName = depName;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "Department{" +
                "depId='" + depId + '\'' +
                ", depName='" + depName + '\'' +
                ", students=" + students +
                '}';
    }
}
