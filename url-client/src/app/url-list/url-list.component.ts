import { UrlService } from '../url.service';
import { Url } from '../url';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-url-list',
  templateUrl: './url-list.component.html',
  styleUrls: ['./url-list.component.css']
})
export class UrlListComponent implements OnInit {

  urls: Url[];

  constructor(private urlService: UrlService,
              private router: Router) { }

  ngOnInit() {
    this.reloadData();
  }

  ngOnDestroy() {
  }

  async reloadData() {
    this.urls = await this.urlService.getUrlsList();
    console.log(this.urls);
  }

  deleteUrl(id: number) {
    this.urlService.deleteUrl(id)
      .subscribe(
        data => {
          console.log(data);
          this.reloadData();
        },
        error => console.log(error));
  }

  urlDetails(id: number) {
    this.router.navigate(['details', id]);
  }

  updateUrl(id: number) {
    this.router.navigate(['update', id]);
  }
}
