package br.imd.modelo.ABB;

import br.imd.modelo2.Cadastro;

public class No{
	
	private Cadastro cadastro;
	

    public No(Cadastro cadastro) {
        this.setCadastro(cadastro);
               
    }


	public Cadastro getCadastro() {
		return cadastro;
	}


	public void setCadastro(Cadastro cadastro) {
		this.cadastro = cadastro;
	}

   
	
    
}
