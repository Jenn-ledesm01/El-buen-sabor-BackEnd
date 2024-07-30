package com.utn.ElBuenSabor.dtos;


import lombok.Data;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

@Data
public class DTOBase{

    private String fechaAlta;

    private String fechaModificacion;

    private String fechaBaja;
    @Autowired
    private ModelMapper modelMapper;

    private static final SimpleDateFormat dateFormat
            = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    public Date getSubmissionDateConvertedAlta(String timezone) throws ParseException {
        dateFormat.setTimeZone(TimeZone.getTimeZone(timezone));
        return dateFormat.parse(this.fechaAlta);
    }

    public void setSubmissionDateAlta(Date date, String timezone) {
        dateFormat.setTimeZone(TimeZone.getTimeZone(timezone));
        this.fechaAlta = dateFormat.format(date);
    }

    public Date getSubmissionDateConvertedBaja(String timezone) throws ParseException {
        dateFormat.setTimeZone(TimeZone.getTimeZone(timezone));
        return dateFormat.parse(this.fechaBaja);
    }

    public void setSubmissionDateBaja(Date date, String timezone) {
        dateFormat.setTimeZone(TimeZone.getTimeZone(timezone));
        this.fechaBaja = dateFormat.format(date);
    }

    public Date getSubmissionDateConvertedMod(String timezone) throws ParseException {
        dateFormat.setTimeZone(TimeZone.getTimeZone(timezone));
        return dateFormat.parse(this.fechaModificacion);
    }

    public void setSubmissionDateMod(Date date, String timezone) {
        dateFormat.setTimeZone(TimeZone.getTimeZone(timezone));
        this.fechaModificacion = dateFormat.format(date);
    }
}
