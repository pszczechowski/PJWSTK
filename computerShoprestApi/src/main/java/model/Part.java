package model;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
@Entity


@NamedQueries({
        @NamedQuery(name="part.all", query="SELECT p FROM Part p"),
        @NamedQuery(name="part.id", query="FROM Part p WHERE p.id=:partId"),
        @NamedQuery(name="part.ByCategory", query="FROM Part p WHERE p.type=:category"),
        @NamedQuery(name="part.byPrice", query="FROM Part p WHERE p.price>=:minPrice AND p.price<=:maxPrice"),
})


public class Part {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private double price;
    private String type;

    public Part() {
    }

    public Part(double price, String type) {
        this.price = price;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
