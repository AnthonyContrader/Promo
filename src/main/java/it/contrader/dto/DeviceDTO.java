package it.contrader.dto;

/**
 * 
 * @author Vittorio
 *
 *Il DTO è simile al Model ma può contenere meno attributi (ad esempio d dati sensibili
 *che non devono arrivare alla View). GLi oggetti vengono trasformati da oggetti del Model
 *a oggetti del DTO tramite i Converter (chiamati dai Service). 
 *Per la descrizione della classe far riferimento al Model "User".
 */
public class DeviceDTO {
	
	private int iddevice;

	private String mac;
	
	private String devtype;
	
	private String position;

	
	public DeviceDTO() {
		
	}

	public DeviceDTO (String mac, String devtype, String position) {
		this.mac = mac;
		this.devtype = devtype;
		this.position = position;
	}

	public DeviceDTO (int iddevice, String mac, String devtype, String position) {
		this.iddevice = iddevice;
		this.mac = mac;
		this.devtype = devtype;
		this.position = position;
	}

	

	public int getIddevice() {
		return iddevice;
	}

	public void setIddevice(int iddevice) {
		this.iddevice = iddevice;
	}

	public String getMac() {
		return mac;
	}

	public void setMac(String mac) {
		this.mac = mac;
	}

	public String getDevtype() {
		return devtype;
	}

	public void setDevtype(String devtype) {
		this.devtype = devtype;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	@Override
	public String toString() {
		return  iddevice + "\t"  + mac +"\t\t" + devtype + "\t\t" + position;
	}
}
