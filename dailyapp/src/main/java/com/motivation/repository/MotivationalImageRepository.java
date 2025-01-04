package com.motivation.repository;

import com.motivation.model.MotivationalImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MotivationalImageRepository extends JpaRepository<MotivationalImage, Long> {
    @Query(value = "SELECT * FROM motivational_image ORDER BY RAND() LIMIT 1", nativeQuery = true)
    MotivationalImage findRandomImage();
} 