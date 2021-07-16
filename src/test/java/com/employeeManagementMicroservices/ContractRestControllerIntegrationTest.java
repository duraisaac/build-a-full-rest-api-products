package com.employeeManagementMicroservices;

import java.util.Date;

import org.junit.Test;
import org.junit.After;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import com.employeeManagementMicroservices.*;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

// for the mock requests
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

// test matchers
import static org.hamcrest.CoreMatchers.is;


import contract.ContractApplication;
import contract.Contract;

@RunWith(SpringRunner.class)
@SpringBootTest(
		webEnvironment = WebEnvironment.RANDOM_PORT,

  classes = ContractApplication.class)
@AutoConfigureMockMvc
@TestPropertySource(
  locations = "classpath:application.properties")
@EnableAutoConfiguration(exclude=SecurityAutoConfiguration.class)
// @TestPropertySource(locations = "classpath:application-integrationtest.properties")
@AutoConfigureTestDatabase
public class ContractRestControllerIntegrationTest {

	@Autowired
    private MockMvc mvc;

    @Autowired
    private contract.ContractRepository repository;

    @After
    public void resetDb() {
        repository.deleteAll();
    }

    @Test
    public void givenContracts_whenGetContracts_thenStatus200()
      throws Exception {

        // Seed data --> to have something in the databse wehn we test
        createTestContract("c", 20, new Date());
        createTestContract("b", 24, new Date());

        mvc.perform(get("/api/contracts")
          .contentType(MediaType.APPLICATION_JSON))
          .andExpect(status().isOk())
          .andExpect(content()
          .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
          .andExpect(jsonPath("$[0].name", is("bob")));
    }
	
    private void createTestContract(String employeeClasification, int holydayDays, Date employmentPeriod) {
		// TODO Auto-generated method stub
		
    	Contract contract=new Contract(employeeClasification,holydayDays,employmentPeriod);
    	repository.saveAndFlush(contract);
    	
	}


	
}
