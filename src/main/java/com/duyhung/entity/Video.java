package com.duyhung.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

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
    @Column(name = "youtube_link")
    private String youtubeLink;
    @OneToMany(mappedBy = "videoId")
    private List<Favorite> favorites;

    public Video(Long id, String title, String poster, Integer views, String description, Boolean active, String youtubeLink) {
        this.id = id;
        this.title = title;
        this.poster = poster;
        this.views = views;
        this.description = description;
        this.active = active;
        this.youtubeLink = youtubeLink;
    }
}
