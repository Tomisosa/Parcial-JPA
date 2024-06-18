package entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name= "articulo")
public class Articulo implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "denominación")
	private String denominacion;

	@Column(name = "cantidad")
	private int cantidad;

	@Column(name = "precio")
	private double precio;

	@OneToMany(mappedBy = "articulo")
	private List<DetalleFactura> detallefacturas = new ArrayList<DetalleFactura>();

	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(name = "articulo_categoria", 
				joinColumns = @JoinColumn(name = "articulo_id"),
				inverseJoinColumns = @JoinColumn(name = "categoria_id"))
	private List<Categoria> categorias = new ArrayList<Categoria>();

	
	public Articulo() {

	}

	public Articulo( String denominacion, int cantidad, double precio) {
		this.denominacion = denominacion;
		this.cantidad = cantidad;
		this.precio = precio;
	}

	public Articulo(String denominacion, int cantidad, double precio, List<DetalleFactura> detallefacturas, List<Categoria> categorias) {
		this.denominacion = denominacion;
		this.cantidad = cantidad;
		this.precio = precio;
		this.detallefacturas = detallefacturas;
		this.categorias = categorias;
	}

	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public List<DetalleFactura> getDetallefacturas() {
		return detallefacturas;
	}

	public void setDetallefacturas(List<DetalleFactura> detallefacturas) {
		this.detallefacturas = detallefacturas;
	}

	public List<Categoria> getCategorias() {
		return categorias;
	}
	
	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}
	

	public String getDenominacion() {
		return denominacion;
	}
	public void setDenominacion(String denominacion) {
		this.denominacion = denominacion;
	}
	
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}



}