package hu.polnikadam.wysiokocsma.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "PubCheckIns")
public class PubCheckIn {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "PubCheckInfrom")
    private Date PubCheckInFrom;
    @Column(name = "PubCheckInto")
    private Date PubCheckInTo;
    @OneToMany
    @Column(name ="ConsumptionList")
    private List<Consumption> consumptionList;
    @Column(name = "Detox")
    private boolean  detox;

    public PubCheckIn() {
    }

    public PubCheckIn(Date pubCheckInFrom, Date pubCheckInTo, List<Consumption> consumptionList, boolean detox) {
        PubCheckInFrom = pubCheckInFrom;
        PubCheckInTo = pubCheckInTo;
        this.consumptionList = consumptionList;
        this.detox = detox;
    }

    public void setPubCheckInFrom(Date pubCheckInFrom) {
        PubCheckInFrom = pubCheckInFrom;
    }

    public void setPubCheckInTo(Date pubCheckInTo) {
        PubCheckInTo = pubCheckInTo;
    }

    public void setConsumptionList(List<Consumption> consumptionList) {
        this.consumptionList = consumptionList;
    }

    public void setDetox(boolean detox) {
        this.detox = detox;
    }

    public long getId() {
        return id;
    }

    public Date getPubCheckInFrom() {
        return PubCheckInFrom;
    }

    public Date getPubCheckInTo() {
        return PubCheckInTo;
    }

    public List<Consumption> getConsumptionList() {
        return consumptionList;
    }

    public boolean isDetox() {
        return detox;
    }
}
