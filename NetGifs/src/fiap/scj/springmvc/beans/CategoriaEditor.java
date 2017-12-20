package fiap.scj.springmvc.beans;

import java.beans.PropertyEditorSupport;

import fiap.scj.springmvc.daos.GenericDAO;

public class CategoriaEditor extends PropertyEditorSupport {
	
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		Categoria categoria = new GenericDAO<>(Categoria.class).buscar(Integer.parseInt(text));
		setValue(categoria);
	}
	@Override
	public String getAsText() {
		Categoria categoria = (Categoria) getValue();
		return categoria.getNome();
	}
}
