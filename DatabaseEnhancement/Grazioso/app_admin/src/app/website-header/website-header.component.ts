import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AuthenticationService } from '../services/authentication.service';

@Component({
  selector: 'app-website-header',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './website-header.component.html',
  styleUrl: './website-header.component.css'
})
export class WebsiteHeaderComponent implements OnInit{
  constructor(
    private authenticationService: AuthenticationService
  ) { }

  ngOnInit() { }

  public isLoggedIn(): boolean {
    return this.authenticationService.isLoggedIn();
  }

  public onLogout(): void {
    return this.authenticationService.logout();
  }
}
