package ru.company.calorie_tracking.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "app_dishes")
public class Dish {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Column(name = "calories", nullable = false)
    private double calories;

    @Column(name = "proteins", nullable = false)
    private double proteins;

    @Column(name = "fats", nullable = false)
    private double fats;

    @Column(name = "carbohydrates", nullable = false)
    private double carbohydrates;

    public Long id() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String name() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCalories() {
        return calories;
    }

    public void setCalories(double calories) {
        this.calories = calories;
    }

    public double proteins() {
        return proteins;
    }

    public void setProteins(double proteins) {
        this.proteins = proteins;
    }

    public double fats() {
        return fats;
    }

    public void setFats(double fats) {
        this.fats = fats;
    }

    public double carbohydrates() {
        return carbohydrates;
    }

    public void setCarbohydrates(double carbohydrates) {
        this.carbohydrates = carbohydrates;
    }
}