package com.motivation.config;

import com.motivation.model.Quote;
import com.motivation.model.MotivationalImage;
import com.motivation.repository.QuoteRepository;
import com.motivation.repository.MotivationalImageRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner initDatabase(QuoteRepository quoteRepository,
                                 MotivationalImageRepository imageRepository) {
        return args -> {
            if (quoteRepository.count() == 0) {
                quoteRepository.save(new Quote("The future belongs to those who believe in the beauty of their dreams.", "Eleanor Roosevelt"));
                quoteRepository.save(new Quote("Success is not final, failure is not fatal: it is the courage to continue that counts.", "Winston Churchill"));
                quoteRepository.save(new Quote("Don't watch the clock; do what it does. Keep going.", "Sam Levenson"));
            }

            if (imageRepository.count() == 0) {
                imageRepository.save(new MotivationalImage("/images/mountain.jpg", "Climb Every Mountain"));
                imageRepository.save(new MotivationalImage("/images/sunrise.jpg", "New Day, New Beginning"));
                imageRepository.save(new MotivationalImage("/images/ocean.jpg", "Endless Possibilities"));
            }
        };
    }
} 