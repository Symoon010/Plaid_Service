package com.example.plaid_service.controller;


import com.example.plaid_service.dto.*;
import com.example.plaid_service.model.entity.AccountModel;
import com.example.plaid_service.model.entity.TransactionsDetailsModel;
import com.example.plaid_service.model.*;
import com.example.plaid_service.repository.AccountDetailsDao;
import com.example.plaid_service.repository.TransactionsDetailsDao;
import com.example.plaid_service.service.AccountDetailsService;
import com.example.plaid_service.service.TransactionsDetailsServeice;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@RestController
public class PlaidController {


    final  String baseUrl = "https://sandbox.plaid.com";

    final String clientId = "632839951364620013bbbbbf";
    final  String secretId = "acb23a51705753f3dbcfe59758c217";
    final  String institutionId = "ins_3";
    final  String [] initialProducts ={"auth"};

    @Autowired
    AccountDetailsDao accountDetailsDao;
    @Autowired
    TransactionsDetailsDao transactionsDetailsDao;
    @Autowired
    AccountDetailsService accountDetailsService;
    @Autowired
    TransactionsDetailsServeice transactionsDetailsServeice;

    private ModelMapper modelMapper;


    RestTemplate restTemplate = new RestTemplate();



    @PostMapping("/public_token/create")
    public PublicTokenDto getPublicToken(@RequestBody PublicTokenModel publicTokenModel){
        final  String endPoint = "/sandbox/public_token/create";
        String url = baseUrl + endPoint;
//        publicTokenModel.setClient_id(clientId);
//        publicTokenModel.setSecret(secretId);
//        publicTokenModel.setInstitution_id(institutionId);
//        publicTokenModel.setInitial_products(initialProducts);

        PublicTokenDto dto =  restTemplate.postForObject(
                url,
                publicTokenModel,PublicTokenDto.class);

          return dto;
    }

    @PostMapping("/item/public_token/exchange")
    public AccessTokenResponseDto getAccessToken(@RequestBody AccessTokenRequestModel accessTokenRequestModel){
        final  String endPoint = "/item/public_token/exchange";
        String url = baseUrl + endPoint;
        AccessTokenResponseDto accessTokenResponseDto = restTemplate.postForObject(url,accessTokenRequestModel,AccessTokenResponseDto.class);
        return accessTokenResponseDto;
    }

    @PostMapping("/auth/get")
    @Transactional
    public AccountsDetailsDto getAccountDetails(@RequestBody AccountsRequestModel accountsRequestModel){
        final  String endPoint = "/auth/get";
        String url = baseUrl + endPoint;
        AccountsDetailsDto accountsDetailsDto = restTemplate.postForObject(url, accountsRequestModel,AccountsDetailsDto.class);
        AccountModel accountModel = new AccountModel();
        List<AccountModel>allAccountModel=new ArrayList<>();

        List<AccountResponseDto>totalAccounts = accountsDetailsDto.getAccounts();
        for(AccountResponseDto i :totalAccounts){
            accountModel=  accountDetailsService.convertDtoToEntity(i);
        }
        return  accountsDetailsDto;
    }
    @PostMapping("/transactions/get")
    public  TransactionsDetailsDto getTransectionsDetails(@RequestBody TransactionsRequestModel transactionsRequestModel){
        final  String endPoint = "/transactions/get";
        String url = baseUrl + endPoint;
        TransactionsDetailsDto transactionsDetailsDto  = restTemplate.postForObject(url, transactionsRequestModel, TransactionsDetailsDto.class);
        TransactionsDetailsModel transactionsDetailsModel = new TransactionsDetailsModel();
        List<TransactionsDto>totalTransactions = transactionsDetailsDto.getTransactions();
        for(TransactionsDto i  :totalTransactions){
//            System.out.println(i.getBalances().getAvailable());
//            accountModel = this.modelMapper.map(i, AccountModel.class);
            transactionsDetailsModel=  transactionsDetailsServeice.convertDtoToEntity(i);
            transactionsDetailsDao.save(transactionsDetailsModel);
        }
        return  transactionsDetailsDto;
    }

    @PostMapping("/get")
    public List<TransactionsDetailsModel> getTransactionById(@RequestBody AccountTransactionsRequestModel accountTransactionsRequestModel){
        String accountId = accountTransactionsRequestModel.getAccount_id();
        List<TransactionsDetailsModel>allTransaction= new ArrayList<>();
        allTransaction = transactionsDetailsDao.getTransactionsById(accountId);
        return  allTransaction;
    }

}
