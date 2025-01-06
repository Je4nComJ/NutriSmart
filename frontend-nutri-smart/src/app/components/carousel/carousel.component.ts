import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { NavigationEnd, Router } from '@angular/router';
import { filter } from 'rxjs';

@Component({
  selector: 'app-carousel',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './carousel.component.html',
  styleUrl: './carousel.component.css'
})
export class CarouselComponent {

  images: string[] = [
    'assets/images/carousel/nutrica-clinica.jpg',
    'assets/images/carousel/nutricao-clinica.png'
  ];

  showCarousel: boolean = false;

  constructor(private router : Router){}

  ngOnInit(): void {
    this.router.events.pipe(
      filter(event => event instanceof NavigationEnd)
    ).subscribe((event: NavigationEnd) => {
      this.showCarousel = event.url === '/';
      this.showCarousel = event.url === '/home';
    });
  }

}
