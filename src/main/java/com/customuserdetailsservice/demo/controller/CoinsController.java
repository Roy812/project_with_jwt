package com.customuserdetailsservice.demo.controller;

import com.customuserdetailsservice.demo.model.Coins;
import com.customuserdetailsservice.demo.service.CoinService;
import com.customuserdetailsservice.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("coins")
public class CoinsController {

    private CoinService coinService;
    private UserService userService;

    @Autowired
    public CoinsController(CoinService coinService, UserService userService) {
        this.coinService = coinService;
        this.userService = userService;
    }

//    @PostMapping(value = "/buy")
//    public ResponseEntity<Object> buyCoins(@RequestBody Coins coins) {
//        coinService.buyCoins(coins);
//        return ResponseEntity.ok("Coins purchased");
//    }

    @PatchMapping(value = "/balance/id/{id}")
    public ResponseEntity<Object> updateCoinBalance(@PathVariable ("id") long userId, @RequestBody int amount) {
        coinService.updateCoinBalance(userId, amount);
        return ResponseEntity.ok("Balance is updated");
    }





}
