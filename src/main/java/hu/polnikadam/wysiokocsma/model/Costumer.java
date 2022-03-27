package hu.polnikadam.wysiokocsma.model;

import javax.persistence.*;

@Entity
@Table(name = "Costumers")
public class Costumer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "Name")
    private String name;
    @Column(name ="LiverStrength")
    private LiverStrength liverStrength;
    @Column(name = "BicepSize")
    private int  bicepsSize;

    public Costumer() {
    }

    public Costumer(String name, LiverStrength liverStrength, int bicepsSize) {
        this.name = name;
        this.liverStrength = liverStrength;
        this.bicepsSize = bicepsSize;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLiverStrength(LiverStrength liverStrength) {
        this.liverStrength = liverStrength;
    }

    public void setBicepsSize(int bicepsSize) {
        this.bicepsSize = bicepsSize;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LiverStrength getLiverStrength() {
        return liverStrength;
    }

    public int isBicepsSize() {
        return bicepsSize;
    }
}
