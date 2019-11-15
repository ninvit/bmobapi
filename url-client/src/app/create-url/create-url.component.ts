import { UrlService } from '../url.service';
import { Url } from '../url';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { take } from 'rxjs/operators';
import { Validators } from '@angular/forms';

@Component({
  selector: 'app-create-url',
  templateUrl: './create-url.component.html',
  styleUrls: ['./create-url.component.css']
})
export class CreateUrlComponent implements OnInit {

  url: Url = new Url();
  submitted = false;
  myForm: any;

  constructor(private urlService: UrlService,
              private router: Router) { }

  ngOnInit() {
  }

  newUrl(): void {
    this.submitted = false;
    this.url = new Url();
  }

  save() {
    this.urlService.createUrl(this.url).pipe(take(1))
      .subscribe(() => {
        this.url = new Url();
        this.gotoList();
      }, error => console.log(error));
  }

  onSubmit() {
    this.submitted = true;
    this.save();
  }

  gotoList() {
    this.router.navigate(['/urls']);
  }
}
