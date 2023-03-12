package com.duyhung.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "videos")
public class Video implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "title")
    private String title;
    @Column(name = "poster")
    private String poster;
    @Column(name = "views")
    private Integer views;
    @Column(name = "description",columnDefinition = "text")
    private String description;
    @Column(name = "active")
    private Boolean active;
}
