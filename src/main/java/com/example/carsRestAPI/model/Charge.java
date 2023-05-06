package com.example.carsRestAPI.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Charge {
    private int idUser;
    private int idPointCharge;
    private Date dateStart;
    private Date dateEnd;
    private Boolean accepted;

    @Override
    public boolean equals(Object o) {
        // If the object is compared with itself then return true
        if (o == this) {
            return true;
        }

        /* Check if o is an instance of Complex or not
          "null instanceof [type]" also returns false */
        if (!(o instanceof Charge)) {
            return false;
        }

        // typecast o to Complex so that we can compare data members
        Charge c = (Charge) o;

        return Integer.compare(idUser,c.idUser) == 0
                && Integer.compare(idPointCharge, c.idPointCharge) == 0
                && dateStart.compareTo(c.dateStart) == 0
                && dateEnd.compareTo(c.dateEnd) == 0
                && Boolean.compare(accepted,c.accepted) ==0;
    }

}
