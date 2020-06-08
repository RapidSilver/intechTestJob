package ru.rapidSilver.subscriber.Controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.rapidSilver.subscriber.domain.Publisher;
import ru.rapidSilver.subscriber.domain.Purchase;
import ru.rapidSilver.subscriber.domain.Subscription;
import ru.rapidSilver.subscriber.repos.PurchaseRepo;
import ru.rapidSilver.subscriber.repos.SubscriptionRepo;


@RestController
public class SubscriberController {

    Logger logger = LoggerFactory.getLogger(SubscriberController.class);

    @Autowired
    PurchaseRepo purchaseRepo;

    @Autowired
    SubscriptionRepo subscriptionRepo;

    @PostMapping("/save")
    public Object save(@RequestBody Publisher publisher){
        logger.info("проверка");
        switch (publisher.getAction()) {
            case PURCHASE:
                logger.info("Сохраняем данные в таблицу PURCHASE");
                purchaseRepo.save(new Purchase(publisher.getMsisdn(), publisher.getTimestamp()));
                break;
            case SUBSCRIPTION:
                logger.info("Сохраняем данные в таблицу SUBSCRIPTION");
                subscriptionRepo.save(new Subscription(publisher.getMsisdn(), publisher.getTimestamp()));
        }
//        logger.info("неверное значение ACTION, не сохраняем");
        return publisher;
    }
}
