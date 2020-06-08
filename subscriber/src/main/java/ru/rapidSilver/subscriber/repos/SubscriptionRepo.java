package ru.rapidSilver.subscriber.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.rapidSilver.subscriber.domain.Subscription;


@Repository
public interface SubscriptionRepo extends CrudRepository<Subscription, Integer> {
}
