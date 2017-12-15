package fiap.scj.springmvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.netgifx.dao.GenericDAO;
import br.com.netgifx.entity.Categoria;

@Controller
public class CategoriaController {

	private GenericDAO<Categoria> categoriaDAO = new GenericDAO<>(Categoria.class);
	
	@RequestMapping(value = "/categoria/form_cadastro", method = RequestMethod.GET)
	public String exibirFormCadastro(Model model) {
		model.addAttribute("categoria", new Categoria());
		return "cadastrar_categoria";
	}
	@RequestMapping(value = "/categoria/form_update/{id}", method = RequestMethod.GET)
	public String exibirFormUpdate(@PathVariable(value="id") int id, Model model) {
		model.addAttribute("categoria", categoriaDAO.buscar(id));
		return "alterar_categoria";
	}
	@RequestMapping(value = "/categoria/form_remove/{id}", method = RequestMethod.GET)
	public String exibirFormRemove(Model model, @PathVariable("id") int id) {
		model.addAttribute("categoria", categoriaDAO.buscar(id));
		return "remover_categoria";
	}
	@RequestMapping(value = "/categoria/cadastrar", method = RequestMethod.POST)
	public String cadastrar(Model model, @ModelAttribute("categoria") Categoria categoria) {
		categoriaDAO.adicionar(categoria);
		return "redirect:/categoria";
	}
	@RequestMapping(value = "/categoria", method = RequestMethod.GET)
	public String listar(Model model, Categoria categoria) {
		model.addAttribute("categorias", categoriaDAO.listar());
		return "categorias";
	}
	@RequestMapping(value = "/categoria/alterar", method = RequestMethod.POST)
	public String alterar(@ModelAttribute("categoria") Categoria categoria) {
		categoriaDAO.atualizar(categoria);
		return "redirect:/categoria";
	}
	@RequestMapping(value = "/categoria/remover", method = RequestMethod.POST)
	public String remover(@ModelAttribute("categoria") Categoria categoria) {
		categoriaDAO.remover(categoriaDAO.buscar(categoria.getId()));
		return "redirect:/categoria";
	}
}
