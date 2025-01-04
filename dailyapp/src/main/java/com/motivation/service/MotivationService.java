package com.motivation.service;

import com.motivation.model.Quote;
import com.motivation.model.MotivationalImage;
import com.motivation.repository.QuoteRepository;
import com.motivation.repository.MotivationalImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MotivationService {
    
    private final QuoteRepository quoteRepository;
    private final MotivationalImageRepository imageRepository;

    @Autowired
    public MotivationService(QuoteRepository quoteRepository, MotivationalImageRepository imageRepository) {
        this.quoteRepository = quoteRepository;
        this.imageRepository = imageRepository;
    }

    public Quote getDailyQuote() {
        return quoteRepository.findRandomQuote();
    }

    public MotivationalImage getDailyImage() {
        return imageRepository.findRandomImage();
    }

    public List<Quote> getAllQuotes() {
        return quoteRepository.findAll();
    }

    public List<MotivationalImage> getAllImages() {
        return imageRepository.findAll();
    }
} 