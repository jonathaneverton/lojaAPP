import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpModule } from '@angular/http';
import { AppComponent } from './app.component';

import { ConfigService } from './services/config.service';
import { ProdutoService } from './services/produto.service';
import { MenuComponent } from './menu/menu.component';
import { HomeComponent } from './home/home.component';
import { ConsultaComponent } from './produto/consulta/consulta.component';
import { CadastroComponent } from './produto/cadastro/cadastro.component';
import { FormsModule } from '@angular/forms';
import { routing } from 'src/app.routes';

@NgModule({
  declarations: [
    AppComponent,
    MenuComponent,
    HomeComponent,
    ConsultaComponent,
    CadastroComponent
  ],
  imports: [
    BrowserModule,
    HttpModule,
    FormsModule,
    routing
  ],
  providers: [ConfigService, ProdutoService],
  bootstrap: [AppComponent]
})
export class AppModule { }
