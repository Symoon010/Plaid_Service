package com.example.plaid_service.service;

import com.example.plaid_service.dto.AccountResponseDto;
import com.example.plaid_service.model.entity.AccountModel;
import com.example.plaid_service.model.entity.Balance;
import com.example.plaid_service.repository.AccountDetailsDao;
import com.example.plaid_service.repository.BalanceDao;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
//@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class AccountDetailsService {

    @Autowired
    AccountDetailsDao accountDetailsDao;
    @Autowired
    BalanceDao balanceDao;
    @Autowired
    private ModelMapper modelMapper;
    public  AccountModel convertDtoToEntity(AccountResponseDto accountResponseDto){

        //accountMapper.mapToEntity(accountResponseDto);


        Balance balance = Balance.builder()
                .available(accountResponseDto.getBalances().getAvailable())
                .current(accountResponseDto.getBalances().getCurrent())
                .unofficial_currency_code(accountResponseDto.getBalances().getUnofficial_currency_code())
                .limit(accountResponseDto.getBalances().getLimit())
                .iso_currency_code(accountResponseDto.getBalances().getIso_currency_code())
                .build();
        balanceDao.save(balance);
        AccountModel accountModel = accountModel = AccountModel.builder()
                .account_id(accountResponseDto.getAccount_id())
                .mask(accountResponseDto.getMask())
                .type(accountResponseDto.getType())
                .subtype(accountResponseDto.getSubtype())
                .name(accountResponseDto.getName())
                .official_name(accountResponseDto.getOfficial_name())

                .build();
        accountDetailsDao.save(accountModel);
       // accountDetailsDao.save(accountModel);
       return accountModel;
    }

    //        accountModel = modelMapper.map(accountResponseDto, AccountModel.class);
//    public AccountModel  convert(AccountResponseDto accountResponseDto){
//        AccountModel accountModel = new AccountModel();
//
//        AccountBalanceModel accountBalanceModel = new AccountBalanceModel();
//
//        accountBalanceModel.setAvailable(accountResponseDto.getBalances().getAvailable());
//        accountBalanceModel.setCurrent(accountResponseDto.getBalances().getCurrent());
//        accountBalanceModel.setIso_currency_code(accountResponseDto.getBalances().getIso_currency_code());
//        accountBalanceModel.setLimit(accountResponseDto.getBalances().getLimit());
//        accountBalanceModel.setUnofficial_currency_code(accountResponseDto.getBalances().getUnofficial_currency_code());
//
//
//        accountModel.setAccount_id(accountResponseDto.getAccount_id());
//       // accountModel.setBalances(accountBalanceModel);
//
//       // accountModel.setBalances(accountBalanceModel);
//
//        accountModel.setMask(accountResponseDto.getMask());
//        accountModel.setName(accountResponseDto.getName());
//        accountModel.setOfficial_name(accountResponseDto.getOfficial_name());
//        accountModel.setSubtype(accountResponseDto.getSubtype());
//        accountModel.setType(accountResponseDto.getType());
//        System.out.println("dukse :"+ accountModel.getAccount_id());
//        return  accountModel;
//    }

}
