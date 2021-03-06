package com.challenge.entity;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Timestamp;
import java.util.List;

@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Challenge {
    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @NotNull
    @Size(max = 100)
    @Column(name = "name")
    private String name;

    @NotNull
    @Size(max = 50)
    @Column(name = "slug")
    private String slug;

    @NotNull
    @CreatedDate
    @Column(name = "created_at")
    private Timestamp created_at;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Acceleration> accelerationList;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Submission> submissionList;
}