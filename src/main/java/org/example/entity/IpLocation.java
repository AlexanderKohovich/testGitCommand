package org.example.entity;

import com.fasterxml.jackson.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class IpLocation {

    private String fias_id;

    @JsonFormat(pattern = "HH:mm:ss")
    private Date date;

    @Override
    public String toString() {
        return "IpLocation{" +
                "fias_id=" + fias_id +
                ", date=" + date +
                '}';
    }

    private Map<String, String> properties;
    public IpLocation() {
        properties = new HashMap<>();
    }
    public Map<String, String> getProperties(){
        return properties;
    }
    @JsonAnySetter
    public void add(String property, String value){
        properties.put(property, value);
    }

    public IpLocation(String fias_id, Date date) {
        this.fias_id = fias_id;
        this.date = date;
    }

    public String getFias_id() {
        return fias_id;
    }

    public void setFias_id(String fias_id) {
        this.fias_id = fias_id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

}
