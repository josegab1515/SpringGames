package application.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import application.model.Genero;
import application.repository.generoRepository;

@Controller
@RequestMapping("/generos")
public class GeneroController {
    @Autowired
    private generoRepository generoRepo;

    @RequestMapping("/insert")
    public String insert() {
        return "/generos/insert";
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public String insert(@RequestParam("nome") String nome) {
        Genero genero = new Genero();
        genero.setNome(nome);

        generoRepo.save(genero);

        return "redirect:/generos/list";
    }

    @RequestMapping("/list")
    public String list(Model ui) {
        ui.addAttribute("generos", generoRepo.findAll());
        return "/generos/list";
    }

    @RequestMapping("/update/{id}")
    public String update(Model ui, @PathVariable long id) {
        Optional<Genero> resultado = generoRepo.findById(id);

        if (resultado.isPresent()) {
            ui.addAttribute("genero", resultado.get());
            return "/generos/update";
        }
        return "/generos/list";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(
            @RequestParam("id") long id,
            @RequestParam("nome") String nome) {
        Optional<Genero> resultado = generoRepo.findById(id);
        if (resultado.isPresent()) {
            resultado.get().setNome(nome);
            generoRepo.save(resultado.get());
        }
        return "redirect:/generos/list";
    }

    @RequestMapping("/delete/{id}")
    public String delete(Model ui, @PathVariable long id){
        Optional<Genero> resltado = generoRepo.findById(id);
       if (resltado.isPresent()) {
            ui.addAttribute("genero", resltado.get());
            return "/generos/delete";
       }
       return "/generos/list";
    }

    @RequestMapping(value="/delete", method = RequestMethod.POST)
    public String delete( @RequestParam("id") long id){
        Optional<Genero> resultado = generoRepo.findById(id);
        if (resultado.isPresent()) {
            generoRepo.deleteById(resultado.get().getId());
        }
        return "redirect:/generos/list";
    }
}