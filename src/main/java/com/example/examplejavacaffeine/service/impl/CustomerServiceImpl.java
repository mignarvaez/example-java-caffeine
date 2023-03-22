package com.example.examplejavacaffeine.service.impl;

import com.example.examplejavacaffeine.model.Customer;
import com.example.examplejavacaffeine.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

// En cacheNames indicamos que elemento será cacheable
@Service
@CacheConfig(cacheNames = {"customer"})
public class CustomerServiceImpl implements CustomerService {

    private static final Logger LOG = LoggerFactory.getLogger(CustomerServiceImpl.class);

    // Cacheable indica que es un método cacheable
    @Cacheable
    @Override
    public Customer getCustomer(String id) {
        LOG.info("Get customer information for id {}", id);
        return getCustomerData(id);
    }

    private Customer getCustomerData(String id)
    {
        Customer customer = new Customer(id,"prueba", "prueba@email", "pruebaAir");
        return customer;
    }
}
