class Time
{
	int minutes;
	int seconds;
	
        
	public Time(int milliSeconds)
	{
		minutes = (int)(milliSeconds/6000);
		int useForSeconds = milliSeconds % 6000;
		seconds = (int)(useForSeconds/100);
	}
	public boolean subtractASecond()
	{
		if(minutes >= 0 && seconds >= 0)
		{
			if(seconds == 0 && minutes != 0)
			{
				minutes--;
				seconds = 59;
			}
			else
			{
				seconds--;
			}
		}
                if(seconds >= 59 || seconds <= 1)
                    return true;
                else
                    return false;
	}
	public void reset(int milliSeconds)
	{
		minutes = (int)(milliSeconds/6000);
		int useForSeconds = milliSeconds % 6000;
		seconds = (int)(useForSeconds/100);
	}
        public void reset(int tSeconds, int tMinutes)
	{
                if(tSeconds >= 60)
                {
                    int minutesToAdd = tSeconds/60;
                    tSeconds = tSeconds%60;
                    tMinutes += minutesToAdd;
                }
		minutes = tMinutes;
                seconds = tSeconds;
        }

	
	public String toString()
	{
		String tempSeconds = "" + seconds;
		if(seconds < 10)
		{
			tempSeconds = 0 + "" + seconds;
		}
		if(seconds < 0)
		{
			tempSeconds = 0 + "" + 0;
		}
		
		return minutes + " : " + tempSeconds;
	}
        public int getMinutes()
        {
            return minutes;
        }
        public int getSeconds()
        {
            return seconds;
        }
}
