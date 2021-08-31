package com.customuserdetailsservice.demo.service;

import com.customuserdetailsservice.demo.model.Coins;

public interface CoinService {
    //    void buyCoins(Coins coins);
    //    void getByCoinsKey(String coinsKey);
    void updateCoinBalance(long userId, int amount);
}
