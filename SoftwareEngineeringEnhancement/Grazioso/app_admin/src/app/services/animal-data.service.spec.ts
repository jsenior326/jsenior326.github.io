import { TestBed } from '@angular/core/testing';

import { AnimalDataService } from '../services/animal-data.service';

describe('AnimalDataService', () => {
  let service: AnimalDataService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AnimalDataService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
