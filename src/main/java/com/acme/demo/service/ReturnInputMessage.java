package com.acme.demo.service;

import com.acme.demo.dto.CustomersBody;
import com.acme.demo.exception.ExceptionMessage;
import com.acme.demo.entity.Customers;
import com.acme.demo.events.LogsEvent;
import com.acme.demo.repository.CustomersRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.dao.DataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Slf4j
@Service
public class ReturnInputMessage implements ExceptionMessage {
    private final ApplicationEventPublisher applicationEventPublisher;
    private final CustomersRepository customersRepository;

    public ReturnInputMessage(ApplicationEventPublisher applicationEventPublisher,
                              CustomersRepository customersRepository) {
        this.applicationEventPublisher = applicationEventPublisher;
        this.customersRepository = customersRepository;
    }

    public String printLog(String message) {
        LogsEvent logsEvent = new LogsEvent(this, message);
        applicationEventPublisher.publishEvent(logsEvent);
        return message;
    }

    public ResponseEntity<?> getCustomerList() {
        try {
            var customersList = customersRepository.findAll();
            return customersList.isEmpty() ?
                    ResponseEntity.noContent().build() :
                    ResponseEntity.ok(customersList);
        } catch (DataAccessException ex) {
            return exceptionDBServer();
        }
    }

    public ResponseEntity<?> saveNewCustomer(CustomersBody customer) {
        try {
            customersRepository.save(new Customers(customer.name(),
                    customer.username(),
                    customer.age()));
            return successMessage();
        } catch (DataAccessException ex) {
            return exceptionDBServer();
        }
    }
}
