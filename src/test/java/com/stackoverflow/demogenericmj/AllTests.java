package com.stackoverflow.demogenericmj;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;

import com.stackoverflow.demogenericmj.model.Dep;
import com.stackoverflow.demogenericmj.model.Emp;
import com.stackoverflow.demogenericmj.repo.DepRepository;
import com.stackoverflow.demogenericmj.repo.EmpRepository;
import com.stackoverflow.demogenericmj.service.BaseServiceI;

@SpringBootTest
class AllTests {
	// all (configured) BaseServiceI beans:
	@Autowired
	ObjectProvider<BaseServiceI> serviceProvider;

	// repositories (for verification/mocking):
	@SpyBean
	EmpRepository empRepo;
	@SpyBean
	DepRepository depRepo;

	@Test
	void contextServices() {
		assertNotNull(serviceProvider);
		serviceProvider.forEach(b -> {
			b.runService();
			b.runService();
			b.runService();
		});
		// 3 from auto, 3 from manual ...
		verify(depRepo, times(6)).findAll();
		verify(empRepo, times(6)).findAll();
	}

	@Test
	void testProtoTypesEmp(@Autowired ObjectProvider<CallbackImpl<Emp>> empCallbackProvider) {
		CallbackImpl<Emp> curr = empCallbackProvider.getIfAvailable();
		for (int i = 1; i < 10; i++) {
			CallbackImpl<Emp> tmp = empCallbackProvider.getIfAvailable();
			assertNotEquals(curr, tmp);
			curr = tmp;
		}
	}

	@Test
	void testProtoTypesDep(@Autowired ObjectProvider<CallbackImpl<Dep>> depCallbackProvider) {
		CallbackImpl<Dep> curr = depCallbackProvider.getIfAvailable();
		for (int i = 1; i < 10; i++) {
			CallbackImpl<Dep> tmp = depCallbackProvider.getIfAvailable();
			assertNotEquals(curr, tmp);
			curr = tmp;
		}
	}
}
