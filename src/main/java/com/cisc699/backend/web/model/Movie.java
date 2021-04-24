package com.cisc699.backend.web.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Table("movies")
public class Movie {
    @Id
    @Column("movie_id")
    private Long id;

    private String name;

    private String genre;


    private String lead;

    private String audience_score;

    private String profitability;

    private String rotten_tomatoes_score;

    private String worldwide_gross;

    private String year;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getGenre() {
        return genre;
    }

    public String getLead() {
        return lead;
    }

    public String getAudience_score() {
        return audience_score;
    }

    public String getProfitability() {
        return profitability;
    }

    public String rotten_tomatoes_score() {
        return rotten_tomatoes_score;
    }

    public String getWorldwide_gross() {
        return worldwide_gross;
    }

    public String getYear() {
        return year;
    }

    public Movie(String line) {
        String[] values = line.split(",");
        this.name = values[0];
        this.genre = values[1];
        this.lead = values[2];
        this.audience_score = values[3];
        this.profitability = values[4];
        this.rotten_tomatoes_score = values[5];
        this.worldwide_gross = values[6];
        this.year = values[7];
    }
}
