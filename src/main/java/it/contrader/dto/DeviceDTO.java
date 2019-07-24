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
	
	private int idclient;

	private String mac;
	
	private String devtype;
	
	private String position;

	
	public DeviceDTO() {
		
	}

	public DeviceDTO (int idclient, String mac, String devtype, String position) {
		this.idclient = idclient;
		this.mac = mac;
		this.devtype = devtype;
		this.position = position;
	}

	public DeviceDTO (int iddevice, int idclient, String mac, String devtype, String position) {
		this.iddevice = iddevice;
		this.idclient = idclient;
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
	
	public int getIdclient() {
		return idclient;
	}

	public void setIdclient(int idclient) {
		this.idclient = idclient;
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
		return  iddevice + "\t" + idclient + "\t\t" + mac +"\t\t" + devtype + "\t\t" + position;
	}
}
