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


import java.util.List;
@Repository
public interface SayHelloRepository extends JpaRepository<SayHello, String> {

}
