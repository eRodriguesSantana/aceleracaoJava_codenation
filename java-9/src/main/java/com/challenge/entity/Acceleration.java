package com.challenge.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Timestamp;
import java.util.List;

@Data
@EqualsAndHashCode(of="id")
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Acceleration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Size(max = 100)
    @Column(name = "name")
    private String name;

    @NotNull
    @Size(max = 50)
    @Column(name = "slug")
    private String slug;

    @ManyToOne
    @JoinColumn(name = "challenge_id")
    private Challenge challenge;

    @NotNull
    @CreatedDate
    @Column(name = "created_at")
    private Timestamp created_at;

    @OneToMany(cascade = CascadeType.ALL, mappedBy="acceleration")
    private List<Candidate> candidateList;
}