package br.imd.modelo.ABB;

import java.io.IOException;
import java.io.PrintWriter;

import br.imd.modelo2.Cadastro;
import br.imd.controle.IDNegativoException;


/**
 * 
 * @Thaynan e Eulle
 * 27//11/2016
 * Vers�o 1.0
 * Classe para cria��o, manipula��o de arvores Bin�rias 
 */
public class ArvoreBinaria implements OperacoesBasicasABB {
    public No raiz;
    private ArvoreBinaria arvoreEsquerda;
    private ArvoreBinaria arvoreDireita;
    private ArvoreBinaria arvorePai;

    public ArvoreBinaria() { }

    public ArvoreBinaria getArvoreDireita() {
        return arvoreDireita;
    }

    public void setArvoreDireita(ArvoreBinaria arvoreDireita) {
        this.arvoreDireita = arvoreDireita;
    }

    public ArvoreBinaria getArvoreEsquerda() {
        return arvoreEsquerda;
    }

    public void setArvoreEsquerda(ArvoreBinaria arvoreEsquerda) {
        this.arvoreEsquerda = arvoreEsquerda;
    }

    public No getRaiz() {
        return raiz;
    }

    public void setRaiz(No raiz) {
        this.raiz = raiz;
    }
    
    

	public ArvoreBinaria getArvorePai() {
		return arvorePai;
	}

