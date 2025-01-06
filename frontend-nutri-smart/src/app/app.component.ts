import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { NavbarComponent } from "./components/navbar/navbar.component";
import { ReactiveFormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { FooterComponent } from './components/footer/footer.component';
import { CarouselComponent } from "./components/carousel/carousel.component";
import { HomeComponent} from './components/home/home.component';
import { AboutUsComponent } from './components/about-us/about-us.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, NavbarComponent, ReactiveFormsModule, CommonModule, FooterComponent, CarouselComponent, HomeComponent, AboutUsComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'frontend-nutri-smart';
}
