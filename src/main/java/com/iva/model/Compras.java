package com.iva.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.apache.commons.lang3.StringUtils;

@Entity(name="ivacompr")
public class Compras{

    @Id
    private Integer id;
    
	/*REPLICO ELEMENTOS ORIGINALES DEL SISTEMA VIEJO, SIN CAMBIAR NOMBRES*/
	  private Integer feccom;
	  private Integer feciva;
	  private String tipcom;
	  private String letra;
	  private Integer nroloc;
	  private Integer nrocom;
	  private Integer codpro;
	  private String nompro;
	  private String dompro;
	  private String tipiva;
	  private String nrcuit;
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
	  private Float imptotal;
	  private Float impret;
	  private Float compni;
	  private String tipmov;
	  private Integer mesano;
	  private Float impv3;
	  private Float impv4;
	  private Float impv5;
	  private Float impv6;
	  private Float comono;
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
	  
	  
//	 Getter y Setters
	  
	public Integer getFeccom() {
		return feccom;
	}
	public void setFeccom(Integer feccom) {
		this.feccom = feccom;
	}
	public Integer getFeciva() {
		return feciva;
	}
	public void setFeciva(Integer feciva) {
		this.feciva = feciva;
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
	public Integer getCodpro() {
		return codpro;
	}
	public void setCodpro(Integer codpro) {
		this.codpro = codpro;
	}
	public String getNompro() {
		return nompro;
	}
	public void setNompro(String nompro) {
		this.nompro = nompro;
	}
	public String getDompro() {
		return dompro;
	}
	public void setDompro(String dompro) {
		this.dompro = dompro;
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
	public Float getImptotal() {
		return imptotal;
	}
	public void setImptotal(Float imptotal) {
		this.imptotal = imptotal;
	}
	public Float getImpret() {
		return impret;
	}
	public void setImpret(Float impret) {
		this.impret = impret;
	}
	public Float getCompni() {
		return compni;
	}
	public void setCompni(Float compni) {
		this.compni = compni;
	}
	public String getTipmov() {
		return tipmov;
	}
	public void setTipmov(String tipmov) {
		this.tipmov = tipmov;
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
	public Float getComono() {
		return comono;
	}
	public void setComono(Float comono) {
		this.comono = comono;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	  
}
