package com.douzon.smartlogistics.domain.account.dao.mapper;

import com.douzon.smartlogistics.domain.account.dto.AccountInsertDto;
import com.douzon.smartlogistics.domain.account.dto.AccountModifyDto;
import com.douzon.smartlogistics.domain.entity.Account;
import com.douzon.smartlogistics.domain.item.dto.ItemInsertDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Mapper
public interface AccountMapper {
    List<Account> searchAccountList(
            @Param("accountCode") Integer accountCode,
            @Param("accountName") String accountName,
            @Param("createDate") String createDate,
            @Param("createId") String createId);

    void insert(AccountInsertDto accountInsertDto);

    void modify(@Param("accountNo") Integer accountNo,
                @Param("accountModifyDto") AccountModifyDto accountModifyDto);

    void delete(Long retrieveItemCode);

    Optional<Account> retrieve(Integer accountNo);

    Object checkAccountCode(String accountCode);
}
