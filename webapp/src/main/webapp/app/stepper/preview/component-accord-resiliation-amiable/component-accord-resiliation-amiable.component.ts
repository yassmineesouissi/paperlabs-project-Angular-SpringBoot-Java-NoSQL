import { Component, OnInit } from '@angular/core';
import { StepperDomManipulationService } from 'app/stepper/stepper/stepper-dom-manipulation.service';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'jhi-component-accord-resiliation-amiable',
  templateUrl: './component-accord-resiliation-amiable.component.html',
  styleUrls: ['./component-accord-resiliation-amiable.component.scss']
})
export class ComponentAccordResiliationAmiableComponent implements OnInit {

  private slideIndex = 1;
  p;

  constructor(protected activeModal: NgbActiveModal) {}

  ngOnInit() {
    this.showSlides(this.slideIndex);
  }

  dismissModal() {
    this.activeModal.dismiss();
  }

  getHtmlInputElement(inputId: string): HTMLInputElement {
    return StepperDomManipulationService.getHTMLInputElement(inputId);
  }

  plusSlides(n) {
    this.showSlides((this.slideIndex += n));
  }

  showSlides(n) {
    let i;
    const slides = document.getElementsByClassName('mySlides');
    if (n > slides.length) {
      this.slideIndex = 1;
    }
    if (n < 1) {
      this.slideIndex = slides.length;
    }
    for (i = 0; i < slides.length; i++) {
      slides[i].setAttribute('style', 'display:none');
    }
    slides[this.slideIndex - 1].setAttribute('style', 'display:block');
  }

}
