package sda.code;

public class CityQuery {

	private final String city;
	private final String countryCode;

	public CityQuery(String city, String countryCode) {
		this.city = city;
		this.countryCode = countryCode;
	}
	
	public CityQuery(String city) {
		this.city = city;
		this.countryCode = null;
	}
	
	@Override
	public String toString(){
		StringBuilder builder = new StringBuilder().append(city);
		
		if(countryCode!=null){
			builder.append(',').append(countryCode);
		}
		return builder.toString();
	}
}
