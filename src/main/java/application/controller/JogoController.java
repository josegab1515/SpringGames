package application.controller;

import java.util.HashSet;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import application.model.Genero;
import application.model.Jogo;
import application.model.ModoJogo;
import application.model.Plataforma;
import application.repository.generoRepository;
import application.repository.jogoRepository;
import application.repository.modoRepository;
import application.repository.plataformaRepository;

@Controller
@RequestMapping("/jogos")
public class JogoController {
    @Autowired
    private jogoRepository jogoRepo;
    @Autowired
    private plataformaRepository plataformaRepo;
    @Autowired
    private modoRepository modoRepo;
    @Autowired
    private generoRepository generoRepo;

    @RequestMapping("/list")
    public String list(Model ui) {
        ui.addAttribute("jogos", jogoRepo.findAll());
        return "/jogos/list";
    }

    @RequestMapping("/insert")
    public String insert(Model ui) {
        ui.addAttribute("modos", modoRepo.findAll());
        ui.addAttribute("plataformas", plataformaRepo.findAll());
        ui.addAttribute("generos", generoRepo.findAll());
        return "/jogos/insert";
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public String insert(
            @RequestParam("titulo") String titulo,
            @RequestParam("id_plataforma") long[] idPlataformas,
            @RequestParam("id_genero") long[] idGeneros,
            @RequestParam("id_modo") long idModo) {
        Optional<ModoJogo> resulModo = modoRepo.findById(idModo);
        if (resulModo.isPresent()) {
            Jogo jogo = new Jogo();
            jogo.setTitulo(titulo);
            jogo.setModoJogo(resulModo.get());
            for (long id : idGeneros) {
                Optional<Genero> resulGenero = generoRepo.findById(id);
                if (resulGenero.isPresent()) {
                    jogo.getGeneros().add(resulGenero.get());
                }
            }
            for (long id : idPlataformas) {
                Optional<Plataforma> resulPlataforma = plataformaRepo.findById(id);
                if (resulPlataforma.isPresent()) {
                    jogo.getPlataformas().add(resulPlataforma.get());
                }
            }
            jogoRepo.save(jogo);

        }
        return "redirect:/jogos/list";
    }

    @RequestMapping("/update/{id}")
    public String update(@PathVariable long id, Model ui) {
        Optional<Jogo> resultado = jogoRepo.findById(id);
        if (resultado.isPresent()) {
            ui.addAttribute("jogos", jogoRepo.findAll());
            ui.addAttribute("modos", modoRepo.findAll());
            ui.addAttribute("plataformas", plataformaRepo.findAll());
            ui.addAttribute("generos", generoRepo.findAll());
            return "/jogos/update";
        }
        return "/jogos/list";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(
            @RequestParam("id") long id,
            @RequestParam("titulo") String titulo,
            @RequestParam("id_plataforma") long[] idPlataformas,
            @RequestParam("id_genero") long[] idGeneros,
            @RequestParam("id_modo") long idModo) {
        Optional<Jogo> resulJogo = jogoRepo.findById(id);
        if (resulJogo.isPresent()) {
            Jogo jogo = resulJogo.get();
            jogo.setTitulo(titulo);

            Optional<ModoJogo> resulModo = modoRepo.findById(idModo);
            if (resulModo.isPresent()) {
                jogo.setModoJogo(resulModo.get());
                jogo.setPlataformas(new HashSet<>());
                jogo.setGeneros(new HashSet<>());

                for (long idplataforma : idPlataformas) {
                    Optional<Plataforma> resultPlataforma = plataformaRepo.findById(idplataforma);
                    if (resultPlataforma.isPresent()) {
                        jogo.getPlataformas().add(resultPlataforma.get());

                    }
                }
                for (long idGenero : idGeneros) {
                    Optional<Genero> resultGenero = generoRepo.findById(idGenero);
                    if (resultGenero.isPresent()) {
                        jogo.getGeneros().add(resultGenero.get());
                    }
                }
                jogoRepo.save(jogo);
            }

        }
        return "redirect:/jogos/list";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable long id, Model ui){
        Optional<Jogo> resultado = jogoRepo.findById(id);
        if (resultado.isPresent()) {
            ui.addAttribute("jogos", resultado.get());
            return "/jogo/delete";
        }
        return "/jogos/list";
    }
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String delete(@RequestParam("id") long id){
        jogoRepo.deleteById(id);
        return "redirect:/jogos/list";
    }
}
