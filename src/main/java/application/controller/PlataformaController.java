package application.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import application.model.Plataforma;
import application.repository.plataformaRepository;

@Controller
@RequestMapping("/plataformas")
public class PlataformaController {
    @Autowired
    private plataformaRepository plataformaRepo;

    @RequestMapping("/insert")
    public String insert() {
        return "/plataformas/insert";
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public String insert(@RequestParam("nome") String nome) {
        Plataforma plataforma = new Plataforma();
        plataforma.setNome(nome);
        plataformaRepo.save(plataforma);
        return "redirect:/plataformas/list";
    }

    @RequestMapping("/list")
    public String list(Model ui) {
        ui.addAttribute("plataformas", plataformaRepo.findAll());
        return "/plataformas/list";
    }

    @RequestMapping("/update/{id}")
    public String update(Model ui, @PathVariable long id) {
        Optional<Plataforma> resultado = plataformaRepo.findById(id);
        if (resultado.isPresent()) {
            ui.addAttribute("plataformas", resultado.get());
            return "/plataformas/update";
        }
        return "/plataformas/list";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(
            @RequestParam("id") long id,
            @RequestParam("nome") String nome) {
        Optional<Plataforma> resultado = plataformaRepo.findById(id);
        if (resultado.isPresent()) {
            resultado.get().setNome(nome);  
            plataformaRepo.save(resultado.get());
        }
        return "redirect:/plataformas/list";
    }

     @RequestMapping("/delete/{id}")
    public String delete(Model ui, @PathVariable long id){
        Optional<Plataforma> resltado = plataformaRepo.findById(id);
       if (resltado.isPresent()) {
            ui.addAttribute("plataformas", resltado.get());
            return "/plataformas/delete";
       }
       return "/plataformas/list";
    }

    @RequestMapping(value="/delete", method = RequestMethod.POST)
    public String delete( @RequestParam("id") long id){
        Optional<Plataforma> resultado = plataformaRepo.findById(id);
        if (resultado.isPresent()) {
            plataformaRepo.deleteById(resultado.get().getId());
        }
        return "redirect:/plataformas/list";
    }

}
