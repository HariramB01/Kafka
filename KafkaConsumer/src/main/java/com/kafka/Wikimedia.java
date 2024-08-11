package com.kafka;


import jakarta.persistence.*;


@Entity
public class Wikimedia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    private String wikimedia;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWikimedia() {
        return wikimedia;
    }

    public void setWikimedia(String wikimedia) {
        this.wikimedia = wikimedia;
    }
}
