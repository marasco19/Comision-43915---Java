package com.coderhouse.Clase8JPAABM.model;

import jakarta.persistence.*;
@Entity
@Table(name="invoice")
public class Invoice {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    private  Client client;
    private String created_at;
    private double total;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Invoice invoice)) return false;

        if (getId() != invoice.getId()) return false;
        if (Double.compare(invoice.getTotal(), getTotal()) != 0) return false;
        if (!getClient().equals(invoice.getClient())) return false;
        return getCreated_at().equals(invoice.getCreated_at());
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = getId();
        result = 31 * result + getClient().hashCode();
        result = 31 * result + getCreated_at().hashCode();
        temp = Double.doubleToLongBits(getTotal());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
