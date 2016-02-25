import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;


public class TestTypeStatsServiceImpl {
	
	StatsService typeStatsService;

	@Before
	public void setUp(){
		typeStatsService = new TypeStatsServiceImpl();
	}
	
	@Test
	public void TestTypeCreateOutput(){
		String reply = typeStatsService.createOutput("FACEBOOK_PAGE");
		assertEquals("{\"type\" : \"FACEBOOK_PAGE\",\"num_of_accounts\":\"106\"}", reply);
	}
}
