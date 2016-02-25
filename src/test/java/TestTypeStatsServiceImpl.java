import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;


public class TestTypeStatsServiceImpl {
	
	StatsService typeStatsService;

	@Before
	public void setUp(){
		typeStatsService = mock(TypeStatsServiceImpl.class);
	}
	
	@Test
	public void TestTypeCreateOutput(){
		when(typeStatsService.createOutput("FACEBOOK_PAGE")).thenReturn("{\"type\" : \"FACEBOOK_PAGE\",\"num_of_accounts\":\"106\"}");
		String reply = typeStatsService.createOutput("FACEBOOK_PAGE");
		assertEquals("{\"type\" : \"FACEBOOK_PAGE\",\"num_of_accounts\":\"106\"}", reply);
	}
}
