package control;

import java.util.Set;
import java.util.TreeMap;

import javax.swing.JComboBox;
import javax.swing.JLabel;

import modelo.Articulo;

public class AccionesArticulo {

	public boolean crearArticulo(String nombre, int precio, int id) {
		Articulo newArticulo = new Articulo(id, nombre, precio);
		Articulo item = (Articulo) new AlmacenArticulo<>().leer(nombre);
		if (newArticulo.getNombre() == item.getNombre()) {
			return false;
		} else {
			new AlmacenArticulo<>().grabar(newArticulo, id, nombre);
			return true;
		}
	}

	public void consultar(String nombre, JLabel nombreArt, JLabel id, JLabel precio) {
		Articulo item = (Articulo) new AlmacenArticulo<>().leer(nombre);
		nombreArt.setText(item.getNombre());
		id.setText(String.valueOf(id));
		precio.setText(String.valueOf(precio));
	}

	public void editar(String nombre, int nuevoPrecio) {
		Articulo item = (Articulo) new AlmacenArticulo<>().leer(nombre);
		item.setPrecio(nuevoPrecio);
		new AlmacenArticulo<>().grabar(item, item.getId(), item.getNombre());
	}

	/**
	 * 
	 * @param articulo
	 * 
	 * @return precio
	 */
	public String consultarPrecioAnterior(String articulo) {
		String precio = "";// Precio que estamos buscando
		return precio;
