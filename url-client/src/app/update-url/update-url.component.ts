import { Component, OnInit } from '@angular/core';
import { Url } from '../url';
import { ActivatedRoute, Router } from '@angular/router';
import { UrlService } from '../url.service';
import { take } from 'rxjs/operators';

@Component({
  selector: 'app-update-url',
  templateUrl: './update-url.component.html',
  styleUrls: ['./update-url.component.css']
})
export class UpdateUrlComponent implements OnInit {

  id: number;
  url: Url;

  constructor(private route: ActivatedRoute, private router: Router,
              private urlService: UrlService) { }

  ngOnInit() {
    this.url = new Url();

    this.id = this.route.snapshot.params.id;

    this.urlService.getUrl(this.id)
      .subscribe(data => {
        console.log(data);
        this.url = data;
      }, error => console.log(error));
  }

  updateUrl() {
    this.urlService.updateUrl(this.id, this.url).pipe(take(1))
    .subscribe(() => {
      this.url = new Url();
      this.gotoList();
    }, error => console.log(error));
}

  onSubmit() {
    this.updateUrl();
  }

  gotoList() {
    this.router.navigate(['/urls']);
  }
}
