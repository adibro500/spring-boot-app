package com.example.repositories;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.example.model.SayHello;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
@Repository
public interface SayHelloRepository extends JpaRepository<SayHello, String> {
	@Query(value = "SELECT * FROM sayhello WHERE kio = ?1", nativeQuery = true)
    List<SayHello> findByKio(String kio);
}
