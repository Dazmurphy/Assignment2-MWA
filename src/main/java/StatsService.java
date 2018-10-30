public interface StatsService {

	public void retrieveData();

	public void deserializeJson(String json);

	public int calculateStats(String name);

	public String createOutput(String name);
}
