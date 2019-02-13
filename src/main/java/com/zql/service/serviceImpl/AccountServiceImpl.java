package com.zql.service.serviceImpl;

import com.zql.crawler.WeChatPublicCrawler;
import com.zql.dataobject.WechatAccount;
import com.zql.dto.ResultDto;
import com.zql.repository.WechatAccountRepository;
import com.zql.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 26725 on 2019/2/13.
 */
@Service
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
        if (list.isEmpty()){
            WechatAccount wechatAccount = new WechatAccount();
            wechatAccount.setAccountNickname(resultDto.getNickname());
            wechatAccount.setAccountNumber(resultDto.getAccount());
            wechatAccount.setAccountDesc(resultDto.getAccountDesc());
            accountRepository.save(wechatAccount);
        }
        return resultDto;
    }
}
