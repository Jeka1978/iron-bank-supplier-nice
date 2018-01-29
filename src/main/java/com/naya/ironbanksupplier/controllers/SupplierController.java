package com.naya.ironbanksupplier.controllers;

import com.naya.ironbanksupplier.services.MoneySupplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Evgeny Borisov
 */
@RestController
@RequestMapping("/iron-bank-supplier/api")
public class SupplierController {
    @Autowired
    private MoneySupplier moneySupplier;

    @GetMapping("/deposit/{amount}")
    public String deposit(@PathVariable Long amount) {
        moneySupplier.deposit(amount);
        return "Transfer was completed. Amount: " + amount;
    }
}
