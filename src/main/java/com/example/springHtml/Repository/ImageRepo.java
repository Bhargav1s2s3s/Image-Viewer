package com.example.springHtml.Repository;

import com.example.springHtml.Model.ImageUploader;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ImageRepo extends JpaRepository<ImageUploader,Long> {

    @Query("SELECT i.imageUrl FROM ImageUploader i")
    List<String> getUrls();
}
