package com.ensa.paiement.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ensa.paiement.model.Directeur;
import com.ensa.paiement.model.Ingenieur;
import com.ensa.paiement.model.Ouvrier;
import com.ensa.paiement.model.Salarie;
import com.ensa.paiement.service.itf.SalarieServices;

@Controller
public class HomeController {

	@Autowired
	SalarieServices salarieServices;

	@RequestMapping("/")
	public String home(Model model) {
		model.addAttribute("liste", salarieServices.getAllSalarie());
		model.addAttribute("salarie", new Salarie());
		model.addAttribute("sala", new Salarie());
		return "index";
	}

	@RequestMapping(value = "/rechercher")
	public String getSalarie(Salarie salarie, Model model) {
        System.out.println(salarie.getDepartement());
		List<Salarie> salaries = new ArrayList<Salarie>();
		if (salarie.getNumSalarie() != null) {
			salaries.add(salarieServices.getSalarieById(salarie.getNumSalarie()));
			model.addAttribute("liste", salaries);
		} else if (salarie.getDepartement() != "") {
			model.addAttribute("liste", salarieServices.getSalarieByDepartement(salarie
					.getDepartement()));
		} else
		model.addAttribute("liste", salarieServices.getAllSalarie());
		model.addAttribute("salarie", new Salarie());
		model.addAttribute("sala", new Salarie());
		return "index";
	}

	@RequestMapping(value="/find")
	public String find(@RequestParam(value="numSalarie" ) String numSalarie, Model model){
		Salarie salarie=salarieServices.getSalarieById(Integer.parseInt(numSalarie));
		model.addAttribute("sala", salarie);
		model.addAttribute("salarie", new Salarie());
		model.addAttribute("liste", salarieServices.getAllSalarie());
		return "index";
	} 
	@RequestMapping("/edite")
	public String editeSalarie(Salarie salarie,Model model) {
		if((salarie.getNumSalarie() !=null)&&(salarieServices.getSalarieById(salarie.getNumSalarie()) !=null))
		salarieServices.edit(salarie);
		else {salarie.setNumSalarie(0);
		      salarie.setNbrEnfant(0);
		if(salarie.getFonction().equals("Directeur")){
			salarieServices.add(salarie);
			Directeur directeur=new Directeur();
			directeur.setSalarie(salarie);
			salarie.setDirecteur(directeur);
			salarieServices.addDirecteur(directeur);			
		}
			
		else if(salarie.getFonction().equals("Ouvrier")){
			salarieServices.add(salarie);
			Ouvrier ouvrier=new Ouvrier();
			ouvrier.setSalarie(salarie);
			salarie.setOuvrier(ouvrier);
			salarieServices.addOuvrier(ouvrier);
		}
		else if(salarie.getFonction().equals("Ingenieur")){
			salarieServices.add(salarie);
            Ingenieur ingenieur=new Ingenieur();
            ingenieur.setSalarie(salarie);
            salarie.setIngenieur(ingenieur);
            salarieServices.addIngenieur(ingenieur);
		}
		}
		model.addAttribute("sala", new Salarie());
		model.addAttribute("salarie", new Salarie());
		model.addAttribute("liste", salarieServices.getAllSalarie());
		return "index";
	}
	@RequestMapping("/remove")
	public String removeSalarie(@RequestParam(value="numSalarie" ) String numSalarie,Model model) {
		Salarie salarie=salarieServices.getSalarieById(Integer.parseInt(numSalarie));
		if(salarie.getDirecteur() !=null)
			salarieServices.deleteDirecteur(Integer.parseInt(numSalarie));
		else if (salarie.getOuvrier() !=null) 
			salarieServices.deleteOuvrier(Integer.parseInt(numSalarie));
		else if(salarie.getIngenieur() != null) salarieServices.deleteIngenieur(Integer.parseInt(numSalarie));
		salarieServices.delete(Integer.parseInt(numSalarie));
		model.addAttribute("sala", new Salarie());
		model.addAttribute("salarie", new Salarie());
		model.addAttribute("liste", salarieServices.getAllSalarie());
		return "index";
	}
	@RequestMapping("/fichePaie")
	public String getFichierPaie(@RequestParam(value="numSalarie" ) String numSalarie,Model model) {
		Salarie salarie=salarieServices.getSalarieById(Integer.parseInt(numSalarie));
		double salaire=salarieServices.CalculeSalaire(salarie, 0);
 		model.addAttribute("sala",salarie );
		model.addAttribute("salarie", new Salarie());
		model.addAttribute("salaire", salaire);
		SimpleDateFormat formater1 = new SimpleDateFormat("dd/MM/yyyy 'à' hh:mm:ss");
		Date dateLe = new Date();
		String date = formater1.format(dateLe);
		model.addAttribute("date", date);
		model.addAttribute("liste", salarieServices.getAllSalarie());
		return "fiche";
	}
	  @InitBinder
	    public void initBinder(WebDataBinder binder) {
	        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	        dateFormat.setLenient(false);
	        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	    }
}
