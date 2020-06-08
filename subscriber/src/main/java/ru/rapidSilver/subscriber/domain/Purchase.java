package ru.rapidSilver.subscriber.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
public class Purchase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NonNull
    private Integer msisdn;
    @NonNull
    private long timestamp;

    public Purchase(@NonNull Integer msisdn, @NonNull long timestamp) {
        this.msisdn = msisdn;
        this.timestamp = timestamp;
    }
}
