package com.example.staybooking.model;

import javax.persistence.*;

@Entity
@Table(name = "stay_reserved_date")
public class StayReservedDate {

    @EmbeddedId // due to composite primary key
    private StayReservedDateKey id;
    @MapsId("stay_id") // refer to this col in another table,  create foreign key relation
    @ManyToOne // one stay/property can have multiple dates reserved
    private Stay stay;

    public StayReservedDate() {
    }

    public StayReservedDate(StayReservedDateKey id, Stay stay) {
        this.id = id;
        this.stay = stay;
    }

    public StayReservedDateKey getId() {
        return id;
    }

    public Stay getStay() {
        return stay;
    }
}
