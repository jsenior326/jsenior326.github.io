import { Component, OnInit } from '@angular/core';
import { AnimalDataService } from '../services/animal-data.service';
import { HttpClientModule } from '@angular/common/http';
import { CommonModule, NgFor } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthenticationService } from '../services/authentication.service';

@Component({
  selector: 'app-data-table',
  standalone: true,
  imports: [HttpClientModule, CommonModule, NgFor, FormsModule],
  templateUrl: './data-table.component.html',
  styleUrl: './data-table.component.css'
})
export class DataTableComponent implements OnInit {
  animals: any[] = [];
  headers: string[] = [];
  isLoading: boolean = false;
  selection: number = 0;
  numResults: number = 0;

  constructor(
    private animalDataService: AnimalDataService,
    private router: Router,
    private authenticationService: AuthenticationService
  ) { }

  ngOnInit(): void {
    this.loadData(0);
  }

  public isLoggedIn(): boolean {
    return this.authenticationService.isLoggedIn();
  }

  loadData(opt: number): void {
    this.isLoading = true; // Start loading
    this.animals = [];

    // Switch on dropdown option selected to filter data accordingly
    var result;
    switch(opt) {
      case 0:
        result = this.animalDataService.getData();
        break;
      case 1:
        result = this.animalDataService.getWaterRescueData();
        break;
      case 2:
        result = this.animalDataService.getMountainWildernessRescue();
        break;
      case 3:
        result = this.animalDataService.getDisasterIndividualRescue();
        break;
      default:
        result = this.animalDataService.getData();
    }

    // Retrieve the data
    result.subscribe({
      next: data => {
        this.animals = data;
        if (this.animals.length > 0) {
          this.headers = Object.keys(this.animals[0]);
        }
        this.numResults = this.animals.length;
        this.isLoading = false; // Stop loading
      },
      error: err => {
        console.error('Error fetching data:', err);
        this.isLoading = false; // Stop loading
      }
    });
  }

  onSelectionChange(event: Event): void {
    const value = (event.target as HTMLSelectElement).value;
    this.selection = Number(value);

    // Filter data based on selection
    this.loadData(Number(value));
  }

  editRow(animalId: any) {
    this.router.navigate(['/edit', animalId]);
  }

  confirmDeleteRow(animalId: any) {
    const confirmation = confirm("Animal ID: " + animalId + "\nAre you sure you want to delete this element?");
    if(confirmation) {
      this.deleteRow(animalId);
    }
  }

  deleteRow(animalId: any) {
    this.animalDataService.deleteAnimal(animalId).subscribe({
      next: () => {
        this.loadData(this.selection);
      },
      error: (error: any) => {
        console.log('Error: ' + error);
      }
    });
  }
}
