import { Url } from '../url';
import { Component, OnInit, Input } from '@angular/core';
import { UrlService } from '../url.service';
import { UrlListComponent } from '../url-list/url-list.component';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-url-details',
  templateUrl: './url-details.component.html',
  styleUrls: ['./url-details.component.css']
})
export class UrlDetailsComponent implements OnInit {

  id: number;
  url: Url;

  constructor(private route: ActivatedRoute,private router: Router,
    private urlService: UrlService) { }

  ngOnInit() {
    this.url = new Url();

    this.id = this.route.snapshot.params['id'];
    
    this.urlService.getUrl(this.id)
      .subscribe(data => {
        console.log(data)
        this.url = data;
      }, error => console.log(error));
  }

  list(){
    this.router.navigate(['urls']);
  }
}
