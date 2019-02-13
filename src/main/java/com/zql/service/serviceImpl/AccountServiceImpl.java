package com.zql.service.serviceImpl;

import com.zql.crawler.WeChatPublicCrawler;
import com.zql.dataobject.WechatAccount;
import com.zql.dto.ElementDto;
import com.zql.dto.ResultDto;
import com.zql.repository.WechatAccountRepository;
import com.zql.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;
import java.util.Optional;

/**
 * Created by 26725 on 2019/2/13.
 */
public class AccountServiceImpl implements AccountService {
    @Autowired
    private WeChatPublicCrawler crawler;
    @Autowired
    private WechatAccountRepository accountRepository;
    @Value("${public.account}")
    private String account;
    /**
     * 保存公众号信息
     * @return
     */
    @Override
    public ResultDto saveAccountInfo() {
        List<WechatAccount> list = accountRepository.findByAccountNumber(account);
        ResultDto resultDto = crawler.getFirst(account);
        if (!Optional.ofNullable(list).isPresent()){
            WechatAccount wechatAccount = new WechatAccount();
            wechatAccount.setAccountNickname(resultDto.getNickname());
            wechatAccount.setAccountNumber(resultDto.getAccount());
            wechatAccount.setAccountDesc(resultDto.getAccountDesc());
            accountRepository.save(wechatAccount);
        }
        return resultDto;
    }
}
