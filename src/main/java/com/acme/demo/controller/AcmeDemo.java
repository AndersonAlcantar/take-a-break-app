package com.acme.demo.controller;

import com.acme.demo.dto.CustomersBody;
import com.acme.demo.dto.RequestMessage;
import com.acme.demo.entity.Customers;
import com.acme.demo.listener.LogsEventListener;
import com.acme.demo.service.ReturnInputMessage;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/acme")
public class AcmeDemo {

    public final ReturnInputMessage returnInputMessage;

    public AcmeDemo(ReturnInputMessage returnInputMessage) {
        this.returnInputMessage = returnInputMessage;
    }


    @GetMapping(value = "/message")
    public ResponseEntity<?> printMessage() {
        Map<String, String> finalMessage = new HashMap<>();
        finalMessage.put("message", "Hello World");
        finalMessage.put("otherMessage", "MESSAGE");
        return ResponseEntity.ok(finalMessage);
    }

    @PostMapping(value = "/event")
    public ResponseEntity<?> executeAutomaticEvent(@RequestBody RequestMessage requestMessage) {
        var response = new HashMap<>();
        response.put("message", returnInputMessage.printLog(requestMessage.getMessage()));
        return ResponseEntity.ok(response);
    }

    @GetMapping(value = "/customers")
    public ResponseEntity<?> getClients() {
        return returnInputMessage.getCustomerList();
    }

    @PostMapping(value = "/save-customer")
    public ResponseEntity<?> saveNewCustomer(@RequestBody CustomersBody customer) {
        return returnInputMessage.saveNewCustomer(customer);
    }

    @GetMapping(value = "/env")
    public ResponseEntity<Map<?, ?>> getEnv() {
        return ResponseEntity.ok(System.getenv());
    }
}

