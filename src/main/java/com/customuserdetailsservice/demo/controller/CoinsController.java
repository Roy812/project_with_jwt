package com.customuserdetailsservice.demo.controller;

import com.customuserdetailsservice.demo.model.Coins;
import com.customuserdetailsservice.demo.service.CoinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("coins")
public class CoinsController {

    private CoinService coinService;

    @Autowired
    public CoinsController(CoinService coinService) {
        this.coinService = coinService;
    }

    @PostMapping(value = "/buy")
    public ResponseEntity<Object> buyCoins(@RequestBody Coins coins) {
        coinService.buyCoins(coins);
        return ResponseEntity.ok("Coins purchased");
    }

    @PatchMapping(value = "/balance/id/{id}")
    public ResponseEntity<Object> updateCoinBalance(@PathVariable ("id") long userId, @RequestBody Coins coins) {
        coinService.updateCoinBalance(coins, userId);
        return ResponseEntity.ok("Balance is updated");
    }





}
