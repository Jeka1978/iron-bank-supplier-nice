package com.naya.ironbanksupplier.services;

import com.netflix.discovery.DiscoveryClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Random;

/**
 * @author Evgeny Borisov
 */
@Service
public class MoneySupplierImpl implements MoneySupplier {

    private Random random = new Random();
    @Autowired
    private RestTemplate restTemplate;

    @Override
    public void deposit(long amount) {
        transfer(amount);
    }

    @Override
    @Scheduled(cron = "1/20 * * * * ?")
    public long fillBank() {
        int amount = random.nextInt(1000) * 10;
        transfer(amount);
        return amount;
    }

    private void transfer(long amount) {
        restTemplate.getForObject("http://BANK/iron-bank/api/deposit/" + amount,String.class);
    }
}
