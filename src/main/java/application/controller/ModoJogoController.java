package application.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import application.model.ModoJogo;
import application.repository.modoRepository;

@Controller
@RequestMapping("/modojogos")
public class ModoJogoController {
    @Autowired
    private modoRepository modoRepo;

    @RequestMapping("/insert")
    public String insert(Model model) {
        model.addAttribute("erro", null);
        return "/modojogos/insert";
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public String insert(
            @RequestParam("nome") String nome,
            @RequestParam("descricao") String descricao,
            Model model) {

        if (nome == null || nome.trim().isEmpty() || descricao == null || descricao.trim().isEmpty()) {
            model.addAttribute("erro", "Nome e descrição não podem estar vazios.");
            return "/modojogos/insert";
        }

        ModoJogo modoJogo = new ModoJogo();
        modoJogo.setNome(nome);
        modoJogo.setDescricao(descricao);
        modoRepo.save(modoJogo);
        return "redirect:/modojogos/list";

    }

    @RequestMapping("list")
    public String list(Model ui) {
        ui.addAttribute("modojogos", modoRepo.findAll());
        return "/modojogos/list";
    }

    @RequestMapping("/delete/{id}")
    public String delete(Model ui, @PathVariable long id) {
        Optional<ModoJogo> resultado = modoRepo.findById(id);
        if (resultado.isPresent()) {
            ui.addAttribute("modojogos", resultado.get());
            return "/modojogos/delete";
        }
        return "/modojogos/list";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String delete(@RequestParam("id") long id) {
        Optional<ModoJogo> resultado = modoRepo.findById(id);
        if (resultado.isPresent()) {
            modoRepo.deleteById(resultado.get().getId());
        }
        return "redirect:/modojogos/list";
    }

    @RequestMapping("/update/{id}")
    public String update(Model ui, @PathVariable long id) {
        Optional<ModoJogo> resultado = modoRepo.findById(id);

        if (resultado.isPresent()) {
            ui.addAttribute("modojogos", resultado.get());
            return "/modojogos/update";
        }
        return "/modojogos/list";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(
            @RequestParam("id") long id,
            @RequestParam("nome") String nome,
            @RequestParam("descricao") String descricao) {
        Optional<ModoJogo> resultado = modoRepo.findById(id);
        if (resultado.isPresent()) {
            resultado.get().setNome(nome);
            resultado.get().setDescricao(descricao);
            modoRepo.save(resultado.get());
        }
        return "redirect:/modojogos/list";
    }

}
