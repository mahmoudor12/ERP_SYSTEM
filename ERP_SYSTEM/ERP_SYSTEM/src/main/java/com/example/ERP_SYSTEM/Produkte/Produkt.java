package com.example.ERP_SYSTEM.Produkte;


import jakarta.persistence.*;
import com.example.ERP_SYSTEM.entities.*;
@Entity
@Table(name = "products")
public class Produkt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "product_name" ,nullable = false, length = 255)
    private  String Pruduct_name;
    @Column(name = "description_0" ,nullable = false, columnDefinition = "TEXT")
    private String description ;
    @Column(name = "description_1" ,nullable = false, columnDefinition = "TEXT")
    private String Description1 ;
    @Column(name = "description_2" ,nullable = false, columnDefinition = "TEXT")
    private String Description2 ;
    @Column(name = "description_3" ,nullable = false, columnDefinition = "TEXT")
    private String Description3 ;
    @Column(name = "price", nullable = false)
    private  double price;
    @Column(name = "artnr", nullable = false ,unique = true)
    private  String Artnr ;
    @Column(name = "image_url" , length = 1000,nullable = true)
    private  String ImageUrl;
    @Column(name = "stock_quantity", nullable = false)
    private int stockQuantity;
    @ManyToOne
    @JoinColumn(name = "warehouse_id", nullable = false)
    private Warehause warehouse ; // Verknüpfung zum Lagerhaus

    public Produkt() {
    }

    public Produkt(String pruduct_name, String description, String description1, String description2, String description3, double price, String artnr, String imageUrl, int stockQuantity, Warehause warehouse) {
        Pruduct_name = pruduct_name;
        this.description = description;
        Description1 = description1;
        Description2 = description2;
        Description3 = description3;
        this.price = price;
        Artnr = artnr;
        ImageUrl = imageUrl;
        this.stockQuantity = stockQuantity;
        this.warehouse = warehouse;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPruduct_name() {
        return Pruduct_name;
    }

    public void setPruduct_name(String pruduct_name) {
        Pruduct_name = pruduct_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription1() {
        return Description1;
    }

    public void setDescription1(String description1) {
        Description1 = description1;
    }

    public String getDescription2() {
        return Description2;
    }

    public void setDescription2(String description2) {
        Description2 = description2;
    }

    public String getDescription3() {
        return Description3;
    }

    public void setDescription3(String description3) {
        Description3 = description3;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getArtnr() {
        return Artnr;
    }

    public void setArtnr(String artnr) {
        Artnr = artnr;
    }

    public String getImageUrl() {
        return ImageUrl;
    }

    public void setImageUrl(String imageUrl) {
        ImageUrl = imageUrl;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    public Warehause getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(Warehause warehouse) {
        this.warehouse = warehouse;
    }

    @Override
    public String toString() {
        return "Produkt{" +
                "id=" + id +
                ", Pruduct_name='" + Pruduct_name + '\'' +
                ", description='" + description + '\'' +
                ", Description1='" + Description1 + '\'' +
                ", Description2='" + Description2 + '\'' +
                ", Description3='" + Description3 + '\'' +
                ", price=" + price +
                ", Artnr='" + Artnr + '\'' +
                ", ImageUrl='" + ImageUrl + '\'' +
                ", stockQuantity=" + stockQuantity +
                ", warehouse=" + warehouse +
                '}';
    }
}
