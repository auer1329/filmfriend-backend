package webtech.filmfriend;

import jakarta.persistence.*;

import java.util.List;
@Entity
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String brand;
    private String name;
    private int iso;
    private boolean formatThirtyFive;
    private boolean formatOneTwenty;
    private boolean color;
    private String process;
    private String staticImageUrl;
    private String description;
    @OneToMany
    private List<Feature> keyFeatures;

    public Stock() {}

    public Stock(String brand, String name, int iso, boolean formatThirtyFive, boolean formatOneTwenty) {
        this.brand = brand;
        this.name = name;
        this.iso = iso;
        this.formatThirtyFive = formatThirtyFive;
        this.formatOneTwenty = formatOneTwenty;
    }

    public Stock(String apiID, String brand, String name, int iso, boolean formatThirtyFive, boolean formatOneTwenty, boolean color, String process, String staticImageUrl, String description, List<Feature> keyFeatures) {
        this.id = (long) apiID.hashCode();
        this.brand = brand;
        this.name = name;
        this.iso = iso;
        this.formatThirtyFive = formatThirtyFive;
        this.formatOneTwenty = formatOneTwenty;
        this.color = color;
        this.process = process;
        this.staticImageUrl = staticImageUrl;
        this.description = description;
        this.keyFeatures = keyFeatures;
    }

    public Long getId() {
        return id;
    }
    public String getBrand() {
        return brand;
    }

    public String getName() {
        return name;
    }

    public int getIso() {
        return iso;
    }

    public boolean isFormatThirtyFive() {
        return formatThirtyFive;
    }

    public boolean isFormatOneTwenty() {
        return formatOneTwenty;
    }

    public boolean isColor() {
        return color;
    }

    public String getProcess() {
        return process;
    }

    public String getStaticImageUrl() {
        return staticImageUrl;
    }

    public String getDescription() {
        return description;
    }

    public List<Feature> getKeyFeatures() {
        return keyFeatures;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setIso(int iso) {
        this.iso = iso;
    }

    public void setFormatThirtyFive(boolean formatThirtyFive) {
        this.formatThirtyFive = formatThirtyFive;
    }

    public void setFormatOneTwenty(boolean formatOneTwenty) {
        this.formatOneTwenty = formatOneTwenty;
    }

    public void setColor(boolean color) {
        this.color = color;
    }

    public void setProcess(String process) {
        this.process = process;
    }

    public void setStaticImageUrl(String staticImageUrl) {
        this.staticImageUrl = staticImageUrl;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setKeyFeatures(List<Feature> keyFeatures) {
        this.keyFeatures = keyFeatures;
    }
}
