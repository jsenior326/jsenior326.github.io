import { Inject, Injectable } from '@angular/core';
import { SESSION_STORAGE } from '../storage';
import { User } from '../models/user';
import { AuthResponse } from '../models/authresponse';
import { AnimalDataService } from '../services/animal-data.service';

@Injectable({
    providedIn: 'root'
})

export class AuthenticationService {
    constructor(
        @Inject(SESSION_STORAGE) private storage: Storage,
            private animalDataService: AnimalDataService
        ) { }

    public getToken(): string {
        return this.storage.getItem('grazioso-token');
    }

    public saveToken(token: string): void {
        this.storage.setItem('grazioso-token', token);
    }

    public login(user: User): Promise<any> {
        return this.animalDataService.login(user)
            .then((authResp: AuthResponse) => 
                this.saveToken(authResp.token));
    }

    public register(user: User): Promise<any> {
        return this.animalDataService.register(user)
            .then((authResp: AuthResponse) =>
                this.saveToken(authResp.token));
    }

    public logout(): void {
        this.storage.removeItem('grazioso-token');
    }

    public isLoggedIn(): boolean {
        const token: string = this.getToken();
        if (token) {
            const payload = JSON.parse(atob(token.split('.')[1]));
            return payload.exp > (Date.now() / 1000);
        } else {
            return false;
        }
    }

    public getCurrentUser(): User {
        if (this.isLoggedIn()) {
            const token: string = this.getToken();
            const { email, name } =
                JSON.parse(atob(token.split('.')[1]));
            return { email, name } as User;
        } else {
            return null;
        }
    }
}