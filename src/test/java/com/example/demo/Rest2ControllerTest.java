package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.assertj.core.util.Arrays;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.example.controllers.Rest2Controller;
import com.example.model.SayHello;
import com.example.repositories.SayHelloRepository;
import com.example.services.SayHelloService;

@WebMvcTest(SayHelloService.class)
public class Rest2ControllerTest {
	
	@Autowired
	Rest2Controller r2c;
	@Autowired
	SayHelloService shs;
	
	@Autowired
    private MockMvc mvc;
	
	@MockBean
	SayHelloRepository shr;
	
	@Before
	public void setup(){
	    MockitoAnnotations.initMocks(this); //without this you will get NPE
	}

	
	@Before
	public void testgetSetup() throws Exception {
		this.shr = Mockito.mock(SayHelloRepository.class, Mockito.RETURNS_DEEP_STUBS);
		this.shs = Mockito.mock(SayHelloService.class, Mockito.RETURNS_DEEP_STUBS);
		this.r2c = Mockito.mock(Rest2Controller.class, Mockito.RETURNS_DEEP_STUBS);
		SayHello sh = new SayHello("dfds","sdfsd");
		ArrayList<SayHello> al = new ArrayList<>();
		al.add(sh);
		Map<String, String> mp = new HashMap<>();
		mp.put("text","dfds");
		mp.put("kio","sdfsd");
		Mockito.when(shr.findAll()).thenReturn(al);
		Mockito.when(shs.getAll()).thenReturn(al);
		Mockito.when(r2c.getThings()).thenReturn(al);
		Mockito.when(shr.save(sh)).thenReturn(sh);
		Mockito.when(shs.saveObj(sh)).thenReturn(sh);
		Mockito.when(r2c.insert(mp)).thenReturn(sh);
	}
	
	@Test
	public void insertTest() {
		assertThat(this.r2c.getThings().get(0).getText()).isEqualTo("dfds");
	}

	@Test
	public void inserttwoTest() {
		Map<String, String> mp = new HashMap<>();
		mp.put("text","dfds");
		mp.put("kio","sdfsd");
		SayHello sh = new SayHello("dfds","sdfsd");
		assertThat(this.r2c.insert(mp).getText()).isEqualTo("dfds");
	}
	
}
