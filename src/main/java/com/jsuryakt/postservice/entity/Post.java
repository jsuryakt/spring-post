package com.jsuryakt.postservice.entity;

import jakarta.persistence.*;
import java.util.List;
import lombok.Data;

@Data
@Entity(name = "post")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @ElementCollection
    @Column(name = "media")
    private List<String> media;
}
