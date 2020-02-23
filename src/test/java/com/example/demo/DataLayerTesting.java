package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.ConfigFileApplicationContextInitializer;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.model.SayHello;
import com.example.repositories.SayHelloRepository;

@RunWith(SpringRunner.class)
@ActiveProfiles("testing")
@DataJpaTest
class DataLayerTesting {

	@Autowired
	private TestEntityManager testEntityManager;
	
	@Autowired
	private SayHelloRepository shr;  
	
	@Test
	  void onlyCustomerRepositoryIsLoaded() {
	    assertThat(shr).isNotNull();
	    assertThat(testEntityManager).isNotNull();
	}	
	
	@Test
	public void test1() {
		SayHello sh = new SayHello();
		sh.setText("abc");
		sh.setKio("kio");
		testEntityManager.persist(sh);
		sh = new SayHello();
		sh.setText("abc5");
		sh.setKio("kio");
		testEntityManager.persist(sh);
		List<SayHello> shl = shr.findAll();
		assertThat(shl).hasSize(2);
	}
}
