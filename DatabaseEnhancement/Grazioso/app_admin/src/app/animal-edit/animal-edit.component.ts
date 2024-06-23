import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { AnimalDataService } from '../services/animal-data.service';
import { Router } from '@angular/router';
import { CommonModule, NgFor } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-animal-edit',
  standalone: true,
  imports: [CommonModule, NgFor, FormsModule],
  templateUrl: './animal-edit.component.html',
  styleUrl: './animal-edit.component.css'
})
export class AnimalEditComponent implements OnInit {
  animal: any = {};

  constructor(
    private route: ActivatedRoute,
    private animalDataService: AnimalDataService,
    private router: Router
  ) {}

  ngOnInit() {
    const id = this.route.snapshot.paramMap.get('animal_id');
    this.animalDataService.getAnimal(id).subscribe(data => {
      this.animal = data;
    });
  }

  public save() {
    const updateFields = {
      animal_type: this.animal.animal_type,
      breed: this.animal.breed,
      sex_upon_outcome: this.animal.sex_upon_outcome,
      age_upon_outcome_in_weeks: this.animal.age_upon_outcome_in_weeks
    };

    this.animalDataService.updateAnimal(this.animal.animal_id, updateFields).subscribe({
      next: () => {
        this.router.navigate(['']);
      },
      error: (error: any) => {
        console.log('Error: ' + error);
      }
    });
  }
}
