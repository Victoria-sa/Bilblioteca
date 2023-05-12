package com.cursoceat.controller;

import java.io.File;


import com.cursoceat.xml.schema.Biblioteca;
import com.cursoceat.xml.schema.Biblioteca.Libro;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import jakarta.xml.bind.Marshaller;
public class Controller {

	public static void main(String[] args) throws JAXBException{
		// TODO Auto-generated method stub
		leerXML();
		escribirXML();
	}
	public static void escribirXML() throws JAXBException{
		Biblioteca biblioteca=new Biblioteca();
		Libro libro=new Libro();
		
		libro.setId(1);
		libro.setTitulo("Don Quijote de la Mancha");
		libro.setAutor("Miguel de Cervantes");
		libro.setGenero("Novela, Parodia");
		libro.setPaginas(1305);
		libro.setPublicacion("16/01/1605");
		biblioteca.getLibro();
		biblioteca.libro.add(libro);
		Libro libro2=new Libro();
		libro2.setId(2);
		libro2.setTitulo("Episodios Nacionales");
		libro2.setAutor("Miguel Delibes");
		libro2.setGenero("Novela, Historica");
		libro2.setPaginas(1305);
		libro2.setPublicacion("16/01/1955");
		biblioteca.getLibro();
		biblioteca.libro.add(libro2);
		Libro libro3=new Libro();
		libro3.setId(3);
		libro3.setTitulo("Tuareg");
		libro3.setAutor("Alberto Vazquez Figueroa");
		libro3.setGenero("Novela, Historica");
		libro3.setPaginas(1105);
		libro3.setPublicacion("16/01/1985");
		biblioteca.getLibro();
		biblioteca.libro.add(libro3);
		Libro libro4=new Libro();
		libro4.setId(4);
		libro4.setTitulo("Perro");
		libro4.setAutor("Alberto Vazquez Figueroa");
		libro4.setGenero("Novela, Historica");
		libro4.setPaginas(1105);
		libro4.setPublicacion("16/01/1985");
		biblioteca.getLibro();
		biblioteca.libro.add(libro4);
		
		
		/**debemos crear el contexto para agrupar el xml*/
		JAXBContext jaxbContext=JAXBContext.newInstance(Biblioteca.class);
		Marshaller jaxbMarshaller=jaxbContext.createMarshaller();
		jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
    	jaxbMarshaller.marshal(biblioteca, System.out);
		
		jaxbMarshaller.marshal(biblioteca, new File("C:\\Users\\PROGRAMACION\\Documents\\HTML\\biblioteca2.xml"));
		
		
	}
	public static void leerXML()throws JAXBException{
		File archivo=new File("C:\\Users\\PROGRAMACION\\Documents\\HTML\\biblioteca.xml");
		
	
		//creqamos el contexto
		JAXBContext jaxbContext=JAXBContext.newInstance(Biblioteca.class);
		//creamos el objeto para desagrupar
		Unmarshaller jaxUnmarshaller=jaxbContext.createUnmarshaller();
		//leer el arachivo utilizando el unmarchaller
		Biblioteca miBiblioteca=(Biblioteca)jaxUnmarshaller.unmarshal(archivo);
		/*creamos un foreach para recorre la coleccion y mostrar los objetos creadis a partir del fichero crreado
		 * 
		 */
		for(Libro libro:miBiblioteca.libro) {
		System.out.println(libro.getId());
		System.out.println(libro.getTitulo());
		System.out.println(libro.getAutor());
		System.out.println(libro.getGenero());
		System.out.println(libro.getPaginas());
			
		}
	}

}
