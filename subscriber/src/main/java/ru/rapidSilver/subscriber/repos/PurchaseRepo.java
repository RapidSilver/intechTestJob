package ru.rapidSilver.subscriber.repos;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.rapidSilver.subscriber.domain.Purchase;


@Repository
public interface PurchaseRepo extends CrudRepository<Purchase, Integer> {
}