	public void setArvorePai(ArvoreBinaria arvorePai) {
		this.arvorePai = arvorePai;
	}

	
	public void insereCadastro(int id,String email,String senha, boolean vip) {
        Cadastro cadastro;
		try {
			cadastro = new Cadastro(Integer.toString(id), email, senha, vip);
		
        No no = new No(cadastro);
     
        	if(this.buscaID(id) == null){
        	 inserir(no);
             //System.out.println(arvore.getRaiz().getAluno().getMatricula());
             //System.out.println("kbajds");
        	}
        	
        	else{
        		System.out.println("Valor j� existente !");
        	}
		} catch (IDNegativoException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
     
    }
	@Override
    public void inserir(No no) {
        if (this.raiz == null) {
            this.raiz = no;
            
     
        }
        
        else  {
        	
        	
        	 if (Integer.parseInt(no.getCadastro().getID()) > Integer.parseInt (this.raiz.getCadastro().getID())) {
                if (this.arvoreDireita == null) {
                    this.arvoreDireita = new ArvoreBinaria();
                    this.arvoreDireita.arvorePai = new ArvoreBinaria();
                    this.arvoreDireita.arvorePai =this;
                    
                }
         
                this.arvoreDireita.inserir(no);
            } else if (Integer.parseInt(no.getCadastro().getID()) < Integer.parseInt(this.raiz.getCadastro().getID())) {
                if (this.arvoreEsquerda == null) {
                    this.arvoreEsquerda = new ArvoreBinaria();
                    this.arvoreEsquerda.arvorePai = new ArvoreBinaria();
                    this.arvoreEsquerda.arvorePai = this;
                    
                } 
               this.arvoreEsquerda.inserir(no);
            }

        }
    }

	public void percorrerInOrder(ArvoreBinaria arvore) throws InterruptedException {
        if (this.raiz == null) {
           return;
        }

        if (this.arvoreEsquerda != null) {
            this.arvoreEsquerda.percorrerInOrder(arvore);
        }

        System.out.println(this.getRaiz().getCadastro().getID());
        
        if (this.arvoreDireita != null) {
            this.arvoreDireita.percorrerInOrder(arvore);
        }
    }

    public void percorrerPreOrder(ArvoreBinaria arvore) throws InterruptedException {
        if (this.raiz == null) {
           return;
        }

        
        

        if (this.arvoreEsquerda != null) {
            this.arvoreEsquerda.percorrerPreOrder(arvore);
        }

        if (this.arvoreDireita != null) {
            this.arvoreDireita.percorrerPreOrder(arvore);
        }
    }

    public void percorrerPostOrder(ArvoreBinaria arvore) throws InterruptedException {
        if (this.raiz == null) {
           return;
        }

        if (this.arvoreEsquerda != null) {
            this.arvoreEsquerda.percorrerPostOrder(arvore);
        }

        if (this.arvoreDireita != null) {
            this.arvoreDireita.percorrerPostOrder(arvore);
        }

       
        
        
       
    }

    public Cadastro buscaID(int matricula) {
    	 
        if (this.raiz == null) {
            return null;
        } else {
            if (matricula == Integer.parseInt(this.raiz.getCadastro().getID())) {
                return this.raiz.getCadastro();
         
            } else {
                if (matricula > Integer.parseInt(this.raiz.getCadastro().getID())) {
                    if (this.arvoreDireita == null) {
                    	
                        return null;
                    }
                    return this.arvoreDireita.buscaID(matricula);
                } else {
                    if (this.arvoreEsquerda == null) {
                        return null;
                    }
                    return this.arvoreEsquerda.buscaID(matricula);
                }
            }
        }
    }

 

    @Override
	public ArvoreBinaria busca(int matricula) {
		 if (this.raiz == null) {
	            return null;
	        } else {
	        	
	            if (matricula == Integer.parseInt (this.raiz.getCadastro().getID())) {
	            	System.out.println("opipo");
	            	System.out.println(matricula);
	            	System.out.println(this.getRaiz().getCadastro().getVip());
	            	System.out.println(this.getRaiz().getCadastro().getID());
	                return this;    
	            } else {
	            	
	                if (matricula > Integer.parseInt(this.raiz.getCadastro().getID())) {
	                    if (this.arvoreDireita == null) {
	                    	
	                        return null;
	                    }
	                    
	                    return this.arvoreDireita.busca(matricula);
	                } else {
	                    if (this.arvoreEsquerda == null) {
	                        return null;
	                    }
	                   
	                   
	                   return this.arvoreEsquerda.busca(matricula);
	                }
	            }
	        }
	}
	
	
	public boolean remocaoCadatro(int id) throws InterruptedException {
		
		ArvoreBinaria d = null;
		
		
		d = busca(id);

		if(d == null)
		{
			System.out.println("Matricula n�o encontrada.");
			return false;
		}
		else
		{
			
			
			remove(id, d);
			
		    System.out.println("Matricula encontrada.");
			return true;
		}
		
		
		
	}
	
	@Override
	public ArvoreBinaria remove(int id, ArvoreBinaria d)  {
	

		
	
		if(d.arvoreDireita == null && d.arvoreEsquerda == null) {
			if(d.getArvorePai() == null) {
					
					this.raiz= null;
					//System.gc();				
				}
			else {
				
					if(Integer.parseInt(d.getArvorePai().getArvoreDireita().getRaiz().getCadastro().getID()) == id) {
					
						d.arvorePai.arvoreDireita = null;
					}
					else if(Integer.parseInt(d.getArvorePai().getArvoreEsquerda().getRaiz().getCadastro().getID()) == id) {
						
						d.arvorePai.arvoreEsquerda = null;
					}
					
					
					
				}
				return null;
		}
			
		else if(d.arvoreDireita == null && d.arvoreEsquerda != null)	 {
			
			if(d.getArvorePai() == null) {
					d = d.getArvoreEsquerda();				
			}
			else   {
				if(Integer.parseInt(d.getArvorePai().getArvoreDireita().getRaiz().getCadastro().getID()) == id) {
					d.arvorePai.arvoreDireita = d.getArvoreEsquerda();
				}
				else if(Integer.parseInt(d.getArvorePai().getArvoreEsquerda().getRaiz().getCadastro().getID()) == id) {
					d.arvorePai.arvoreEsquerda = d.getArvoreEsquerda();
				}
				
				
				return null;
			}
			
		}
		
		
			else if(d.arvoreDireita != null && d.arvoreEsquerda == null)	 {
			
			if(d.getArvorePai() == null) {
					d = d.getArvoreDireita();				
			}
			else   {
				if(Integer.parseInt(d.getArvorePai().getArvoreDireita().getRaiz().getCadastro().getID()) == id) {
					d.arvorePai.arvoreDireita = d.getArvoreDireita();
				}
				else if(Integer.parseInt(d.getArvorePai().getArvoreEsquerda().getRaiz().getCadastro().getID()) == id) {
					d.arvorePai.arvoreEsquerda = d.getArvoreDireita();
				}
				
				return null;
				
			}
			
		}
			
	
			else if(d.arvoreDireita != null && d.arvoreEsquerda != null)	 {
				
				ArvoreBinaria r = d.getArvoreEsquerda();
				
				while(r.arvoreDireita != null)
				{
					r = r.arvoreDireita;
				}
				
				int valor;
				
				System.out.println(Integer.parseInt(r.raiz.getCadastro().getID()));
				System.out.println(Integer.parseInt(d.raiz.getCadastro().getID()));
				
				valor = Integer.parseInt(d.getRaiz().getCadastro().getID());
				d.raiz.getCadastro().setID(r.getRaiz().getCadastro().getID());
				r.raiz.getCadastro().setID(Integer.toString(valor));
				
				System.out.println(r.raiz.getCadastro().getID());
				System.out.println(d.raiz.getCadastro().getID());
				return remove(id, r);
				
					
				}
		return null;
				
		
	}

	 public void percorrerInOrderInserirArquivo(ArvoreBinaria arvore, PrintWriter gravarArquivo) throws IOException, InterruptedException {
	        if (arvore.raiz == null) {
	           return;
	        }
	        System.out.println("dmask.");
	        if (arvore.arvoreEsquerda != null) {
	            arvore.percorrerInOrderInserirArquivo(arvore.getArvoreEsquerda(), gravarArquivo);
	        }

	       gravarArquivo.print(arvore.getRaiz().getCadastro().getID());
	       gravarArquivo.print(" ");
	       gravarArquivo.print(arvore.getRaiz().getCadastro().getEmail());
	       gravarArquivo.print(" ");
	       gravarArquivo.print(arvore.getRaiz().getCadastro().getSenha());
	       gravarArquivo.print(" ");
	       gravarArquivo.println(arvore.getRaiz().getCadastro().getVip());
	       
	       
	 
	        
	        if (arvore.arvoreDireita != null) {
	            arvore.percorrerInOrderInserirArquivo(arvore.getArvoreDireita(), gravarArquivo);
	        }
	    }

	

	

	
	
}