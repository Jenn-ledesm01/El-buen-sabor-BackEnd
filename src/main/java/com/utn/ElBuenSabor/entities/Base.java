package com.utn.ElBuenSabor.entities;

import jakarta.persistence.*;
import lombok.*;
import jakarta.validation.constraints.NotNull;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;


@MappedSuperclass
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Base implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "fecha_alta")
    private String fechaAlta;

    @Column(name = "fecha_modificacion")
    private String fechaModificacion;

    @Column(name = "fecha_baja")
    private String fechaBaja;

    private static final SimpleDateFormat dateFormat
            = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    public Date getSubmissionDateConvertedAlta(String timezone) throws ParseException {
        dateFormat.setTimeZone(TimeZone.getTimeZone(timezone));
        return dateFormat.parse(this.fechaAlta);
    }

    public void setSubmissionDateAlta(Date date) {
        //dateFormat.setTimeZone(TimeZone.getTimeZone(timezone));
        fechaAlta = dateFormat.format(date);
    }

    public Date getSubmissionDateConvertedBaja(String timezone) throws ParseException {
        dateFormat.setTimeZone(TimeZone.getTimeZone(timezone));
        return dateFormat.parse(this.fechaBaja);
    }

    public void setSubmissionDateBaja(Date date) {
        //dateFormat.setTimeZone(TimeZone.getTimeZone(timezone));
        fechaBaja = dateFormat.format(date);
    }

    public Date getSubmissionDateConvertedMod(String timezone) throws ParseException {
        dateFormat.setTimeZone(TimeZone.getTimeZone(timezone));
        return dateFormat.parse(this.fechaModificacion);
    }

    public void setSubmissionDateMod(Date date) {
        //dateFormat.setTimeZone(TimeZone.getTimeZone(timezone));
        fechaModificacion = dateFormat.format(date);
    }



}