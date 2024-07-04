package com.semina.springDataJpa.repository;

import com.semina.springDataJpa.dto.MemberDto;
import com.semina.springDataJpa.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Long> {

//    조회 : find...By ,read...By ,query...By get...By
//    COUNT : count...By 반환타입 long
//    EXISTS : exists...By 반환타입 boolean
//    삭제 : delete...By, remove...By 반환타입 long
//    DISTINCT : findDistinct, findMemberDistinctBy
//    LIMIT : findFirst3, findFirst, findTop, findTop3
    List<Member> findByUsernameAndAgeGreaterThan(String username, int age);

    List<Member> findTop3HelloBy();

    //    @Query(name = "Member.findByUsername")
    List<Member> findByUsername(@Param("username") String username);

    @Query("select m from Member m where m.username = :username and m.age = :age") //이름이 없는 namedQuery라고 생각하면 된다(자주 쓰임)
    List<Member> findUser(@Param("username") String username, @Param("age") int age);

    @Query("select m.username from Member m")
    List<String> findUsernameList();

    @Query("select new com.semina.springDataJpa.dto.MemberTeamDto(m.id, m.username, t.name) from Member m join m.team t")
    List<MemberDto> findMemberDto();
}
