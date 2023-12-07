package com.example.maintenancerequest;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RequestRepository extends JpaRepository<Request,Integer> {
    List<Request> findAllByApartmentnumberEquals(Integer apartmentNumber);

    List<Request> findAllByAreaEquals(String area);

    List<Request> findAllByFulldatetimeContaining(String date);

    List<Request> findAllByCompletedEquals(boolean completed);

    List<Request> findAllByOrderByFulldatetimeDesc();
}
