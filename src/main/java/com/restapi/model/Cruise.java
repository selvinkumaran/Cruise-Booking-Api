package com.restapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Cruise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 200)
    private String name;

    @Column(nullable = false, length = 200)
    private String description;

    private String photo;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createAt;

    @Column(nullable = false)
    private int capacity;

    @JsonIgnore
    @OneToMany(mappedBy = "cruise",cascade = CascadeType.ALL)
    private List<Tour> tour;

}
