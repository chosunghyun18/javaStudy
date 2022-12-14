package com.gdschufs.simplejpa.repository;

import com.gdschufs.simplejpa.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberRepository {
    @Autowired
    private final EntityManager em;

    public void post(String m_name,String m_email,String m_password)
    {
        Member member = new Member();
        member.setM_name(m_name);
        member.setM_password(m_password);
        member.setM_email(m_email);
        em.persist(member);
    }

    public void delete(Long id)
    {
        Member member = em.find(Member.class , id);
        em.remove(member);
    }

    /**
     * @id   //  pk of Membertable
     * @return  // instance of Member
     **/
    public Member findOne(Long id)
    {
        return em.find(Member.class,id);
    }

    public List<Member> findALL()
    {
        return em.createQuery("select m from Member m",Member.class).getResultList();
    }

}
