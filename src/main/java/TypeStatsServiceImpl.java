
import java.util.Iterator;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class TypeStatsServiceImpl implements StatsService{

	private static List<Department> departmentList = null;	
	private String typeWithCorrectCase = "";
	
	public TypeStatsServiceImpl(){
		retrieveData();
	}
	
	@Override
	public void retrieveData() {
		//getting the data from the url
		URL url = null;
		
		try {
			url = new URL("https://www.cs.utexas.edu/~devdatta/ej42-f7za.json");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		
		try {
			URLConnection connection = url.openConnection();
			
			InputStream input = connection.getInputStream();
			
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			byte[] buf = new byte[8192];
			int len = 0;
			while ((len = input.read(buf)) != -1) {
			    baos.write(buf, 0, len);
			}
			String body = new String(baos.toByteArray(), "UTF-8");
			deserializeJson(body);
		}catch (IOException e){
			e.printStackTrace();
		}
	}

	@Override
	public int calculateStats(String type) {
		
		int total = 0;
		typeWithCorrectCase = "";
		
		Iterator<Department> iter = departmentList.listIterator();
		
		while(iter.hasNext()){
			Department dept = iter.next();
			if(type.equalsIgnoreCase(dept.getType())){
				typeWithCorrectCase = dept.getType();//ensures type name is same case as social media
				total++;
			}
		}
		
		return total;
	}
	
	@Override
	public void deserializeJson(String json) {
		final Gson gson = new Gson();
		
		final Type deptListType = new TypeToken<List<Department>>(){}.getType();
	    departmentList = gson.fromJson(json, deptListType);
	}

	@Override
	public String createOutput(String name) {
		String output = "";
		int total = calculateStats(name);
		
		if(typeWithCorrectCase.equals("")){
			typeWithCorrectCase = name;
		}
		
		output = "{" + "\"type\" : " + "\"" + typeWithCorrectCase + "\"" + "," + "\"num_of_accounts\"" + ":" + "\"" + total + "\"" + "}";
		
		return output;
	}

}
