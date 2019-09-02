package com.project.contrader.domain;


import javax.persistence.*;

import java.io.Serializable;
import java.util.Objects;

/**
 * A Screen.
 */
@Entity
@Table(name = "screen")
public class Screen implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "output")
    private String output;

    @Column(name = "position")
    private String position;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOutput() {
        return output;
    }

    public Screen output(String output) {
        this.output = output;
        return this;
    }

    public void setOutput(String output) {
        this.output = output;
    }

    public String getPosition() {
        return position;
    }

    public Screen position(String position) {
        this.position = position;
        return this;
    }

    public void setPosition(String position) {
        this.position = position;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Screen screen = (Screen) o;
        if (screen.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), screen.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Screen{" +
            "id=" + getId() +
            ", output='" + getOutput() + "'" +
            ", position='" + getPosition() + "'" +
            "}";
    }
}
