package com.personal.helper.wallet;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by hnastevska on 8/16/2017.
 */
@Entity
public class Wallet {
    @Id
    private String id;
    private String name;
    private String description;

    public Wallet(String id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public Wallet() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
