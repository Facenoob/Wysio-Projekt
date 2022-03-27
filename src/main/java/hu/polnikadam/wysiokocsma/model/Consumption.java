package hu.polnikadam.wysiokocsma.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Consumption")
public class Consumption {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @ManyToMany
    @Column(name="Drink")
    private List<Drink> drink;
    @Column(name="NumberOfDrinks")
    private int numberOfDrinks;

    public Consumption(List<Drink> drink, int numberOfDrinks) {
        this.drink = drink;
        this.numberOfDrinks = numberOfDrinks;
    }

    public Consumption() {
    }

    public void setDrink(List<Drink> drink) {
        this.drink = drink;
    }

    public void setNumberOfDrinks(int numberOfDrinks) {
        this.numberOfDrinks = numberOfDrinks;
    }

    public long getId() {
        return id;
    }

    public List<Drink> getDrink() {
        return drink;
    }

    public int getNumberOfDrinks() {
        return numberOfDrinks;
    }
}
