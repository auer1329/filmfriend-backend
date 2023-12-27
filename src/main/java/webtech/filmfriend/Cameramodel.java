package webtech.filmfriend;

import jakarta.persistence.*;

@Entity

public class Cameramodel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String brand;
    private String model;
    private String staticImageUrl;
    private boolean formatThirtyFive;
    private boolean formatOneTwenty;
    @OneToOne
    private Roll roll;
    public Cameramodel() {}

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

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getStaticImageUrl() {
        return staticImageUrl;
    }

    public void setStaticImageUrl(String staticImageUrl) {
        this.staticImageUrl = staticImageUrl;
    }

    public boolean isFormatThirtyFive() {
        return formatThirtyFive;
    }

    public void setFormatThirtyFive(boolean formatThirtyFive) {
        this.formatThirtyFive = formatThirtyFive;
    }

    public boolean isFormatOneTwenty() {
        return formatOneTwenty;
    }

    public void setFormatOneTwenty(boolean formatOneTwenty) {
        this.formatOneTwenty = formatOneTwenty;
    }

    public Roll getRoll() {
        return roll;
    }

    public void setRoll(Roll roll) {
        this.roll=roll;
    }
}
