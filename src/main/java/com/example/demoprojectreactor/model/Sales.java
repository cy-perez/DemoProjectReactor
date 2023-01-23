package com.example.demoprojectreactor.model;

import java.time.LocalDateTime;

public class Sales {

 private Integer id;
 private LocalDateTime saleDate;

    public Sales() {
    }

    public Sales(Integer id, LocalDateTime saleDate) {
        this.id = id;
        this.saleDate = saleDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(LocalDateTime saleDate) {
        this.saleDate = saleDate;
    }

    @Override
    public String toString() {
        return "Sales{" +
                "id: " + id +
                ", saleDate: " + saleDate +
                '}';
    }
}
