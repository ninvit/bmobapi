import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CreateUrlComponent } from './create-url/create-url.component';
import { UrlDetailsComponent } from './url-details/url-details.component';
import { UrlListComponent } from './url-list/url-list.component';
import { HttpClientModule } from '@angular/common/http';
import { UpdateUrlComponent } from './update-url/update-url.component';
import { NavigateUrlComponent } from './navigate-url/navigate-url.component';
@NgModule({
  declarations: [
    AppComponent,
    CreateUrlComponent,
    UrlDetailsComponent,
    UrlListComponent,
    UpdateUrlComponent,
    NavigateUrlComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
