package com.example.springHtml.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="image")
@Setter
@Getter


public class ImageUploader {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "email" ,nullable = false)
    private String email;

    @Column(name = "image_url")
    private String imageUrl;

    public ImageUploader(String email ,String imageUrl) {
        this.email = email;
        this.imageUrl = imageUrl;
    }
}