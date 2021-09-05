package org.se.lab.data;

public class HistPair implements Comparable<HistPair> 
{
	private final Object key; 
	private int count;
	
	public HistPair(Object key)
	{
		this.key = key;
		this.count = 1;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public Object getKey() {
		return key;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((key == null) ? 0 : key.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HistPair other = (HistPair) obj;
		if (key == null) {
			if (other.key != null)
				return false;
		} else if (!key.equals(other.key))
			return false;
		return true;
	}

	@Override
	public int compareTo(HistPair o) {
if (this.getCount() > o.getCount())
	return -1;
if (this.getCount() < o.getCount())
	return 1;
return 0;
	}
	
	

}
