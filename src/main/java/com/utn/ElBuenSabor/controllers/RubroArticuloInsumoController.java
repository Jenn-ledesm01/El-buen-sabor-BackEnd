package com.utn.ElBuenSabor.controllers;

import com.utn.ElBuenSabor.entities.RubroArticuloInsumo;
import com.utn.ElBuenSabor.services.RubroArticuloInsumoServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/rubroArticuloInsumo")
public class RubroArticuloInsumoController extends BaseControllerImpl<RubroArticuloInsumo, RubroArticuloInsumoServiceImpl>{
}
