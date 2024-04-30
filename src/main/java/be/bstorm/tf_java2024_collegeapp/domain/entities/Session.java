package be.bstorm.tf_java2024_collegeapp.domain.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Session extends BaseEntity<Long>{

    @Getter @Setter
    @Column(name = "DAY_",nullable = false)
    private int day;

    @Getter @Setter
    @Column(name = "HOUR_",nullable = false)
    private int hour;

    @Getter @Setter
    @ManyToOne(fetch = FetchType.EAGER)
    private Course course;

    @Getter @Setter
    @ManyToOne(fetch = FetchType.EAGER)
    private Grade grade;
}
