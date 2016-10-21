/* tslint:disable:no-unused-variable */

import { TestBed, async, inject } from '@angular/core/testing';
import { DogsService } from './dogs.service';

describe('Service: Dogs', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [DogsService]
    });
  });

  it('should ...', inject([DogsService], (service: DogsService) => {
    expect(service).toBeTruthy();
  }));
});
