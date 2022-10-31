package udemycode.dao;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import udemycode.domain.Employee;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;
@Repository
@RequiredArgsConstructor
public class EmployeeDAOJpaImpl implements EmployeeDAO{
    @Autowired
    private final EntityManager em;

    //    private EntityManager em;  DI 의 3가지 종류중 생성자 를 이용한 Dependency Injection
//
//    @Autowired
//    public EmployeeDAOJpaImpl(EntityManager theem){
//        em=theem;
//    }

    @Override
    public List<Employee> findAll() {
        Query theQuery = em.createQuery("select e from Employee e");
        List<Employee> employees =theQuery.getResultList();
        return employees;
    }

    @Override
    public Employee findById(int theId) {
        return null;
    }

    @Override
    public void save(Employee theEmployee) {

    }

    @Override
    public void deleteById(int theId) {

    }
}
