import { Component, OnInit } from '@angular/core';3
import { Url } from '../url';
import { Router, ActivatedRoute } from '@angular/router';
import { UrlService } from '../url.service';

@Component({
  selector: 'app-navigate-url',
  templateUrl: './navigate-url.component.html',
  styleUrls: ['./navigate-url.component.css']
})
export class NavigateUrlComponent implements OnInit {

  alias: string;
  url: Url = new Url();

  constructor(private route: ActivatedRoute,private router: Router,
    private urlService: UrlService) { }

    ngOnInit() {
    }

    navigateToUrl(){        
      this.urlService.getUrlByAlias(this.url.alias)
        .subscribe(data => {
          console.log(data)
          window.open('http://' + data.longUrl);          
        }, error => console.log(error));
    }

}
