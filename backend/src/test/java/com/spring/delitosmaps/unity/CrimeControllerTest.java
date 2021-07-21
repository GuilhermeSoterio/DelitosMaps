package com.spring.delitosmaps.unity;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoSettings;
import org.springframework.boot.test.context.SpringBootTest;

import com.spring.delitosmaps.controllers.CrimeController;
import com.spring.delitosmaps.service.CrimeService;

@ExtendWith(SpringExtension.class)
public class CrimeControllerTest {
	@InjectMocks
	private CrimeController crimeController;
	@Mock
	private CrimeService crimeServiceMock;
	
	@Test
	void test() {
		
	}

}
