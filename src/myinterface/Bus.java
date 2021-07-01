package myinterface;

class Bus implements Vehicle{
	int speed;
	int people;
	static int capacity;
	Bus() {
		capacity = 13;
	}
	@Override
	public int acceleration() {
		speed++;
		return speed;
	}

	@Override
	public int deceleration() {
		speed--;
		return speed;
	}

	@Override
	public boolean ride() {
		if(capacity <= people) 
		{			
			return true;
		}
		else
		{
			people++;
			return false;
		}
	}
	
}