package fiap.scj.springmvc.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fiap.scj.springmvc.beans.Categoria;
import fiap.scj.springmvc.beans.CategoriaEditor;
import fiap.scj.springmvc.beans.Gif;
import fiap.scj.springmvc.daos.GenericDAO;

@Controller
public class GifController {

	private GenericDAO<Gif> gifDAO = new GenericDAO<>(Gif.class);
	private GenericDAO<Categoria> categoriaDAO = new GenericDAO<>(Categoria.class);
	
	private List<Integer> classEtarias = Arrays.asList(8, 10, 12, 14, 16, 18);
	private List<String> idiomas = Arrays.asList("Português", "Inglês");
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Categoria.class, "categoria", new CategoriaEditor());
	}
	
	@RequestMapping(value = "/gif/form_cadastro", method = RequestMethod.GET)
	public String exibirFormCadastro(Model model) {
		model.addAttribute("gif", new Gif());
		model.addAttribute("categorias", categoriaDAO.listar());
		model.addAttribute("classEtarias", classEtarias);
		model.addAttribute("idiomas", idiomas);
		return "cadastrar_gif";
	}
	@RequestMapping(value = "/gif/cadastrar", method = RequestMethod.POST)
	public String cadastrar(Model model, @ModelAttribute("gif") Gif gif) {
		gifDAO.adicionar(gif);
		return "redirect:/gif";
	}
	@RequestMapping(value = "/gif", method = RequestMethod.GET)
	public String listar(Model model, Gif gif) {
		model.addAttribute("gifs", gifDAO.listar());
		return "gifs";
	}
}
