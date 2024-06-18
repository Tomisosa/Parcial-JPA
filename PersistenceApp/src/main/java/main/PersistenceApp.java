package main;

import javax.persistence.EntityManager;
import javax.persistence. EntityManagerFactory;
import javax.persistence.Persistence;

import entidades.Articulo;
import entidades.Categoria;
import entidades.Cliente;
import entidades.DetalleFactura;
import entidades.Domicilio;
import entidades.Factura;


public class PersistenceApp {
	public static void main(String[] args) {
		/*
		Nombre: Parcial Practica Profesionalizante II
		Profesor: Naveda, Claudia
		Alumno: Sosa, Tomás
		Carrera: Desarrollo de Software 2°4°
		*/
		EntityManagerFactory emf= Persistence.createEntityManagerFactory("PersistenceAppPU");
		EntityManager em = emf.createEntityManager();	

		try{
			em.getTransaction().begin();

			//Cliente cliente = new Cliente("Tomás","Sosa",41863099);
			//Domicilio domicilio = new Domicilio("San Jose",2219);
			//cliente.setDomicilio(domicilio);
			//domicilio.setCliente(cliente);

			//Domicilio dom = em.find(Domicilio.class, 1L);
			//Cliente clien = em.find(Cliente.class, 1L);

			//System.out.println("Valor prueba");
			//System.out.println("Cliente del domicilio: "+dom.getCliente().getDni());
			//System.out.println("Domicilio del cliente: "+clien.getDomicilio().getNombreCalle());

			Factura factura1 = new Factura();

			factura1.setNumero(12);
			factura1.setFecha("10/08/2020");

			Domicilio dom = new Domicilio("San Martin", 1222);
			Cliente cliente = new Cliente("Pablo", "Muñoz",15245778);
			cliente.setDomicilio(dom);
			dom.setCliente(cliente);

			factura1.setCliente(cliente);

			Categoria perecederos = new Categoria("Perecederos");
			Categoria lacteos = new Categoria("Lacteos");
			Categoria limpieza = new Categoria("Limpieza");

			Articulo art1 = new Articulo("Yogurt Ser sabor frutilla", 200 ,20);			
			Articulo art2 = new Articulo("Detergente Magistral", 300 ,80);

			art1.getCategorias().add(perecederos);
			art1.getCategorias().add(lacteos);
			lacteos.getArticulos().add(art1);
			perecederos.getArticulos().add(art1);

			art2.getCategorias().add(limpieza);
			limpieza.getArticulos().add(art2);

			DetalleFactura detalle1 = new DetalleFactura();
			detalle1.setArticulo(art1);
			detalle1.setCantidad(2);
			detalle1.setSubtotal(40);

			art1.getDetallefacturas().add(detalle1);
			factura1.getDetalle().add(detalle1);
			detalle1.setFactura(factura1);

			DetalleFactura detalle2 = new DetalleFactura();
			detalle2.setArticulo(art2);
			detalle2.setCantidad(1);
			detalle2.setSubtotal(80);

			art2.getDetallefacturas().add(detalle2);
			factura1.getDetalle().add(detalle2);
			detalle2.setFactura(factura1);

			factura1.setTotal(120);

			em.persist(factura1);


			em.flush();
			em.getTransaction().commit();
		}catch (Exception e) {
			em.getTransaction().rollback();
		}

		em.close();
		emf.close();

		}
}
