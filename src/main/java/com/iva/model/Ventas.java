package com.iva.model;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.apache.commons.lang3.StringUtils;

@Entity(name="ivvtasgu")
public class Ventas{

    @Id
    private Integer id;
	
	/*REPLICO ELEMENTOS ORIGINALES DEL SISTEMA VIEJO, SIN CAMBIAR NOMBRES*/
	  private Integer feccom;//Representa nro de didas desde la fecha  1800-12-28 ( Clarion :| ) , convertido en date.
	  private String tipcom;
	  private String letra;
	  private Integer nroloc;
	  private Integer nrocom;
	  private Integer codpcli;
	  private String razsoc;
	  private String domcom;
	  private String tipiva;
	  private String nrcuit;
	  private Integer codint;
	  private Float impgra;
	  private Float impgra1;
	  private Float impgra2;
	  private Float impexe;
	  private Float impper;
	  private Float impiv1;
	  private Float impiv2;
	  private Float impiv3;
	  private Float impiv4;
	  private Float impiv5;
	  private Float impiv6;
	  private Float impiin;
	  private Float imptot;
	  private String nrohas;
	  private Integer mesano; //Se usa para buscar, se llama mesano, pero la informacion esta guardada en la base como anomes :) 
	  private Float impv3;
	  private Float impv4;
	  private Float impv5;
	  private Float impv6;
	  private Date fecha;
	  
	  
	public Float getTotalImpGravados() {
		return impgra + impgra1 + impgra2;
	}
	  
	public Float getTotalImpIVA() {
		return impiv1 + impiv2 + impiv3 + impiv4 + impiv5 + impiv6;
	}
	
	public String getComprobante() {
		return tipcom + "." + letra + StringUtils.leftPad(nroloc.toString(), 4, "0") + " " + StringUtils.leftPad(nrocom.toString(), 8,"0");
	}
	
	
//--GETTERS Y SETTERS	
	public Integer getFeccom() {
		return feccom;
	}
	public void setFeccom(Integer feccom) {
		this.feccom = feccom;
	}
	public String getTipcom() {
		return tipcom;
	}
	public void setTipcom(String tipcom) {
		this.tipcom = tipcom;
	}
	public String getLetra() {
		return letra;
	}
	public void setLetra(String letra) {
		this.letra = letra;
	}
	public Integer getNroloc() {
		return nroloc;
	}
	public void setNroloc(Integer nroloc) {
		this.nroloc = nroloc;
	}
	public Integer getNrocom() {
		return nrocom;
	}
	public void setNrocom(Integer nrocom) {
		this.nrocom = nrocom;
	}
	public Integer getCodpcli() {
		return codpcli;
	}
	public void setCodpcli(Integer codpcli) {
		this.codpcli = codpcli;
	}
	public String getRazsoc() {
		return razsoc;
	}
	public void setRazsoc(String razsoc) {
		this.razsoc = razsoc;
	}
	public String getDomcom() {
		return domcom;
	}
	public void setDomcom(String domcom) {
		this.domcom = domcom;
	}
	public String getTipiva() {
		return tipiva;
	}
	public void setTipiva(String tipiva) {
		this.tipiva = tipiva;
	}
	public String getNrcuit() {
		return nrcuit;
	}
	public void setNrcuit(String nrcuit) {
		this.nrcuit = nrcuit;
	}
	public Integer getCodint() {
		return codint;
	}
	public void setCodint(Integer codint) {
		this.codint = codint;
	}
	public Float getImpgra() {
		return impgra;
	}
	public void setImpgra(Float impgra) {
		this.impgra = impgra;
	}
	public Float getImpgra1() {
		return impgra1;
	}
	public void setImpgra1(Float impgra1) {
		this.impgra1 = impgra1;
	}
	public Float getImpgra2() {
		return impgra2;
	}
	public void setImpgra2(Float impgra2) {
		this.impgra2 = impgra2;
	}
	public Float getImpexe() {
		return impexe;
	}
	public void setImpexe(Float impexe) {
		this.impexe = impexe;
	}
	public Float getImpper() {
		return impper;
	}
	public void setImpper(Float impper) {
		this.impper = impper;
	}
	public Float getImpiv1() {
		return impiv1;
	}
	public void setImpiv1(Float impiv1) {
		this.impiv1 = impiv1;
	}
	public Float getImpiv2() {
		return impiv2;
	}
	public void setImpiv2(Float impiv2) {
		this.impiv2 = impiv2;
	}
	public Float getImpiin() {
		return impiin;
	}
	public void setImpiin(Float impiin) {
		this.impiin = impiin;
	}
	public Float getImptot() {
		return imptot;
	}
	public void setImptot(Float imptotal) {
		this.imptot = imptotal;
	}
	public String getNrohas() {
		return nrohas;
	}
	public void setNrohas(String nrohas) {
		this.nrohas = nrohas;
	}
	public Integer getMesano() {
		return mesano;
	}
	public void setMesano(Integer mesano) {
		this.mesano = mesano;
	}
	public Float getImpv3() {
		return impv3;
	}
	public void setImpv3(Float impv3) {
		this.impv3 = impv3;
	}
	public Float getImpv4() {
		return impv4;
	}
	public void setImpv4(Float impv4) {
		this.impv4 = impv4;
	}
	public Float getImpv5() {
		return impv5;
	}
	public void setImpv5(Float impv5) {
		this.impv5 = impv5;
	}
	public Float getImpv6() {
		return impv6;
	}
	public void setImpv6(Float impv6) {
		this.impv6 = impv6;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Float getImpiv3() {
		return impiv3;
	}

	public void setImpiv3(Float impiv3) {
		this.impiv3 = impiv3;
	}

	public Float getImpiv4() {
		return impiv4;
	}

	public void setImpiv4(Float impiv4) {
		this.impiv4 = impiv4;
	}

	public Float getImpiv5() {
		return impiv5;
	}

	public void setImpiv5(Float impiv5) {
		this.impiv5 = impiv5;
	}

	public Float getImpiv6() {
		return impiv6;
	}

	public void setImpiv6(Float impiv6) {
		this.impiv6 = impiv6;
	}
	
	
//	private Float floatToDosDecimales(Float number) {
//		NumberFormat formatter = NumberFormat.getInstance(Locale.getDefault());
//		formatter.setMaximumFractionDigits(2);
//		formatter.setMinimumFractionDigits(2);
//		return new Float(formatter.format(number));
//	}
//	
}
