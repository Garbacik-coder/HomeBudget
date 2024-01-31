package com.garbacik.homebudget.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
import java.util.Date;

@Entity
@ApiModel(description = "Details about the spending")
public class Spending {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(notes = "The unique ID of the spending")
    private int id;

    @ApiModelProperty(notes = "The name of the spending")
    private String name;

    @ApiModelProperty(notes = "The cash value of the spending")
    private Integer value;

    @ApiModelProperty(notes = "The category of the spending")
    private String category;

    @JsonFormat(pattern="dd-MM-yyyy")
    @ApiModelProperty(notes = "The date of the spending")
    private LocalDate date;

    public Spending() {
        super();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value  ;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
