package com.apicrud.mackenziepsii;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocadorRepository extends JpaRepository<Locador, Long> {
  
}
