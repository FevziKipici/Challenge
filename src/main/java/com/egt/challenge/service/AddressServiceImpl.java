package com.egt.challenge.service;


import com.egt.challenge.model.Address;
import com.egt.challenge.repo.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl implements AddressService{

    @Autowired
    AddressRepository addressRepository;


    @Override
    public void saveAddress(Address address) {
        addressRepository.save(address);
    }
}
