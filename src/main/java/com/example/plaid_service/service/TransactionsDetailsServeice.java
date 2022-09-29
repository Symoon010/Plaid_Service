package com.example.plaid_service.service;

import com.example.plaid_service.dto.TransactionsDto;
import com.example.plaid_service.model.entity.TransactionsDetailsModel;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionsDetailsServeice {

    @Autowired
    private ModelMapper modelMapper;

    public TransactionsDetailsModel convertDtoToEntity(TransactionsDto transactionsDto){
        TransactionsDetailsModel  transactionsDetailsModel= new TransactionsDetailsModel();
        transactionsDetailsModel = modelMapper.map(transactionsDto, TransactionsDetailsModel.class);

        return transactionsDetailsModel;
    }
}
