package it.contrader.model;
/**
 * Per dettagli vedi guida sez 4 Model
 */
public class Device {

	/**
	 * Qui sotto definisco gli attributi di Device. 
	 */
	private int iddevice;

	private String mac;
	
	private String devtype;
	
	private String position;

	/**
	 * Definisco i due costruttori, uno vuoto e uno con tre parametri per costrire oggetti di tipo Device
	 */
	public Device() {
		
	}

	public Device (String mac, String devtype, String position) {
		this.mac = mac;
		this.devtype = devtype;
		this.position = position;
	}

	public Device (int iddevice, String mac, String devtype, String position) {
		this.iddevice = iddevice;
		this.mac = mac;
		this.devtype = devtype;
		this.position = position;
	}

	/**
	 * Getter e Setter: servono alle altre classi a recuperare e modificare gli attributi di Device
	 */
	

	public int getIddevice() {
		return iddevice;
	}

	public void setIddevice(int iddev) {
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
		return  iddevice + "\t"  + mac +"\t\t" +  devtype  + "\t\t" + position;
	}

	//Metodo per il confronto degli oggetti
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Device other = (Device) obj;
		if (iddevice != other.iddevice)
			return false;
		if (mac == null) {
			if (other.mac != null)
				return false;
		} else if (!mac.equals(other.mac))
			return false;
		if (devtype == null) {
			if (other.devtype != null)
				return false;
		} else if (!devtype.equals(other.devtype))
			return false;
		if (position == null) {
			if (other.position != null)
				return false;
		} else if (!position.equals(other.position))
			return false;
		return true;
	}
}
