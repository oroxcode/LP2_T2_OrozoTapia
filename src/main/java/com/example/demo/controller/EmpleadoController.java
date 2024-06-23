package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.AreaEntity;
import com.example.demo.entity.EmpleadoEntity;
import com.example.demo.repository.AreaRepository;
import com.example.demo.repository.EmpleadoRepository;

@Controller
public class EmpleadoController {
	@Autowired
	private EmpleadoRepository empleadoRepository;
	@Autowired
	private AreaRepository areaRepository;
	
	@GetMapping("/Listar")
	public String listarEmpleados(Model model) {
		List<EmpleadoEntity>listaEmpleados = empleadoRepository.findAll();
		model.addAttribute("listaEmpleados", listaEmpleados);
		return "home";	
	} 
	
	
	@GetMapping("/registrar_empleado")
	
	public String showRegistrarEmpleado(Model model) {
		 List<AreaEntity>listaAreas = areaRepository.findAll();
		 model.addAttribute("listaAreas", listaAreas);
		 model.addAttribute("empleado", new EmpleadoEntity());
		 return "registrar_empleado";
	}
	
	@PostMapping("/registrar_empleado")
	public String registrarEmpleado(Model model, @ModelAttribute EmpleadoEntity empleado ) {
		empleadoRepository.save(empleado);
		return "redirect:/Listar";
	}
	
	
	@GetMapping("/actualizarEmpleado/{id}")
    public String showActualizarEmpleado(Model model, @PathVariable("id") String id) {
        EmpleadoEntity empleadoEncontrado = empleadoRepository.findById(id).get();
        List<AreaEntity> listaAreas = areaRepository.findAll();
        model.addAttribute("listaAreas", listaAreas);
        model.addAttribute("emple", empleadoEncontrado);
        return "actualizarEmpleado";
    }

    @PostMapping("/actualizarEmpleado/{id}")
    public String actualizarEmpleado(Model model ,@ModelAttribute EmpleadoEntity empleado) {
        empleadoRepository.save(empleado);
        return "redirect:/listar";
    }
	
	
	@GetMapping("/detalleEmpleado/{dni}")
	public String verEmpleado(Model model , @PathVariable("dni")String dni) {
		List<AreaEntity> listaAreas = areaRepository.findAll();
		EmpleadoEntity empleadoEncontrado = empleadoRepository.findByDni(dni);
		 model.addAttribute("emple",empleadoEncontrado);
		return "detalleEmpleado";
	}
	
	//Eliminar
    @GetMapping("/eliminarEmpleado/{dni}")
    public String eliminarEmpleado(@PathVariable("dni") String dni) {
        empleadoRepository.deleteById(dni);
        return "redirect:/listar";
    }
}
