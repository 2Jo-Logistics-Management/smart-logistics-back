package com.douzon.smartlogistics.domain.member.dao;

import com.douzon.smartlogistics.domain.entity.Member;
import com.douzon.smartlogistics.domain.member.dao.mapper.MemberMapper;
import com.douzon.smartlogistics.domain.member.dto.LoginDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.NoSuchElementException;

@Slf4j
@Repository
@RequiredArgsConstructor
public class MemberDao {
    private final MemberMapper memberMapper;
    public Member memberLogin(LoginDto loginDto) {
        return memberMapper.memberLogin(loginDto);
    }

    public boolean saveIpAddress(HashMap<String, Object> paramsMap) {
        return memberMapper.saveIpAddress(paramsMap);
    }

    public List<Member> searchMemberList(Integer memberNo, String memberId, String createDate) {
        return memberMapper.searchMemberList(memberNo, memberId, createDate);
    }

    public Member searchMember(Long memberNo) {
        return memberMapper.searchMember(memberNo);
    }
    public void insert(Member member) {
        memberMapper.insert(member);
    }

    public void modify(Integer memberNo, Member member) {
        memberMapper.modify(memberNo, member);
    }

    public void delete(Integer memberNo) {
        Long retrieveMemberCode = retrieveMember(memberNo);

        memberMapper.delete(retrieveMemberCode);
    }

    private Long retrieveMember(Integer memberNo) {
        return memberMapper.retrieve(memberNo).orElseThrow(() -> {
            throw new NoSuchElementException("해당 멤버는 존재하지 않습니다.");
        }).getMemberNo();
    }

    public boolean checkId(String memberId) {
        return memberMapper.checkId(memberId) != null;
    }
}
