import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { DataTableComponent } from './data-table/data-table.component';
import { CommonModule } from '@angular/common';
import { WebsiteHeaderComponent } from './website-header/website-header.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [CommonModule, RouterOutlet, DataTableComponent, WebsiteHeaderComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'Grazioso Salvare Admin';
}
