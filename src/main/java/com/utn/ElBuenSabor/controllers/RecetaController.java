package com.utn.ElBuenSabor.controllers;

import com.utn.ElBuenSabor.entities.Receta;
import com.utn.ElBuenSabor.services.RecetaServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/productos/receta")
public class RecetaController extends BaseControllerImpl<Receta, RecetaServiceImpl>{

}