package com.project.contrader.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Objects;

/**
 * A Device.
 */
@Entity
@Table(name = "device")
public class Device implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "mac")
    private String mac;

    @Column(name = "devtype")
    private String devtype;

    @Column(name = "position")
    private String position;

    @ManyToOne
    @JsonIgnoreProperties("")
    private Client client;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMac() {
        return mac;
    }

    public Device mac(String mac) {
        this.mac = mac;
        return this;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    public String getDevtype() {
        return devtype;
    }

    public Device devtype(String devtype) {
        this.devtype = devtype;
        return this;
    }

    public void setDevtype(String devtype) {
        this.devtype = devtype;
    }

    public String getPosition() {
        return position;
    }

    public Device position(String position) {
        this.position = position;
        return this;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Client getClient() {
        return client;
    }

    public Device client(Client client) {
        this.client = client;
        return this;
    }

    public void setClient(Client client) {
        this.client = client;
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
        Device device = (Device) o;
        if (device.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), device.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Device{" +
            "id=" + getId() +
            ", mac='" + getMac() + "'" +
            ", devtype='" + getDevtype() + "'" +
            ", position='" + getPosition() + "'" +
            "}";
    }
}
