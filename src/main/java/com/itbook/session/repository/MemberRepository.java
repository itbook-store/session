package com.itbook.session.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.itbook.session.entity.Member;

public interface MemberRepository extends JpaRepository<Member, String> {
}
