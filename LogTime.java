package Esame;

import java.time.Instant;
import java.util.ArrayList;

public class LogTime implements TimeStamp
{
	ArrayList<String>timestamp;
	
	public LogTime()
	{
		timestamp= new ArrayList<String>(0);
	}
	
	@Override
	public void getDelta()
	{
			for(int i=0;i<timestamp.size()-1;i++)
				System.err.println(timestamp.get(i)+"==>"+timestamp.get(i+1)+"="+(Double.parseDouble(timestamp.get(i+1))-Double.parseDouble(timestamp.get(i))));
	}

	@Override
	public void getDelta(int base) 
	{
		System.err.println("milliseconds unit="+base);
		for(int i=0;i<timestamp.size()-1;i++)
	    System.err.println((Double.parseDouble(timestamp.get(i))/base)+"==>"+(Double.parseDouble(timestamp.get(i))/base)+"="+((Double.parseDouble(timestamp.get(i+1))/base)-(Double.parseDouble(timestamp.get(i))/base)));
	}

	@Override
	public void getTime() {
		timestamp.add(""+Instant.now().toEpochMilli());
	}

	@Override
	public String showTime() {
		return Instant.now().toString();
	}

}
