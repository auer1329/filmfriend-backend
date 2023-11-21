package webtech.filmfriend;

import jakarta.persistence.*;

@Entity
public class Camera {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String brand;
    private String model;
    private String staticImageUrl;
    private boolean formatThirtyFive;
    private boolean formatOneTwenty;
    public Camera() {}
}
