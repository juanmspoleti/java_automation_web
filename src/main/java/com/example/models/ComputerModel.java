package com.example.models;

import com.example.core.Utils;

public class ComputerModel {

    private String id;
    private String name;
    private String introducedDate;
    private String discontinuedDate;
    private String company;

    /**
     * Default new ComputerModel sets only the name (required input)
     */
    public ComputerModel(){
        this.name = Utils.fillWithRandom("Automation #####");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIntroducedDate() {
        if(introducedDate == null){
            introducedDate = "";
        }
        return introducedDate;
    }

    public void setIntroducedDate(String introducedDate) {
        this.introducedDate = introducedDate;
    }

    public String getDiscontinuedDate() {
        if(discontinuedDate == null){
            discontinuedDate = "";
        }
        return discontinuedDate;
    }

    public void setDiscontinuedDate(String discontinuedDate) {
        this.discontinuedDate = discontinuedDate;
    }

    public String getCompany() {
        if(company == null){
            company = "";
        }
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
