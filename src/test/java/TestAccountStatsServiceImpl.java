import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class TestAccountStatsServiceImpl {
	
	StatsService accountStatsService;
	

	@Before
	public void setUp(){
		accountStatsService = new AccountStatsServiceImpl();
	}
	
	@Test
	public void TestAccountCreateOutput(){
		String reply = accountStatsService.createOutput("Austintexasgov");
		assertEquals("{\"account\" : \"Austintexasgov\",\"num_of_types\":\"9\"}", reply);
	}
}
