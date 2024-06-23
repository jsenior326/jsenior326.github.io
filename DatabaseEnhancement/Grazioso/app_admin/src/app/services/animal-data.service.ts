import { Injectable, Inject } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, firstValueFrom } from 'rxjs';

import { User } from '../models/user'
import { AuthResponse } from '../models/authresponse';
import { SESSION_STORAGE } from '../storage';

@Injectable({
  providedIn: 'root',
})

@Injectable()
export class AnimalDataService {

  constructor(private http: HttpClient,
    @Inject(SESSION_STORAGE) private storage: Storage,
  ) { }

  private url = 'http://localhost:3000/api';

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

  // Gets an animal given the animal id
  getAnimal(id: string): Observable<any[]> {
    return this.http.get<any[]>(this.url + '/animals/' + id);
  }

  // Updates an animal
  updateAnimal(id: string, animal: any): Observable<any> {
    const header = {
      headers: new HttpHeaders({'Authorization': `Bearer ${this.storage.getItem('grazioso-token')}`})
    }
    return this.http.put<any>(this.url + '/animals/' + id, animal, header);
  }

  // Deletes an animal
  deleteAnimal(id: string): Observable<any> {
    const header = {
      headers: new HttpHeaders({'Authorization': `Bearer ${this.storage.getItem('grazioso-token')}`})
    }
    return this.http.delete<any>(this.url + '/animals/' + id, header);
  }

  private handleError(err: any): Promise<any> {
    console.error('Something has gone wrong', err);
    return Promise.reject(err.message || err);
  }

  public login(user: User): Promise<AuthResponse> {
    return this.makeAuthApiCall('login', user);
  }

  public register(user: User): Promise<AuthResponse> {
    return this.makeAuthApiCall('register', user);
  }

  private async makeAuthApiCall(urlPath: string, user: User): Promise<AuthResponse> {
    const url: string = `${this.url}/${urlPath}`;
    return await firstValueFrom(this.http.post(url, user))
      .catch(this.handleError);
  }

}
