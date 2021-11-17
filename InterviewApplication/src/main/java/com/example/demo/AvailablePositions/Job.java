package com.example.demo.AvailablePositions;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Job {
    private @Id @GeneratedValue Long id;
    private String name;
    private String domain;
    private String numberOfWantedPeople;
    private String description;
    private String level;

    Job(){}

    Job(String name, String domain, String numberOfWantedPeople, String description, String level){
        this.name = name;
        this.domain = domain;
        this.numberOfWantedPeople = numberOfWantedPeople;
        this.description = description;
        this.level = level;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getNumberOfWantedPeople() {
        return numberOfWantedPeople;
    }

    public void setNumberOfWantedPeople(String numberOfWantedPeople) {
        this.numberOfWantedPeople = numberOfWantedPeople;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Job))
            return false;
        Job job = (Job) o;
        return Objects.equals(this.id, job.id) && Objects.equals(this.name, job.name)
                && Objects.equals(this.domain, job.domain) && Objects.equals(this.numberOfWantedPeople, job.numberOfWantedPeople)
                && Objects.equals(this.description, job.description) && Objects.equals(this.level, job.level);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.name, this.domain, this.numberOfWantedPeople, this.description, this.level);
    }

    @Override
    public String toString() {
        return "Job{" + "id=" + this.id + ", name='" + this.name + '\''
                + ", domain='" + this.domain + '\''
                + ", numberOfWantedPeople='" + this.numberOfWantedPeople + '\''
                + ", description='" + this.description + '\''
                + ", level='" + this.level + '\'' + '}';
    }
}
