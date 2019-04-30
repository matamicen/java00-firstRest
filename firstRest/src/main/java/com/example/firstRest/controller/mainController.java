package com.example.firstRest.controller;

import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.firstRest.model.Saludo;


@RestController
@RequestMapping({"/consultas"})
public class mainController {
	
//@GetMapping(path = {"/primera"})	
@GetMapping	
public ResponseEntity<Object> saludar() {
	
	 JSONObject obj = new JSONObject();
	 

     obj.put("error", 0);
     obj.put("saludo", "Hola che!!!!!!!!!");
     
     

return ResponseEntity.ok().body(obj.toString());
		
	//	return "Hola che!!!!!!!!!";
	
	}


@GetMapping(path = {"/segunda"})
public String saludarMejor() {
	
	return "Esta es la segunda consulta";

}

//@GetMapping(path = {"/{nom}/{ape}"})
//public String saludarConNombre(@PathVariable String nom, @PathVariable String ape) {
@GetMapping(path = {"/{nom}"})
public String saludarConNombre(@PathVariable String nom) {

	
	return "Hola querido:"+nom;

}

//@PostMapping(path = {"/guardosaludo"})
@PostMapping
public ResponseEntity<Object> guardarSaludo(@RequestBody Saludo saludo,
		@RequestHeader(name = "Authorization", required = true) String headerAuth,
		@RequestHeader(name = "Otro", required = true) String headerOtro){
//public ResponseEntity<Object> guardarSaludo(@RequestBody Saludo saludo){
		
	
	System.out.println("paso por POST:");
	System.out.println("su HeaderAuth es:"+ headerAuth);
	System.out.println("su HeaderOtro es:"+ headerOtro);
	

	System.out.println(saludo.getRemitente() + " " + saludo.getDestinatario() + " "+ saludo.getMensaje());
	
	if (saludo.getDestinatario().equals("jose"))
	{
		JSONObject obj = new JSONObject();
		 
		   
		obj.put("error", 0);
		obj.put("mensaje", "Su mensaje ha sido guardado");
		
		
	   return ResponseEntity.ok().body(obj.toString());
	}
	else
				
		 {
			JSONObject obj = new JSONObject();
			 
		   
			obj.put("error", 1);
			obj.put("mensaje", "Solo guardamos mensajes para jose");
			
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(obj.toString());
			//return heroedao.save(contact);
		    
		}


    }


}
