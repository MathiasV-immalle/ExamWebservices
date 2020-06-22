package edu.ap.newdate.Repository;

import java.util.Date;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import edu.ap.newdate.Model.*;

@Repository
public interface NewDateRepository extends CrudRepository<NewDate, Integer>{
    NewDate findByCheckDate(Date checkDate);
}