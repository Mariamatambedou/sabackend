package com.example.sabackend.repository;

import com.example.sabackend.enums.TypeSentiment;
import com.example.sabackend.modele.Client;
import com.example.sabackend.modele.Sentiment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SentimentRepository extends JpaRepository<Sentiment, Integer> {
    List<Sentiment> findByType(TypeSentiment type);
}
