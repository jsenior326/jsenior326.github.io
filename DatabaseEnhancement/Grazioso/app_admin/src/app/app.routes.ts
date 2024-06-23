import { Routes } from '@angular/router';
import { DataTableComponent } from './data-table/data-table.component';
import { AnimalEditComponent } from './animal-edit/animal-edit.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';

export const routes: Routes = [
    { path: '', component: DataTableComponent, pathMatch: 'full' },
    { path: 'edit/:animal_id', component: AnimalEditComponent},
    { path: 'login', component: LoginComponent},
    { path: 'register', component: RegisterComponent}
];
