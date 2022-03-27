package hu.polnikadam.wysiokocsma.model;

import javax.persistence.*;

@Entity
@Table(name = "Drinks")
public class Drink {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "Name")
    private String name;
    @Column(name ="ABV")
    private double  abv;
    @Column(name = "Volume")
    private double  volume;

    public Drink(String name, double abv, double volume) {
        this.name = name;
        this.abv = abv;
        this.volume = volume;
    }

    public Drink() {
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getAbv() {
        return abv;
    }

    public double getVolume() {
        return volume;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAbv(double abv) {
        this.abv = abv;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }
}
