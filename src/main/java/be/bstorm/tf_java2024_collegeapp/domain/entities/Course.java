package be.bstorm.tf_java2024_collegeapp.domain.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = {"name","summary"})
@ToString
public class Course extends BaseEntity<Long>{

    @Column(name = "NAME",nullable = false,unique = true,length = 50)
    @Getter @Setter
    private String name;

    @Column(name = "SUMMARY",nullable = false,length = 200)
    @Getter @Setter
    private String summary;

    @Getter @Setter
    @Column(name = "ACADEMIC_YEAR")
    private int academicYear;

    @OneToOne(fetch = FetchType.EAGER)
    @Getter @Setter
    private Professor delegate;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Professor> professors;

    public Set<Professor> getProfessors() {
        return Set.copyOf(this.professors);
    }

    public void addProfessor(Professor p){
        this.professors.add(p);
    }

    public void removeProffesor(Professor p){
        this.professors.remove(p);
    }
}
