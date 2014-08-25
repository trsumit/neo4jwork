package neo4j;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.kmc.ne04j.domain.Employee;
import org.kmc.ne04j.domain.Organization;
import org.kmc.ne04j.repository.EmpoloyeeRepository;
import org.kmc.ne04j.repository.OrganizationRepository;
import org.kmc.ne04j.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration (locations= {"Neo4jRepoTest-context.xml"})



public class OrganizationRepoTest {

	
	   final static Logger logger = LoggerFactory.getLogger(OrganizationRepoTest.class);
	private static final int USER_COUNT = 1;

	@Autowired
	OrganizationRepository organizationRepository;

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	EmpoloyeeRepository empoloyeeRepository;

	
	private long rootId;
	

	@Before
	public void setUp() {
		Organization organization = new Organization("base");
		organizationRepository.save(organization);
		rootId = organization.getId();
		
		
		logger.info("Root id: " + rootId);

	}

	@Test
	public void shouldFindAll() {
		// when
		long n = organizationRepository.count();
		// then
		
		logger.info("count user "  + n);
	}

	@Test
	public void shouldFindRootUserById() {
		// when
		Organization root = organizationRepository.findOne(rootId);

		// then
		assertNotNull("Root user not found", root);
	}

	@Test
	public void shouldFindRootUserByLogin() {
		// when
		List<Organization> root = organizationRepository.findByName("base");

		System.out.println( root.size());
		
		
		Organization organization = root.get(0);
		
		Employee employee = new Employee("testLogin1", "testName1");
				
		organization.addEmployee(employee);
		
		

		// then
		assertNotNull("Root user not found", root);
	}

//	@Test
//	public void shouldFindFriendsOfRoot() {
//		// when
//		List<Organization> users = repo.findFriendsOfRoot();
//
//		// then
//		assertNotNull("result is <null>", users);
//		assertEquals("mismatch @ friend count", USER_COUNT, users.size());
//	}

	@After
	public void tearDown() {
		organizationRepository.deleteAll();
		userRepository.deleteAll();
		empoloyeeRepository.deleteAll();
	}

	private static void out(Object o) {
		//System.out.println(o);
	}

}
