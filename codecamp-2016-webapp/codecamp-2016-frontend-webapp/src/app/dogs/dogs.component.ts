import { Component, OnInit } from '@angular/core';

import { DogsService } from './dogs.service';
import { Dog } from './dogs';

@Component({
  selector: 'app-dogs',
  templateUrl: './dogs.component.html',
  styleUrls: ['./dogs.component.css']
})
export class DogsComponent implements OnInit {
  errorMessage: string;
  dogs: Dog[];
  mode = 'Observable';
  formShowing : boolean;
  createDogModel = new Dog(0, 'Goofy', 'Micky Mouse', 'Friend of Micky Mouse', true);
  searchDogModel = new Dog(0, '', '', '', true);
    
  constructor(private dogsService: DogsService) {
      this.formShowing = false;  
  }

  ngOnInit() {
      this.getDogs();
  }
    
  createDog($event) {
      let createdDog: Dog;
      this.dogsService.createDog(this.createDogModel)
        .subscribe(
            dog => this.dogs.push(dog),
            error => this.errorMessage = <any>error);
      this.createDogModel = new Dog(0, 'Goofy', 'Micky Mouse', 'Friend of Micky Mouse', true);
      this.formShowing = false;
  }
    
    deleteDog(id: number) {
      this.dogsService.deleteDog(id)
        .subscribe(
            
           () => this.getDogs());
      
  }
    
     saveDog(dog: Dog) {
      this.dogsService.saveDog(dog)
        .subscribe(
           () => this.getDogs());
      }
    
    searchDog() {
      this.dogsService.searchDogs(this.searchDogModel)
        .subscribe(
            dogs => this.dogs = dogs,
            error => this.errorMessage = <any>error);
      this.formShowing = false;
    }
    
  getDogs() {
    this.dogsService.getDogs()
                     .subscribe(
                       dogs => this.dogs = dogs,
                       error =>  this.errorMessage = <any>error);
  }
    
    customTrackBy(index: number, obj: any): any {
    return index;
  }

}
