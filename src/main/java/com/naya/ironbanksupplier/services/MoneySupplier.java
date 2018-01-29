package com.naya.ironbanksupplier.services;

/**
 * @author Evgeny Borisov
 */
public interface MoneySupplier {
    void deposit(long amount);

    long fillBank();
}
