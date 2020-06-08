package ru.rapidSilver.publisher.domain;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.time.Instant;


@Data
public class Publisher {
    final Integer max = 999999999;
    final Integer min = 100000000;
    private Integer id;
    @NonNull
    private Integer msisdn;
    @NonNull
    private Action action;
    @NonNull
    private long timestamp;

    public Publisher() {
        this.msisdn = (int) (Math.random() * (max - min)) + min;;
        this.action = Action.findByValue((int) Math.round(Math.random()));
        this.timestamp = Instant.now().getEpochSecond();
    }
}
