package com.customuserdetailsservice.demo.service;

import com.customuserdetailsservice.demo.Exception.BadRequestException;
import com.customuserdetailsservice.demo.Exception.RecordNotFoundException;
import com.customuserdetailsservice.demo.model.Coins;
import com.customuserdetailsservice.demo.model.User;
import com.customuserdetailsservice.demo.repository.CoinRepository;
import com.customuserdetailsservice.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CoinsServiceImpl implements CoinService{

    private CoinRepository coinRepository;
    private UserRepository userRepository;

    @Autowired
    public CoinsServiceImpl(CoinRepository coinRepository, UserRepository userRepository) {
        this.coinRepository = coinRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void updateCoinBalance(long userId, int amount) {
        Optional<User> user = userRepository.findById(userId);
        int coinBalance = user.get().getCoinBalance();
        try {
            user.get().setCoinBalance(coinBalance + amount);
        } catch (Exception e) {
            throw new RecordNotFoundException();
        }
    }

    //    @Override
//    public void buyCoins(Coins coins) {
//        List<Coins> list = coinRepository.findAll();
//        boolean badRequest = false;
//        for (int i = 0; i < list.size(); i++) {
//            if (coins.getCoinsKey().equals(list.get(i).getCoinsKey())) {
//                badRequest = true;
//            }
//        }
//        if (badRequest) {
//            throw new BadRequestException();
//        } else {
//            coinRepository.save(coins);
//        }
//    }

//    @Override
//    public void getByCoinsKey(String coinsKey) {
//        try {
//            coinRepository.findCoinsByCoinsKey(coinsKey);
//        } catch (Exception e) {
//            throw new BadRequestException();
//        }
//    }

}
