package com.coderhouse.Clase8JPAABM.model;
import jakarta.persistence.*;
@Entity
@Table(name="invoice_details")
public class InvoiceDetails {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    private Invoice invoice;
    @ManyToOne
    private Product product;
    private double cantidad;
    private double precio;

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof InvoiceDetails that)) return false;

        if (Double.compare(that.getCantidad(), getCantidad()) != 0) return false;
        if (Double.compare(that.getPrecio(), getPrecio()) != 0) return false;
        if (!getInvoice().equals(that.getInvoice())) return false;
        return getProduct().equals(that.getProduct());
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = getInvoice().hashCode();
        result = 31 * result + getProduct().hashCode();
        temp = Double.doubleToLongBits(getCantidad());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(getPrecio());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
