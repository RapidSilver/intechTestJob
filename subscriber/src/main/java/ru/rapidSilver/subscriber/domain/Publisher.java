package ru.rapidSilver.subscriber.domain;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import java.time.Instant;


@Data
@NoArgsConstructor
public class Publisher {
    private Integer id;
    @NonNull
    private Integer msisdn;
    @NonNull
    private Action action;
    @NonNull
    private long timestamp;

    public Publisher(@NonNull Integer msisdn, @NonNull Action action) {
        this.msisdn = msisdn;
        this.action = action;
        this.timestamp = Instant.now().getEpochSecond();
    }
}
