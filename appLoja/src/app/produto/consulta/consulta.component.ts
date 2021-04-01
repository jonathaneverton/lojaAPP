import { Component, OnInit } from '@angular/core';

import {Router} from '@angular/router';

import {ProdutoService} from '../../services/produto.service';

import {Produto} from '../../services/produto';

import {Response} from '../../services/response';

@Component({
    selector: 'app-consulta-produto',
    templateUrl: './consulta.component.html',
    styleUrls:["./consulta.component.css"]
  })
  export class ConsultaComponent implements OnInit {

    private produtos: Produto[] = new Array();
    private titulo:string;

    constructor(private produtoService: ProdutoService,
                private router: Router){}

    ngOnInit() {

      /*SETA O TÍTULO */
      this.titulo = "Lista de Produtos";

      /*CHAMA O SERVIÇO E RETORNA TODAS AS PESSOAS CADASTRADAS */
      this.produtoService.getProdutos().subscribe(res => this.produtos = res);
    }

    /**EXCLUI UM REGISTRO QUANDO CLICAMOS NA OPÇÃO EXCLUIR DE UMA
     * LINHA DA TABELA*/
    excluir(codigo:number, index:number):void {

      if(confirm("Deseja realmente excluir esse registro?")){

        /*CHAMA O SERVIÇO PARA REALIZAR A EXCLUSÃO */
        this.produtoService.excluirProduto(codigo).subscribe(response => {

              /**PEGA O RESPONSE DO SERVIÇO */
              let res:Response = <Response>response;

              /*1 = SUCESSO
              * MOSTRAMOS A MENSAGEM RETORNADA PELO SERVIÇO E DEPOIS REMOVEMOS
              O REGISTRO DA TABELA HTML*/
              if(res.codigo == 1){
                alert(res.mensagem);
                this.produtos.splice(index,1);
              }
              else{
                /*0 = EXCEPTION GERADA NO SERVIÇO JAVA */
                alert(res.mensagem);
              }
          },
          (erro) => {
               /*MOSTRA ERROS NÃO TRATADOS */
               alert(erro);
          });
      }

    }

    editar(codigo:number):void{

      this.router.navigate(['/cadastro-produto',codigo]);

    }

  }
