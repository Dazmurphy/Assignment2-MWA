import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class TestSocialMediaController {

	SocialMediaController socialMediaController;
	StatsService mockAccountService = null;
	StatsService mockTypeService = null;
	
	@Before
	public void setUp(){
		mockAccountService = mock(AccountStatsServiceImpl.class);
		mockTypeService = mock(TypeStatsServiceImpl.class);
		socialMediaController = new SocialMediaController(mockAccountService, mockTypeService);
	}
	
	@Test
	public void TestGetStatsOne(){
		when(mockAccountService.createOutput("AE")).thenReturn("{\"account\" : \"AE\",\"num_of_types\":\"6\"}");
		String reply = socialMediaController.getStats("AE", null);
		assertEquals("{\"account\" : \"AE\",\"num_of_types\":\"6\"}", reply);
		verify(mockAccountService).createOutput("AE");
	}
	
	@Test
	public void TestGetStatsTwo(){
		when(mockTypeService.createOutput("INSTAGRAM")).thenReturn("{\"type\" : \"INSTAGRAM\",\"num_of_accounts\":\"9\"}");
		String reply = socialMediaController.getStats(null, "INSTAGRAM");
		assertEquals("{\"type\" : \"INSTAGRAM\",\"num_of_accounts\":\"9\"}", reply);
		verify(mockTypeService).createOutput("INSTAGRAM");
	}
	
	@Test
	public void TestGetStartsThree(){
		String reply = socialMediaController.getStats(null, null);
		assertEquals("", reply);
	}
}
