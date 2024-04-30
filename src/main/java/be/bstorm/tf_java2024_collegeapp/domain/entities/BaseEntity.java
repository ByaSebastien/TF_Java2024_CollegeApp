package be.bstorm.tf_java2024_collegeapp.domain.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@MappedSuperclass
public class BaseEntity<T extends Serializable> {

    @Id
    @GeneratedValue
    @Getter
    private T id;

    @Column(name = "CREATED_AT",nullable = false,updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    @Getter @Setter
    private LocalDateTime createdAt;

    @Column(name = "UPDATED_AT",nullable = false,updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @UpdateTimestamp
    @Getter @Setter
    private LocalDateTime updatedAt;
}
