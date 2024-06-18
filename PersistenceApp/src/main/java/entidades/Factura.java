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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "factura")
public class Factura implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "fecha")
	private String fecha;
	
	@Column(name = "numero")
	private int numero;
	
	@Column(name = "total")
	private int total;
	
	
	//@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	//private List<DetalleFactura> detalle = new ArrayList<DetalleFactura>();
	

	@OneToMany(mappedBy = "factura",cascade = CascadeType.ALL, orphanRemoval = true)
	private List<DetalleFactura> detalle = new ArrayList<DetalleFactura>();
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "fk_cliente")
	private Cliente cliente;
	
	public Factura() {
	}
	
	public Factura(String fecha, int numero, int total) {
		super();
		this.fecha = fecha;
		this.numero = numero;
		this.total = total;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public List<DetalleFactura> getDetalle() {
		return detalle;
	}

	public void setDetalle(List<DetalleFactura> detalle) {
		this.detalle = detalle;
	}
	
	
	
}