package hu.polnikadam.wysiokocsma.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Fights")
public class Fight {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name ="FightStart")
    private Date fightStart;
    @Column(name = "FightEnd")
    private Date  fightEnd;
    @ManyToMany
    @Column(name = "Fighters")
    private List<Costumer> fighters;
    @ManyToMany
    @Column(name = "Winner")
    private List<Costumer> winner;

    public Fight() {
    }

    public Fight(Date fightStart, Date fightEnd, List<Costumer> fighters, List<Costumer> winner) {
        this.fightStart = fightStart;
        this.fightEnd = fightEnd;
        this.fighters = fighters;
        this.winner = winner;
    }

    public void setFightStart(Date fightStart) {
        this.fightStart = fightStart;
    }

    public void setFightEnd(Date fightEnd) {
        this.fightEnd = fightEnd;
    }

    public void setFighters(List<Costumer> fighters) {
        this.fighters = fighters;
    }

    public void setWinner(List<Costumer> winner) {
        this.winner = winner;
    }

    public long getId() {
        return id;
    }

    public Date getFightStart() {
        return fightStart;
    }

    public Date getFightEnd() {
        return fightEnd;
    }

    public List<Costumer> getFighters() {
        return fighters;
    }

    public List<Costumer> getWinner() {
        return winner;
    }
}
