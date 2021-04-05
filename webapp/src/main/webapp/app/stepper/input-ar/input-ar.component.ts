import { Component, OnInit, Input } from '@angular/core';
import { Input as StepperInput } from 'app/entities/Input';
import { StepperEventManagerService } from 'app/stepper/stepper/stepper-event-manager.service';
import { COUNTRIES_FR } from 'app/shared/constants/country.constants';

@Component({
  selector: 'jhi-input-ar',
  templateUrl: './input-ar.component.html',
  styleUrls: ['input-ar.component.scss']
})
export class InputArComponent implements OnInit {
  @Input() input: StepperInput;
  countries: string[] = [];

  constructor(private stepperEventManagerService: StepperEventManagerService) {
    this.countries = COUNTRIES_FR;
  }

  ngOnInit() {}

  onChange(inputId: string) {
    this.stepperEventManagerService.sendOnChange(inputId);
  }
}
