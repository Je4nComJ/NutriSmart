import { RouterModule, Routes } from '@angular/router';
import { HomeComponent} from './components/home/home.component';
import { AboutUsComponent } from './components/about-us/about-us.component';

export const appRoutes: Routes = [
  {path:'', component: HomeComponent},
  {path:'home', component: HomeComponent},
  {path:'about-us', component: AboutUsComponent}
];

export const routes = RouterModule.forRoot(appRoutes);
