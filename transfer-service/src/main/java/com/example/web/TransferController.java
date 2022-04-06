package com.example.web;

import com.example.service.AccountBalanceException;
import com.example.service.TransferService;
import com.example.web.payload.TransferRequest;
import com.example.web.payload.TransferResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class TransferController {

    @Autowired
    private TransferService transferService;


    @RequestMapping(
            method = RequestMethod.POST,
            value = "/transfer",
            consumes = {"application/json"},
            produces = {"application/json"}
    )
    public TransferResponse doTransfer(@RequestBody TransferRequest request) {
        System.out.println("doTransfer");
        TransferResponse transferResponse = new TransferResponse();
        try {
            boolean b = transferService.transfer(request.getAmount(), request.getFromAccNum(), request.getToAccNum());
            if (b) {
                transferResponse.setTxnId("1");
                transferResponse.setMessage("transfer successfully");
            }
        } catch (AccountBalanceException e) {
            transferResponse.setMessage(e.getMessage());
        }
        return transferResponse;
    }

}
