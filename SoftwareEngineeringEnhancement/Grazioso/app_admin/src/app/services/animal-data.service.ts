import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class AnimalDataService {

  private url = 'http://localhost:3000/api';

  constructor(private http: HttpClient) { }

  // Gets all data using api/animals endpoint
  getData(): Observable<any[]> {
    return this.http.get<any[]>(this.url + '/animals');
  }

  // Gets animals filtered by water rescue using api/waterRescue endpoint
  getWaterRescueData(): Observable<any[]> {
    return this.http.get<any[]>(this.url + '/waterRescue');
  }

  // Gets animals filtered by mountain or wilderness rescue using 
  // api/mountainWildernessRescue endpoint
  getMountainWildernessRescue(): Observable<any[]> {
    return this.http.get<any[]>(this.url + '/mountainWildernessRescue');
  }

  // Gets animals filtered by disaster or individual tracking rescues using
  // api/disasterIndividualRescue endpoint
  getDisasterIndividualRescue(): Observable<any[]> {
    return this.http.get<any[]>(this.url + '/disasterIndividualRescue');
  }
}
