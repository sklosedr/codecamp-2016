import { Component, OnInit } from '@angular/core';
import { DogsService } from './dogs.service';
import { Dog } from './dogs'; 


@Component({
  selector: 'app-dogs',
  templateUrl: './dogs.component.html',
  styleUrls: ['./dogs.component.css']
})
    

export class DogsComponent implements OnInit {
    public dog : Dog;
    

  constructor(private dogService: DogsService) {
  }

  ngOnInit() {
    this.dog = this.dogService.getDog();
  }

}
