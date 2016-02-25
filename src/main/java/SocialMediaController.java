
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SocialMediaController {
	
	private StatsService accountStatsService;
	private StatsService typeStatsService;
	
	//constructor injection
	public SocialMediaController(StatsService statsServiceOne, StatsService statsServiceTwo){
		this.accountStatsService = statsServiceOne;
		this.typeStatsService = statsServiceTwo;
	}
	
	@ResponseBody
	@RequestMapping(value = "/austinsocialmedia")
	public String getStats(@RequestParam(value = "accountstats", required = false) String account,
						   @RequestParam(value = "typestats", required = false) String type){
		
		if(account != null){
			return accountStatsService.createOutput(account);
			
		}else if(type != null){
			return typeStatsService.createOutput(type);
			
		}
		
		return "";
	}
}