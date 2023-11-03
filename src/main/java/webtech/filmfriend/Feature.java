package webtech.filmfriend;

import jakarta.persistence.*;
import jdk.jfr.Enabled;

@Entity
public class Feature {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String apiID;
    String feature;
}
